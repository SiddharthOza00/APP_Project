<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ca.concordia.webapp.util.Constants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Update | Flight API</title>
</head>
<body>
	<form action="saveFlightData" method="POST">
		<input type="hidden" id="updateFlag" name="updateFlag" value="${flight.flightNumber!=null?1:0 }"/>
		<table>
			<tr>
				<td>Flight Number:</td>
				<td><input type="text" id="flightNumber" onblur="validateFlightNumber(this);" name="flightNumber" value="${flight.flightNumber}" required="required" ${flight.flightNumber!=null?'readonly':'' } /></td>
				<td>Hex: </td>
				<td><input type="text" name="hex" value="${flight.hex}" required="required" /></td>
			</tr>
			<tr>
				<td>Reg Number: </td>
				<td><input type="text" name="regNumber" value="${flight.regNumber}" required="required" /></td>
				<td>Alt: </td>
				<td><input type="number" name="alt" value="${flight.alt}" required="required" /></td>
			<tr>
				<td>Latitude: </td>
				<td><input type="number" step=".000001" name="lat" value="${flight.lat}" required="required" /></td>
				<td>Longitude: </td>
				<td><input type="number" step=".000001" name="lng" value="${flight.lng}" required="required" /></td>
			</tr>
			<tr>
				<td>Arr Iata: </td>
				<td><input type="text" name="arrIata" value="${flight.arrIata}" required="required" /></td>				
				<td>Dep Iata: </td>
				<td><input type="text" name="depIata" value="${flight.depIata}" required="required" /></td>
			</tr>
			<tr>
				<td>Flag</td>
				<td><select style="width:100%;" name="flag" required="required">
						<c:forEach items="${Constants.FLAGS}" var="flag">
							<option value="${flag }"
								${flag==flight.flag?'selected':'' }>${flag }</option>
						</c:forEach>
				</select></td>
				<td>Speed: </td>
				<td><input type="number" name="speed" value="${flight.speed}" required="required" /></td>
			</tr>
			<tr>
			<td>Status: </td>
				<td><select style="width:100%;" name="status" required="required">
						<c:forEach items="${Constants.STATUS_TYPES}" var="status">
							<option value="${status }"
								${status==flight.status?'selected':'' }>${status }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><c:choose>
						<c:when test="${flight.flightNumber==null}">
							<button>Save</button>
						</c:when>
						<c:otherwise>
							<button>Update</button>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form>
	<script>
		const flightNumbers = "${flightNumberList}".split(',');
		function validateFlightNumber(input) {
			let flightNumber = input.value;
			let updateFlag = window.updateFlag.value;
			let ct = flightNumbers.reduce((ct,el)=>el==flightNumber?ct+1:ct,0);
			
			if(ct==0 || updateFlag==1){
				return;
			}
			alert('Flight Number already exists.');
			window.flightNumber.value='';
		}
	</script>
</body>
</html>