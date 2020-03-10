<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Date afficheee par JS et rafraichie 
automatiquement
 -->
 <div style="width : 400px; height : 50px ;
 		 background : grey ; color : white 
 		 test-align : center ; line-height : 50px;">
 </div>
 <br>
 <label name="afficheHeure" id="Labaffiche">...</label>
 <script>
 // je récupére références des éléments de IHM=UI
 var affichageDansDiv=document.querySelector("div");
 
 function horloge()
 {
	 var heure=new Date();
	  affichageDansDiv.textContent="il est "+heure.getHours()+
	  ":"+heure.getMinutes()+":"+heure.getSeconds();
	  var affichageDansLabel=document.getElementById("Labaffiche");
	 
 }
// appler la foction c-dessus toutes les secondes
setInterval("horloge()",1000;)
	 
 
 </script>

</body>
</html>