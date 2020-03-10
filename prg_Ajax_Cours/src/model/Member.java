package model;

import java.sql.ResultSet;

import prg_Ajax_Cours.parametresBd;

public class Member {
	public String nom;
	public String password;
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setPassword(String pw) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	public static Boolean register(String name, String pw) {
		String req = "SELECT * FROM members WHERE pseudo LIKE '"+name+"';";
		
		try {
			ResultSet res = parametresBd.executeRequeteSQL(req);
			
			if(!res.next()) {
				req = "INSERT INTO members(id,pseudo,password) VALUES(null,'" + name +"','"+ pw +"')";
				System.out.println(req);
				try {
					
					parametresBd.executeUpdateSQL(req);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
