package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    long id;
    long postId;
    String authorId;
    String content;
    int likes;
    int dislikes;

    public Comment() {}

    public Comment(long postId, String content, int likes, int dislikes, String authorId ) {
        this.postId = postId;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.authorId = authorId;
    }
    public void setId(long Id) {
        this.id = id;
    }
    public void setPostId(long postId) {
        this.postId = postId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public long getId() {
        return this.id;
    }
    public long getPostId() {
        return this.postId;
    }

    public String getAuthorId() {
        return this.authorId;
    }
    public String getContent() {
        return this.content;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }
}
