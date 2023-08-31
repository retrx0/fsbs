package com.nsi.fsbs.controllers;

import com.nsi.dto.UserRegistrationDTO;
import com.nsi.fsbs.exception.UserAlreadyExistException;
import com.nsi.fsbs.services.web.impl.UserService;
import com.nsi.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserControllerV1 {

    private final UserService userService;

    public UserControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/v1/user/registration")
    public String registerUser(WebRequest request, Model model){
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        model.addAttribute("user", userRegistrationDTO);
        return "registered";
    }

    @PostMapping
    public ModelAndView registerUserAccountV1(@ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO,
                                              HttpServletRequest request,
                                              Errors errors){

        ModelAndView modelAndView = new ModelAndView();
        try {
            User registered = userService.registerNewUserAccount(userRegistrationDTO);
            modelAndView.addObject("successfulRegistration", "user");
        } catch (UserAlreadyExistException ex){
            modelAndView.addObject("message", "An account for that username/email already exist");
        }
        return modelAndView;
    }

}
