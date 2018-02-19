'use strict';
// Declare app level module which depends on views, and components
var abc = angular.module("Lab5",[]);


abc.controller("sentiController", function ($scope, $http) {
    $scope.venueList = new Array();


    $scope.getReview = function (sentimentText) {
        var text=document.getElementById('input1').value;

        //This is the Alchemy API for getting the sentiment of the most recent review for a place.
        var callback = $http.get("http://gateway-a.watsonplatform.net/calls/text/TextGetTextSentiment" +
            "?apikey=022b6ab6c88d4008049bdbf9cb94a440bf8bc19c" +
            "&outputMode=json&text=" + sentimentText);
        callback.success(function (data) {
            if(data!=null  )
            {
                $scope.sentiment = data.text.type;
            }
        })
    }

});