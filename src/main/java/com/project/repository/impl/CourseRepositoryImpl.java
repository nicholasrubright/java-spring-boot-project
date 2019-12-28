package com.project.repository.impl;

import com.google.common.collect.MoreCollectors;
import com.project.model.Course;
import com.project.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private List<Course> courseList;

    public CourseRepositoryImpl() {
        courseList = new ArrayList<>();
    }

    @Override
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    @Override
    public int getNextCourseId() {
        Course maxCourse = courseList.stream().max(Comparator.comparing(Course::getId)).get();
        return maxCourse.getId() + 1;
    }

    @Override
    public Course findCourseByID(int id) {
        return courseList.stream().filter(g -> g.getId() == id).collect(MoreCollectors.onlyElement());
    }

    @Override
    public Course editCourse(int id, String cID, String cName, String cDesc, int cCredits) {

        Course existing = findCourseByID(id);
        if(existing == null) {
            throw new IllegalStateException("course with ID not found");
        }
        existing.setcName(cName);
        existing.setcDesc(cDesc);
        existing.setcCredits(cCredits);
        return existing;
    }

    @Override
    public boolean deleteCourseByID(int id) {
        courseList = courseList.stream().filter(g -> g.getId() != id).collect(Collectors.toList());
        return true;
    }
}
