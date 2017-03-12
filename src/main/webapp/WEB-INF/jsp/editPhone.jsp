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
    <div class="container" style="width: 300px;">
        <c:url value="/editPhoneHandler/${phone.getId()}" var="Url" />
        <form action="${Url}" method="post">
            <h2 class="form-signin-heading">Edit phone</h2>
            <div class="input-d">
                <input type="text" class="form-control" name="name" value="${phone.getName()}" required autofocus>
                <span class="error-msg">${errorName}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="surname" value="${phone.getSurname()}" required>
                <span class="error-msg">${errorSurname}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="patronymic" value="${phone.getPatronymic()}" required>
                <span class="error-msg">${errorPatronymic}</span>
            </div>
            <div class="input-d">
                <input type="tel" class="form-control" name="mobile" value="${phone.getMobilePhone()}" required>
                <span class="error-msg">${errorMobile}</span>
            </div>
            <div class="input-d">
                <input type="tel" class="form-control" name="home" value="${phone.getHomePhone()}">
                <span class="error-msg">${errorHome}</span>
            </div>
            <div class="input-d">
                <input type="text" class="form-control" name="address" value="${phone.getAddress()}">
            </div>
            <div class="input-d">
                <input type="email" class="form-control" name="email" value="${phone.getEmail()}">
                <span class="error-msg">${errorEmail}</span>
            </div>
            <p style="text-align: center;"><button class="btn btn-primary full-w" type="submit">Save</button></p>
        </form>
    </div>
</sec:authorize>


</body>
</html>