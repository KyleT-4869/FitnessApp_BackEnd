package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;


public class Post {

    @Id
    long id;
    String authorId;
    String content;
    int likes;
    int comments;

    public Post() {

    }

    public Post(String authorId, int likes, int comments, String content) {
        this.authorId = authorId;
        this.likes = likes;
        this.comments = comments;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }
    public void setAuthorId(String author) {
        this.authorId = author;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return this.likes;
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
