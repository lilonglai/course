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
		q.setParameter("ontime", onTime);
		q.setParameter("studentId", studentId);
		List<? extends Schedule> list = q.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;		
	}
	
	public List<? extends Schedule> getByStudentId(int studentId){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.studentId=:studentId");
		q.setParameter("studentId", studentId);
        List<? extends Schedule> list = q.getResultList();
		return list;		
	}
	
	public List<? extends Schedule> getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
        List<? extends Schedule> list = q.getResultList();
		return list;	
		
	}
	
	
	public List<? extends Schedule> getByDateAndTime(Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from "  + getActualClass().getSimpleName() + " s where s.onDate=:onDate and d.onTime=:onTime order by s.onDate,d.onTime");
		q.setParameter("onDate", onDate);
		q.setParameter("ontime", onTime);
        List<? extends Schedule> list = q.getResultList();
		return list;		
	}
	
	protected  Object changeToJpa(Object t){
		Schedule newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlSchedule();
		}
		else{
			newObject = new OracleSchedule();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	public static void main(String[] args) {
		JpaScheduleOperation operation = new JpaScheduleOperation();
		
	}

}
