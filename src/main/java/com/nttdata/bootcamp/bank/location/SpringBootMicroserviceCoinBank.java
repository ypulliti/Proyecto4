package com.nttdata.bootcamp.bank.location;

import com.nttdata.bootcamp.bank.location.model.dao.inte.CoinBankDaoInte;
import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceCoinBank implements CommandLineRunner {
    @Autowired
    CoinBankDaoInte dao;
    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceCoinBank.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceCoinBank.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init reports");
        Flux.just(
                new CoinBank("1","0001", "Test01", "Prueba 1", "None", "This is a test", new Date(), 90.0, 0.0, 0.0, "6"),
                new CoinBank("2","0002", "Test02", "Prueba 2", "None", "This is a test", new Date(), 120.0, 0.0, 0.0, "6")
                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getImei()));
    }

}
