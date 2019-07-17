package pl.coderslab.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.TweetRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    private TweetRepository tweetRepository;

    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/{id}")
    public String oneTweet(Model model, @PathVariable Long id) {
        model.addAttribute("tweet", tweetRepository.findById(id));
        return "tweet";
    }
}
