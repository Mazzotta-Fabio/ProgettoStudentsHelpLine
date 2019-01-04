package gestioneDomanda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Questa classe implementa l'interfaccia GestioneDomanda.
 * @author Antonio Cimino
 * @version 1.0
 */
public class ImpGestioneDomanda implements GestioneDomanda{
	
	public ImpGestioneDomanda() {}
	
	/**
	 * Il metodo serve per scaricare l'allegato nella cartella downloads.
	 * @param password,destinatario: sono uno la password da inviare e l'altro l'email dove inviare l'email
	 */
	public void scaricaAllegato(String fileName) throws IOException {
		
		File sourceLocation = new File(fileName);
		String destLocation = new String("C:\\Users\\Antonio\\Downloads");
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
		
	}

	@Override
	public void eliminaDomanda(int id) {
		Domanda d = new Domanda (id, null, null, null, null, null, null);
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Domanda");
		try {
			o.cancellaDati(d);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> recuperaDomandeSenzaRisposta(String email) {
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Domanda");
		ArrayList<Object> listaD = null;
		try {
			listaD = o.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		List<String> listaDomande = new ArrayList<String>();
		for(int i = 0;i<listaD.size();i++) {
		      Domanda d = (Domanda) listaD.get(i);
		      if (d.getRisposta().getId() == 0) {
		    	  if(email.equals(d.getStudente().getEmail())) {
		    		  listaDomande.add(String.valueOf(d.getId()));
		    		  listaDomande.add(d.getOggetto());
		    		  listaDomande.add(d.getTesto());
		    		  listaDomande.add(d.getTutor().getEmail());
		    	  }
		      }	  
		}
		return listaDomande;
	}

	@Override
	public List<String> recuperaDomandeConRisposta(String email) {
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Domanda");
		ArrayList<Object> listaD = null;
		try {
			listaD = o.recuperaTutto();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		List<String> listaDomande = new ArrayList<String>();
		for(int i = 0;i<listaD.size();i++) {
		      Domanda d = (Domanda) listaD.get(i);
		      if (d.getRisposta().getId() != 0) {
		    	  if(email.equals(d.getStudente().getEmail())) {
		    		  listaDomande.add(String.valueOf(d.getId()));
		    		  listaDomande.add(d.getOggetto());
		    		  listaDomande.add(d.getTesto());
		    		  listaDomande.add(d.getTutor().getEmail());
		    	  }
		      }	  
		}
		return listaDomande;
	}

	@Override
	public ArrayList<String> visualizzaDomanda(int id) {
		
		ArrayList<String> listaInfo = new ArrayList<String>();
		
		FactoryDAO fd = new FactoryDAO();
		Domanda d = new Domanda (id, null, null, null, null, null, null);	
		ObjectDAO o = fd.getObject("Domanda");
		try {
			o.recuperaDati(d);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listaInfo.add(d.getAllegato());
		listaInfo.add(d.getOggetto());
		listaInfo.add(d.getTesto());
		
		Studente s = d.getStudente(); 
		o = fd.getObject("Studente");
		try {
			o.recuperaDati(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listaInfo.add(d.getStudente().getEmail());
 
		Tutor t = d.getTutor(); 
		o = fd.getObject("Tutor");
		try {
			o.recuperaDati(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listaInfo.add(t.getEmail());
		
		Risposta r = d.getRisposta();
		o = fd.getObject("Risposta");
		try {
			o.recuperaDati(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listaInfo.add(r.getTesto());
		listaInfo.add(r.getAllegato());
		listaInfo.add(r.getValutazione());
		
		return listaInfo;
	}

	@Override
	public void inserisciRisposta(String testo, int idDomanda, String url) {
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Risposta");
		Risposta r = new Risposta(0, testo, url,null);
		try {
			o.inserisciDati(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		o = fd.getObject("Domanda");
		Domanda d = new Domanda(idDomanda, null, null,null, null, null, null);
		try {
			o.recuperaDati(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			o.cancellaDati(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.setRisposta(r);
		try {
			o.inserisciDati(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
