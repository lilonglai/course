package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.TeacherAbility;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisTeacherAbility {
    public TeacherAbility get(int key);

    public List<TeacherAbility> getAll();

    public List<TeacherAbility> getByTeacherId(int teacherId);

    public List<TeacherAbility> getByCourseId(int courseId);

    public void add(TeacherAbility teacherAbility);

    public void update(TeacherAbility teacherAbility);

    public void delete(int key);

    public void deleteByTeacherId(int teacherId);

    public void deleteByTeacherAndGrade(@Param("teacherId") int teacherId,@Param("grade") int grade);
}
