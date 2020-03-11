package model;

import java.sql.ResultSet;

import prg_Ajax_Cours.parametresBd;

public class Degrees {
	public static String findDetails(String diploma) {
		String req = "SELECT description FROM degrees WHERE nom LIKE '"+diploma+"';";
		System.out.println(req);
		try {
			ResultSet res = parametresBd.executeRequeteSQL(req);
			
			if(res.next()) {
				req = res.getString(1);
				return req;
			} else {
				return "";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
