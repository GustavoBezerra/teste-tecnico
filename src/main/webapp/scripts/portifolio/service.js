/**
 * Serviço responsável pelas operações referentes ao portifólio
 */
angular.module("crudApp").factory('portifolioService', function ($http) {
    var endpoint = "/teste-tecnico/v1/projeto/";
    var config = {headers: {
            'Content-Type': 'application/json;'
        }};
    return ({
        getProjetos: function (successCallback, errorCallback) {
            $http.get(endpoint).then(successCallback, errorCallback);
        },
        addProjeto: function (projeto, successCallback, errorCallback) {
            $http.post(endpoint, JSON.stringify(projeto), config).then(successCallback, errorCallback);
        },
        alterarProjeto: function (projeto, successCallback, errorCallback) {
            $http.put(endpoint, projeto, config).then(successCallback, errorCallback);
        },
        excluirProjeto: function(id, successCallback, errorCallback){
            $http.delete(endpoint + id).then(successCallback, errorCallback);
        }
    });
});