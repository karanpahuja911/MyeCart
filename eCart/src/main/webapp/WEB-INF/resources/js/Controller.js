/**
 * 
 */
var cartApp = angular.module ("cartApp", []);
 
cartApp.controller("cartCtrl", function($scope, $http){
 
    $scope.addToCart = function(productId){
        $http.put('http://localhost:9002/eCart/customer/rest/cart/add/' + productId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };
 
  
});