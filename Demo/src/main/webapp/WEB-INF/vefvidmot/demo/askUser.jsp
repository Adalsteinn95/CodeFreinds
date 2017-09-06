<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
    <title>TEST RUN</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>TEST RUN</h1>
<p>this is an test</p>
<form method="POST" action="/demo/who">
    <label for="name">Name:</label>
    <input name="name" type="text">
    <input type="submit" value="okay">
</form>

</body>

</html>