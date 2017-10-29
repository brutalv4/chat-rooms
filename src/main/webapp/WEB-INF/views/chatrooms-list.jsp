<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Home</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="<c:url value="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>" rel="stylesheet"/>

        <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <h2>Available ChatRooms</h2>
            <!--Search Form -->
            <%-- not yet implemented --%>
            <%--<form action="/search-chatroom" method="get" id="seachEmployeeForm" role="form">--%>
                <%--<input type="hidden" id="searchAction" name="searchAction" value="searchByName">--%>
                <%--<div class="form-group col-xs-5">--%>
                    <%--<input type="text" name="employeeName" id="employeeName" class="form-control" required="true" placeholder="Type the Name or Descripton of the ChatRoom"/>--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-info">--%>
                    <%--<span class="glyphicon glyphicon-search"></span> Search--%>
                <%--</button>--%>
                <%--<br></br>--%>
                <%--<br></br>--%>
            <%--</form>--%>

            <!--ChatRooms List-->
            <form
                    <%--action="/select-room" method="post" --%>
                    id="chatRoomForm">
                <c:choose>
                    <c:when test="${not empty chatRoomsList}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <%--<td>id</td>--%>
                                    <td>Name</td>
                                    <td>Descripton</td>
                                </tr>
                            </thead>

                            <c:forEach var="chatroom" items="${chatRoomsList}">
                                <tr>
                                    <%--<td>${chatroom.id}</td>--%>
                                    <td>
                                        <a href="/select-room?chatRoomId=${chatroom.id}">${chatroom.name}</a>
                                    </td>
                                    <td>${chatroom.description}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                </c:choose>
            </form>
        </div>

    </body>
</html>
