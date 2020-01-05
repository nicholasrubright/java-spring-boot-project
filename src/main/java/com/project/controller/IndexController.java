package com.project.controller;

import com.project.model.Course;
import com.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    private final CourseService courseService;

    public IndexController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);
        return "index";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam("term") String term) {
        List<Course> courses = courseService.findAllFilteredCourses(term);
        model.addAttribute("courses", courses);
        return "index";
    }

    @GetMapping("/success")
    public String indexWithSuccess(Model model) {
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("success", "Your changes were successfully saved");
        return "index";
    }

    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourseById(id);
        return "redirect:/";
    }
}
