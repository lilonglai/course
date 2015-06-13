package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Student;
import com.kevin.course.object.mysql.MySqlStudent;
import com.kevin.course.object.oracle.OracleStudent;
import com.kevin.course.operation.db.IStudentOperation;
import com.kevin.course.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class JpaStudentOperation extends JpaBasicOperation<Student> implements IStudentOperation {
	public JpaStudentOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlStudent.class);
		}
		else{
			setActualClass(OracleStudent.class);
		}
	}
	
	public Student getByName(String name) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.name=:name";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("name", name);
            return (Student) q.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	public List<Student> getByGrade(int grade) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.grade=:grade";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Student> getAlive() {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("isAlive", true);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Student> getNotAlive() {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("isAlive", false);
            List<Student> list = q.getResultList();
            return list;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	public List<Student> getByTeacherId(int teacherId) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public void retire(int key) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Student student = (Student) entityManager.find(getActualClass(), key);
            student.setIsAlive(false);
            entityManager.merge(student);
            transaction.commit();
        }catch(Exception e){
            transaction.commit();
            throw new BasicException(e);
        }
	}
}
