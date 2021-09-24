package com.mosi.spring.rest;

import com.mosi.spring.rest.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String url = "http://91.241.64.178:7081/api/users";

    public static void main(String[] args) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", responseEntity.getHeaders().getFirst("Set-Cookie"));

        User user = new User(3L, "James", "Brown", (byte) 25);
        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseCreate = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        user.setName("Thomas");
        user.setLastName("Shelby");
        ResponseEntity<String> responseUpdate = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);

        ResponseEntity<String> responseDelete = restTemplate.exchange(url+"/"+user.getId(), HttpMethod.DELETE, httpEntity, String.class);

        System.out.println(responseCreate.getBody() + responseUpdate.getBody() + responseDelete.getBody());

    }
}
