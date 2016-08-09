//Myapp.controller('HomeController', function($scope, DbService){
    //DbService.getData();
    //$scope.myFunk2 = function() {
        //console.log();
    //};

   // $scope.myFunk = function() {
     //   $scope.name = "Welcome!";
    //};
    var app = angular.module('app', ['ngRoute', 'ui.router',  'chart.js']);
    app.controller('homeController', function($scope) {
      $scope.name = "John Doe";
});
//});