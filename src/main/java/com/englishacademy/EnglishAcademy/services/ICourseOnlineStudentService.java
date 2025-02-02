package com.englishacademy.EnglishAcademy.services;

import com.englishacademy.EnglishAcademy.dtos.courseOnlineStudent.CourseOnlineStudentDTO;
import com.englishacademy.EnglishAcademy.models.courseOnlineStudent.CreateCourseOnlineStudent;

public interface ICourseOnlineStudentService {
    CourseOnlineStudentDTO buyCourse(CreateCourseOnlineStudent model, Long studentId);
    boolean checkCourseOnlineRegistered(String slug, Long studentId);
}
