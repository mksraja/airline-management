'use strict';

angular.module('testApp').controller(
        'reportsCtrl',
        function($scope, $state, $sessionStorage, ReportService, $location,
                $log, $window) {

          //Top 10 Highest Airports
          ReportService.getTopTenHighestAirports().query().$promise.then(
                  function(data) {
                    $log.debug('success');
                    $scope.highestAirports = data;
                    $log.debug('success' + JSON.stringify($scope.runwayTypes));
                  }, function(error) {
                    $log.debug(error);
                    $log.debug('error');
                  });

          //Top 10 Lowest Airports
          ReportService.getTopTenLowestAirports().query().$promise.then(
                  function(data) {
                    $log.debug('success');
                    $scope.lowestAirports = data;
                  }, function(error) {
                    $log.debug(error);
                    $log.debug('error');
                  });
          
          //Top 10 Common Runways
          ReportService.getTopTenCommonRunways().query().$promise.then(
                  function(data) {
                    $log.debug('success');
                    $scope.commonRunways = data;
                  }, function(error) {
                    $log.debug(error);
                    $log.debug('error');
                  });

          //Type of Runways
          ReportService.getTypeOfRunways().query().$promise.then(
                  function(data) {
                    $log.debug('success');
                    $scope.runwayTypes = data;
                  }, function(error) {
                    $log.debug(error);
                    $log.debug('error');
                  });
          

        });