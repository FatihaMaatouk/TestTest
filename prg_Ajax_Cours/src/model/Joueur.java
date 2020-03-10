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
			
			if(res != null) {
				System.out.println(res.toString());
				while (res.next()) {
					System.out.println(res.toString());
					Joueur player = new Joueur();
					player.setId(res.getInt(1));
					player.setNom(res.getString(2));
					player.setPrenom(res.getString(3));
					player.setGenre(res.getString(4));
					vouala.add(player);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vouala;
	}
	
	public static Joueur searchPlayer(String id) throws SQLException{
		
		String req = "SELECT * FROM joueurs WHERE id = " + id;
		Joueur j = new Joueur();
		try {
			
			ResultSet res = parametresBd.executeRequeteSQL(req);
			
			if(res != null) {
				System.out.println(res.toString());
				while (res.next()) {
					System.out.println(res.toString());
					Joueur player = new Joueur();
					player.setId(res.getInt(1));
					player.setNom(res.getString(2));
					player.setPrenom(res.getString(3));
					player.setGenre(res.getString(4));
					return player;
				}
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
public static Boolean addPlayer(String nom, String prenom, String genre) throws SQLException{
		
		String req = "INSERT INTO joueurs(id,nom,prenom,sexe) VALUES(null,'" + nom+"','"+prenom+"','"+genre+"')";
		System.out.println(req);
		try {
			
			parametresBd.executeUpdateSQL(req);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
