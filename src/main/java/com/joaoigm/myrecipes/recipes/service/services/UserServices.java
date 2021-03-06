package com.joaoigm.myrecipes.recipes.service.services;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.UUID;

public class UserServices {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    public UserServices(){}
    public boolean CheckUserAutenticated(UUID id) {
        HttpGet get = new HttpGet(System.getenv("USERS_SERVICE_URL")+"/api/users/authenticated?id="+id);
        try {
            try(CloseableHttpResponse response = httpClient.execute(get)){
                HttpEntity entity = response.getEntity();

                return(Boolean.parseBoolean(EntityUtils.toString(entity)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
