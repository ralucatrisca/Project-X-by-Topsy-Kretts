
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app = "app">
<head>
    <title>Main Page</title>
</head>
<body ng-controller="homeController">

<div ng-view></div>

<!-- Module -->

<!-- Services -->
<script type="text/javascript" src="views/DbService.js"></script>

<!-- Controllers -->
<script type="text/javascript" src="/WEB-INF/js/controllers/homeController.js"></script>
<script type="text/javascript" src="/WEB-INF"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>


<!-- UI-Router module -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-route.js"></script>

</body>
</html>
