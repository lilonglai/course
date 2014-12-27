package com.kevin.aeas.operation.v2;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasTeacherDefaultHoliday;

public class AeasTeacherDefaultHolidayOperation extends AeasBasicOperation<AeasTeacherDefaultHoliday>{
	public AeasTeacherDefaultHolidayOperation(){
		super(AeasTeacherDefaultHoliday.class);
	}
	
	public AeasTeacherDefaultHoliday getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select h from AeasTeacherDefaultHoliday h where h.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List<AeasTeacherDefaultHoliday> list = q.getResultList();
		AeasTeacherDefaultHoliday aeasTeacherDefaultHoliday = null;
		if(list.size() > 0)
			aeasTeacherDefaultHoliday = list.get(0);
		return aeasTeacherDefaultHoliday;		
	}
	
	public static void main(String[] args) {
		AeasTeacherDefaultHolidayOperation operation = new AeasTeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());		
	}
}
