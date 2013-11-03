$app.factory("DataService", ['$resource',function($resource) {
  
  var myCart = new shoppingCart("EbookStore");
  
  return {
    
    cart: myCart
  };
}]);