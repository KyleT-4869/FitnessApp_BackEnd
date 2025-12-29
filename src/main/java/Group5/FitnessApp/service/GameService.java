package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Game;
import Group5.FitnessApp.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.*;

    @Service
    public class GameService {

        private final GameRepository gameRepo;

        public GameService(GameRepository gameRepo) {
            this.gameRepo = gameRepo;
        }

        public Game createGame(Game game) {
            return gameRepo.save(game);
        }

        public boolean deleteGame(Integer gameId) {
            if(gameRepo.existsById(gameId)) {
                gameRepo.deleteById(gameId);
                return true;
            }
            return false;
        }

        public Optional<Game> getGameById(Integer id) {
            return gameRepo.findById(id);
        }

        public List<Game> getGamesBySport(String sport) {
            return gameRepo.findBySport(sport);
        }

        public boolean joinGame(Integer gameId, String memberId) {
            Optional<Game> opt = gameRepo.findById(gameId);
            if(opt.isPresent()) {
                Game game = opt.get();
                boolean added = game.joinGame(memberId);
                gameRepo.save(game);
                return added;
            }
            return false;
        }

        public boolean leaveGame(Integer gameId, String memberId) {
            Optional<Game> opt = gameRepo.findById(gameId);
            if(opt.isPresent()) {
                Game game = opt.get();
                boolean removed = game.leaveGame(memberId);
                gameRepo.save(game);
                return removed;
            }
            return false;
        }

        public List<Game> getAllGames() {
            return (List<Game>) gameRepo.findAll();
        }
    }
