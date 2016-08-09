app.factory('DbService', function($http) {

   return {
       getData: function(){
            var url = "/submitUploadFileForm.html";
            return $http.get(url);

        }
    };

});