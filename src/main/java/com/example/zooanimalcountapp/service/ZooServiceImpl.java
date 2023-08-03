package com.example.zooanimalcountapp.service;

import com.example.zooanimalcountapp.dto.ZooAnimalDto;
import com.example.zooanimalcountapp.exception.NotFoundException;
import com.example.zooanimalcountapp.repository.ZooAnimalCountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;
import java.util.Optional;

@Service
public class ZooServiceImpl implements ZooService {

    ZooAnimalCountRepository zooAnimalCountRepository;

    public ZooServiceImpl (ZooAnimalCountRepository zooAnimalCountRepository) {
        this.zooAnimalCountRepository = zooAnimalCountRepository;
    }
    @Override
    public Iterable<ZooAnimalDto> findAll() {
        return zooAnimalCountRepository.findAll();
    }
    @Override
    public Optional<ZooAnimalDto> findById(Integer id) throws NotFoundException {
       return Optional.ofNullable(zooAnimalCountRepository.findById(id)
               .orElseThrow(() -> new NotFoundException("id = " + id + " not found")));
    }
    @Override
    public ZooAnimalDto addDto(ZooAnimalDto zooAnimalDto) {
        return zooAnimalCountRepository.save(zooAnimalDto);
    }

    @Override
    public void deleteDto(Integer id) throws NotFoundException {
        ZooAnimalDto zooAnimalDtoUpdate = zooAnimalCountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id = " + id + " not found"));
        if(zooAnimalDtoUpdate!=null) {
            zooAnimalCountRepository.deleteById(id);
        }
    }
    @Override
    public ZooAnimalDto editDto(Integer id, ZooAnimalDto zooAnimalDto) throws NotFoundException {
        ZooAnimalDto zooAnimalDtoUpdate = zooAnimalCountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("id = " + id + " not found"));

        zooAnimalDtoUpdate.setName(zooAnimalDto.getName());
        zooAnimalDtoUpdate.setKind(zooAnimalDto.getKind());
        zooAnimalDtoUpdate.setCount(zooAnimalDto.getCount());

        return zooAnimalCountRepository.save(zooAnimalDtoUpdate);
    }

}
