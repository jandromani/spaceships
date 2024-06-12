package com.w2m.spaceships.api.services;

import com.w2m.spaceships.api.models.SpaceshipDTO;
import java.util.List;

public interface SpaceshipService {

    List<SpaceshipDTO> getAllSpaceships();
    SpaceshipDTO getSpaceshipById(Long id);
    SpaceshipDTO createSpaceship(SpaceshipDTO spaceshipDTO);
    SpaceshipDTO updateSpaceship(SpaceshipDTO spaceshipDTO);
    void deleteSpaceship(Long id);
    List<SpaceshipDTO> findSpaceshipsByName(String name);
    List<SpaceshipDTO> findSpaceshipsBySeries(String series);
    List<SpaceshipDTO> findSpaceshipsByMovie(String movie);
	SpaceshipDTO createSpaceshipKafka(SpaceshipDTO spaceshipDTO);
}
