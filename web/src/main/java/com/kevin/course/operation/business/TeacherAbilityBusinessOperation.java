package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.OperationManager;
import com.kevin.course.operation.db.TeacherAbilityOperation;

import javax.ws.rs.QueryParam;
import java.util.List;

public class TeacherAbilityBusinessOperation implements ITeacherAbilityBusinessOperation {
    TeacherAbilityOperation teacherAbilityOperation = OperationManager.getInstance().getTeacherAbilityOperation();

    public void add(TeacherAbility teacherAbility) {
        teacherAbilityOperation.add(teacherAbility);
    }

    public void update(TeacherAbility teacherAbility) {
        teacherAbilityOperation.update(teacherAbility);
    }

    public TeacherAbility get(@QueryParam("id") int id) {
        return teacherAbilityOperation.get(id);
    }

    public void delete(@QueryParam("id") int id) {
        teacherAbilityOperation.delete(id);
    }

    public List<TeacherAbility> getAll() {
        return teacherAbilityOperation.getAll();
    }

    public void deleteByTeacherId(int teacherId) {
        teacherAbilityOperation.deleteByTeacherId(teacherId);
    }

    public void deleteByTeacherAndGrade(int teacherId, int grade) {
        teacherAbilityOperation.deleteByTeacherAndGrade(teacherId, grade);
    }

    public List<TeacherAbility> getByTeacherId(int teacherId) {
        return teacherAbilityOperation.getByTeacherId(teacherId);
    }

    public List<TeacherAbility> getByCourseId(int courseId) {
        return teacherAbilityOperation.getByCourseId(courseId);
    }


}
