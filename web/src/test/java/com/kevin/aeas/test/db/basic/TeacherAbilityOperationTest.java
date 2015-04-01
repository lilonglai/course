package com.kevin.aeas.test.db.basic;

import java.util.List;

import com.kevin.aeas.operation.db.basic.JdbcTeacherAbilityOperation;
import junit.framework.TestCase;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.test.db.utils.DbUtils;

public abstract class TeacherAbilityOperationTest extends TestCase {
	public void testGet() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		TeacherAbility teacher = operation.get(1);
	}

	public void testGetAll() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
	}

	public void testGetByTeacherId() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByCourseId(1);
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
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
		JdbcTeacherAbilityOperation operation = new JdbcTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
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
