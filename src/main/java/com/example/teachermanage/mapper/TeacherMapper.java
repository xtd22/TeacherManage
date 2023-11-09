package com.example.teachermanage.mapper;

import com.example.teachermanage.entity.Course;
import com.example.teachermanage.entity.History;
import com.example.teachermanage.entity.Teacher;
import com.example.teachermanage.entity.TeacherCourse;
import com.example.teachermanage.page.Page;
import com.sun.source.doctree.HiddenTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @author 24024
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-10-09 10:28:32
* @Entity com.example.teachermanage.entity.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByTeacherCode(Teacher record);

    List<Teacher> selectAllByPage(@Param("page") Page page);

    int deleteTeacherByCode(String teahcerCode);

    Integer findTeacherRowCount();

    Teacher selectByTeacherCode(@Param("teacherCode") String teacherCode);

    List<Course> selectCourseByDepartment(@Param("teacherDepartment") String teacherDepartment);

    List<Integer> queryTeacherCourseByTeacherCode(@Param("teacherCode") String teacherCode);

    Integer deleteTeacherCourseByCode(@Param("teacherCode") String teacherCode);


    Integer insertTeacherCourseByCode(@Param("teacherCode") String teacherCode, @Param("cid") Integer cid);

    List<History> getAllHistoryByPage(@Param("page") Page page);

    List<History> getHistoryByMoudle(@Param("moudle") String moudle,@Param("page") Page page);

    Integer findHistoryRowCount();

    Integer findHistoryRowCountByMoudle(@Param("moudle") String moudle);
}
