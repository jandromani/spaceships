package com.w2m.spaceships.api;

import static org.junit.jupiter.api.Assertions.*;

import com.w2m.spaceships.api.models.SpaceshipDTO;
import com.w2m.spaceships.api.services.impl.SpaceshipServiceImpl;
import com.w2m.spaceships.data.SpaceshipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class SpaceshipServiceTest {

    @Mock
    private SpaceshipRepository spaceshipRepository;

    @InjectMocks
    private SpaceshipServiceImpl spaceshipService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSpaceships() {
        when(spaceshipRepository.findAll()).thenReturn(Collections.emptyList());
        List<SpaceshipDTO> spaceships = spaceshipService.getAllSpaceships();
        assertTrue(spaceships.isEmpty());
    }
}
