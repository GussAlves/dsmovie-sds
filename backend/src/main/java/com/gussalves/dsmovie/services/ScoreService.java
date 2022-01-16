package com.gussalves.dsmovie.services;

import com.gussalves.dsmovie.dto.MovieDTO;
import com.gussalves.dsmovie.dto.ScoreDTO;
import com.gussalves.dsmovie.entities.Movie;
import com.gussalves.dsmovie.entities.Score;
import com.gussalves.dsmovie.entities.User;
import com.gussalves.dsmovie.repositories.MovieRepository;
import com.gussalves.dsmovie.repositories.ScoreRepository;
import com.gussalves.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional(readOnly = true)
    public MovieDTO saveScore(ScoreDTO dto) {

        // valida se o usuário tem cadastro caso não cria
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        // Busca filme no banco de dados
        Movie movie = movieRepository.findById(dto.getMovieID()).get();
        Score score = new Score();
        score.setUser(user);
        score.setMovie(movie);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }

}
