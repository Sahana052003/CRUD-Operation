
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Form</title>
</head>
<body>
<table border="2">

<tr>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>MobileNumber</th>
<th>Gender</th>
<th>nationality</th>
</tr>


<c:forEach items="${message}" var="singleData">
<tr>
<td>${singleData.name}</td>
<td>${singleData.email}</td>
<td>${singleData.mobileNumber}</td>
<td>${singleData.location}</td>
<td>${singleData.gender}</td>
<td>${singleData.nationality}</td>
<td><a href="getData?id=${singleData.id}">UPDATE</a></td>
</tr>
</c:forEach>
</table>



</body>
</html>