angular.module('portifolioDiretivas').directive('detalhesModal', function(){
    var ddo = {};

    ddo.restrict = "AE";

    ddo.templateUrl = "scripts/directives/modal/detalhesModal.html";

    return ddo;
});