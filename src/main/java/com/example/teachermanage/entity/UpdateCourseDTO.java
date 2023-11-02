package com.example.teachermanage.entity;

import lombok.Data;

import java.util.List;

@Data
public class UpdateCourseDTO {

    private String teacherCode;

    private List<Integer> courses;
}
