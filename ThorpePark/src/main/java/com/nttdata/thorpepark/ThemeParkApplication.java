package com.nttdata.thorpepark;

import com.nttdata.thorpepark.entity.ThemeParkRide;
import com.nttdata.thorpepark.repository.ThemeParkRideRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.context.Theme;

@SpringBootApplication
public class ThemeParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRespository respository){
        return (args -> {
           respository.save(new ThemeParkRide("RollerCoaster", "Train ride that you speeds you along", 5, 3));
           respository.save(new ThemeParkRide("Log Flume", "Boat Ride with Plenty of Splashes", 3, 2));
           respository.save(new ThemeParkRide("TeaCups", "Spinning Ride in a giant Tea-cup", 2, 4));
        });
    }
}
