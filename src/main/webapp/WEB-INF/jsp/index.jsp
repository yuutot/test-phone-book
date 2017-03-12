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
    <meta name="author" content="">
    <link href="<c:url value="../../bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../style.css" />" rel="stylesheet">
</head>

<body>

<div class="container-fluid">

        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/register" />" role="button">Регистрация</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <header class="row user">

                <div class="col-md-4 add-cont">
                    <%--<a class="add-c" href="<c:url value="/createPhone"/>">Add contact</a>--%>
                </div>
                    <c:url value="/search" var="Url" />
                    <form action="${Url}" method="post" class="col-md-4 form-s">
                        <input type="text" class="form-control"  placeholder="Search" name="search" >
                               <button type="submit" class="btn btn-primary ">search</button>
                    </form>
                <div class="col-md-4 user-info">
                    <div class="log"><sec:authentication property="principal.username" />
                        <div class="quit">
                            <a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a>
                        </div>
                    </div>
                </div>
                </header>

            <div class="container add-form" style="width: 300px;">
                <c:url value="/createPhoneHandler" var="Url" />
                <form action="${Url}" method="post">
                    <h2 class="form-signin-heading">Create contact</h2>
                    <div class="input-d">
                        <input type="text" class="form-control" name="name" placeholder="Name" required autofocus>
                        <span class="error-msg">${errorName}</span>
                    </div>
                    <div class="input-d">
                        <input type="text" class="form-control" name="surname" placeholder="Surname" required>
                        <span class="error-msg" >${errorSurname}</span>
                    </div>
                    <div class="input-d">
                        <input type="text" class="form-control" name="patronymic" placeholder="Patronymic" required>
                        <span class="error-msg">${errorPatronymic}</span>
                    </div>
                    <div class="input-d">
                        <input type="tel" class="form-control" name="mobile" placeholder="Mobile phone" required>
                        <span class="error-msg">${errorMobile}</span>
                    </div>
                    <div class="input-d">
                        <input type="tel" class="form-control" name="home" placeholder="Home phone">
                        <span class="error-msg">${errorHome}</span>
                    </div>
                    <div class="input-d">
                        <input type="text" class="form-control" name="address" placeholder="Address">
                    </div>
                    <div class="input-d">
                        <input type="email" class="form-control" name="email" placeholder="Email">
                        <span class="error-msg">${errorEmail}</span>
                    </div>
                    <p style="text-align: center;"><button class="btn btn-primary" type="submit">Create</button></p>
                </form>
            </div>
            <c:forEach items="${phones}" var="phone">
                <div class="contact-item">

                <p class="c-name"> ${phone.getName()} ${phone.getSurname()} ${phone.getPatronymic()}</p>
                    <div class="actions">
                <p>Mobile: <a href="tel:${phone.getMobilePhone()}">${phone.getMobilePhone()}</a></p>
                        <c:if test="${phone.getHomePhone().length() > 0}">
                            <p>Home: <a href="tel:${phone.getHomePhone()}">${phone.getHomePhone()}</a></p>
                        </c:if>
                    </div>
                    <c:if test="${phone.getAddress().length() > 0}">
                        <p>Address: ${phone.getAddress()}</p>
                    </c:if>
                    <c:if test="${phone.getEmail().length() > 0}">
                        <p>Email: <a href="mailto:${phone.getEmail()}">${phone.getEmail()}</a></p>
                    </c:if>
                    <div class="actions">
                        <a class="btn btn-primary" href="<c:url value="/editPhone/${phone.getId()}"/>">Edit</a>
                        <a class="btn btn-danger" href="<c:url value="/removePhone/${phone.getId()}"/>">Remove</a>
                    </div>

                </div>
            </c:forEach>
        </sec:authorize>

</div>
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script>
    $('.user-info .log').mouseover(function () {
        if (!$('.quit').hasClass('open')){
            $('.quit').fadeIn();
            $('.quit').addClass('open');
        }

    })

    $('.user-info .log').mouseout(function () {
        $('.quit').removeClass('open')
            .fadeOut();
    })
</script>
</body>
</html>