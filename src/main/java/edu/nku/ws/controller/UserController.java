package edu.nku.ws.controller;

import edu.nku.ws.model.IUserDao;
import edu.nku.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private IUserDao iUserDao;

    @Autowired
    public UserController(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public ModelAndView getAllUsers(){
        Iterable<User> allUsers = this.iUserDao.findAll();
        ModelAndView modelAndView = new ModelAndView("allUsers");
        modelAndView.addObject("users", allUsers);
        return modelAndView;
    }


    @RequestMapping("/getByUserId")
    @ResponseBody
    public ModelAndView getByUserId(@RequestParam int userId){
        User byUserId = this.iUserDao.findByUserId(userId);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("myUser", byUserId);
        return modelAndView;
    }

    @RequestMapping("/countUsers")
    @ResponseBody
    public String countUsers(){
        return "Total users: " + this.iUserDao.count();
    }

}
