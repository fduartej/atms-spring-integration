<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring Boot Integration, Web, Security, JPA</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		$( "#idbtn" ).click(function() {
  			var jsondata = $('#idjson').val();
  			alert("JSON:"+jsondata);
  			$.ajax({
  			  type: "POST",
  			  url: "/integration/create",
  			  data: jsondata,
  	          contentType: "application/json; charset=utf-8",
  	          dataType: "json",
  	          success: function(data){
  	        	  alert("Created!!!!");
  	          },
  	          error: function(errMsg){
  	        	  console.log(errMsg);
  	        	 alert("Created!!!!");
  	          }
  			});
  		});
	});
  </script>
</head>
<body>
    <h1>Spring Boot Integration, Web, Security, JPA - CREATE</h1>
    <br />
    Please USE JSON format
    <br />
    <div>
	<table width="200" height="155" border="1">
  <tr>
    <td><textarea id="idjson" name="textarea" rows="10" cols="60">
    	{"type":"ING","distance":0,"address":{"street":"t Plateau TEST","housenumber":"14","postalcode" : "3202 GM TEST","city":"SPIJKENISSE TEST","geoLocation":{"lat":"51.854636","lng":"4.316897"}}}</textarea></td>
  </tr>
  <tr>
    <td><input id="idbtn" type="submit" name="Submit" value="Create"></td>
  </tr>
  <tr>
    <td><a href="/integration/atms" target="_blank">JSON</a>&nbsp;<a href="/web/atms" target="_blank">LIST</a> </td>
  </tr>
</table>

    </div>
</body>
</html>
