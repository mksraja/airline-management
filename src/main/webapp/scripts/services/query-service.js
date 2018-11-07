(function() {
  'use strict';

  angular.module('testApp').factory(
          'QueryService',
          [
              '$http',
              '$localStorage',
              '$sessionStorage',
              '$resource',
              '$log',
              function($http, $localStorage, $sessionStorage, $resource, $log) {

                return {
                  findAirports: function(data) {
                    $log.debug('code in the service : ' + data.code);
                    $log.debug('country in the service : ' + data.country);
                    return $resource('api/query/search', {}, {
                      query: {
                        method: "GET",
                        params:{code: data.code, country: data.country},
                        isArray: true
                      }
                    });
                  }
                };
              }]);

})();