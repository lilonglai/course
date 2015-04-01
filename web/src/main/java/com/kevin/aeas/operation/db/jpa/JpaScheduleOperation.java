package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.mysql.MySqlSchedule;
import com.kevin.aeas.object.oracle.OracleSchedule;
import com.kevin.aeas.operation.db.IScheduleOperation;
import com.kevin.aeas.utils.ConfigurationManager;

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
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime and s.studentId=:studentId");
		q.setParameter("onDate", onDate);
		q.setParameter("onTime", onTime);
		q.setParameter("studentId", studentId);
		return (Schedule)q.getSingleResult();
	}
	
	public List<Schedule> getByStudentId(int studentId){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.studentId=:studentId");
		q.setParameter("studentId", studentId);
        return q.getResultList();
	}
	
	public List<Schedule> getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        return q.getResultList();
	}
	
	
	public List<Schedule> getByDateAndTime(Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.onDate=:onDate and s.onTime=:onTime order by s.onDate,s.onTime");
		q.setParameter("onDate", onDate);
		q.setParameter("onTime", onTime);
        return q.getResultList();
	}
	
	protected  Object changeToJpa(Object t){
		Schedule newObject;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlSchedule();
		}
		else{
			newObject = new OracleSchedule();
		}
		setValueByObject(t, newObject);
		return newObject;
	}

}
