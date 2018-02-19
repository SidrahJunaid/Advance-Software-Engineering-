/**
 * Created by sidra on 3/16/2016.
 */
var myapp = angular.module('myService', ['ng-route','ng-main']);
myapp.config(function($routeProvider){
  $routeProvider
    .when('/',{
      templateUrl:'index.html'
    })


});

myapp.controller('VolumeService', function() {
    this.volume = function(a)
  {
    a*a*a;
  }
});

myapp.controller('MyController',function ($scope,VolumeService){
  $scope.result=0;
  $scope.calculatevolume= function (a){
    $scope.result = VolumeService.volume(a);
  };
});

