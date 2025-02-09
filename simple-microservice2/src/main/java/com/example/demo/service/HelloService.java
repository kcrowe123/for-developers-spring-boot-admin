package com.example.demo.service;

import com.example.demo.entity.Greeting;
import com.example.demo.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HelloService {
    @Autowired
    private GreetingRepository greetingRepository;

    public void updateGreetingById(Long id, Greeting greeting) {
        Optional<Greeting> byId = greetingRepository.findById(id);
        Greeting savedGreeting = byId.get();
        savedGreeting.setMessage(greeting.getMessage());
        greetingRepository.save(savedGreeting);
    }

    public void createMessage(Greeting greeting) {
        greetingRepository.save(greeting);
    }

    public void deleteById(Long id) {
        greetingRepository.deleteById(id);
    }

    public Greeting findById(Long id) {
        return greetingRepository.findById(id).get();
    }

    public List<Greeting> listAllGreetings() {
        return greetingRepository.findAll();
    }
}
