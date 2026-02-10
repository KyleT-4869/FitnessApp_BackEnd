package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Calories;
import Group5.FitnessApp.model.Member;
import Group5.FitnessApp.repository.CaloriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaloriesService {

    private final CaloriesRepository calRepo;

    public CaloriesService(CaloriesRepository calRepo) {
        this.calRepo = calRepo;
    }

    public void calculateBMR(Member member) {
        if(member.getSex().equals("male")) {
            double bmr = (10 * (member.getWeight() * 0.4536)) + (6.25 * (member.getHeight() * 30.48)) - (5 * member.getAge()) + 5;
            calculateTdee(bmr, member.getActivity_level(), member.getUsername());
        }
        else if(member.getSex().equals("female")) {
            double bmr = (10 * (member.getWeight() * 0.4536)) + (6.25 * (member.getHeight() * 30.48)) - (5 * member.getAge()) - 161;
            calculateTdee(bmr, member.getActivity_level(), member.getUsername());
        }
        else {
            throw new IllegalArgumentException("Unable to calculate BMR");
        }
    }

    public void calculateTdee(double bmr, String activityLevel, String username) {
        double tdee;
        switch (activityLevel) {
            case "sedentary":
                tdee = bmr * 1.2;
                break;
            case "light" :
                tdee = bmr * 1.375;
                break;
            case "moderate":
                tdee = bmr * 1.55;
                break;
            case "heavy":
                tdee = bmr * 1.725;
                break;
            case "very heavy":
                tdee = bmr * 1.9;
                break;
            default:
                throw new IllegalArgumentException(
                        "Unknown activity level: " + activityLevel
                );
        }
        saveToDatabase(bmr, tdee, username);
    }

    public void saveToDatabase(double bmr, double tdee, String username) {
        Calories cal = new Calories();
        cal.setBmr(bmr);
        cal.setTdee(tdee);
        cal.setUsername(username);
        calRepo.save(cal);
    }

    public Optional<Calories> retrieveCaloriesInfo(String username) { return calRepo.findById(username); }
}
