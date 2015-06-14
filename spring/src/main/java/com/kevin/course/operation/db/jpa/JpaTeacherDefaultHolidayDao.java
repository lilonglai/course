package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.object.mysql.MySqlTeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository("jpaTeacherDefaultHolidayDao")
public class JpaTeacherDefaultHolidayDao extends JpaBasicDao<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation {
    public JpaTeacherDefaultHolidayDao() {
        setActualClass(MySqlTeacherDefaultHoliday.class);
    }

    @Transactional
    public TeacherDefaultHoliday getByTeacherId(int teacherId) {
        try {
            String hsql = "select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return (TeacherDefaultHoliday) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public void deleteByTeacherId(int teacherId) {
        try {
            String hsql = "select td from " + getActualClass().getSimpleName() + " td where td.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

}
