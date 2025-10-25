package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    long id;
    long postId;
    String content;
    int likes;
    int dislikes;

    public Comment(long postId, String content, int likes, int dislikes) {
        this.postId = postId;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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

    public long getPostId() {
        return this.postId;
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
