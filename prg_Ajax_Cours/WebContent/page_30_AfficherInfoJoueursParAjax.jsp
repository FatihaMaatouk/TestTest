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
				var url="SrvAnimes?action=list";
				//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
				if(requete.readyState==4){
					if(requete.status == 200){
						alert("Réponse correcte du serveur");
						display=document.getElementById("showSelectPlayer");
						display.textContent=requete.responseText;
						console.log(requete);
					}
					
				}	
			}
			}
			</script>
			</head>
			<body>
			<button name="action" value="showPlayers" onclick="initialise()">Afficher</button>
			<div id="showSelectPlayer">
			</div>
				
				<div id="liste">
					<table style="background-color:#decba4;width:250px">
						<tr>
							<td>ID</td>
							<td>Nom</td>
							<td>Prenom</td>
							<td>Genre</td>
						</tr>
						<tr id="players"></tr>
					</table>
				</div>
			</body>
</html>