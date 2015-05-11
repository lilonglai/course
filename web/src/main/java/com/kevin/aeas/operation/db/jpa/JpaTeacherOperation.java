package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.mysql.MySqlTeacher;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.operation.db.ITeacherOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class JpaTeacherOperation extends JpaBasicOperation<Teacher> implements ITeacherOperation{
	public JpaTeacherOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacher.class);
		}
		else{
			setActualClass(OracleTeacher.class);
		}
	}
	
	public Teacher getByName(String name){
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.name=:name";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("name", name);
            return (Teacher) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	public Teacher getByShortName(String shortName){
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.shortName=:shortName";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("shortName", shortName);
            return (Teacher) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Teacher> getAlive(){
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("isAlive", true);
            List<Teacher> list = q.getResultList();
            return list;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Teacher> getNotAlive(){
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive";
            Query q = getEntityManager().createQuery(hsql);
            q.setParameter("isAlive", false);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
    }
	
	public Teacher getByCondition(Teacher condition){
		return null;
	}

	public void retire(int key){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Teacher teacher = (Teacher) getEntityManager().find(getActualClass(), key);
            teacher.setIsAlive(false);
            getEntityManager().merge(teacher);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            new BasicException(e);
        }
	}
}
