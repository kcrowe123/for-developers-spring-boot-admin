package com.example.demo.service;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HelloService {
    @Autowired
    private GreetingRepository greetingRepository;


    public String hello() {
        if(greetingRepository.count() < 1) {
            var response = greetingRepository.save(new Greeting("Hello"));
            return response.getMessage();
        }
        return greetingRepository.findAll().get(0).getMessage();
    }
}
