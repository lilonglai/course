package com.kevin.aeas.test.db.mybatis;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.basic.DbTeacherAbilityOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherAbilityOperation;
import com.kevin.aeas.test.db.utils.DbUtils;
import junit.framework.TestCase;

import java.util.List;

public class TeacherAbilityOperationTest extends TestCase {
	public void testGet() {
		MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		TeacherAbility teacher = operation.get(1);
	}

	public void testGetAll() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
	}

	public void testGetByTeacherId() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		List<TeacherAbility> list = operation.getByCourseId(1);
	}

	public void testAdd() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setTeacherId(25);
		teacherAbility.setCourseId(25);
		operation.add(teacherAbility);
	}

	public void testUpdate() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.delete(teacherAbility.getId());
			}
		}
	}

	public void testDeleteByTeacherId() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		operation.deleteByTeacherId(1);
	}

	public void testDeleteByTeacherAndGrade() {
        MyBatisTeacherAbilityOperation operation = new MyBatisTeacherAbilityOperation();
		operation.deleteByTeacherAndGrade(1, 1);;
	}

}
