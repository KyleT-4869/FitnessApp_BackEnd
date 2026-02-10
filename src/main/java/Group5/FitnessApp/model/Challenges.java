package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;

public class Challenges {

    @Id
    private String id;
    private String type;
    private String name;

    public Challenges() {}

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
