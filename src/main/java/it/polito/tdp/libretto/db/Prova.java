package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.libretto.model.Voto;

public class Prova {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=Viennese1553x?";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql = "SELECTED corso, punti, data "
					+ "FROM voto";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				
	//			System.out.println(corso + " = " + punti);
				
				Voto v = new Voto(corso, punti, null);
				voti.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
