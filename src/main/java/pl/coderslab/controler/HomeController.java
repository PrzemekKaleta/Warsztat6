package pl.coderslab.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.session.UserSession;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UserSession userSession;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public HomeController(UserSession userSession, UserRepository userRepository, TweetRepository tweetRepository) {
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        //StringUtils pomaga nam sprawdzić czy emial jest pusty czy nie, można by bło zrobić to ręcznie
        if(StringUtils.isEmpty(userSession.getEmail())){
            return "redirect:user/login";
        }
        model.addAttribute("tweet", new Tweet());

        model.addAttribute("allTweets",tweetRepository.findByOrderByIdDesc());

        return "index";

    }

    @PostMapping("/")
    public String saveTweet(@Valid Tweet tweet, BindingResult result){
        if(result.hasErrors()){
            return "index";
        }
        tweet.setUser(userRepository.findUserByEmail(userSession.getEmail()));
        tweetRepository.save(tweet);
        return "redirect:/";
    }

}
