package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.object.mysql.MySqlTeacherAbility;
import com.kevin.course.object.oracle.OracleFirstCourse;
import com.kevin.course.object.oracle.OracleTeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaTeacherAbilityOperation extends JpaBasicOperation<TeacherAbility> implements ITeacherAbilityOperation {
	private Class firstCourseClass;
	public JpaTeacherAbilityOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherAbility.class);
			firstCourseClass = MySqlFirstCourse.class;
		}
		else{
			setActualClass(OracleTeacherAbility.class);
			firstCourseClass = OracleFirstCourse.class;
		}
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
        try {
            String hsql = "select ta from " + getActualClass().getSimpleName() + " ta where ta.teacherId=:teacherId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
        try {
            String hsql = "select ta from " + getActualClass().getSimpleName() + " ta where ta.courseId=:courseId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("courseId", courseId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	
	public void deleteByTeacherId(int teacherId){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            String sql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId";
            Query q = entityManager.createQuery(sql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }
	}
		
	public void deleteByTeacherAndGrade(int teacherId,int grade){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            String hsql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId"
                    + " and ta.courseId in(select fc.id from " + firstCourseClass.getSimpleName() + " fc where fc.grade = :grade)";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            q.setParameter("grade", grade);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
            throw new BasicException(e);
        }
    }
}


