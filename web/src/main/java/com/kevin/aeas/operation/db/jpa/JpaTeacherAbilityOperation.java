package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.mysql.MySqlTeacherAbility;
import com.kevin.aeas.object.oracle.OracleTeacherAbility;
import com.kevin.aeas.utils.ConfigurationManager;

public class JpaTeacherAbilityOperation extends JpaBasicOperation{
	public JpaTeacherAbilityOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacherAbility.class);
		}
		else{
			setActualClass(OracleTeacherAbility.class);
		}
	}
	
	public List getByTeacherId(int teacherId) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select ta from TeacherAbility ta where ta.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		return list;
	}
	
	public List getByCourseId(int courseId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select ta from TeacherAbility ta where ta.courseId=:courseId");
		q.setParameter("courseId", courseId);
		List list = q.getResultList();
		return list;
	}
	
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from TeacherAbility ta where ta.teacherid = " + teacherId;
		EntityManangerUtil.getInstance().createQuery(sql);
	}
		
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete from TeacherAbility ta where ta.teacherid = " + teacherId
				+ " and ta.courseId in(select c.id from FirstCourse fc where fc.grade = " + grade + ")";
		EntityManangerUtil.getInstance().createQuery(sql);
		
	}
		
	public static void main(String[] args) {
		
		
		
		
	}
}


