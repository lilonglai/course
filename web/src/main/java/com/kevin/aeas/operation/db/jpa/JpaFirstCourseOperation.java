package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.operation.db.IFirstCourseOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.Query;
import java.util.List;


public class JpaFirstCourseOperation extends JpaBasicOperation<FirstCourse> implements IFirstCourseOperation{
	public JpaFirstCourseOperation(){		
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlFirstCourse.class);
		}
		else{
			setActualClass(OracleFirstCourse.class);
		}
	}
	
	public List<? extends FirstCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select c from " + getActualClass().getSimpleName() + " c where c.grade=:grade");
		q.setParameter("grade", grade);
        List<? extends FirstCourse> list = q.getResultList();
		return list;
	}		
	
	protected  Object changeToJpa(Object t){
		FirstCourse newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlFirstCourse();
		}
		else{
			newObject = new OracleFirstCourse();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	public static void main(String[] args) {
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
