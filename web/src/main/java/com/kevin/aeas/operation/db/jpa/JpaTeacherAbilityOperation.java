package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.mysql.MySqlTeacherAbility;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleTeacherAbility;
import com.kevin.aeas.operation.db.ITeacherAbilityOperation;
import com.kevin.aeas.utils.ConfigurationManager;

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
        List<TeacherAbility> list = q.getResultList();
		return list;
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select ta from "  + getActualClass().getSimpleName() + " ta where ta.courseId=:courseId");
		q.setParameter("courseId", courseId);
        List< TeacherAbility> list = q.getResultList();
		return list;
	}
	
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from "  + getActualClass().getSimpleName() + " ta where ta.teacherId = " + teacherId;
		EntityManangerUtil.getInstance().createQuery(sql);
	}
		
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete from " + getActualClass().getSimpleName() + " ta where ta.teacherId = " + teacherId
				+ " and ta.courseId in(select fc.id from "  + firstCourseClass.getSimpleName() + " fc where fc.grade = " + grade + ")";
		EntityManangerUtil.getInstance().createQuery(sql);
		
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


