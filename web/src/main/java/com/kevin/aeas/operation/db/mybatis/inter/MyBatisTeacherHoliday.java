package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.TeacherHoliday;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisTeacherHoliday {
    public TeacherHoliday get(int key);

    public List<TeacherHoliday> getByTeacherId(int teacherId);

    public TeacherHoliday getByTeacherAndDate(@Param("teacherId")int teacherId,@Param("adjustDate") Date date);

    public List<TeacherHoliday> getAll();

    public void add(TeacherHoliday teacherHoliday);

    public void update(TeacherHoliday teacherHoliday);

    public void delete(int key);
}
