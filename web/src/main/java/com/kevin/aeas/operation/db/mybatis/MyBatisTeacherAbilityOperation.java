package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacherAbility;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisTeacherAbilityOperation extends MyBatisBaseOperation<MyBatisTeacherAbility> {
    public MyBatisTeacherAbilityOperation(){
        super(MyBatisTeacherAbility.class);
    }

	public TeacherAbility get(int key) {
		TeacherAbility teacherAbility = null;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
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
            MyBatisTeacherAbility myBatisTeacherAbility = session.getMapper(mybatisMapper);
            myBatisTeacherAbility.deleteByTeacherAndGrade(teacherId, grade);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
		
	}
	
}


