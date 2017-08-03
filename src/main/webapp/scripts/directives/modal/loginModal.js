angular.module('portifolioDiretivas').directive('loginModal', function(){
    var ddo = {};

    ddo.restrict = "AE";

    ddo.templateUrl = "scripts/directives/modal/loginModal.html";

    return ddo;
});