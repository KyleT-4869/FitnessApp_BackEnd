package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Comment;
import Group5.FitnessApp.model.Post;
import Group5.FitnessApp.repository.CommentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    CommentRepository commentRepo;
    JdbcTemplate jdbcTemplate;

    public  CommentService(CommentRepository commentRepo, JdbcTemplate jdbcTemplate) {
        this.commentRepo = commentRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> getComment(Post post) {
        List<Comment> returnComment = new ArrayList<>();
        returnComment = jdbcTemplate.query("SELECT * FROM COMMENT WHERE POST_ID = ?", (ResultSet rs, int rowNum) -> {
            Comment c = new Comment();
            c.setId(rs.getInt("ID"));
            c.setAuthorId(rs.getString("AUTHOR_ID"));
            c.setContent(rs.getString("CONTENT"));
            c.setLikes(rs.getInt("LIKES"));
            return c;
        }, post.getId());

        return returnComment;
    }

    public int makeComment(Comment comment) {
        int status = jdbcTemplate.update("INSERT INTO COMMENT(post_id, author_id, content, likes) VALUES (?,?,?,?)",
                comment.getPostId(),
                comment.getAuthorId(),
                comment.getContent(),
                comment.getLikes());

        return status;
    }

    public boolean deleteComment(String id) {
        try {
            commentRepo.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

}
