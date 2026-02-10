package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Member {

    @Id
    private String id;
    private String name;
    private String username;
    private double height;
    private double weight;
    private String sex;
    private String goals;
    private String activity_level;
    private int age;

    public Member() {}

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, String name, double height, double weight, String sex, String username, String goals, String activity_level, int age) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.username = username;
        this.goals = goals;
        this.activity_level = activity_level;
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getId() {
        return this.id;
    }

    public void setGoals(String description) {
        this.goals = description;
    }

    public String getGoals() {
        return this.goals;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setActivity_level(String activity_level) {
        this.activity_level = activity_level;
    }

    public String getActivity_level() {
        return this.activity_level;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}

