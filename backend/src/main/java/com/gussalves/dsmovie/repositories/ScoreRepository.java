package com.gussalves.dsmovie.repositories;

import com.gussalves.dsmovie.entities.Score;
import com.gussalves.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
