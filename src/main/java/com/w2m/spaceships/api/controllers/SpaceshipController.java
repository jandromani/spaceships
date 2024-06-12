package com.w2m.spaceships.api.controllers;

import com.w2m.spaceships.api.models.SpaceshipDTO;
import com.w2m.spaceships.api.services.SpaceshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaceships")
@Slf4j
public class SpaceshipController {

    @Autowired
    private SpaceshipService spaceshipService;

    @GetMapping
    public ResponseEntity<List<SpaceshipDTO>> getAllSpaceships() {
        log.info("Received request to get all spaceships");
        List<SpaceshipDTO> spaceships = spaceshipService.getAllSpaceships();
        log.info("Returning {} spaceships", spaceships.size());
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceshipDTO> getSpaceshipById(@PathVariable Long id) {
        log.info("Received request to get spaceship with ID: {}", id);
        SpaceshipDTO spaceship = spaceshipService.getSpaceshipById(id);
        if (spaceship != null) {
            log.info("Spaceship found: {}", spaceship);
            return new ResponseEntity<>(spaceship, HttpStatus.OK);
        } else {
            log.warn("Spaceship with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SpaceshipDTO> createSpaceship(@jakarta.validation.Valid @RequestBody SpaceshipDTO spaceshipDTO) {
        log.info("Received request to create a new spaceship: {}", spaceshipDTO);
        SpaceshipDTO createdSpaceship = spaceshipService.createSpaceship(spaceshipDTO);
        log.info("Spaceship created with ID: {}", createdSpaceship.getId());
        return new ResponseEntity<>(createdSpaceship, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceshipDTO> updateSpaceship(@PathVariable Long id, @jakarta.validation.Valid @RequestBody SpaceshipDTO spaceshipDTO) {
        log.info("Received request to update spaceship with ID: {}", id);
        spaceshipDTO.setId(id);
        SpaceshipDTO updatedSpaceship = spaceshipService.updateSpaceship(spaceshipDTO);
        log.info("Spaceship with ID {} updated", id);
        return new ResponseEntity<>(updatedSpaceship, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpaceship(@PathVariable Long id) {
        log.info("Received request to delete spaceship with ID: {}", id);
        spaceshipService.deleteSpaceship(id);
        log.info("Spaceship with ID {} deleted", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
