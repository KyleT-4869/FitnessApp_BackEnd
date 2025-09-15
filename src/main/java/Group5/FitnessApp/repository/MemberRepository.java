package Group5.FitnessApp.repository;

import Group5.FitnessApp.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
