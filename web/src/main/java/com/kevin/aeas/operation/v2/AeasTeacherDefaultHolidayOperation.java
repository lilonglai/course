package com.kevin.aeas.operation.v2;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;

public class AeasTeacherDefaultHolidayOperation extends AeasBasicOperation<OracleTeacherDefaultHoliday>{
	public AeasTeacherDefaultHolidayOperation(){
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
		AeasTeacherDefaultHolidayOperation operation = new AeasTeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());		
	}
}
