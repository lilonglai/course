package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.mysql.MySqlStudent;
import com.kevin.aeas.object.oracle.OracleStudent;
import com.kevin.aeas.operation.db.IStudentOperation;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DatabaseHelp;

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
		List<? extends Student> list = q.getResultList();
		Student aeasStudent = null;
		if(list.size() >0)
			aeasStudent = list.get(0);
		return aeasStudent;
	}
	

	public List<Student> getByGrade(int grade) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.grade=:grade");
		q.setParameter("grade", grade);
        List<Student> list = q.getResultList();
		return list;
	}
	
	public List<Student> getAlive() {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive");
		q.setParameter("isAlive", true);
        List<Student> list = q.getResultList();
		return list;
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
        List<Student> list = q.getResultList();
		return list;

	}
	
	public void retire(int key) {
		String sql = "update aeas_student set isalive = false" + " where id = " + key;
		try {
			DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected  Object changeToJpa(Object t){
		Student newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlStudent();
		}
		else{
			newObject = new OracleStudent();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	
	public static void main(String[] args) {
		JpaStudentOperation studentOperation = new JpaStudentOperation();		
		System.out.println(studentOperation.getAll());
		
	}

}
