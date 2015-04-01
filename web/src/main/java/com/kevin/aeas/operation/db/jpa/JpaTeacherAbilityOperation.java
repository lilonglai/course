package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.mysql.MySqlTeacherAbility;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleTeacherAbility;
import com.kevin.aeas.operation.db.ITeacherAbilityOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaTeacherAbilityOperation extends JpaBasicOperation<TeacherAbility> implements ITeacherAbilityOperation{
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
		Query q = EntityManangerUtil.getInstance().createQuery("select ta from "  + getActualClass().getSimpleName() + " ta where ta.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        return q.getResultList();
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select ta from "  + getActualClass().getSimpleName() + " ta where ta.courseId=:courseId");
		q.setParameter("courseId", courseId);
        return q.getResultList();
	}
	
	
	public void deleteByTeacherId(int teacherId){
        EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            String sql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(sql);
            q.setParameter("teacherId", teacherId);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
	}
		
	public void deleteByTeacherAndGrade(int teacherId,int grade){
        EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            String sql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = :teacherId"
                    + " and ta.courseId in(select fc.id from " + firstCourseClass.getSimpleName() + " fc where fc.grade = :grade)";
            Query q = EntityManangerUtil.getInstance().createQuery(sql);
            q.setParameter("teacherId", teacherId);
            q.setParameter("grade", grade);
            q.executeUpdate();
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
	
	protected  Object changeToJpa(Object t){
		TeacherAbility newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlTeacherAbility();
		}
		else{
			newObject = new OracleTeacherAbility();
		}
		setValueByObject(t, newObject);
		return newObject;
	}
	
}


