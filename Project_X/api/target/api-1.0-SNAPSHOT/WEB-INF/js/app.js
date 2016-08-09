var app = angular.module('app', ['ngRoute', 'ui.router',  'chart.js']);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/',{
                templateUrl: 'home.jsp',
                controller: 'homeController'})
        .when('/home/view-data', {
            templateUrl: 'view-data.html',
            controller: 'homeController',
            resolve: {
                // I will cause a 1 second delay
                delay: function($q, $timeout) {
                    var delay = $q.defer();
                    $timeout(delay.resolve, 1000);
                    return delay.promise;
                }
            }
        })
        .when('/home/view-data', {
            templateUrl: 'view-data.html',
            controller: 'homeController'
        });

    // configure html5 to get links working on jsfiddle
    $locationProvider.html5Mode(true);
});