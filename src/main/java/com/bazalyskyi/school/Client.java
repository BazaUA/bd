package com.bazalyskyi.school;

import com.bazalyskyi.school.entity.PagesOfJournal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Client {
    public static void main(String args[]) {
//        int productId = 6;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/personnel/pages" ;
//        restTemplate.delete(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/personnel/pages";
        PagesOfJournal p = new PagesOfJournal();

        HttpEntity<PagesOfJournal> requestEntity = new HttpEntity<PagesOfJournal>(p, headers);
        restTemplate.postForLocation(url, requestEntity);
    }
}
