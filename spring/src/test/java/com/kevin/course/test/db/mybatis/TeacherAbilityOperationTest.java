package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class TeacherAbilityOperationTest extends TestCase {
	ITeacherAbilityOperation operation;
	public TeacherAbilityOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
		operation = (ITeacherAbilityOperation)context.getBean("myBatisTeacherAbilityDao");
	}
	public void testGet() {
		TeacherAbility teacher = operation.get(1);
	}

	public void testGetAll() {
		List<? extends TeacherAbility> list=operation.getAll();
	}

	public void testGetByTeacherId() {
		List<? extends TeacherAbility> list = operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
		List<? extends TeacherAbility> list = operation.getByCourseId(1);
	}

	public void testAdd() {
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setTeacherId(25);
		teacherAbility.setCourseId(25);
		operation.add(teacherAbility);
	}

	public void testUpdate() {
		List<? extends TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.delete(teacherAbility.getId());
			}
		}
	}

	public void testDeleteByTeacherId() {
		operation.deleteByTeacherId(1);
	}

	public void testDeleteByTeacherAndGrade() {
		operation.deleteByTeacherAndGrade(1, 1);;
	}

}
