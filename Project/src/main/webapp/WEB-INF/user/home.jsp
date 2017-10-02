<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <title>SUPER-AWESOME-HELLOWORLD</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>WELCOME TO KEWLKVIS</h1>
    <h3>Sign up here!</h3>
    <form method="POST" action="/user/showuser">
        <div>
            <label for="name">name:</label>
            <input name="name" id="name" type="text" />
        </div>
        <div>
            <label for="password">Password:</label>
            <input name="password" id="password" type="password" />
        </div>
        <div>
            <label for="email">email</label>
            <input name="email" id="email" type="email" />
        </div>
        <button type="submit">Sign up</button>
    </form>
    <h3>Already have an account? Sign in here!</h3>
    <form method="POST" action="/user/profile">
        <div>
            <label for="name">name:</label>
            <input name="name" id="name" type="text" />
        </div>
        <div>
            <label for="password">Password:</label>
            <input name="password" id="password" type="password" />
        </div>
        <button type="submit">LOG IN</button>
    </form>
</body>
</html>