package pl.coderslab.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.session.UserSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    private final TweetRepository tweetRepository;
    private final UserSession userSession;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public TweetController(TweetRepository tweetRepository, UserSession userSession, UserRepository userRepository, CommentRepository commentRepository) {
        this.tweetRepository = tweetRepository;
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/{id}")
    public String oneTweet(Model model, @PathVariable Long id) {
        model.addAttribute("tweet", tweetRepository.findById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("allComments", commentRepository.findAllByTweetId(id));
        return "tweet";
    }

    @PostMapping("/{id}")
    public String addComment(Model model, @PathVariable Long id, @Valid Comment comment, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("tweet", tweetRepository.findById(id));
            return "tweet"/*+id*/;
        }
        comment.setId(null);
        comment.setTweet(tweetRepository.findById(id));
        comment.setUser(userRepository.findUserByEmail(userSession.getEmail()));
        commentRepository.save(comment);
        model.addAttribute("tweet", tweetRepository.findById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("allComments", commentRepository.findAllByTweetId(id));

        return "tweet";

    }

}
