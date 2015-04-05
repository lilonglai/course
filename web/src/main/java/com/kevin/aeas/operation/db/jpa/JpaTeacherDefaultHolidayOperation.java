package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.object.mysql.MySqlTeacherDefaultHoliday;
import com.kevin.aeas.object.oracle.OracleTeacherDefaultHoliday;
import com.kevin.aeas.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
        try {
            String hsql = "select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return (TeacherDefaultHoliday) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public void deleteByTeacherId(int teacherId){
        EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            String hsql = "select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }
	}

}
