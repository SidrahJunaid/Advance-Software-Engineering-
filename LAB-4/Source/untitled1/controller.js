/**
 * Created by sidra on 2/13/2016.
 */
var mainApp = angular.module('mainApp',['ng-route','ng-main']);


mainApp.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl:'weather and direction.html'
       })

        .when('/new',{
        templateUrl:'new.html'})
    .otherwise({
        redirectTo:'/'});
});
mainApp.controller('loginControl',function($scope,$location){
    $scope.submit= function(){
        var uname=$scope.username;
        var password=$scope.password;
        if ($scope.username=='admin'&& $scope.password=='admin'){
            $window.location.href='weather and direction.html'

        }
    };
});
