package com.fashion.rest.apiURL;

public class API {
    public static String apiName ;

    public static String apiURLBase(){
        String apiName ="http://46.101.235.217/api/";
        return apiName ;
    }

    public static String apiBase(){
        apiName ="http://46.101.235.217/api/areas/by-country/600814ac731d75ae35f558b3/";
        //apiName ="http://46.101.235.217/api/items/";
        //apiName ="https://jsonplaceholder.typicode.com/";
        return apiName ;
    }

    public static String api1(int x){
        apiName =apiBase();
        //return apiName+"posts"+"/"+x+"/"+"comments" ;
        return apiName+"items"+"/" ;
    }

    public static String apiCites(int x){
        apiName =apiBase();
        return apiName+"posts"+"/"+x+"/"+"comments" ;
    }

    public static String apiNumberOfCountries(){
        String apiName ="http://46.101.235.217/api/countries/count/";
        return apiName;
    }

    public static String apiCountries(){
        String apiName ="http://46.101.235.217/api/countries/";
        return apiName;
    }


    public static String apiCities(String countryId){
        String apiName ="http://46.101.235.217/api/cities/by-country/"+countryId+"/";
        return apiName;
    }

    public static String apiAreas(String countryId){
        String apiName ="http://46.101.235.217/api/areas/by-country/"+countryId+"/";
        return apiName;
    }

    public static String apiCat(){
        String apiName ="";
        apiName =apiURLBase() + "/categories/";
        return "http://46.101.235.217/api/categories/";
    }

    public static String apiHome(){
        String apiName ="http://46.101.235.217/api/homes/";
        return apiName;
    }

    public static String apiItems(String subCategoryID){
        //226020da4212f197d167672163    "+subCategoryID+"
        //"http://46.101.235.217/api/items/by-filter/%7B%22from%22%20:%2020,%22to%22:55555,%22sub_category%22:%226020da4212f197d167672163%22,%22category%22:%226020da0412f197d167672161%22,%22area%22:[%2260082119e4afcdaf7e1cb8ad%22]%7D/"
        String x ="http://46.101.235.217/api/items/by-filter/%7B%22from%22%20:%2020,%22to%22:55555,%22sub_category%22:%22"+subCategoryID+"%22,%22category%22:%226020da0412f197d167672161%22,%22area%22:[%2260082119e4afcdaf7e1cb8ad%22]%7D/";

        String apiName ="http://46.101.235.217/api/items/by-filter/%7B%22from%22%"+20+":%2020,%22to%22:"+55555+",%22area%22:[%2260082119e4afcdaf7e1cb8ad%22]%7D/";
        return x;
    }

}
