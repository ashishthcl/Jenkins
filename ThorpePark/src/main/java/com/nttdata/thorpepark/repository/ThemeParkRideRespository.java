package com.nttdata.thorpepark.repository;

import com.nttdata.thorpepark.entity.ThemeParkRide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeParkRideRespository extends CrudRepository<ThemeParkRide,Long> {
    List<ThemeParkRide> findByName(String name);
}
