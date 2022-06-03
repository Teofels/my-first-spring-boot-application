package com.example.myfirstspringbootapplication.configuration;

import com.example.myfirstspringbootapplication.dto.Customer;
import com.example.myfirstspringbootapplication.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * с помощью этого класса можно на этапе инициализации приложения добавить записи в БД
 */
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerService repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Customer("Bilbo", "Baggins")));
            log.info("Preloading " + repository.save(new Customer("Frodo", "Baggins")));
        };
    }
}
