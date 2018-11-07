(function () {
    'use strict';

angular.module('testApp')
        .factory('ReportService', ['$http', '$localStorage', '$sessionStorage','$resource', '$log', function ($http, $localStorage, $sessionStorage, $resource, $log) {
        	
        return {
               getTypeOfRunways: function () {
                 $log.debug('Retrieving all runways in each country : ');
                   return $resource('api/reports/runwayTypes', {}, {
                          query: {method : "GET", isArray:true}
                          });
              },
              getTopTenHighestAirports: function () {
                $log.debug('Retrieving Top 10 Highest Airports : ');
                  return $resource('api/reports/airports/highest', {}, {
                         query: {method : "GET", isArray:true}
                         });
             },
             getTopTenLowestAirports: function () {
               $log.debug('Retrieving Top 10 Highest Airports : ');
                 return $resource('api/reports/airports/lowest', {}, {
                        query: {method : "GET", isArray:true}
                        });
            },
            getTopTenCommonRunways: function () {
              $log.debug('Retrieving Top 10 Common Runways : ');
                return $resource('api/reports/commonRunways', {}, {
                       query: {method : "GET", isArray:true}
                       });
           }
        };
    }
]);

})();