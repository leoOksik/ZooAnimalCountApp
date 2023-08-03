package com.example.zooanimalcountapp.service;

import com.example.zooanimalcountapp.dto.ZooAnimalDto;
import com.example.zooanimalcountapp.exception.NotFoundException;

import java.util.Optional;

public interface ZooService {

    Iterable<ZooAnimalDto> findAll();
    Optional<ZooAnimalDto> findById(Integer id) throws NotFoundException;
    ZooAnimalDto addDto (ZooAnimalDto zooAnimalDto);
    void deleteDto (Integer id) throws NotFoundException;
    ZooAnimalDto editDto (Integer id, ZooAnimalDto zooAnimalDto) throws NotFoundException;

}
