package com.nttdata.thorpepark.controller;

import com.nttdata.thorpepark.entity.ThemeParkRide;
import com.nttdata.thorpepark.repository.ThemeParkRideRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ThemeParkRideController {
    private final ThemeParkRideRespository themeParkRideRespository;

    public ThemeParkRideController(ThemeParkRideRespository themeParkRideRespository) {
        this.themeParkRideRespository = themeParkRideRespository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides(){
        return themeParkRideRespository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable Long id){
        return themeParkRideRespository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide){
        return themeParkRideRespository.save(themeParkRide);
    }
}
