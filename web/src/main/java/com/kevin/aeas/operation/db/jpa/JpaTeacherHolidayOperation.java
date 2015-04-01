package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.object.mysql.MySqlTeacherHoliday;
import com.kevin.aeas.object.oracle.OracleTeacherHoliday;
import com.kevin.aeas.operation.db.ITeacherHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class JpaTeacherHolidayOperation extends JpaBasicOperation<TeacherHoliday> implements ITeacherHolidayOperation{
	
	public JpaTeacherHolidayOperation() {
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherHoliday.class);
		}
		else{
			setActualClass(OracleTeacherHoliday.class);
		}
	}

	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select th from "  + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        List<TeacherHoliday> list = q.getResultList();
		return list;
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
		Query q = EntityManangerUtil.getInstance().createQuery("select th from "  + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId and th.adjustDate=:adjustDate");
		q.setParameter("teacherId", teacherId);
		q.setParameter("adjustDate", Date.valueOf(date));
        List<? extends TeacherHoliday> list = q.getResultList();
		
		return null;

	}

	public void deleteByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select th from "  + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        List<TeacherHoliday> list = q.getResultList();
	}

	protected  Object changeToJpa(Object t){
		TeacherHoliday newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlTeacherHoliday();
		}
		else{
			newObject = new OracleTeacherHoliday();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	
	public static void main(String[] args) {
		
	}

}
