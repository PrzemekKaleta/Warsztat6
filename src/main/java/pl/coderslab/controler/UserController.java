package pl.coderslab.controler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.LoginUser;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.session.UserSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.passwordEncoder = passwordEncoder;
        this.tweetRepository = tweetRepository;

    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "user/form";
            //jezęli ma błędy to wraca do formularza
        }

        if(userRepository.existsUserByEmail(user.email)){
            result.addError(new FieldError("user", "email", "email już jest zajęty"));
            return "user/form";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        userSession.setEmail(user.getEmail());
        //przekazujemy do sesji identyfikator użytkowinka jakim jest email - bo on jest unikatowy
        return "redirect:/";

    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginUser", new LoginUser());
        return "user/login";
    }
    @PostMapping("login")
    public String login(LoginUser loginUser, BindingResult result){
        String hashedPassword = userRepository.findPasswordByEmail(loginUser.getEmail());
        if(passwordEncoder.matches(loginUser.getPassword(), hashedPassword)){
            userSession.setEmail(loginUser.getEmail());
            return "redirect:/";
        }else{
            result.addError(new ObjectError("loginUser", "Wpisano zły login lub hasło"));
        }
        return "user/login";
    }
    @GetMapping("/mytweets")
    public String myTweets(Model model){
        model.addAttribute("mytweets", tweetRepository.findByUserOrderByIdDesc(userRepository.findUserByEmail(userSession.getEmail())));
        return "user/user-tweets";
    }

    @GetMapping("/logout")
    public String logout(){
        userSession.setEmail(null);
        return "redirect:login";
    }
}
