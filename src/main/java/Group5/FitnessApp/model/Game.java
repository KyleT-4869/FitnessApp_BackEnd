package Group5.FitnessApp.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import java.sql.Timestamp;



public class Game {

    @Id
    private Integer gameId;  // unique identifier for the game
    private String sport; // e.g., "Basketball", "Soccer"
    private String title; // optional: name of the game
    //@JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    //private Timestamp gameTime;
    private String participants; // store IDs of members who joined
    // private Integer max;

    public Game() {}

    /*
   * public Game(Integer gameId, String sport, String title, String gameTime, String participants, int maxPlayers) {
       * this.gameId = gameId;
       * this.sport = sport;
       * this.title = title;
       * this.gameTime = gameTime;
       * this.participants = participants;
       * this.maxPlayers = maxPlayers;
    }
    */

    // Getters & setters
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*public Timestamp getGameTime() {
        return gameTime;
    }

    public void setGameTime(Timestamp gameTime) {
        this.gameTime = gameTime;
    }*/

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getParticipants() {
        return participants;
    }

    // Methods to manage participants
    public boolean joinGame(String memberId) {
        if (participants == null || participants.isEmpty()) {
            participants = memberId;
            return true;
        }

        // already in game
        for (String id : participants.split(",")) {
            if (id.trim().equals(memberId)) {
                return false;
            }
        }

        participants += "," + memberId;
        return true;
    }

    public boolean leaveGame(String memberId) {
        if (participants == null || participants.isEmpty()) {
            return false;
        }

        String[] ids = participants.split(",");
        StringBuilder newList = new StringBuilder();
        boolean removed = false;

        for (String id : ids) {
            if (!id.trim().equals(memberId)) {
                if (newList.length() > 0) newList.append(",");
                newList.append(id.trim());
            } else {
                removed = true;
            }
        }

        participants = newList.toString();
        return removed;
    }

   /* public Integer getMax() {
        return max;
    }

    public void setMax(Integer  max) {
        this.max = max;
    }*/
}