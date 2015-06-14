package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Schedule;
import com.kevin.course.object.mysql.MySqlSchedule;
import com.kevin.course.operation.db.IScheduleOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository("jpaScheduleDao")
public class JpaScheduleDao extends JpaBasicDao<Schedule> implements IScheduleOperation {
    public JpaScheduleDao() {
        setActualClass(MySqlSchedule.class);
    }

    @Transactional
    public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime and s.studentId=:studentId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("onDate", onDate);
            q.setParameter("onTime", onTime);
            q.setParameter("studentId", studentId);
            return (Schedule) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Schedule> getByStudentId(int studentId) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.studentId=:studentId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("studentId", studentId);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Schedule> getByTeacherId(int teacherId) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Schedule> getByDateAndTime(Date onDate, int onTime) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime order by s.onDate,s.onTime";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("onDate", onDate);
            q.setParameter("onTime", onTime);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

}
