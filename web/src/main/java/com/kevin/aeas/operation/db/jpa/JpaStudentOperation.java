package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.mysql.MySqlStudent;
import com.kevin.aeas.object.oracle.OracleStudent;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.operation.db.IStudentOperation;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DatabaseHelp;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class JpaStudentOperation extends JpaBasicOperation<Student> implements IStudentOperation{
	public JpaStudentOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlStudent.class);
		}
		else{
			setActualClass(OracleStudent.class);
		}
	}
	
	public Student getByName(String name) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.name=:name");
		q.setParameter("name", name);
        try {
            return (Student) q.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
	}

	public List<Student> getByGrade(int grade) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.grade=:grade");
		q.setParameter("grade", grade);
        return q.getResultList();
	}
	
	public List<Student> getAlive() {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive");
		q.setParameter("isAlive", true);
        return q.getResultList();
	}
	
	public List<Student> getNotAlive() {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive");
		q.setParameter("isAlive", false);
        List<Student> list = q.getResultList();
		return list;
	}

	public List<Student> getByTeacherId(int teacherId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        return q.getResultList();
	}
	
	public void retire(int key) {
        Student student = (Student) EntityManangerUtil.getInstance().find(getActualClass(), key);
        student.setIsAlive(false);
        EntityManangerUtil.getInstance().merge(student);
	}

	protected  Object changeToJpa(Object t){
		Student newObject;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlStudent();
		}
		else{
			newObject = new OracleStudent();
		}
		setValueByObject(t, newObject);
		return newObject;
	}
}
