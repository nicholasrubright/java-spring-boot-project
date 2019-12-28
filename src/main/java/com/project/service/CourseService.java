package com.project.service;

import com.project.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course addCourse(String cID, String cName, String cDesc, int cCredits);

    List<Course> findAllFilteredCourses(String filter);

    Course findCourseById(int id);

    Course editCourse(int id, String cID, String cName, String cDesc, int cCredit);

    boolean deleteCourseById(int id);
}
