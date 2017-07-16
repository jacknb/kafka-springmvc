<%--
  Created by IntelliJ IDEA.
  User: znb
  Date: 17-7-16
  Time: 下午7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>kafka_send</title>
</head>
<body>
    <h1>Send a Message</h1>
    <form action="onsend" method="post">
        MessageText:<textarea name="message">${time}</textarea>
        <br>
        <input type="submit" value="Submit">
    </form>

    <h2><a href="welcome">RETURN HOME</a></h2>
</body>
</html>
