package Group5.FitnessApp.repository;

import Group5.FitnessApp.model.Game;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findBySport(String sport); // filtering by sport
}

