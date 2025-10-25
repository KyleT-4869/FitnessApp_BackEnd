package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;


public class Post {

    @Id
    long id;
    String authorID;
    String content;
    int likes;
    int dislikes;
    int comments;
    public Post(String authorID, int likes, int dislikes, int comments, String content) {
        this.authorID = authorID;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    public void setAuthor(String author) {
        this.authorID = author;
    }

    public String getAuthor() {
        return this.authorID;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
    public int getComments() {
        return this.comments;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
