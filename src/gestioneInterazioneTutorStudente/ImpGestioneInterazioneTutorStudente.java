package gestioneInterazioneTutorStudente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Part;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;

public class ImpGestioneInterazioneTutorStudente implements GestioneInterazioneTutorStudente {
	
	private String destLocation;
	
	public ImpGestioneInterazioneTutorStudente() {
		destLocation = new String("C:\\Users\\Antonio\\Desktop\\Documenti\\web\\File\\WebContent\\Immagine");
	}
	
    public String upload(Part part)throws IOException {
        
    	String fileName = extractFileName(part);
		File sourceLocation = new File(fileName);
    	File targetFolder = new File(destLocation);
   

        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetFolder + "\\"+ sourceLocation.getName(), true);
        System.out.println("Destination Path ::"+targetFolder + "\\"+ sourceLocation.getName());            
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        
        String d =(targetFolder + "\\"+ sourceLocation.getName());
        return d;
    }    

    private String extractFileName(Part part) {
 			String contentDisp = part.getHeader("content-disposition");
 			String [] items = contentDisp.split(";");
 			for(String s : items) {
 				if(s.trim().startsWith("filename")) {
 					return s.substring(s.lastIndexOf("=")+2,s.length()-1);
 				}
 			}
 			return "";
 	}

	@Override
	public List<String> listaTutor(String materia) {
		System.out.println("la materia selezionata è: " + materia);
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Tutor");
		List<Object> listaT = null;
		try {
			listaT = o.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		List<String> listaTutor = new ArrayList<String>();
		for(int i = 0;i<listaT.size();i++) {
		      Tutor t = (Tutor) listaT.get(i);
		      System.out.println("materia di competenza: " + t.getMateriaDiCompetenza());
		      if (t.getMateriaDiCompetenza().equals(materia)) {
		    	  listaTutor.add(t.getNome());
		    	  listaTutor.add(t.getCognome());
		    	  listaTutor.add(t.getLinkImmagine());
		    	  int num[] = this.valutazioniTot(t.getEmail());
		    	  listaTutor.add(String.valueOf(num[0]));
		    	  listaTutor.add(String.valueOf(num[1]));
		    	  listaTutor.add(t.getEmail());
		      }
		}
		return listaTutor;
	}

	@Override
	public void inserisciDomanda(String oggetto, String testo,String url,String emailT,String emailS) {
		Tutor t = new Tutor(null, null, emailT, null, null, null, null, null, null);
		Studente s = new Studente(null, null, emailS, null, null, null, null);
		Risposta r = new Risposta(1, null, null,null, null); 	//1 perchè su database la risposta 1 sarà sempre vuota, esiste 
														//solo per creare il collegamento visto che c'è chiave esterna;
		Domanda d = new Domanda(0, testo, oggetto, url, s, t, r, "no");
	    FactoryDAO fd = new FactoryDAO();
	    ObjectDAO o = fd.getObject("Domanda");
	    try {
			o.inserisciDati(d);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	 }

	@Override
	public void valutaRisposta(int id, String valutazione) {
		System.out.println(id + " " + valutazione );
		Risposta r = new Risposta(id,null,null, null, null);
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Risposta");
		try {
			o.recuperaDati(r);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		r.setValutazione(valutazione);
		try {
			o.modificaDati(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object visualizzaAccount(String email) {
		Studente s = new Studente(null, null, email, null, null, null, null);
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Studente");
		try {
			o.recuperaDati(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (s.getNome() != null) {return s;}
		else {
			Tutor t = new Tutor(null, null, email, null, null, null, null,null,null);
			o = fd.getObject("Tutor");
			try {
				o.recuperaDati(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(t.getNome() != null) {return t;}		
			else {return null;}
		}
	}

	@Override
	public int[] valutazioniTot(String email) {
		
		int [] voti = new int[2];
		Arrays.fill(voti, 0);
		
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Risposta");
		List<Object> listR = null;
		try {
			listR = o.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i<listR.size();i++) {
		      Risposta r = (Risposta) listR.get(i);
		      if (r.getValutazione().equals("like")) {voti[0]++;}
		      else if (r.getValutazione().equals("dislike")) {voti[1]++;}
		}
		
		return voti;
	}
}
