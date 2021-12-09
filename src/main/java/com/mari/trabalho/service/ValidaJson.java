package com.mari.trabalho.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidaJson {

    public boolean isJsonValid (String json){
        try{
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json);
            return true;
        } catch (JsonProcessingException ex){
            return false;
        }
    }
}
