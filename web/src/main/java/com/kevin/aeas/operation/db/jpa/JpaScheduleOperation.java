package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.mysql.MySqlSchedule;
import com.kevin.aeas.object.oracle.OracleSchedule;
import com.kevin.aeas.operation.db.IScheduleOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class JpaScheduleOperation extends JpaBasicOperation<Schedule> implements IScheduleOperation{
	public JpaScheduleOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlSchedule.class);
		}
		else{
			setActualClass(OracleSchedule.class);
		}
	}
	
	public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
        try {
            String hsql="select s from " + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime and s.studentId=:studentId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("onDate", onDate);
            q.setParameter("onTime", onTime);
            q.setParameter("studentId", studentId);
            return (Schedule) q.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Schedule> getByStudentId(int studentId){
        try {
            String hsql = "select s from " + getActualClass().getSimpleName() + " s where s.studentId=:studentId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("studentId", studentId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
        try {
            String hsql="select s from " + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("teacherId", teacherId);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
        try {
            String hsql="select s from " + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime order by s.onDate,s.onTime";
            Query q = EntityManangerUtil.getInstance().createQuery(hsql);
            q.setParameter("onDate", onDate);
            q.setParameter("onTime", onTime);
            return q.getResultList();
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

}
