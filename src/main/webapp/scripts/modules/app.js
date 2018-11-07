/**
 * @name testApp Module
 * @description
 */
'use strict';
angular.module('testApp', ['ui.router', 'ngStorage', 'ngResource', ]).config(
        function($stateProvider, $urlRouterProvider, $locationProvider) {

          $urlRouterProvider.otherwise('/main');

          $stateProvider.state('Main', {
            url: '/main',
            views: {
              'headerView': {
                templateUrl: 'header.html'
              },
              'mainView': {
                templateUrl: 'main.html'
              }
            }
          }).state('Reports', {
            url: '/reports',
            views: {
              'headerView': {
                templateUrl: 'header.html'
              },
              'mainView': {
                templateUrl: 'reports.html',
                controller: 'reportsCtrl'
              }
            }
          }).state('Query', {
            url: '/query',
            views: {
              'headerView': {
                templateUrl: 'header.html'
              },
              'mainView': {
                templateUrl: 'query.html',
                controller: 'queryCtrl'
              }
            }
          });

          $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
          });

        }).run(['$state', function($state) {
  $state.transitionTo('Main');
}]);
