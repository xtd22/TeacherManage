package com.example.teachermanage.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName teacher
 */
@Data
public class Teacher implements Serializable {
    /**
     * 
     */
    private Integer teacherId;

    /**
     * 
     */
    private String teacherCode;

    /**
     * 
     */
    private String teacherPwd;

    /**
     * 
     */
    private String teacherName;

    /**
     * 教师职称
     */
    private String teacherTitle;

    /**
     * 入职时间
     */
    private Date teacherEntryTime;

    /**
     * 性别
     */
    private Integer teacherGender;

    /**
     * 出生日期
     */
    private Date teacherBirth;

    /**
     * 家庭地址
     */
    private String teacherAdress;

    /**
     * 邮箱
     */
    private String teacherEmail;

    /**
     * 电话号码
     */
    private String teacherPhone;

    /**
     * 所属部门、院系
     */
    private String teacherDepartment;

    /**
     * 薪水
     */
    private BigDecimal teacherSalary;

    /**
     * 头像
     */
    private String teacherPicture;

    /**
     * 学历和资格证书
     */
    private String teacherQualifications;

    /**
     * 是否被删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teacher other = (Teacher) that;
        return (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getTeacherCode() == null ? other.getTeacherCode() == null : this.getTeacherCode().equals(other.getTeacherCode()))
            && (this.getTeacherPwd() == null ? other.getTeacherPwd() == null : this.getTeacherPwd().equals(other.getTeacherPwd()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getTeacherTitle() == null ? other.getTeacherTitle() == null : this.getTeacherTitle().equals(other.getTeacherTitle()))
            && (this.getTeacherEntryTime() == null ? other.getTeacherEntryTime() == null : this.getTeacherEntryTime().equals(other.getTeacherEntryTime()))
            && (this.getTeacherGender() == null ? other.getTeacherGender() == null : this.getTeacherGender().equals(other.getTeacherGender()))
            && (this.getTeacherBirth() == null ? other.getTeacherBirth() == null : this.getTeacherBirth().equals(other.getTeacherBirth()))
            && (this.getTeacherAdress() == null ? other.getTeacherAdress() == null : this.getTeacherAdress().equals(other.getTeacherAdress()))
            && (this.getTeacherEmail() == null ? other.getTeacherEmail() == null : this.getTeacherEmail().equals(other.getTeacherEmail()))
            && (this.getTeacherPhone() == null ? other.getTeacherPhone() == null : this.getTeacherPhone().equals(other.getTeacherPhone()))
            && (this.getTeacherDepartment() == null ? other.getTeacherDepartment() == null : this.getTeacherDepartment().equals(other.getTeacherDepartment()))
            && (this.getTeacherSalary() == null ? other.getTeacherSalary() == null : this.getTeacherSalary().equals(other.getTeacherSalary()))
            && (this.getTeacherPicture() == null ? other.getTeacherPicture() == null : this.getTeacherPicture().equals(other.getTeacherPicture()))
            && (this.getTeacherQualifications() == null ? other.getTeacherQualifications() == null : this.getTeacherQualifications().equals(other.getTeacherQualifications()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getTeacherCode() == null) ? 0 : getTeacherCode().hashCode());
        result = prime * result + ((getTeacherPwd() == null) ? 0 : getTeacherPwd().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getTeacherTitle() == null) ? 0 : getTeacherTitle().hashCode());
        result = prime * result + ((getTeacherEntryTime() == null) ? 0 : getTeacherEntryTime().hashCode());
        result = prime * result + ((getTeacherGender() == null) ? 0 : getTeacherGender().hashCode());
        result = prime * result + ((getTeacherBirth() == null) ? 0 : getTeacherBirth().hashCode());
        result = prime * result + ((getTeacherAdress() == null) ? 0 : getTeacherAdress().hashCode());
        result = prime * result + ((getTeacherEmail() == null) ? 0 : getTeacherEmail().hashCode());
        result = prime * result + ((getTeacherPhone() == null) ? 0 : getTeacherPhone().hashCode());
        result = prime * result + ((getTeacherDepartment() == null) ? 0 : getTeacherDepartment().hashCode());
        result = prime * result + ((getTeacherSalary() == null) ? 0 : getTeacherSalary().hashCode());
        result = prime * result + ((getTeacherPicture() == null) ? 0 : getTeacherPicture().hashCode());
        result = prime * result + ((getTeacherQualifications() == null) ? 0 : getTeacherQualifications().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherCode=").append(teacherCode);
        sb.append(", teacherPwd=").append(teacherPwd);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", teacherTitle=").append(teacherTitle);
        sb.append(", teacherEntryTime=").append(teacherEntryTime);
        sb.append(", teacherGender=").append(teacherGender);
        sb.append(", teacherBirth=").append(teacherBirth);
        sb.append(", teacherAdress=").append(teacherAdress);
        sb.append(", teacherEmail=").append(teacherEmail);
        sb.append(", teacherPhone=").append(teacherPhone);
        sb.append(", teacherDepartment=").append(teacherDepartment);
        sb.append(", teacherSalary=").append(teacherSalary);
        sb.append(", teacherPicture=").append(teacherPicture);
        sb.append(", teacherQualifications=").append(teacherQualifications);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}