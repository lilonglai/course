package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.object.mysql.MySqlTeacherHoliday;
import com.kevin.aeas.object.oracle.OracleTeacherHoliday;
import com.kevin.aeas.operation.db.ITeacherHolidayOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.NoResultException;
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
        try {
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
           throw new BasicException(e);
        }
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        try{
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId and th.adjustDate=:adjustDate";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
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
        try {
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        }catch(Exception e){
            new BasicException(e);
        }
	}

}
