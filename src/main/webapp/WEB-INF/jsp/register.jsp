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
            <input type="text" class="form-control" name="username" placeholder="Username" required autofocus>
            <input type="password" class="form-control" name="password" placeholder="Password" required>
            <input type="text" class="form-control" name="name" placeholder="Name" required>
            <input type="text" class="form-control" name="surname" placeholder="Surname" required>
            <input type="text" class="form-control" name="patronymic" placeholder="Patronymic" required>
            <p><button type="submit">Войти</button></p>
        </form>
    </div>
</sec:authorize>


</body>
</html>