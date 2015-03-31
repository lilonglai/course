package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisStudent;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacherAbility;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyBatisTeacherAbilityOperation extends MyBatisBaseOperation<TeacherAbility> {
	public TeacherAbility get(int key) {
		TeacherAbility teacherAbility = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            teacherAbility = myBatisTeacherAbility.get(key);
        }finally {
            session.close();
        }
		return teacherAbility;
	}
	
	public List<TeacherAbility> getAll() {
		List<TeacherAbility> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            list = myBatisTeacherAbility.getAll();
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
		List<TeacherAbility> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            list = myBatisTeacherAbility.getByTeacherId(teacherId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
        List<TeacherAbility> list = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            list = myBatisTeacherAbility.getByCourseId(courseId);
        }finally {
            session.close();
        }
		return list;
	}
	
	public void add(TeacherAbility teacherAbility) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            myBatisTeacherAbility.add(teacherAbility);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
    }

	
	public void update(TeacherAbility teacherAbility){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            myBatisTeacherAbility.update(teacherAbility);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	
	public void delete(int key){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            myBatisTeacherAbility.delete(key);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	public void deleteByTeacherId(int teacherId){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            myBatisTeacherAbility.deleteByTeacherId(teacherId);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(MyBatisTeacherAbility.class);
            myBatisTeacherAbility.deleteByTeacherAndGrade(teacherId, grade);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
		
	}
	
}


