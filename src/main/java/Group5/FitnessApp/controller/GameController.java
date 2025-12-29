package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Game;
import Group5.FitnessApp.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // CREATE GAME -------------
    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.createGame(game));
    }

    // DELETE GAME --------------
    @DeleteMapping("/delete/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable Integer gameId) {
        if (gameService.deleteGame(gameId)) {
            return ResponseEntity.ok("Deleted successfully");
        }
        return ResponseEntity.badRequest().body("Game not found");
    }

    // FILTER BY SPORT ----------
    @GetMapping("/sport/{sport}")
    public ResponseEntity<List<Game>> getBySport(@PathVariable String sport) {
        if (sport.equalsIgnoreCase("All")) {
            return ResponseEntity.ok(gameService.getAllGames());
        }
        return ResponseEntity.ok(gameService.getGamesBySport(sport));
    }

    // JOIN GAME ----------------
    @PostMapping("/join")
    public ResponseEntity<String> joinGame(
            @RequestParam Integer gameId,
            @RequestParam String memberId) {

        if (gameService.joinGame(gameId, memberId)) {
            return ResponseEntity.ok("Joined successfully");
        }
        return ResponseEntity.badRequest().body("Failed to join");
    }

    // LEAVE GAME ---------------
    @PostMapping("/leave")
    public ResponseEntity<String> leaveGame(
            @RequestParam Integer gameId,
            @RequestParam String memberId) {

        if (gameService.leaveGame(gameId, memberId)) {
            return ResponseEntity.ok("Left successfully");
        }
        return ResponseEntity.badRequest().body("Failed to leave");
    }
}
