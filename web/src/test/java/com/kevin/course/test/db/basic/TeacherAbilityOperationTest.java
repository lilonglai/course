package com.kevin.course.test.db.basic;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.basic.JdbcTeacherAbilityOperation;
import com.kevin.course.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.util.List;

public abstract class TeacherAbilityOperationTest extends TestCase {
	public void testGet() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		TeacherAbility teacher = operation.get(1);
	}

	public void testGetAll() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<? extends TeacherAbility> list=operation.getAll();
	}

	public void testGetByTeacherId() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<? extends TeacherAbility> list = operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<? extends TeacherAbility> list = operation.getByCourseId(1);
	}

	public void testAdd() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setTeacherId(25);
		teacherAbility.setCourseId(25);
		operation.add(teacherAbility);
	}

	public void testUpdate() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<? extends TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<? extends TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.delete(teacherAbility.getId());
			}
		}
	}

	public void testDeleteByTeacherId() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		operation.deleteByTeacherId(1);
	}

	public void testDeleteByTeacherAndGrade() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		operation.deleteByTeacherAndGrade(1, 1);;
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
