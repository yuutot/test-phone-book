<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="../../bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../style.css" />" rel="stylesheet">

</head>

<body>

<sec:authorize access="isAuthenticated()">
    <p>Вы уже автоизированы</p>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <div class="container" style="width: 300px;">
        <c:url value="/reg" var="regUrl" />
        <form action="${regUrl}" method="post">
            <h2 class="form-signin-heading">Please register</h2>
            <div class="input-d">
                <input type="text" class="form-control" name="username" placeholder="Username" required autofocus>
                <span class="error-msg">${errorLogin}</span>
            </div>
            <div class="input-d">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                <span class="error-msg">${errorPassword}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="name" placeholder="Name" required>
                <span class="error-msg">${errorName}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="surname" placeholder="Surname" required>
                <span class="error-msg">${errorSurname}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="patronymic" placeholder="Patronymic" required>
                <span class="error-msg">${errorPatronymic}</span>
            </div>
            <p><button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button></p>
        </form>
    </div>
</sec:authorize>


</body>
</html>