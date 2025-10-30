package Group5.FitnessApp.service;

import Group5.FitnessApp.model.Post;
import Group5.FitnessApp.repository.PostRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

@Service
public class PostService {

    PostRepository postRepo;
    JdbcTemplate jdbcTemplate;

    public PostService(PostRepository postRepo, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.postRepo = postRepo;
    }

    public List<Post> getPosts() {

        List<Post> returnPosts = new ArrayList<>();
        returnPosts = jdbcTemplate.query("SELECT * FROM POST ORDER BY ID DESC LIMIT 5", (rs, rowNum) -> {
            Post p = new Post();
            p.setId(rs.getInt("ID"));
            p.setAuthorId(rs.getString("AUTHOR_ID"));
            p.setContent(rs.getString("CONTENT"));
            p.setLikes(rs.getInt("LIKES"));
            p.setDislikes(rs.getInt("DISLIKES"));
            p.setComments(rs.getInt("COMMENTS"));
            return p;
        });
        return returnPosts;
    }

    public long makePost(Post post) {
        jdbcTemplate.update(
                "INSERT INTO POST(author_id, content, likes, dislikes, comments) VALUES (?,?,?,?,?)",
                post.getAuthorId(),
                post.getContent(),
                post.getLikes(),
                post.getDislikes(),
                post.getComments()
        );
        Post postCheck = findByContent(post);
        if(postCheck != null) {
            return postCheck.getId();
        }
        return 0;
    }

    public boolean deletePost(String id) {
        try {
            postRepo.deleteById(id);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public Post findByContent(Post post) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM POST WHERE CONTENT = ? AND AUTHOR_ID = ?",
                    new BeanPropertyRowMapper<>(Post.class),
                    post.getContent(),
                    post.getAuthorId()
            );
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

}
