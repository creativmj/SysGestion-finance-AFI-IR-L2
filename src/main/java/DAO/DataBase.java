package DAO;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private Connection connectBD;
    static final String user = "root";
    static final String passwd = "";
    static final String port = "3306";
    static final String url = "jdbc:mysql://localhost:"+port+"/Sys-Gestion";
    
    private FileWriter log;
    
	public Connection connection() throws SQLException, IOException{
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      this.connectBD = DriverManager.getConnection(url, user, passwd);
	    } catch (Exception ex) {
			Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
	    	ex.printStackTrace();
	    }
		return connectBD;     

	  }
	
	public void close() throws SQLException {
		
		if(connectBD!=null){
			connectBD.close();
		}
	}

	public Statement createAStatement() throws SQLException{
		return connectBD.createStatement();
	}

	public Connection getConnectBD() {
		return connectBD;
	}

	public void setConnectBD(Connection connectBD) {
		this.connectBD = connectBD;
	}
}
