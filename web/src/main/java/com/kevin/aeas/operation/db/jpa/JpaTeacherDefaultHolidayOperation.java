package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.mysql.MySqlTeacherDefaultHoliday;
import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;
import com.kevin.aeas.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaTeacherDefaultHolidayOperation extends JpaBasicOperation<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation{
	public JpaTeacherDefaultHolidayOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherDefaultHoliday.class);
		}
		else{
			setActualClass(OracleTeacherDefaultHoliday.class);
		}
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select td from "  + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        return (TeacherDefaultHoliday)q.getSingleResult();
	}
	
	public void deleteByTeacherId(int teacherId){
        EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            Query q = EntityManangerUtil.getInstance().createQuery("select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId");
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        }catch(Exception e){
            transaction.rollback();
        }
	}

	protected  Object changeToJpa(Object t){
		TeacherDefaultHoliday newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlTeacherDefaultHoliday();
		}
		else{
			newObject = new OracleTeacherDefaultHoliday();
		}
		setValueByObject(t, newObject);
		return newObject;
	}
}
