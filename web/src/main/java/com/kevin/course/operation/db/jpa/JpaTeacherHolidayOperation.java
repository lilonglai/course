package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.object.mysql.MySqlTeacherHoliday;
import com.kevin.course.object.oracle.OracleTeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class JpaTeacherHolidayOperation extends JpaBasicOperation<TeacherHoliday> implements ITeacherHolidayOperation {
	
	public JpaTeacherHolidayOperation() {
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherHoliday.class);
		}
		else{
			setActualClass(OracleTeacherHoliday.class);
		}
	}

	public List<TeacherHoliday> getByTeacherId(int teacherId) {
        try {
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
           throw new BasicException(e);
        }
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        try{
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId and th.adjustDate=:adjustDate";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.setParameter("adjustDate", Date.valueOf(date));
            return (TeacherHoliday) q.getSingleResult();
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
            String hsql = "delete th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            new BasicException(e);
        }
	}

}
