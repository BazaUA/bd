package com.bazalyskyi.school.controller;

import com.bazalyskyi.school.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    SubjectDao subjectDao;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("list",subjectDao.getAllSubjects());
        return modelAndView;
    }

    @GetMapping("/redirect")
    public RedirectView redirect() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String role=authorities.get(0).toString();
        String redirect="";
        switch (role) {
            case "ROLE_ADMIN":
                redirect="/admin/";
                break;
            case "ROLE_PUPIL":
                    redirect="/pupil/";
                    break;
            case "ROLE_PERSONNEL":
                redirect="/personnel/";
                break;
            default:
                redirect="/error";
                break;
        }
        return new RedirectView(redirect);
    }

    @GetMapping("/403")
    public ModelAndView forbidden() {
        ModelAndView modelAndView=new ModelAndView("403");
        return modelAndView;
    }
   @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView=new ModelAndView("error");
        return modelAndView;
    }
}
