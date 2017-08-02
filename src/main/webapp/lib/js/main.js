angular.module("crudApp", [])
    .controller("projetoController", function ($scope, $http) {
//        $scope.projetos = {};
//        $scope.projeto = {};
//        $scope.search = "";
//        $scope.tempProjeto = {};

        /**
         * Método responsável por recuperar todos os projetos cadastrados e a preparar a exportação
         */
        $scope.getProjetos = function () {
            $http.get('/teste-tecnico/v1/projeto').success(function (response) {
                var data = "text/json;charset=utf-8," + encodeURIComponent(response.projetos);
                $('#download').empty();
                $('<a href="data:' + data + '" download="data.json"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save" aria-hidden="true"></span> Exportar</button></a>').appendTo('#download');
                $scope.projetos = JSON.parse(response.projetos);
            });
        };

        /**
         * Método responsável por abrir o formulário e preencher o tempProjeto com o projeto clicado
         */
        $scope.alterar = function (projeto) {
            $scope.tempProjeto = angular.copy(projeto);
        };

        /**
         * Método responsável por fechar o formulário e a limpar o tempProjeto.
         */
        $scope.cancelar = function () {
            $scope.tempProjeto = {};
        };

        /**
         * Método responsável pelo envio das informações de cadastro para o servidor
         */
        $scope.addProjeto = function () {
            var config = {
                headers: {
                    'Content-Type': 'application/json;'
                }
            };
            $http.post('/teste-tecnico/v1/projeto', $scope.tempProjeto, config).success(function (response) {
                if (response.status !== 'OK') {
                    $scope.getProjetos();
                    alert("Projeto cadastrado com sucesso!");
                    $scope.cancelar();
                } else {
                    console.log("Erro!\n"+response);
                }
            });
        };

        /**
         * Método responsável por mandar as informações de alteração ao servidor
         */
        $scope.alterarProjeto = function () {
            var config = {
                headers: {
                    'Content-Type': 'application/json;'
                }
            };
            $http.put('/teste-tecnico/v1/projeto', $scope.tempProjeto, config).success(function (response) {
                if (response.status !== 'OK') {
                    $scope.getProjetos();
                    alert("Projeto alterado com sucesso!");
                    $scope.cancelar();
                } else {
                    console.log("Erro!\n"+response);
                }
            });
        };

        /**
         * Método responsável por enviar a requisição de exclusão para o servidor
         */
        $scope.excluir = function (projeto) {
            if (confirm("Deseja realmente excluir o projeto " + projeto.nome + "?")) {
                $http.delete('/teste-tecnico/v1/projeto/' + projeto.id).success(function (response) {
                    $scope.getProjetos();
                    alert("Projeto excluído com sucesso!");
                });
            }
        };


    });