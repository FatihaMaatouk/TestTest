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
							display=document.getElementById("showCities");
							display.innerHTML=requete.responseText;
						}
					
					}
				}
			}
			
			function addPlayer(e){
				e.preventDefault();
				var url="SrvAnimes?action=add&nom="+ document.getElementById("nomNewPlayer").value +
						"&prenom=" + document.getElementById("prenomNewPlayer").value +"&genre="+document.getElementById("genderNewPlayer").value ;
				//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							document.getElementById("tableJoueurs").innerHTML = requete.responseText;
							console.log(requete.responseText);
						}
					
					}
				}
			}
			</script>
			</head>
			<body onload="initialise();">
				<div id="showCountries">
				</div>
				<div id="showRegions">
				</div>	
				<div id="showDeps">
				</div>	
				<div id="showCities">
				</div>
				</body>
</html>