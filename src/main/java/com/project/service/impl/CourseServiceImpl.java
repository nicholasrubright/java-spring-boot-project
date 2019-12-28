package com.project.service.impl;

import com.project.model.Course;
import com.project.repository.CourseRepository;
import com.project.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.getCourses();
    }

    @Override
    public Course addCourse(String cID, String cName, String cDesc, int cCredits) {

        if(cName == null || cName.isEmpty()) {
            throw new IllegalArgumentException("course name cannot be nulled");
        }
        int credits;
        try {
            credits = Integer.valueOf(cCredits);
        } catch(NumberFormatException nfex) {
            throw new IllegalArgumentException("invalid credits");
        }

        int nextID = courseRepository.getNextCourseId();
        Course course = new Course(nextID, cID,  cName, cDesc, credits);
        return courseRepository.addCourse(course);
    }

    @Override
    public List<Course> findAllFilteredCourses(String filter) {
        List<Course> allCourses = courseRepository.getCourses();
        return allCourses.stream()
                .filter(g -> g.getcName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Course findCourseById(int id) {
        return courseRepository.findCourseByID(id);
    }

    @Override
    public Course editCourse(int id, String cID, String cName, String cDesc, int cCredits) {
        return courseRepository.editCourse(id, cID, cName, cDesc, cCredits);
    }

    @Override
    public boolean deleteCourseById(int id) {
        return courseRepository.deleteCourseByID(id);
    }

}
