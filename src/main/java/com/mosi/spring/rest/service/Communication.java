package com.mosi.spring.rest.service;

import com.mosi.spring.rest.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final RestTemplate restTemplate;

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String URL = "http://91.241.64.178:7081/api/users";

    HttpHeaders headers = new HttpHeaders();

//    HttpEntity<User> httpEntity = new HttpEntity<>(headers);

//    public List<User> getAllUsers() {
////        ResponseEntity<List<User>> responseEntity =
////                restTemplate.exchange(URL, HttpMethod.GET, null,
////                        new ParameterizedTypeReference<List<User>>() {});
////        List<User> allUsers = responseEntity.getBody();
//
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(URL, String.class);
//        forEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
////        String allInfo = responseEntity.getHeaders().toString();
////        final String allInfo1 = allInfo;
//        return null;
//    }

//    public User getUser(Long id) {
//
//        User user = restTemplate.getForObject(URL+"/"+id, User.class);
//        return user;
//    }

    public void getHeaders() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        headers.add("Cookie", responseEntity.getHeaders().getFirst("Set-Cookie"));
        System.out.println(headers);
    }
    HttpEntity<User> httpEntity = new HttpEntity<>(headers);
    public void saveUser(User user) {
        ResponseEntity<String> responseCreate = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, String.class);
        System.out.print(responseCreate.getBody());
    }

    public void upateUser(User user) {
        ResponseEntity<String> update = restTemplate.exchange(URL, HttpMethod.PUT, httpEntity, String.class);
        System.out.print(update.getBody());
    }

    public void deleteUser(User user, Long getId) {
        ResponseEntity<String> responseDelete =
                restTemplate.exchange(URL + "/" + getId, HttpMethod.DELETE, httpEntity, String.class);
        System.out.print(responseDelete.getBody());

    }
}
