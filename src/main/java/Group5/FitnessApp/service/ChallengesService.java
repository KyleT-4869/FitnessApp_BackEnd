package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Challenges;
import Group5.FitnessApp.repository.ChallengesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChallengesService {

    private final ChallengesRepository chalRepo;

    public ChallengesService(ChallengesRepository chalRepo) {
        this.chalRepo = chalRepo;
    }

    public Optional<Challenges> retrieveChallenge(String id) {
        return chalRepo.findById(id);
    }

}
