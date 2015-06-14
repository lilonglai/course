package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.object.mysql.MySqlTeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("jpaTeacherAbilityDao")
public class JpaTeacherAbilityDao extends JpaBasicDao<TeacherAbility> implements ITeacherAbilityOperation {
    private Class firstCourseClass;

    public JpaTeacherAbilityDao() {
        setActualClass(MySqlTeacherAbility.class);
        firstCourseClass = MySqlFirstCourse.class;
    }

    @Transactional
    public List<TeacherAbility> getByTeacherId(int teacherId) {
        try {
            String hsql = "select ta from " + getActualClass().getSimpleName() + " ta where ta.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<TeacherAbility> getByCourseId(int courseId) {
        try {
            String hsql = "select ta from " + getActualClass().getSimpleName() + " ta where ta.courseId=:courseId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("courseId", courseId);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public void deleteByTeacherId(int teacherId) {
        try {
            String sql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId";
            Query q = entityManager.createQuery(sql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public void deleteByTeacherAndGrade(int teacherId, int grade) {
        try {
            String hsql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId"
                    + " and ta.courseId in(select fc.id from " + firstCourseClass.getSimpleName() + " fc where fc.grade = :grade)";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.setParameter("grade", grade);
            q.executeUpdate();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }
}


