package gestioneInterazioneTutorStudente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class ImpGestioneInterazioneTutorStudente implements GestioneInterazioneTutorStudente {
	
	private String destLocation;
	
	public ImpGestioneInterazioneTutorStudente() {
		destLocation = new String("C:\\Users\\Antonio\\Desktop\\Documenti\\web\\File\\file");
	}
	
    public String Upload(Part part)throws IOException {
        
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
}
