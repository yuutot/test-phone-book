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
    <p>Вы не авторизированы</p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="container" style="width: 300px;">
        <c:url value="/editPhoneHandler/${phone.getId()}" var="Url" />
        <form action="${Url}" method="post">
            <h2 class="form-signin-heading">Edit phone</h2>
            <input type="text" class="form-control" name="name" value="${phone.getName()}" required autofocus>
            <input type="text" class="form-control" name="surname" value="${phone.getSurname()}" required>
            <input type="text" class="form-control" name="patronymic" value="${phone.getPatronymic()}" required>
            <input type="tel" class="form-control" name="mobile" value="${phone.getMobilePhone()}" required>
            <input type="tel" class="form-control" name="home" value="${phone.getHomePhone()}">
            <input type="text" class="form-control" name="address" value="${phone.getAddress()}">
            <input type="email" class="form-control" name="email" value="${phone.getEmail()}">
            <p><button type="submit">Сохранить</button></p>
        </form>
    </div>
</sec:authorize>


</body>
</html>