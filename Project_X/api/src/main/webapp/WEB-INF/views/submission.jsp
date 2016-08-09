<%--
  Created by IntelliJ IDEA.
  User: POF4CLJ
  Date: 22.07.2016
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>

<html>
<script>
    function validateInput(){
        var x = document.forms["myForm"]["data"].value;
        if (x==null || x==""){
            alert("Error! Fill in data!");
            return false;
        }
    }
</script>
<head>
    <title>WEB-App</title>
</head>
<body>

<center><h1>
    <font face="Verdana">Data uploading form for my WEB application...</font>
</h1></center>

<form name="myForm" action="/home/submitUploadFileForm.html" onsubmit="return validateInput()" method="post">
    <p>
       <center><textarea id="data" name="data" cols="40" rows="5"></textarea></center>
    </p>
    <center><input type="submit" value="Upload data by clicking here!"/></center>
</form>


</body>
</html>
