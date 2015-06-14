package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.object.mysql.MySqlTeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository("jpaTeacherHolidayDao")
public class JpaTeacherHolidayDao extends JpaBasicDao<TeacherHoliday> implements ITeacherHolidayOperation {
	
	public JpaTeacherHolidayDao() {
			setActualClass(MySqlTeacherHoliday.class);
	}

    @Transactional
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
        try {
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
           throw new BasicException(e);
        }
	}

    @Transactional
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
        try{
            String hsql = "select th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId and th.adjustDate=:adjustDate";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.setParameter("adjustDate", Date.valueOf(date));
            return (TeacherHoliday) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

    @Transactional
	public void deleteByTeacherId(int teacherId){
        try {
            String hsql = "delete th from " + getActualClass().getSimpleName() + " th where th.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        }catch(Exception e){
            new BasicException(e);
        }
	}

}
