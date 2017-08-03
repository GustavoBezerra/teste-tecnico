angular.module("crudApp").controller("portifolioController", function ($scope, portifolioService) {
    /**
     * Método responsável por recuperar todos os projetos cadastrados e a preparar a exportação
     */
    $scope.getProjetos = function () {
        portifolioService.getProjetos(function (response) {
            var data = "text/json;charset=utf-8," + encodeURIComponent(response.data.projetos);
            $('#download').empty();
            $('<a href="data:' + data + '" download="data.json"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-save" aria-hidden="true"></span> Exportar</button></a>').appendTo('#download');
            $scope.projetos = JSON.parse(response.data.projetos);
            // retira o gif de loading
            $(".loading").fadeOut("slow");
        }, erros);
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
        portifolioService.addProjeto($scope.tempProjeto, function (response) {
            $scope.getProjetos();
            alert("Projeto cadastrado com sucesso!");
            $scope.cancelar();
            $('#projetoModel').modal('hide');
        }, erros);
    };

    /**
     * Método responsável por mandar as informações de alteração ao servidor
     */
    $scope.alterarProjeto = function () {
        portifolioService.alterarProjeto($scope.tempProjeto, function (response) {
            $scope.getProjetos();
            alert("Projeto alterado com sucesso!");
            $scope.cancelar();
            $('#projetoModel').modal('hide');
        }, erros);
    };

    /**
     * Método responsável por enviar a requisição de exclusão para o servidor
     */
    $scope.excluir = function (projeto) {
        if (confirm("Deseja realmente excluir o projeto " + projeto.nome + "?")) {
            portifolioService.excluirProjeto(projeto.id, function (response) {
                $scope.getProjetos();
                alert("Projeto excluído com sucesso!");
            }, erros);
        }
    };

    /**
     * Método responsável pela exibição dos erros nas requisições
     * @param {Array} error Erros que retornaram do back-end
     */
    function erros(error) {
        var erros = JSON.parse(error.data.erros);
        var mensagem = "";
        erros.forEach(function (erro) {
            mensagem += erro + "\n";
        });
        alert(mensagem);
    }
});


