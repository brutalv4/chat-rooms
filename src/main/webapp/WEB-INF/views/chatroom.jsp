<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CR: ${chatRoomName}</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="<c:url value="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="resources/chatroom/chatroom.css"/>" rel="stylesheet"/>

    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/chatroom/chatroom.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-info">
        <div class="panel-body">
            <div class="text-left">
                <a href="/chatrooms">Back to ChatRooms list....</a>
            </div>
            <div id="current-time" class="text-right">current time</div>
        </div>
    </div>

    <div class="msg-wrap" style="position: relative">
        <script>var chatRoomId = ${chatRoomId};</script>
    </div>

    <div class="my-footer">
        <div class="send-wrap ">
            <textarea class="form-control send-message" rows="3" placeholder="Write a reply..."></textarea>
        </div>
        <div class="btn-panel">
            <a href="" class=" col-lg-4 text-right btn   send-message-btn pull-right" role="button">
                <span class="glyphicon glyphicon-send"></span> Send Message
            </a>
        </div>
    </div>
</div>

</body>
</html>
