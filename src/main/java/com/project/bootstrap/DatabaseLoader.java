package com.project.bootstrap;

import com.project.model.Course;
import com.project.repository.CourseRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.project.repository.impl.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CourseRepository courseRepository;
    public DatabaseLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("This will run when spring starts");

        this.courseRepository.addCourse(new Course(1, "CMPSC 121", "Introduction to Programming", "First class on programming", 3));
    }
}
