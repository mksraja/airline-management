'use strict';

angular.module('testApp')
    .controller('queryCtrl',
        function ($scope, $state, $sessionStorage, QueryService, $location, $log, $window) {

            $scope.search = function () {
                var formData = {
                    code: $scope.code,
                    country : $scope.country
                };
                $log.debug('$scope.code : ' + $scope.code);
                $log.debug('$scope.country : ' + $scope.country);
                QueryService.findAirports(formData).query().$promise.then(function
                 (data) {
        			$log.debug('success');
        			$scope.airports = data;
        		}, function (error) {
        			$log.debug(error);
        			$log.debug('error');
        		});
        };
    });