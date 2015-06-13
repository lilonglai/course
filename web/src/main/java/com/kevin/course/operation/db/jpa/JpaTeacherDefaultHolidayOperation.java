package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.object.mysql.MySqlTeacherDefaultHoliday;
import com.kevin.course.object.oracle.OracleTeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JpaTeacherDefaultHolidayOperation extends JpaBasicOperation<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation {
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
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return (TeacherDefaultHoliday) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public void deleteByTeacherId(int teacherId){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            String hsql = "select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }
	}

}
