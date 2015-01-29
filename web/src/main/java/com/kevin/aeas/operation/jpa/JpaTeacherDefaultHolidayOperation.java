package com.kevin.aeas.operation.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;

public class JpaTeacherDefaultHolidayOperation extends JpaBasicOperation<OracleTeacherDefaultHoliday>{
	public JpaTeacherDefaultHolidayOperation(){
		super(OracleTeacherDefaultHoliday.class);
	}
	
	public OracleTeacherDefaultHoliday getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select h from AeasTeacherDefaultHoliday h where h.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List<OracleTeacherDefaultHoliday> list = q.getResultList();
		OracleTeacherDefaultHoliday aeasTeacherDefaultHoliday = null;
		if(list.size() > 0)
			aeasTeacherDefaultHoliday = list.get(0);
		return aeasTeacherDefaultHoliday;		
	}
	
	public static void main(String[] args) {
		JpaTeacherDefaultHolidayOperation operation = new JpaTeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());		
	}
}
