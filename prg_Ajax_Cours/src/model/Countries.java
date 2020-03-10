package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import prg_Ajax_Cours.parametresBd;

public class Countries {
	public String code;
	public Integer id;
	public String nom;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static ArrayList<Countries> listCountries(){
		ArrayList<Countries> vouala = new ArrayList<Countries>(); 
		
		String req = "SELECT * FROM countries";
		try {
			
			ResultSet res = parametresBd.executeRequeteSQL(req);
			
			if(res != null) {
				System.out.println(res.toString());
				while (res.next()) {
					System.out.println(res.toString());
					Countries player = new Countries();
					player.setId(res.getInt(1));
					player.setNom(res.getString(2));
					player.setCode(res.getString(3));
					vouala.add(player);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vouala;
	}
}
