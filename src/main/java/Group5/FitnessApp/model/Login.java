package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;

public class Login {

    @Id
    String username;
    String id;
    String password;
    int hash;

    public String getUsername() {
        return username;
    }

    public void setUserame(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHash() {
        return password.hashCode();
    }

}
