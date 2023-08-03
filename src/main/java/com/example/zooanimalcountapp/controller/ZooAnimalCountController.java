package com.example.zooanimalcountapp.controller;

import com.example.zooanimalcountapp.dto.ZooAnimalDto;
import com.example.zooanimalcountapp.exception.NotFoundException;
import com.example.zooanimalcountapp.service.ZooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ZooAnimalCountController {
    ZooService zooService;

    public ZooAnimalCountController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping ("status")
    public String ping () {
        return "Server is running";
    }

    @GetMapping("animal")
    public Iterable<ZooAnimalDto> getAll() {
        return zooService.findAll();
    }

    @GetMapping("animal/{id}")
    public Optional<ZooAnimalDto> getById(@PathVariable Integer id) throws NotFoundException {
        return zooService.findById(id);
    }

    @PostMapping("animal")
    public ZooAnimalDto add(@RequestBody ZooAnimalDto zooAnimalDto) {
        return zooService.addDto(zooAnimalDto);
    }

    @DeleteMapping("animal/{id}")
    public void delete(@PathVariable Integer id) {
        zooService.deleteDto(id);
    }

    @PutMapping("animal/{id}")
    public ResponseEntity<ZooAnimalDto> edit(@PathVariable Integer id, @RequestBody ZooAnimalDto zooAnimalDto) {
        return ResponseEntity.ok(zooService.editDto(id,zooAnimalDto));
    }
}
