package com.example.demo.rest;

import com.example.demo.entity.Greeting;
import com.example.demo.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;

    @GetMapping
    public List<Greeting> findAllGreetings() {
        return helloService.listAllGreetings();
    }

    @GetMapping("/{id}")
    public Greeting findById(@PathVariable Long id) {
        return helloService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Greeting greeting) {
        helloService.updateGreetingById(id, greeting);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Greeting greeting) {
        helloService.createMessage(greeting);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id) {
        helloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
