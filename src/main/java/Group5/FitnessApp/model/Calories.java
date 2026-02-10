package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;

public class Calories {

    @Id
    String username;
    double bmr;
    double tdee;

    public Calories() {}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getBmr() {
        return this.bmr;
    }

    public void setTdee(double tdee) {
        this.tdee = tdee;
    }

    public double getTdee() {
        return this.tdee;
    }
}
