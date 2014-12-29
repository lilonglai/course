package com.kevin.aeas.operation.v2;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasStudent;
import com.kevin.aeas.utils.DatabaseHelp;

public class AeasStudentOperation extends AeasBasicOperation<AeasStudent>{
	public AeasStudentOperation(){
		super(AeasStudent.class);
	}
	
	public AeasStudent getByName(String name) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasStudent s where s.name=:name");
		q.setParameter("name", name);
		List<AeasStudent> list = q.getResultList();
		AeasStudent aeasStudent = null;
		if(list.size() >0)
			aeasStudent = list.get(0);
		return aeasStudent;
	}
	

	public List<AeasStudent> getByGrade(int grade) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasStudent s where s.grade=:grade");
		q.setParameter("grade", grade);
		List<AeasStudent> list = q.getResultList();
		return list;
	}
	
	public List<AeasStudent> getAlive() {		
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasStudent s where s.isAlive=:isAlive");
		q.setParameter("isAlive", true);
		List<AeasStudent> list = q.getResultList();
		return list;
	}
	
	public List<AeasStudent> getNotAlive() {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasStudent s where s.isAlive=:isAlive");
		q.setParameter("isAlive", false);
		List<AeasStudent> list = q.getResultList();
		return list;
	}

	public List<AeasStudent> getByTeacherId(int teacherId) {
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasStudent s where s.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List<AeasStudent> list = q.getResultList();
		return list;

	}
	
	public int retire(int key) {
		String sql = "update aeas_student set isalive = false" + " where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	public static void main(String[] args) {
		AeasStudentOperation studentOperation = new AeasStudentOperation();		
		System.out.println(studentOperation.getAll());
		
	}

}
