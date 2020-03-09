package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prg_Ajax_Cours.parametresBd;

public class Joueur {
	public String nom;
	
	public Integer id;
	
	public String prenom;
	
	public Integer size;
	
	public String genre;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public static ArrayList<Joueur> listPlayers() throws SQLException{
		ArrayList<Joueur> vouala = new ArrayList<Joueur>(); 
		
		String req = "SELECT * FROM joueurs";
		try {
			ResultSet res = parametresBd.executeRequeteSQL(req);
			System.out.println(res.toString());
			if(res != null) {
				System.out.println(res.toString());
				while (res.next()) {
					Joueur player = new Joueur();
					player.setId(res.getInt(0));
					player.setNom(res.getString(1));
					player.setPrenom(res.getString(2));
					player.setGenre(res.getString(3));
					vouala.add(player);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vouala;
	}
	
}
