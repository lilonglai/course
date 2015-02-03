package com.kevin.aeas.test.db.basic;

import java.util.List;

import junit.framework.TestCase;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.basic.DbTeacherAbilityOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

public abstract class TeacherAbilityOperationTest extends TestCase {
	public void testGet() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		TeacherAbility teacher = operation.get(1);
	}

	public void testGetAll() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
	}

	public void testGetByTeacherId() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByCourseId(1);
	}

	public void testAdd() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setTeacherId(25);
		teacherAbility.setCourseId(25);
		operation.add(teacherAbility);
	}

	public void testUpdate() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.delete(teacherAbility.getId());
			}
		}
	}

	public void testDeleteByTeacherId() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		operation.deleteByTeacherId(1);
	}

	public void testDeleteByTeacherAndGrade() {
		DbTeacherAbilityOperation operation = new DbTeacherAbilityOperation();
		operation.deleteByTeacherAndGrade(1, 1);;
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
