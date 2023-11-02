package com.example.teachermanage.vo;

import com.example.teachermanage.entity.Course;
import com.example.teachermanage.entity.Teacher;
import com.example.teachermanage.entity.TeacherCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {

    private List<Course> course;

    private List<Integer> currentTeacherCourse;
}
