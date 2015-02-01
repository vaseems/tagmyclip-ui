'use strict';

/**
 * @ngdoc function
 * @name tagmyclip.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the tagmyclip
 */
var tagmyclip = angular.module('tagmyclip');
tagmyclip.controller('SceneTagController', function ($scope, APIKEY, $http, $rootScope, $timeout, $window, $interval) {

    $scope.menu = [
      {text: 'My Tags'},
      {text: 'Search History'}
    ];



    $scope.words = [
      {text: 'Comedy', weight: 13, autoResize: true},
      {text: 'Dialogue', weight: 10.5, autoResize: true},
      {text: 'Song', weight: 9.4, autoResize: true},
      {text: 'Action', weight: 8, autoResize: true},
      {text: 'Fight', weight: 6.2, autoResize: true},
      {text: 'Drama', weight: 5, autoResize: true},
      {text: 'Chasing', weight: 5, autoResize: true},
      {text: 'Police', weight: 5, autoResize: true},
      {text: 'Thief', weight: 5, autoResize: true},
      {text: 'Theft', weight: 4, autoResize: true},
      {text: 'Laughing', weight: 4, autoResize: true},
      {text: 'Bluffing', weight: 3, autoResize: true},
      {text: 'bluff master', weight: 3, autoResize: true},
      {text: 'punch', weight: 3, autoResize: true},
      {text: 'super star', weight: 3, autoResize: true},
      {text: 'TV Ad', weight: 3, autoResize: true},
      {text: 'Paint', weight: 3, autoResize: true},
      {text: 'Running', weight: 3, autoResize: true},
      {text: 'flying', weight: 2, autoResize: true},
      {text: 'flight', weight: 2, autoResize: true},
      {text: 'airport', weight: 2, autoResize: true},
      {text: 'hyderabad', weight: 2, autoResize: true},
      {text: 'chennai', weight: 2, autoResize: true},
      {text: 'bangalore', weight: 2, autoResize: true},
      {text: 'mumbai', weight: 2, autoResize: true},
      {text: 'thane', weight: 2, autoResize: true},
      {text: 'India', weight: 2, autoResize: true},
      {text: 'Bharat', weight: 2, autoResize: true}
    ];
    
    $scope.seek = {
      min: 0,
      max:9.10,
      value: 0,
      step: 0.01
    };

    $scope.colors = ['#800026', '#bd0026', '#e31a1c', '#fc4e2a', '#fd8d3c', '#feb24c', '#fed976'];

    $scope.update = function() {
      $scope.words.splice(-5);
    };

	$scope.search = function(){
    var q = $scope.searchVal;
    var request = gapi.client.youtube.search.list({
      q: q,
      part: 'snippet',
      maxResults: 25
    });

    request.execute(function(response) {
      $scope.videoList = response.result;
      $scope.$apply();
    });
	};

 $scope.yt = {
    width: 1000, 
    height: 480, 
    videoid: "M7lc1UVf-VE",
    playerStatus: "NOT PLAYING"
  };
  /*$interval(function(){
        $scope.seek.value = $scope.seek.value + 0.01;
  }, 1000, 100 * 100);*/

 /* var value = setInterval(function(){
    if(parseFloat($('#seek').val()) > 22.24) clearInterval(value);
    console.log(parseFloat($('#seek').val()));
    $('#seek').val(parseFloat($('#seek').val()) + 0.01 );
  }, 1000);*/
  $scope.value = 0;
	$scope.viewVideo = function(index){
    console.log($scope.yt);
    $scope.yt.videoid = $scope.videoList.items[index].id.videoId;
    $timeout(function(){
      angular.element('#play').trigger('click');
      $window.scrollTo(0,0);
      $scope.seek.value = 0.01;
      $scope.seek.max = 22.24;

      $scope.value = setInterval(function(){
          if(parseFloat($('#seek').val()) > 22.24) clearInterval(value);
          console.log(parseFloat($('#seek').val()));
          $('#seek').val(parseFloat($('#seek').val()) + 0.01 );
      }, 1000);
    });


		//window.location.href = 'http://www.youtube.com/watch?v=' + $scope.videoList.items[index].id.videoId;
	};
  $scope.sendControlEvent = function (ctrlEvent) {
    $scope.$broadcast(ctrlEvent);
  }

  $scope.searchVideos = function(index){
    $scope.searchVal = $scope.words[index].text;
  };

  $scope.playVideo = function(){
    /*$timeout(function(){
      angular.element('#play').trigger('click');
    });*/
  };

  $scope.pauseVideo = function(){
    /*$timeout(function(){
      angular.element('#pause').trigger('click');
    });*/
  };

  $scope.scanText = function(){

  };
  
});

tagmyclip.controller('TagCouldController', function($scope, APIKEY, $http){

});

tagmyclip.constant('APIKEY', 'AIzaSyDOTHOX1q1xWnmLAqzqGcCUuY5AdMz8hGc');
tagmyclip.constant('OAUTH2_CLIENT_ID', '__YOUR_CLIENT_ID__');
tagmyclip.constant('OAUTH2_SCOPES ',  ['https://www.googleapis.com/auth/youtube']);