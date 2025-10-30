package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Comment;
import Group5.FitnessApp.model.Post;
import Group5.FitnessApp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getComments")
    public ResponseEntity<List<Comment>> getComments(@RequestParam long id) {
        Post post = new Post();
        post.setId(id);
        List<Comment> returnComments = commentService.getComment(post);
        return ResponseEntity.ok(returnComments);
    }

    @GetMapping("/makeComments")
    public ResponseEntity<Comment> makeComments(@RequestBody Comment comment) {
        int status = commentService.makeComment(comment);
        if(status > 0) {
            return ResponseEntity.ok(comment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/deleteComment")
    public ResponseEntity<String> deleteComment(@RequestParam String id) {
        if(commentService.deleteComment(id)) {
            return ResponseEntity.ok("Your comment has been deleted");
        }
        return new ResponseEntity<>("Unable to delete comment", HttpStatus.BAD_REQUEST);
    }
}
