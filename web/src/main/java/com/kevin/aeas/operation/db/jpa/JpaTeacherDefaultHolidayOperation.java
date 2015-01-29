package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;

public class JpaTeacherDefaultHolidayOperation extends JpaBasicOperation{
	public JpaTeacherDefaultHolidayOperation(){
		super(OracleTeacherDefaultHoliday.class);
	}
	
	public Object getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select td from TeacherDefaultHoliday td where td.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}
	
	public void deleteByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select td from TeacherDefaultHoliday td where td.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
	}
	
	public static void main(String[] args) {
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());		
	}
}
