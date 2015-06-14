package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.object.mysql.MySqlSecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("jpaSecondCourseDao")
public class JpaSecondCourseDao extends JpaBasicDao<SecondCourse> implements ISecondCourseOperation {
	private Class firstCourseClass;
	
	public JpaSecondCourseDao(){
			setActualClass(MySqlSecondCourse.class);
			firstCourseClass = MySqlFirstCourse.class;
	}

    @Transactional
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
        try {
            String hsql="select sc from " + getActualClass().getSimpleName() + " sc where sc.firstCourseId=:firstCourseId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("firstCourseId", firstCourseId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

    @Transactional
	public List<SecondCourse> getByGrade(int grade){
        try {
            String hsql="select sc from " + firstCourseClass.getSimpleName() + " fc, " + getActualClass().getSimpleName() + " sc  where fc.grade=:grade and sc.firstCourseId=fc.id";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
}
