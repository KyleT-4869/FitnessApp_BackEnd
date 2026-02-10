package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Comment;
import Group5.FitnessApp.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    Post prep() {
        Post post = new Post();
        post.setAuthorId("mc2003");
        post.setLikes(0);
        post.setComments(0);
        post.setContent("Leon Kennedy is so hot!!!");
        postService.makePost(post);

        return post;
    }

    Post prep2() {
        Post post = new Post();
        post.setAuthorId("vmchavez00");
        post.setLikes(0);
        post.setComments(0);
        post.setContent("The sky is so blue");
        postService.makePost(post);

        return post;
    }

    @Test
    void makeComment_Test() {
        Post post = prep();
        post.setId(6);
        Comment comment = new Comment();
        comment.setPostId(6);
        comment.setAuthorId("vmchavez00");
        comment.setLikes(0);
        comment.setContent("Preach, sister");
        commentService.makeComment(comment);

        List<Comment> list = commentService.getComment(post);
        Comment check = list.getFirst();

        Assertions.assertEquals(comment.getContent(), check.getContent());
    }

    @Test
    void makeComment_Test2() {
        Comment comment = new Comment();
        comment.setAuthorId("mc2003");
        comment.setContent("I like spending money");
        Comment commentCheck = commentService.findByContent(comment);

        Assertions.assertNull(commentCheck);
    }

    @Test
    void deleteComment_Test() {
        Post post = prep2();
        post.setId(7);
        Comment comment = new Comment();
        comment.setPostId(7);
        comment.setAuthorId("mc2003");
        comment.setLikes(0);
        comment.setContent("so pretty");
        commentService.makeComment(comment);

        boolean status = commentService.deleteComment("2");

        Assertions.assertTrue(status);
    }

    @Test
    void deleteComment_Test2() {
        boolean status = commentService.deleteComment("10");
        Assertions.assertFalse(status);
    }
}
