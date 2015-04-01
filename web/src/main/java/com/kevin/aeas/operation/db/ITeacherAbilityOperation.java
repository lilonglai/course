package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.TeacherAbility;

import java.util.List;

/**
 * Created by loli on 2015/3/30.
 */
public interface ITeacherAbilityOperation {
    public TeacherAbility get(int key);

    public List<? extends TeacherAbility> getAll();

    public List<? extends TeacherAbility> getByTeacherId(int teacherId);

    public List<? extends TeacherAbility> getByCourseId(int courseId);

    public void add(TeacherAbility teacherAbility);

    public void update(TeacherAbility teacherAbility);

    public void delete(int key);

    public void deleteByTeacherId(int teacherId);

    public void deleteByTeacherAndGrade(int teacherId, int grade);
}
