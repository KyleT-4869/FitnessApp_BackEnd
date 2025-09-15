package Group5.FitnessApp.repository;

import Group5.FitnessApp.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, String> {

}
