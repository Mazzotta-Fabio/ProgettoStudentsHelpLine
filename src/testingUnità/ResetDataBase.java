package testingUnità;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
 
public class ResetDataBase  {
 
	private Connection con;
	public ResetDataBase(){
		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://den1.mysql4.gear.host/studenthelpline";
			String username = "studenthelpline"; 
			String pwd = "st5d3nth3lpl1n3?"; 
			con = (Connection) DriverManager.getConnection(url,username,pwd);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
 
	public void resetDataBase() {
		try {
			this.eliminaTabelle();
			this.creaTabelle();
			this.inserisciDati();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    public void eliminaTabelle() throws SQLException
    {
        String s = new String();
        StringBuffer sb = new StringBuffer();
 
        try
        {
            File f = new File("C:\\MySql\\elimina.sql");
        	FileReader fr = new FileReader(f);
            
            BufferedReader br = new BufferedReader(fr);
 
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();
 
            String[] inst = sb.toString().split(";");
            Statement st = con.createStatement();
 
            for(int i = 0; i<inst.length; i++)
            {
                if(!inst[i].trim().equals(""))
                {
                    st.executeUpdate(inst[i]);
                }
            }
   
        }
        catch(Exception e)
        {
            System.out.println("*** Error ***");
        }
    }
    
    public void creaTabelle() throws SQLException
    {
        String s = new String();
        StringBuffer sb = new StringBuffer();
 
        try
        {
            File f = new File("C:\\MySql\\creazione.sql");
        	FileReader fr = new FileReader(f);
            
            BufferedReader br = new BufferedReader(fr);
 
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();
 
            String[] inst = sb.toString().split(";");
            Statement st = con.createStatement();
 
            for(int i = 0; i<inst.length; i++)
            {
                if(!inst[i].trim().equals(""))
                {
                    st.executeUpdate(inst[i]);
                }
            }
   
        }
        catch(Exception e)
        {
            System.out.println("*** Error ***");
        }
    }
    
    public void inserisciDati() throws SQLException
    {
        String s = new String();
        StringBuffer sb = new StringBuffer();
 
        try
        {
            File f = new File("C:\\MySql\\inserimento.sql");
        	FileReader fr = new FileReader(f);
            
            BufferedReader br = new BufferedReader(fr);
 
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();
 
            String[] inst = sb.toString().split(";");
            Statement st = con.createStatement();
 
            for(int i = 0; i<inst.length; i++)
            {
                if(!inst[i].trim().equals(""))
                {
                    st.executeUpdate(inst[i]);
                }
            }
   
        }
        catch(Exception e)
        {
            System.out.println("*** Error ***");
        }
    }
}
