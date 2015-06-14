package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Student;
import com.kevin.course.object.mysql.MySqlStudent;
import com.kevin.course.operation.db.IStudentOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("jpaStudentDao")
public class JpaStudentDao extends JpaBasicDao<Student> implements IStudentOperation {
    public JpaStudentDao() {
        setActualClass(MySqlStudent.class);
    }

    @Transactional
    public Student getByName(String name) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.name=:name";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("name", name);
            return (Student) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Student> getByGrade(int grade) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.grade=:grade";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("grade", grade);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Student> getAlive() {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("isAlive", true);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Student> getNotAlive() {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.isAlive=:isAlive";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("isAlive", false);
            List<Student> list = q.getResultList();
            return list;
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public List<Student> getByTeacherId(int teacherId) {
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId";
            Query q = entityManager.createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }

    @Transactional
    public void retire(int key) {
        try {
            Student student = (Student) entityManager.find(getActualClass(), key);
            student.setIsAlive(false);
            entityManager.merge(student);
        } catch (Exception e) {
            throw new BasicException(e);
        }
    }
}
