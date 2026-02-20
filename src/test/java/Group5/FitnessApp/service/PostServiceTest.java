package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Post;
import org.junit.jupiter.api.Assertions;
import Group5.FitnessApp.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void makePost_Test() {
        Post post = new Post();
        post.setAuthorId("mc2003");
        post.setLikes(0);
        post.setComments(0);
        post.setContent("I'm so glad I listened to Kyle and got all those games");
        postService.makePost(post);

        Post postcheck = postService.findByContent(post);
        Assertions.assertEquals(post.getContent(), postcheck.getContent());
    }

    @Test
    void makePost_Test2() {
        Post post = new Post();
        post.setAuthorId("mc2003");
        post.setLikes(0);
        post.setComments(0);
        post.setContent("I hate Marvel Rivals");

        Post postCheck = postService.findByContent(post);
        Assertions.assertNull(postCheck);
    }

    @Test
    void deletePost_Test() {
        Post post = new Post();
        post.setAuthorId("mc2003");
        post.setLikes(0);
        post.setComments(0);
        post.setContent("Marvel Rivals is so boring");
        postService.makePost(post);

        long id = postService.findByContent(post).getId();
        String s = String.valueOf(id);
        boolean status = postService.deletePost(s);
        Assertions.assertTrue(status);
    }

    @Test
    void deletePost_Test2() {
        boolean status = postService.deletePost("15");
        Assertions.assertFalse(status);
    }
}
