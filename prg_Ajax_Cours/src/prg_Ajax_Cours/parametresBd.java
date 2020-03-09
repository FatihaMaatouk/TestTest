package prg_Ajax_Cours;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//	================================
//	Auteur		:	Chouaïb LAGHLAM
//	Date		:	Janvier 2013
//	================================
//	Accès aux Données d’une BD via JDBC
//	penser à faire référence à library jdbc pour
//	mysql, oracle,sqlserver, ...
//	================================
public class parametresBd {
//	propriété	:	type SGBDR : Mysql, MS SQL Server, Oracle,..
	// changer ci-dessous l’attribut SGBDR en valeur MY ou MS ou OR pour spécialiser
	// l’accès à MySQL ou à Microsoft SQL Server ou à Oracle 
	private static final String SGBDR="MY";
	/*		
	 * 		========================
	 * 		paramètres Serveur Mysql
	 * 		========================
	 */
	// 		constante 	:	nom de la source de données :
	//				:	Type d’accès + nom serveur + nom de la BD
	private static final String urlMY = "jdbc:mysql://127.0.0.1:3308/tennisbdd";
	//		constante	:	login
	private static final String userMY = "root";
	//		constante	:	mot de passe
	private static final String passwordMY = "";
	//		constante	:	driver jdbc
	private static final String driverJMY = "com.mysql.jdbc.Driver";
	
	/*		
	 * 		========================
	 * 		paramètres Serveur Oracle 11g et plus
	 * 		========================
	 */
	//		constante 	:	nom de la source de données
	private static final String urlOR = "";
	//		constante	:	login
	private static final String userOR = "";
	//		constante	:	mot de passe
	private static final String passwordOR = "";
	//		constante	:	driver jdbc
	private static final String driverJOR = "";
	/*
	 * 		==============================
	 *  	getteurs (pas de setteurs ici)
	 *  	==============================
	 */
	public static String getSGBDR() {
		return SGBDR;
	}
	public static String getDriverJ() {
		switch(getSGBDR())
		{
			case	"MY":			// Mysql	
				return driverJMY;
			case	"OR":
				return driverJOR;		// Oracle
			default 	:
				return "";
		}
	}
	public static String getUrl() {
		switch(getSGBDR())
		{
			case	"MY":			// Mysql	
				return urlMY;
			case	"OR":
				return urlOR;		// Oracle
			default 	:
				return "";
		}
	}
	public static String getUser() {
		switch(getSGBDR())
		{
			case	"MY":			// Mysql	
				return userMY;
			case	"OR":
				return userOR;		// Oracle
			default 	:
				return "";
		}
	}
	public static String getPassword() {
		switch(getSGBDR())
		{
			case	"MY":			// Mysql	
				return passwordMY;
			case	"OR":
				return passwordOR;		// Oracle
			default 	:
				return "";
		}
	}
	//		méthode	:	pour insérer ou modifier ou supprimer
	//		dans la BD
	public static int executeUpdateSQL(String requete) throws ClassNotFoundException{
	try {
		Class.forName(getDriverJ());
		Connection connexion = DriverManager.getConnection(getUrl(),getUser(),getPassword());
		Statement instruction = connexion.createStatement();
		int resultatTemp = instruction.executeUpdate(requete);
		return 0;
		} 
	catch (Exception e) 
	{	
		return -1;
		}
	}
	//		méthode		:	pour lire BD
	public static ResultSet executeRequeteSQL(String requete) throws ClassNotFoundException{
	try {
		Class.forName(getDriverJ());
		ResultSet resultat = null;
		Connection connexion = DriverManager.getConnection(getUrl()
				,getUser(),getPassword());
		Statement instruction = connexion.createStatement();
		ResultSet resultatTemp = instruction.executeQuery(requete);
		resultat = resultatTemp;
		return resultat;
		} 
	catch (Exception e) {
		return null;
		}
	}
}
