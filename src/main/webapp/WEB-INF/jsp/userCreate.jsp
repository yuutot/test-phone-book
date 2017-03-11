<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

</head>
<body>
<div class="container">
    <div class="starter-template">
        <h1>User create!</h1>
        <h2>UserId: ${user.getId()}</h2>
        <h2>Login: ${user.getLogin()}</h2>
        <h2>Name: ${user.getName()}</h2>
        <h2>Surname: ${user.getSurname()}</h2>
        <h2>Patronymic: ${user.getPatronymic()}</h2>
    </div>
</div>
<a href="<c:url value="/login" />">Login</a>

</body>

</html>