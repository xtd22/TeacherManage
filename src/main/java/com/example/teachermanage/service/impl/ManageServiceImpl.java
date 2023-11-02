package com.example.teachermanage.service.impl;

import com.example.teachermanage.entity.*;
import com.example.teachermanage.mapper.TeacherMapper;
import com.example.teachermanage.mapper.UserMapper;
import com.example.teachermanage.service.ManageService;
import com.example.teachermanage.page.Page;
import com.example.teachermanage.utils.TokenUtils;
import com.example.teachermanage.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public Result queryTeacherPage(String token, Page page) {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        String userCode = currentUser.getUserCode();
        try{
            User userByCode = userMapper.findUserByCode(userCode);
            if (userByCode.getUserCode().equals("ss")){
                List<Teacher> teacherList = teacherMapper.selectAllByPage(page);
                Integer count = teacherMapper.findTeacherRowCount();
                page.setTotalNum(count);
                page.setResultList(teacherList);
                Result result = Result.ok("身份验证无误！",page);
                return result;
            }
        }catch (Exception e){
            Result result = Result.err(100, "身份验证出错！");
            return result;
        }
        Result result = Result.err(101, "非系统管理员！");
        return result;
    }

    @Override
    public Result getCourse(Teacher teacher) {
        if (teacher.getTeacherDepartment().equals("null")){
            return Result.err(210,"所属部门、院系不存在");
        }
        String teacherDepartment = teacher.getTeacherDepartment();
        List<Course> courses = teacherMapper.selectCourseByDepartment(teacherDepartment);
        List<Integer> teacherCourses = teacherMapper.queryTeacherCourseByTeacherCode(teacher.getTeacherCode());
        CourseVO courseVO = new CourseVO();
        courseVO.setCourse(courses);
        //System.out.println(courses);
        courseVO.setCurrentTeacherCourse(teacherCourses);
        return Result.ok("返回课程！",courseVO);
    }

    @Override
    public Result updateCourse(UpdateCourseDTO updateCourseDTO) {
        String teacherCode = updateCourseDTO.getTeacherCode();
        List<Integer> courses = updateCourseDTO.getCourses();
        //System.out.println(courses);
        Integer i = 0;
//        i += teacherMapper.deleteTeacherCourseByCode(teacherCode);
//        if (i==0){
//            return Result.err(211,"更新失败（删除）");
//        }
        for (Integer cid: courses) {
            i += teacherMapper.insertTeacherCourseByCode(teacherCode,cid);
        }
//        if (i<courses.size()+1){
//            return Result.err(212,"更新失败（插入）");
//        }
        return Result.ok("更新成功！");
    }
}
