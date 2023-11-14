package com.example.teachermanage.service;

import com.example.teachermanage.entity.Result;
import com.example.teachermanage.entity.Teacher;
import com.example.teachermanage.DTO.UpdateCourseDTO;
import com.example.teachermanage.page.Page;

public interface ManageService {

    void addTeacher(Teacher teacher);

    Result queryTeacherPage(String token, Page page);

    Result getCourse(Teacher teacher);

    Result updateCourse(UpdateCourseDTO updateCourseDTO);

    Result getHistory(String moudle, Page page);

    Result searchTeacher(String teacherCode);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(String teacherCode);

    void addTeacherHistory(String token, Teacher teacher);

    void deleteTeacherHistory(String token, String teacherCode);

    void updateTeacherHistory(String token, Teacher teacher);

    void updateCourseHistory(String token,UpdateCourseDTO updateCourseDTO);
}
