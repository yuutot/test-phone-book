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

<sec:authorize access="!isAuthenticated()">
    <p>Вы не автоизированы</p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="container" style="width: 300px;">
        <c:url value="/createPhoneHandler" var="Url" />
        <form action="${Url}" method="post">
            <h2 class="form-signin-heading">Create phone</h2>
            <input type="text" class="form-control" name="name" placeholder="Name" required autofocus>
            <input type="text" class="form-control" name="surname" placeholder="Surname" required>
            <input type="text" class="form-control" name="patronymic" placeholder="Patronymic" required>
            <input type="tel" class="form-control" name="mobile" placeholder="Mobile phone" required>
            <input type="tel" class="form-control" name="home" placeholder="Home phone">
            <input type="text" class="form-control" name="address" placeholder="Address">
            <input type="email" class="form-control" name="email" placeholder="Email">
            <p><button type="submit">Создать</button></p>
        </form>
    </div>
</sec:authorize>


</body>
</html>