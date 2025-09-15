package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Member {

    @Id
    private String id;
    private String name;
    //private AggregateReference<>

    public Member() {}

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
