package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByOrderByIdDesc();
    List<Tweet> findByIdOrderByIdDesc(Long id);
    List<Tweet> findByUserOrderByIdDesc(User user);
    Tweet findById(Long id);
}
