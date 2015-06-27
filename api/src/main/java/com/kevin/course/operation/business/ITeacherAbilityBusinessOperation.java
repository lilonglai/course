package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherAbility;

import java.util.List;

public interface ITeacherAbilityBusinessOperation {

    public void add(TeacherAbility teacherAbility);

    public void update(TeacherAbility teacherAbility);

    public TeacherAbility get(int id);

    public void delete(int id);

    public List<TeacherAbility> getAll();

    public List<TeacherAbility> getByTeacherId(int teacherId);

    public List<TeacherAbility> getByCourseId(int courseId);

    public void deleteByTeacherId(int teacherId);

    public void deleteByTeacherAndGrade(int teacherId, int grade);

}
