package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("jpaFirstCourseDao")
public class JpaFirstCourseDao extends JpaBasicDao<FirstCourse> implements IFirstCourseOperation {
    public JpaFirstCourseDao() {
        setActualClass(MySqlFirstCourse.class);
    }

    @Transactional
    public List<FirstCourse> getByGrade(int grade) {
        try {
            String hsql = "select c from " + getActualClass().getSimpleName() + " c where c.grade=:grade";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }
}
