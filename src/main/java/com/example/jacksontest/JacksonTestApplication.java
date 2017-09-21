package com.example.jacksontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@SpringBootApplication
public class JacksonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JacksonTestApplication.class, args);
    }
}

@RestController
class PersonController {

    @GetMapping
    public Person get() {
        return new Person("Jørgen", "Ringen");
    }

    @PostMapping
    public Person post(@RequestBody Person person) {
        return person;
    }
}

final class Person {

    private final String firstname;
    private final String lastname;

    @JsonCreator
    Person(@JsonProperty("firstname") String firstname,
           @JsonProperty("lastname") String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
