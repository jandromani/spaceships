package com.w2m.spaceships.api.controllers;

import com.w2m.spaceships.api.models.SpaceshipDTO;
import com.w2m.spaceships.api.services.SpaceshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spaceships/search")
@Slf4j
public class SpaceshipSearchController {

    private final SpaceshipService spaceshipService;

    public SpaceshipSearchController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<SpaceshipDTO>> findSpaceshipsByName(@RequestParam String name) {
        log.info("Received request to find spaceships by name: {}", name);
        List<SpaceshipDTO> spaceshipDTOs = spaceshipService.findSpaceshipsByName(name);
        log.info("Found {} spaceships with name containing '{}'", spaceshipDTOs.size(), name);
        return new ResponseEntity<>(spaceshipDTOs, HttpStatus.OK);
    }

    @GetMapping("/by-series")
    public ResponseEntity<List<SpaceshipDTO>> findSpaceshipsBySeries(@RequestParam String series) {
        log.info("Received request to find spaceships by series: {}", series);
        List<SpaceshipDTO> spaceshipDTOs = spaceshipService.findSpaceshipsBySeries(series);
        log.info("Found {} spaceships with series '{}'", spaceshipDTOs.size(), series);
        return new ResponseEntity<>(spaceshipDTOs, HttpStatus.OK);
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<SpaceshipDTO>> findSpaceshipsByMovie(@RequestParam String movie) {
        log.info("Received request to find spaceships by movie: {}", movie);
        List<SpaceshipDTO> spaceshipDTOs = spaceshipService.findSpaceshipsByMovie(movie);
        log.info("Found {} spaceships with movie '{}'", spaceshipDTOs.size(), movie);
        return new ResponseEntity<>(spaceshipDTOs, HttpStatus.OK);
    }
}
