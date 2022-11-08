package com.example.springrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(IStudentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Student("Ivan", 16)));
            log.info("Preloading " + repository.save(new Student("Petya", 14)));
        };
    }
}
