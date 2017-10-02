<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>SUPER-AWESOME</title>
    <meta charset="UTF-8">
    <style>
        .questions{
            display: flex;
        }

        p {
            font-size: 3em;
        }

        .question1{
            margin-left: 100px;
            margin-right: 200px;
        }

        button {
            padding: 3em;
        }
    </style>
</head>
<body>


<h1>Question for you sir</h1>
<p>Which city is closer to you ${Question.getData().getDest1()} || ${Question.getData().getDest2()}</p>
<div class="questions">
    <div class="question1">
        <form action="/question/questionLocation" method="POST">
            <input type="name" id="answer1" name="answer1" value="${Question.getData().getDest1()}">
            <input type="submit" value="This city">
        </form>
    </div>
    <div class="question2">
        <form action="/question/questionLocation2" method="POST">
            <input type="name" id="answer2" name="answer2" value="${Question.getData().getDest2()}">
            <input type="submit" value="This city">
        </form>
    </div>
</div>
<div>
    <p> Your current location is ${Question.getData().getCurrentLoc()}</p>
</div>

</body>

</html>