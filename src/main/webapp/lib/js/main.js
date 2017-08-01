angular.module("crudApp", [])
        .controller("projetoController", function ($scope, $http) {
            $scope.projetos = {};

            /**
             * Método responsável por recuperar todos os projetos cadastrados e a preparar a exportação
             */
            $scope.getProjetos = function () {
                $http.get('/teste-tecnico/v1/projeto').success(function (response) {
                    var data = "text/json;charset=utf-8," + encodeURIComponent(response.projetos);
                    $('<a href="data:' + data + '" download="data.json" class="glyphicon glyphicon-save"> Download</a>').appendTo('#download');
                    $scope.projetos = JSON.parse(response.projetos);
                });
            };


        });