package com.beta.rsatech.churchcradle.server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class DBConnection {
	private static Connection con;
	private static final String MYSQL_DRIVER = "jdbc:mysql://";
	private static DBConnection dbc = new DBConnection();
	private static int counter;

	private DBConnection(){
	}

	public static Connection getConnection(){
		if(counter == 0){
			dbc.establishConnection();
			counter ++;
		}
		
		try {
			if(con.isClosed()){
				dbc.establishConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

	private void establishConnection(){
		//		try{
		//
		//			String url = null;
		////			if (SystemProperty.environment.value() ==
		////					SystemProperty.Environment.Value.Production) {
		////				// Connecting from App Engine.
		////				// Load the class that provides the "jdbc:google:mysql://"
		////				// prefix.
		////				Class.forName("com.mysql.jdbc.GoogleDriver");
		////				url = "jdbc:google:mysql://smscradle:smsdb?user=root";
		////			} else {
		//				// Connecting from an external network.
		//				Class.forName("com.mysql.jdbc.Driver");
		//				url = "jdbc:mysql://127.0.0.1:3306/church_cradle?user=root";
		//				url = "jdbc:mysql://"+ServerGlobalResources.getInstance().getIp()+":"+ServerGlobalResources.getInstance().getPort()
		//						+"/"+ServerGlobalResources.getInstance().getDbName()+"?user="+ServerGlobalResources.getInstance().getDbUserName();
		//			//}
		//
		//			con = (Connection) DriverManager.getConnection(url);
		//
		//		}catch(Exception e){
		////			e.printStackTrace();
		//		}
		
		String url = "";

		try {
			if (SystemProperty.environment.value() ==
					SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://" prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
				//url = "jdbc:google:mysql://cradle-labs:db/church_cradle_gl?user=root&autoReconnect=true";
				//url = "jdbc:mysql://127.0.0.1:3306/church_cradle?user=root&autoReconnect=true";
				url = MYSQL_DRIVER+"127.0.0.1:3306/church_cradle_web_google?user=root&password=root&autoReconnect=true";



//				Class.forName("com.mysql.jdbc.Driver");
//				url = "jdbc:mysql://104.197.74.211:3306/church_cradle_gl?user=root&autoReconnect=true";

			} else {
				// Local MySQL instance to use during development.
				Class.forName("com.mysql.jdbc.Driver");
				//url = "jdbc:mysql://173.194.87.191:3306/church_cradle_gl?user=root&autoReconnect=true";
				url = MYSQL_DRIVER+"127.0.0.1:3306/church_cradle_web_google?user=root&password=root&autoReconnect=true";

				//url = "jdbc:mysql://127.0.0.1:3306/church_cradle?user=root&autoReconnect=true";


				//173.194.105.1
				// Alternatively, connect to a Google Cloud SQL instance using:
				// jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/guestbook?user=root

			}
			con = (Connection)DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}


		//		try{
		//			Class.forName("com.mysql.jdbc.Driver");
		//		}catch(Exception e){
		//			e.printStackTrace();
		//		}
		//
		//		try{
		//			String url = MYSQL_DRIVER+ServerGlobalResources.getInstance().getIp()+":"+ServerGlobalResources.getInstance().getPort()+"/";
		//			con = (Connection)DriverManager.getConnection(url+ServerGlobalResources.getInstance().getDbName(), ServerGlobalResources.getInstance().getDbUserName(), ServerGlobalResources.getInstance().getDbPassword());
		//
		//		}catch(Exception e){
		//			e.printStackTrace();
		//		}
	}
}