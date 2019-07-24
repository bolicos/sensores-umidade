package greenhouse.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
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
    @GetMapping("/users/new")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/users/new")
    public String processCreationForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        } else {
            this.users.save(user);
            return "redirect:/owners/" + user.getId();
        }
    }
//--------------------------------------------------------------------------------------
//-------------------------------------EDIT USER----------------------------------------
    @GetMapping("/users/{userId}/edit")
    public String initUpdateUserForm(@PathVariable("userId") Integer userId, Model model) {
    	User user = this.users.findById(userId);
        model.addAttribute(user);
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid User user, BindingResult result, @PathVariable("userId") Integer userId) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        } else {
        	user.setId(userId);
            this.users.save(user);
            return "redirect:/users/{userId}";
        }
    }
    
    
    
    
    @GetMapping("/users/{userId}")
    public ModelAndView showUser(@PathVariable("userId") int userId) {
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(this.users.findById(userId));
        return mav;
    }
}
