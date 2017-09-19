<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>SUPER-AWESOME-HELLOWORLD</title>
</head>
<body>

<form method="POST" action="/user/showuser">
    <div>
        <label for="name">name:</label>
        <input name="name" id="name" type="text" />
    </div>
    <div>
        <label for="password">Password:</label>
        <input name="password" id="password" type="password" />
    </div>
    <button type="submit">Sign up</button>
</form>

</body>

</html>