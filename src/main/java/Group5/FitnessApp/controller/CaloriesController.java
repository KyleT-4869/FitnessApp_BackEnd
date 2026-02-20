package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Calories;
import Group5.FitnessApp.service.CaloriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
@RequestMapping("/api")
@RestController
public class CaloriesController {
    private final CaloriesService calService;

    public CaloriesController(CaloriesService calService) {
        this.calService = calService;
    }

    @GetMapping("/getCaloriesInfo")
    public ResponseEntity<Calories> getCaloriesInfo(@RequestParam String username) {
        Optional<Calories> cal = calService.retrieveCaloriesInfo(username);
        if(cal.isPresent()) {
            Calories returnCal = cal.get();
            return ResponseEntity.ok(returnCal);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
