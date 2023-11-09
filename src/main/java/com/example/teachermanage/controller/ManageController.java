package com.example.teachermanage.controller;

import com.example.teachermanage.DTO.UpdateCourseDTO;
import com.example.teachermanage.DTO.HistoryDTO;
import com.example.teachermanage.entity.*;
import com.example.teachermanage.page.Page;
import com.example.teachermanage.service.ManageService;
import com.example.teachermanage.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManageController {


    @Autowired
    private ManageService manageService;

    @RequestMapping("/teacher-list")
    public Result teacherList(@RequestHeader(Constants.HEADER_TOKEN_NAME) String token,@RequestBody Page page){
        Result result = manageService.queryTeacherPage(token, page);
        return result;
    }

    @RequestMapping("/add_teacher")
    public Result addTeacher(@RequestBody Teacher teacher){
        manageService.addTeacher(teacher);
        return Result.ok("添加成功！");
    }

    @RequestMapping("/delete_teacher")
    public Result deleteTeacher(@RequestBody String teacherCode){
        manageService.deleteTeacher(teacherCode);
        return Result.ok("删除成功！");
    }

    @RequestMapping("/search_teacher")
    public Result searchTeacher(@RequestBody String teacherCode){
        Result result = manageService.searchTeacher(teacherCode);
        return Result.ok("查询成功！",result);
    }

    @RequestMapping("/update_teacher")
    public Result updateTeacher(@RequestBody Teacher teacher){
        manageService.updateTeacher(teacher);
        return Result.ok("更新成功！");
    }

    @RequestMapping("/get-course")
    public Result getCourse(@RequestBody Teacher teacher){
        Result result = manageService.getCourse(teacher);
        return result;
    }

    @RequestMapping("/update-course")
    public Result upadteCourse(@RequestBody UpdateCourseDTO updateCourseDTO){
        Result result = manageService.updateCourse(updateCourseDTO);
        return result;
    }

    @RequestMapping("/history")
    public Result history(@RequestBody HistoryDTO historyDTO){
        Result result = manageService.getHistory(historyDTO.getMoudle(),historyDTO.getPage());
        return result;
    }
}
