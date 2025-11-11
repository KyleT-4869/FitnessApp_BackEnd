package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Post;
import Group5.FitnessApp.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getPosts")
    public ResponseEntity<List<Post>> getPosts() {

        List<Post> returnPosts = new ArrayList<>();
        returnPosts = postService.getPosts();

        return ResponseEntity.ok(returnPosts);
    }

    @PostMapping("/makePost")
    public ResponseEntity<Post> makePost(@RequestBody Post post) {

        long id = postService.makePost(post);
        if(id != 0) {
            post.setId(id);
            return ResponseEntity.ok(post);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/deletePost")
    public ResponseEntity<String> deletePost(@RequestParam String id) {
        if(postService.deletePost(id)) {
            return ResponseEntity.ok("This post has been deleted");
        }
        return new ResponseEntity<>("Unable to delete post", HttpStatus.BAD_REQUEST);
    }
}
