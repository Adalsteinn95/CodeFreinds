<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>SUPER-AWESOME</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Your Logged in as ${user.getName()}</h1>
    <h1>And your password is ${user.getPass()}</h1>
    <a href="question"><h2>Let's go to questions!</h2></a>
</body>

</html>