'use strict';

/**
 * @ngdoc overview
 * @name scenetagApp
 * @description
 * # scenetagApp
 *
 * Main module of the application.
 */
angular
  .module('tagmyclip', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'youtube',
    'angular-jqcloud',
    'YouTubeApp'
  ])
  .config(function ($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'SceneTagController'
      })
      .when('/toptags', {
        templateUrl: 'tagcloud.html',
        controller: 'TagCouldController'
      })
      .otherwise({
        redirectTo: '/'
      });
    
    $locationProvider.html5Mode(true);
  });
