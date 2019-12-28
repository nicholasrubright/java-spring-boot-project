package com.project.repository;

import com.project.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getCourses();

    Course addCourse(Course course);

    int getNextCourseId();

    Course findCourseByID(int id);

    Course editCourse(int id, String cID, String cName, String cDesc, int cCredits);

    boolean deleteCourseByID(int id);
}
