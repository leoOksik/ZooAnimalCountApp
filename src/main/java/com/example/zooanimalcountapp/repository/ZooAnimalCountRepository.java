package com.example.zooanimalcountapp.repository;

import com.example.zooanimalcountapp.dto.ZooAnimalDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ZooAnimalCountRepository extends CrudRepository<ZooAnimalDto, Integer> {
}
