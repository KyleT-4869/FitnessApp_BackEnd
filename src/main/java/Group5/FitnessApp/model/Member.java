package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Member {

    @Id
    private String id;
    private String name;
    private String username;
    double height;
    double weight;
    String sex;
    String description;

    public Member() {}

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, String name, double height, double weight, String sex, String username, String description) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.username = username;
        this.description = description;
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

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
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
}
