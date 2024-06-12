package com.w2m.spaceships.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w2m.spaceships.api.models.Spaceship;
import com.w2m.spaceships.api.models.SpaceshipDTO;
import com.w2m.spaceships.api.services.KafkaProducerService;
import com.w2m.spaceships.api.services.SpaceshipService;
import com.w2m.spaceships.data.SpaceshipRepository;

@Service
public class SpaceshipServiceImpl implements SpaceshipService {

    @Autowired
    private SpaceshipRepository spaceshipRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public SpaceshipDTO createSpaceshipKafka(SpaceshipDTO spaceshipDTO) {
        // Lógica de creación de la nave espacial
        SpaceshipDTO savedSpaceship = spaceshipRepository.save(spaceshipDTO);
        kafkaProducerService.sendMessage(savedSpaceship);
        return savedSpaceship;
    }

    @Override
    public List<SpaceshipDTO> getAllSpaceships() {
        return spaceshipRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SpaceshipDTO getSpaceshipById(Long id) {
        Spaceship spaceship = spaceshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spaceship not found"));
        return convertToDto(spaceship);
    }

    @Override
    public SpaceshipDTO createSpaceship(SpaceshipDTO spaceshipDTO) {
        Spaceship spaceship = convertToEntity(spaceshipDTO);
        Spaceship savedSpaceship = spaceshipRepository.save(spaceship);
        kafkaProducerService.sendMessage(spaceshipDTO);
        return convertToDto(savedSpaceship);
    }



    @Override
    public SpaceshipDTO updateSpaceship(SpaceshipDTO spaceshipDTO) {
        Spaceship spaceship = spaceshipRepository.findById(spaceshipDTO.getId())
                .orElseThrow(() -> new RuntimeException("Spaceship not found"));
        spaceship.setName(spaceshipDTO.getName());
        spaceship.setMovie(spaceshipDTO.getMovie());
        spaceship.setSerie(spaceshipDTO.getSeries());
        Spaceship updatedSpaceship = spaceshipRepository.save(spaceship);
        return convertToDto(updatedSpaceship);
    }

    @Override
    public void deleteSpaceship(Long id) {
        Spaceship spaceship = spaceshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spaceship not found"));
        spaceshipRepository.delete(spaceship);
    }

    @Override
    public List<SpaceshipDTO> findSpaceshipsByName(String name) {
        return spaceshipRepository.findByNameContaining(name).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SpaceshipDTO> findSpaceshipsBySeries(String series) {
        return spaceshipRepository.findBySeries(series).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SpaceshipDTO> findSpaceshipsByMovie(String movie) {
        return spaceshipRepository.findByMovie(movie).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private SpaceshipDTO convertToDto(Spaceship spaceship) {
        return new SpaceshipDTO(spaceship.getId(), spaceship.getName());
    }

    private Spaceship convertToEntity(SpaceshipDTO spaceshipDTO) {
        return new Spaceship(spaceshipDTO.getId(), spaceshipDTO.getName());
    }
}
