<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring Boot Integration, Web, Security, JPA</title>
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css'/>" media="screen">
</head>
<body>
    <h1>Spring Boot Integration, Web, Security, JPA - LIST</h1>
    <br />
    <div>
    <table>
        <tr>
                <td>ID Atm</td>
                <td>Distance</td>
              	<td>Type</td>
              	<td>City</td>
              	<td>House Number</td>
              	<td>Postal Code</td>
              	<td>Street</td>
              	<td>Lattitude</td>
              	<td>Longitude</td>
        </tr>
        
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.distance}</td>
              	<td>${item.type}</td>
              	<td>${item.address.city}</td>
              	<td>${item.address.housenumber}</td>
              	<td>${item.address.postalcode}</td>
              	<td>${item.address.street}</td>
              	<td>${item.address.geoLocation.lat}</td>
              	<td>${item.address.geoLocation.lng}</td>
            </tr>
        </c:forEach>
    </table>

    </div>
</body>
</html>
