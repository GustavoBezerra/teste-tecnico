angular.module("crudApp").factory('portifolioService', function ($http) {
    var endpoint = "/teste-tecnico/v1/projeto/";
    var config = {headers: {
            'Content-Type': 'application/json;'
        }};
    return ({
        getProjetos: function (callback) {
            $http.get(endpoint).success(callback);
        },
        addProjeto: function (projeto, callback) {
            $http.post(endpoint, projeto, config).success(callback);
        },
        alterarProjeto: function (projeto, callback) {
            $http.put(endpoint, projeto, config).success(callback);
        },
        excluirProjeto: function(id, callback){
            $http.delete(endpoint + id).success(callback);
        }
    });
});