package greenhouse.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import greenhouse.services.SecurityService;
import greenhouse.services.UserService;
import greenhouse.validator.UserValidator;

import greenhouse.models.User;
import greenhouse.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {return "welcome";}
//------------------------------------------------------------------------------------------------
	
	private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "user/createOrUpdateUserForm";
	
	private UserRepository users;

	public UserController(UserRepository users) {
		super();
		this.users = users;
	}
//--------------------------------------------MAPPINGS--------------------
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
//------------------------------------------------------------------------
//-------------------------------------NEW USER-------------------------------------------
//    @GetMapping("/users/new")
//    public String initCreationForm(Map<String, Object> model) {
//        User user = new User();
//        model.put("user", user);
//        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @PostMapping("/users/new")
//    public String processCreationForm(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
//        } else {
//            this.users.save(user);
//            return "redirect:/users/" + user.getUserName();
//        }
//    }
//--------------------------------------------------------------------------------------
//-------------------------------------EDIT USER----------------------------------------
//    @GetMapping("/users/{userName}/edit")
//    public String initUpdateUserForm(@PathVariable("userName") String userName, Model model) {
//    	User user = this.users.findByUserName(userName);
//        model.addAttribute(user);
//        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @PostMapping("/users/{userName}/edit")
//    public String processUpdateOwnerForm(@Valid User user, BindingResult result, @PathVariable("userId") String userName) {
//        if (result.hasErrors()) {
//            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
//        } else {
//        	user.setUserName(userName);
//            this.users.save(user);
//            return "redirect:/users/{userId}";
//        }
//    }
    
    
    
    
//    @GetMapping("/users/{userName}")
//    public ModelAndView showUser(@PathVariable("userId") String userName) {
//        ModelAndView mav = new ModelAndView("users/userDetails");
//        mav.addObject(this.users.findById(userName));
//        return mav;
//    }
}
