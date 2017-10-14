angular.module('sortApp', [])

.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // set the default sort type
  $scope.sortReverse  = false;  // set the default sort order
  $scope.searchFish   = '';     // set the default search/filter ter
  
  
  
  
  
  $scope.sushi=[

	 { ID:'01', name: 'Computer', price: '25000', Image: 2 },
    { ID:'02', name: 'Mobile', price: '15000',  Image: 4 },
    { ID:'03', name: 'Headphone', price: '1000', Image: 7 },
    { ID:'04', name: 'PenDrive', price: '500',   Image: 6 },
  ];
  
})  

