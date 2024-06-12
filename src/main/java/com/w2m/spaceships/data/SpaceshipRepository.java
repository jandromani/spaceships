package com.w2m.spaceships.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w2m.spaceships.api.models.Spaceship;
import com.w2m.spaceships.api.models.SpaceshipDTO;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {

    Spaceship findByName(String name);
    List<Spaceship> findByNameContaining(String name);
    List<Spaceship> findBySeries(String series);
    List<Spaceship> findByMovie(String movie);
	SpaceshipDTO save(SpaceshipDTO spaceshipDTO);

}
