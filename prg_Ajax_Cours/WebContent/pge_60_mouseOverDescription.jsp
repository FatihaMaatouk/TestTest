<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			<html>
			<head>
			<meta charset="ISO-8859-1">
			<title>Insert title here</title>
			<script>			
			
			function showDetails(e){
				console.log(e);
				var url="SrvDetails?action=browse&nom="+ e;
		//var requete	
				var requete = new XMLHttpRequest();
				
				requete.open("GET",url,true);
				requete.send(null);
				requete.onreadystatechange=function(){
					if(requete.readyState==4){
						if(requete.status == 200){
							console.log(requete.responseText);
							 document.getElementById('details').innerHTML = requete.responseText;
						}
					
					}
				}
			}
			</script>
			</head>
			<div id="isSuccess"></div>
			<ul>
			<li onmouseover="showDetails(this.textContent)">Licence</li>
			<li onmouseover="showDetails(this.textContent)">Master</li>
			<li onmouseover="showDetails(this.textContent)">Doctorat</li>
			</ul>
			<div id="details"></div>
</html>