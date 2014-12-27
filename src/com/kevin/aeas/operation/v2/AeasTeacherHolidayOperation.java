package com.kevin.aeas.operation.v2;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.object.v2.AeasFirstCourse;
import com.kevin.aeas.object.v2.AeasTeacher;
import com.kevin.aeas.object.v2.AeasTeacherAbility;
import com.kevin.aeas.object.v2.AeasTeacherHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class AeasTeacherHolidayOperation {
	
	public AeasTeacherHoliday get(int key) {		
		AeasTeacherHoliday aeasTeacherHoliday = EntityManangerUtil.getInstance().find(AeasTeacherHoliday.class,key);
		return aeasTeacherHoliday;
	}

	public List<AeasTeacherHoliday> getByTeacherId(int teacherId) {		
		AeasTeacher aeasTeacher = EntityManangerUtil.getInstance().find(AeasTeacher.class,teacherId);
		List<AeasTeacherHoliday> list;
		if(aeasTeacher.getAeasTeacherAbilities() instanceof List){
			list = (List<AeasTeacherHoliday>)aeasTeacher.getAeasTeacherHolidays();
		}
		else{
			list = new ArrayList<AeasTeacherHoliday>();
			list.addAll(aeasTeacher.getAeasTeacherHolidays());
		}
		return list;

	}
	
	public AeasTeacherHoliday getByTeacherAndDate(int teacherId,String date) {		
		AeasTeacher aeasTeacher = EntityManangerUtil.getInstance().find(AeasTeacher.class,teacherId);
		for(AeasTeacherHoliday aeasTeacherHoliday: aeasTeacher.getAeasTeacherHolidays())
			if(aeasTeacherHoliday.getAdjustDate().equals(date)){
				return aeasTeacherHoliday;
			}
		return null;

	}

	public List<AeasTeacherHoliday> getAll() {
		Query q = EntityManangerUtil.getInstance().createQuery("select h from AeasTeacherHoliday h");
		List<AeasTeacherHoliday> list = q.getResultList();				
		return list;

	}

	public void add(AeasTeacherHoliday aeasTeacherHoliday) {
		EntityManangerUtil.getInstance().persist(aeasTeacherHoliday);

	}

	public void update(AeasTeacherHoliday aeasTeacherHoliday) {
		EntityManangerUtil.getInstance().merge(aeasTeacherHoliday);
	}

	public void delete(int key) {
		AeasTeacherHoliday aeasTeacherHoliday = EntityManangerUtil.getInstance().find(AeasTeacherHoliday.class,key);
		EntityManangerUtil.getInstance().remove(aeasTeacherHoliday);
	}

	public static void main(String[] args) {
		
	}

}
