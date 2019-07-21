package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>{

   // List<Comment> findAllByTweetOrderByIdDesc(Tweet tweet);
    List<Comment> findAllByTweetId(Long id);

/*    List<Tweet> findByOrderByIdDesc();
    List<Tweet> findByIdOrderByIdDesc(Long id);
    List<Tweet> findByUserOrderByIdDesc(User user);
    Tweet findById(Long id);*/

}
