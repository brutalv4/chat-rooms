<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <title>Login</title>
    <%-- see mvc:resources mapping in mvc.xml --%>
    <link href="<c:url value="/resources/login/reset.css"/>" rel="stylesheet" />
    <link href="<c:url value="/resources/login/structure.css"/>" rel="stylesheet" />
</head>
<body>

<form:form method="post" commandName="currentUser" action="submit-login" class="box login">
    <fieldset class="boxBody">
        <%--<form:label path="name">Username:</form:label>--%>
        <form:input type="text" path="name" placeholder="Username" tabindex="1" required="true"/>

        <%--<form:label path="password"><a href="#" class="rLink" tabindex="5">Forgot your password?</a>Password:</form:label>--%>
        <form:password path="password" placeholder="Password" tabindex="5" required="true"/>
    </fieldset>

    <footer>
        <%-- not yet implemeneted --%>
        <%--<label><input type="checkbox" tabindex="3">Keep me logged in</label>--%>
        <input type="submit" class="btnLogin" value="Login" tabindex="4">
    </footer>
</form:form>

<footer id="main">
    Simple ChatRooms application (course project) |
    <a href="http://skillsup.ua/training/courses/diving-into-java/root/diving-into-java-practice-i/">
        Diving into Java (practice 1)</a> |
    <a href="http://skillsup.ua/">skillsup.ua</a>
</footer>

</body>
</html>
