package com.kevin.aeas.operation.v2;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.object.oracle.OracleTeacherAbility;
import com.kevin.aeas.object.oracle.OracleTeacherHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class AeasTeacherHolidayOperation {
	
	public OracleTeacherHoliday get(int key) {		
		OracleTeacherHoliday aeasTeacherHoliday = EntityManangerUtil.getInstance().find(OracleTeacherHoliday.class,key);
		return aeasTeacherHoliday;
	}

	public List<OracleTeacherHoliday> getByTeacherId(int teacherId) {		
		OracleTeacher aeasTeacher = EntityManangerUtil.getInstance().find(OracleTeacher.class,teacherId);
		List<OracleTeacherHoliday> list;
		if(aeasTeacher.getAeasTeacherAbilities() instanceof List){
			list = (List<OracleTeacherHoliday>)aeasTeacher.getAeasTeacherHolidays();
		}
		else{
			list = new ArrayList<OracleTeacherHoliday>();
			list.addAll(aeasTeacher.getAeasTeacherHolidays());
		}
		return list;

	}
	
	public OracleTeacherHoliday getByTeacherAndDate(int teacherId,String date) {		
		OracleTeacher aeasTeacher = EntityManangerUtil.getInstance().find(OracleTeacher.class,teacherId);
		for(OracleTeacherHoliday aeasTeacherHoliday: aeasTeacher.getAeasTeacherHolidays())
			if(aeasTeacherHoliday.getAdjustDate().equals(date)){
				return aeasTeacherHoliday;
			}
		return null;

	}

	public List<OracleTeacherHoliday> getAll() {
		Query q = EntityManangerUtil.getInstance().createQuery("select h from AeasTeacherHoliday h");
		List<OracleTeacherHoliday> list = q.getResultList();				
		return list;

	}

	public void add(OracleTeacherHoliday aeasTeacherHoliday) {
		EntityManangerUtil.getInstance().persist(aeasTeacherHoliday);

	}

	public void update(OracleTeacherHoliday aeasTeacherHoliday) {
		EntityManangerUtil.getInstance().merge(aeasTeacherHoliday);
	}

	public void delete(int key) {
		OracleTeacherHoliday aeasTeacherHoliday = EntityManangerUtil.getInstance().find(OracleTeacherHoliday.class,key);
		EntityManangerUtil.getInstance().remove(aeasTeacherHoliday);
	}

	public static void main(String[] args) {
		
	}

}
