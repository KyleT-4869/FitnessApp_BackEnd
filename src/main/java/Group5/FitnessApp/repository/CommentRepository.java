package Group5.FitnessApp.repository;

import Group5.FitnessApp.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {
}
