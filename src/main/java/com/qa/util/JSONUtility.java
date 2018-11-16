package com.qa.util;

import com.google.gson.Gson;

public class JSONUtility {
    private Gson gson;

    public JSONUtility(){
        this.gson = new Gson();
    }

    public String getJSONForObject(Object object){
        return gson.toJson(object);
    }

    public <T> T getObjectForJSON(String jsonString, Class<T> tClass){
        return gson.fromJson(jsonString, tClass);
    }
}
