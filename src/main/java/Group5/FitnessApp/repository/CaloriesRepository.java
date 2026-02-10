package Group5.FitnessApp.repository;

import Group5.FitnessApp.model.Calories;
import org.springframework.data.repository.CrudRepository;

public interface CaloriesRepository extends CrudRepository<Calories, String> {
    Calories findByUsername(String username);
}
