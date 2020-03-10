<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			<html>
			<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
			<script>
			function initialise()
			{
				var url="SrvVilles?action=choixPays";
				//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
				if(requete.readyState==4){
					if(requete.status == 200){
						display=document.getElementById("showCountries");
						display.innerHTML=requete.responseText;
					}
					
				}	
			}
			}
			
			function showRegions(val){
				console.log(this.val);
				var url="SrvVilles?action=choixRegion&region="+ val
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							display=document.getElementById("showRegions");
							display.innerHTML=requete.responseText;
						}
					
					}
				}
			}
			
			function showDept(val){
				var url="SrvVilles?action=choixDept&dept="+ val
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							display=document.getElementById("showDeps");
							display.innerHTML=requete.responseText;
						}
					
					}
				}
			}
			
			function showCities(val){
				var url="SrvVilles?action=choixVille&cities="+ val
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							display=document.getElementById("showDeps");
							display.innerHTML=requete.responseText;
						}
					
					}
				}
			}
			
			function submitFormAjax(e){
				e.preventDefault();
				var url="SrvRegister?action=add&nom="+ document.getElementById("name").value +
						"&password=" + document.getElementById("password").value;
				//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							 requete.responseText;
							if(requete.responseText === "false"){
								document.getElementById("isSuccess").innerHTML = "L'identifiant existe déjà.";
							} else {
								document.getElementById("isSuccess").innerHTML = "Inscription confirmée";
							}
						}
					
					}
				}
			}
			</script>
			</head>
			<div id="isSuccess"></div>
			<form method="get">
			Nom: <input type="text" id="name" placeholder="Nom">
			Password: <input type="password" id="password" placeholder="Mot de Passe">
			<button type="submit" onclick="submitFormAjax(event)">TestThis</button>
			</form>
</html>