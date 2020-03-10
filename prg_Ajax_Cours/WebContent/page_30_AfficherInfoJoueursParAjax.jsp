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
						display=document.getElementById("showSelectPlayer");
						display.innerHTML=requete.responseText;
					}
					
				}	
			}
			}
			
			function findPlayerInfos(val){
				var url="SrvAnimes?action=search&player="+ document.getElementById("player").value;
				//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							let nom = document.getElementById("playerName");
							let id = document.getElementById("playerId");
							let prenom = document.getElementById("playerFirstName");
							let genre = document.getElementById("playerGender");
							datas = requete.responseText.split("/");
							nom.textContent = datas[1];
							id.textContent = datas[0];
							prenom.textContent = datas[2];
							genre.textContent = datas[3];
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
			<body>
			<button name="action" value="showPlayers" onclick="initialise()">Afficher</button>
			<div id="showSelectPlayer">
			</div>
				
				<div id="liste">
					<table >
						<tr>
							<td>ID</td>
							<td>Nom</td>
							<td>Prenom</td>
							<td>Genre</td>
						</tr>
						<tr>
							<td id="playerId"></td>
							<td id="playerName"></td>
							<td id="playerFirstName"></td>
							<td id="playerGender"></td>
						</tr>
						<tr id="players"></tr>
					</table>
				</div>
				<div id ="tableJoueurs"></div>
				<form method="post" id="playerForm">
				Nom : <input type="text" id="nomNewPlayer" placeholder="nom du tennis mawoman"> 
				Prenom : <input type="text" id="prenomNewPlayer" placeholder="Prenom du tennis mawoman"> 
				Sexe : <select name="sexe" id="genderNewPlayer" >
				<option value="m" >Man</option>
				<option value="f" selected>Woman</option></select>
				<button type="submit" onclick="addPlayer(event)">Ajouter un joueur</button>
				</form>
			</body>
</html>