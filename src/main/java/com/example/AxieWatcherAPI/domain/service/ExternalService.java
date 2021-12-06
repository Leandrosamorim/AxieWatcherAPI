/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.service;

import com.example.AxieWatcherAPI.domain.model.Axie;
import com.example.AxieWatcherAPI.domain.model.AxieDto;
import com.example.AxieWatcherAPI.domain.model.AxieList;
import com.example.AxieWatcherAPI.util.Data;
import com.example.AxieWatcherAPI.util.Request;
import com.example.AxieWatcherAPI.util.Variables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 55229
 */
@Service
public class ExternalService {

    public List<AxieDto> getAxies() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Request request = new Request();
// build the request
        HttpEntity<Request> entity = new HttpEntity<>(request, headers);
        ResponseEntity<Data> response = template.postForEntity("https://graphql-gateway.axieinfinity.com/graphql", entity, Data.class);
        Data axies = response.getBody();
        List<AxieDto> axieList = axies.getAxies().getAxieList().getAxies();
        return axieList;
    }

}
