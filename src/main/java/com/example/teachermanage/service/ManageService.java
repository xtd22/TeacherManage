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
}
