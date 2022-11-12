<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="ca.concordia.webapp.util.Constants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home | Flight API</title>
</head>
<body>

    <h1> FLIGHTS DATA</h1>
	<a href="addOrUpdate"><button>Add</button></a>
	<br>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>Flight Number</th>
			<th>Hex</th>
			<th>Reg Number</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Alt</th>
			<th>Arr_iata</th>
			<th>Dep_iata</th>
			<th>Flag</th>
			<th>Speed</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<c:forEach var="flight" items="${flights }">
			<tr>
				<td>${flight.flightNumber}</td>
				<td>${flight.hex}</td>
				<td>${flight.regNumber}</td>
				<td>${flight.lat}</td>
				<td>${flight.lng}</td>
				<td>${flight.alt}</td>
				<td>${flight.arrIata}</td>
				<td>${flight.depIata}</td>
				<td>${flight.flag}</td>
				<td>${flight.speed}</td>
				<td>${flight.status}</td>

				<td>&nbsp;&nbsp;<a
					href="addOrUpdate?flightNumber=${flight.flightNumber }">Update</a>&nbsp;&nbsp;<a
					href="delete?flightNumber=${flight.flightNumber }">Delete</a>&nbsp;&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		window.onload = function() {
			if ("${status}" != "${Constants.STATUS_NORMAL}") {
				alert("${msg}");
				//window.history.pushState({},'','/${Constants.ROOT_PATH}')
			}
		};
	</script>
</body>
</html>