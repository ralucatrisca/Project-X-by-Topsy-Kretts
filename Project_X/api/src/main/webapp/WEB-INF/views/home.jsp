<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: POF4CLJ
  Date: 22.07.2016
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>WEB-App</title>
</head>
<body>

<center><h1>
    <font face="Verdana">My WEB Application</font>
</h1></center>

<form action="/home/uploadFileForm.html">
    <center><input type="submit" value="Go to upload page"></center>
</form>

<form action="/home/view-data.html">
    <center><input type="submit" value="View-data"></center>

</form>

<div style="clear:both">
</div>
<style type="text/css">
    #content {
        position: absolute;
    }
    #content img {
        position: absolute;
        top: -100px;
        right: -150px;
    }
</style>

</body>
</html>
