package com.example.teachermanage.service.impl;

import com.example.teachermanage.DTO.UpdateCourseDTO;
import com.example.teachermanage.entity.*;
import com.example.teachermanage.mapper.TeacherMapper;
import com.example.teachermanage.mapper.UserMapper;
import com.example.teachermanage.service.ManageService;
import com.example.teachermanage.page.Page;
import com.example.teachermanage.utils.TokenUtils;
import com.example.teachermanage.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (teacher == null){
            return Result.err(211,"没有该教师信息");
        }
        if (teacher.getTeacherDepartment().equals("null") || teacher.getTeacherDepartment().isEmpty()){
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
    @Transactional
    public Result updateCourse(UpdateCourseDTO updateCourseDTO) {
        String teacherCode = updateCourseDTO.getTeacherCode();
        List<Integer> courses = updateCourseDTO.getCourses();
        //System.out.println(courses);
        Integer i = 0;
//        i += teacherMapper.deleteTeacherCourseByCode(teacherCode);
//        if (i==0){
//            return Result.err(211,"更新失败（删除）");
//        }
        teacherMapper.deleteTeacherCourseByCode(teacherCode);
        for (Integer cid: courses) {
            i += teacherMapper.insertTeacherCourseByCode(teacherCode,cid);
        }
//        if (i<courses.size()+1){
//            return Result.err(212,"更新失败（插入）");
//        }
        return Result.ok("更新成功！");
    }

    @Override
    public Result getHistory(String moudle, Page page) {
        System.out.println("*****************");
        System.out.println(moudle);
        System.out.println(page);
        if (moudle.equals("all")){
            List<History> allHistory = teacherMapper.getAllHistoryByPage(page);
            Integer count = teacherMapper.findHistoryRowCount();
            page.setTotalNum(count);
            page.setResultList(allHistory);
            return Result.ok("查询成功！",page);
        }
        List<History> historyByMoudle = teacherMapper.getHistoryByMoudle(moudle, page);
        Integer count = teacherMapper.findHistoryRowCountByMoudle(moudle);
        page.setTotalNum(count);
        page.setResultList(historyByMoudle);
        return Result.ok("查询成功！",page);
    }

    @Override
    public Result searchTeacher(String teacherCode) {
        Teacher teacher = teacherMapper.selectByTeacherCode(teacherCode.replace("\"", ""));
        return Result.ok(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateByTeacherCode(teacher);
    }

    @Override
    public void deleteTeacher(String teacherCode) {
        teacherMapper.deleteTeacherByCode(teacherCode.replace("\"", ""));
    }

    @Override
    public void addTeacherHistory(String token, Teacher teacher) {
        String userName = tokenUtils.getCurrentUser(token).getUserName();
        String teacherCode = teacher.getTeacherCode();
        teacherMapper.addTeacherMessage(userName,teacherCode);
}

    @Override
    public void deleteTeacherHistory(String token, String teacherCode) {
        String userName = tokenUtils.getCurrentUser(token).getUserName();
        teacherMapper.deleteTeacherMessage(userName,teacherCode.replace("\"", ""));
    }

    @Override
    public void updateTeacherHistory(String token, Teacher teacher) {
        String userName = tokenUtils.getCurrentUser(token).getUserName();
        String teacherCode = teacher.getTeacherCode();
        teacherMapper.updateTeacherMessage(userName,teacherCode);
    }

    @Override
    public void updateCourseHistory(String token, UpdateCourseDTO updateCourseDTO) {
        String userName = tokenUtils.getCurrentUser(token).getUserName();
        String teacherCode = updateCourseDTO.getTeacherCode();
        teacherMapper.updateCourseMessage(userName,teacherCode);
    }
}
