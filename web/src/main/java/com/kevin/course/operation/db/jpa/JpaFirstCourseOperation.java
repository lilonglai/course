package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.FirstCourse;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.object.oracle.OracleFirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.Query;
import java.util.List;


public class JpaFirstCourseOperation extends JpaBasicOperation<FirstCourse> implements IFirstCourseOperation {
	public JpaFirstCourseOperation(){		
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlFirstCourse.class);
		}
		else{
			setActualClass(OracleFirstCourse.class);
		}
	}
	
	public List<FirstCourse> getByGrade(int grade){
        try {
            String hsql = "select c from " + getActualClass().getSimpleName() + " c where c.grade=:grade";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
}
