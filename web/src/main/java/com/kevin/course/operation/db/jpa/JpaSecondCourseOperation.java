package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.object.mysql.MySqlFirstCourse;
import com.kevin.course.object.mysql.MySqlSecondCourse;
import com.kevin.course.object.oracle.OracleFirstCourse;
import com.kevin.course.object.oracle.OracleSecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.Query;
import java.util.List;

public class JpaSecondCourseOperation extends JpaBasicOperation<SecondCourse> implements ISecondCourseOperation {
	private Class firstCourseClass;
	
	public JpaSecondCourseOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlSecondCourse.class);
			firstCourseClass = MySqlFirstCourse.class;
		}
		else{
			setActualClass(OracleSecondCourse.class);
			firstCourseClass = OracleFirstCourse.class;
		}
	}
	
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
        try {
            String hsql="select sc from " + getActualClass().getSimpleName() + " sc where sc.firstCourseId=:firstCourseId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("firstCourseId", firstCourseId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<SecondCourse> getByGrade(int grade){
        try {
            String hsql="select sc from " + firstCourseClass.getSimpleName() + " fc, " + getActualClass().getSimpleName() + " sc  where fc.grade=:grade and sc.firstCourseId=fc.id";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
}
