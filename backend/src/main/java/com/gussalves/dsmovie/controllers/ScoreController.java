package com.gussalves.dsmovie.controllers;

import com.gussalves.dsmovie.dto.MovieDTO;
import com.gussalves.dsmovie.dto.ScoreDTO;
import com.gussalves.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping(value = "/{id}")
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        MovieDTO movieDto = service.saveScore(dto);
        return movieDto;
    }
}
