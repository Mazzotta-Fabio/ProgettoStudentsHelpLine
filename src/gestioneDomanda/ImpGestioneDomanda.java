package gestioneDomanda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImpGestioneDomanda implements GestioneDomanda{
	
	public ImpGestioneDomanda() {}
	
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

}
