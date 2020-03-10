package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import prg_Ajax_Cours.parametresBd;

public class Region {
	public Integer code;
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
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public static ArrayList<Region> listRegionsCountries(String id){
		ArrayList<Region> vouala = new ArrayList<Region>(); 
		
		String req = "SELECT * FROM regions WHERE countryId = "+id;
		try {
			
			ResultSet res = parametresBd.executeRequeteSQL(req);
			
			if(res != null) {
				System.out.println(res.toString());
				while (res.next()) {
					Region player = new Region();
					player.setId(res.getInt(1));
					player.setNom(res.getString(2));
					player.setCode(res.getInt(3));
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
