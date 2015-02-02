package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.jpa.JpaTeacherHoliday;
import com.kevin.aeas.object.mysql.MySqlTeacherHoliday;
import com.kevin.aeas.object.oracle.OracleTeacherHoliday;
import com.kevin.aeas.utils.ConfigurationManager;

public class JpaTeacherHolidayOperation extends JpaBasicOperation{
	
	public JpaTeacherHolidayOperation() {
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherHoliday.class);
		}
		else{
			setActualClass(OracleTeacherHoliday.class);
		}
	}

	public List getByTeacherId(int teacherId) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		return list;
	}
	
	public Object getByTeacherAndDate(int teacherId,String date) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId and th.adjustDate=:adjustDate");
		q.setParameter("teacherId", teacherId);
		q.setParameter("adjustDate", date);
		List list = q.getResultList();
		return null;

	}

	public void deleteByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		
	}

	protected  Object changeToJpa(Object t){
		JpaTeacherHoliday newObject = null;
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
