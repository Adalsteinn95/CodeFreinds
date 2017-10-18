<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>SUPER-AWESOME</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>Congratulations with the new account ${user.getName()}!</h1>
<h1>Your Password is ${user.getPass()}!</h1>
<h1>Your email is ${user.getEmail()}</h1>

<h2>Please login</h2>
<a href="login">here!</a>

</body>

</html>