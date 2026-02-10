package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Comment;
import Group5.FitnessApp.model.Post;
import Group5.FitnessApp.repository.CommentRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepo;

    private final JdbcTemplate jdbcTemplate;


    public CommentService(CommentRepository commentRepo, JdbcTemplate jdbcTemplate) {
        this.commentRepo = commentRepo;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Comment> getComment(Post post) {
        List<Comment> returnComment = new ArrayList<>();

        returnComment = jdbcTemplate.query(
                "SELECT * FROM COMMENT WHERE POST_ID = ?",
                (ResultSet rs, int rowNum) -> {
                    Comment c = new Comment();
                    c.setId(rs.getInt("ID"));
                    c.setAuthorId(rs.getString("AUTHOR_ID"));
                    c.setContent(rs.getString("CONTENT"));
                    c.setLikes(rs.getInt("LIKES"));
                    return c;
                },
                post.getId()
        );

        return returnComment;
    }


    public long makeComment(Comment comment) {
         jdbcTemplate.update(
                "INSERT INTO COMMENT(post_id, author_id, content, likes) VALUES (?,?,?,?)",
                comment.getPostId(),
                comment.getAuthorId(),
                comment.getContent(),
                comment.getLikes()
        );
        Comment commentCheck = findByContent(comment);
        if(commentCheck == null) {
            return -1;
        }
        else {
            return commentCheck.getId();
        }
    }

    public Comment findByContent(Comment comment) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM COMMENT WHERE CONTENT = ? AND AUTHOR_ID = ?",
                    new BeanPropertyRowMapper<>(Comment.class),
                    comment.getContent(),
                    comment.getAuthorId()
            );
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }


    public boolean deleteComment(String id) {
        if(commentRepo.existsById(id)) {
            commentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
