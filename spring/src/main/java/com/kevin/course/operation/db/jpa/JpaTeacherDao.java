package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Teacher;
import com.kevin.course.object.mysql.MySqlTeacher;
import com.kevin.course.operation.db.ITeacherOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("jpaTeacherDao")
public class JpaTeacherDao extends JpaBasicDao<Teacher> implements ITeacherOperation {
    public JpaTeacherDao() {
        setActualClass(MySqlTeacher.class);
    }

    @Transactional
    public Teacher getByName(String name) {
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.name=:name";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("name", name);
            return (Teacher) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public Teacher getByShortName(String shortName) {
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.shortName=:shortName";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("shortName", shortName);
            return (Teacher) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Teacher> getAlive() {
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("isAlive", true);
            List<Teacher> list = q.getResultList();
            return list;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Teacher> getNotAlive() {
        try {
            String hsql = "select t from " + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("isAlive", false);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public Teacher getByCondition(Teacher condition) {
        return null;
    }

    @Transactional
    public void retire(int key) {
        try {
            Teacher teacher = (Teacher) entityManager.find(getActualClass(), key);
            teacher.setIsAlive(false);
            entityManager.merge(teacher);
        } catch (Exception e) {
            new BasicException(e);
        }
    }
}
