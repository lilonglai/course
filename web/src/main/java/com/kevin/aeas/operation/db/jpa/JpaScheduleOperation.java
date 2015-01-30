package com.kevin.aeas.operation.db.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleSchedule;
import com.kevin.aeas.object.oracle.OracleStudent;
import com.kevin.aeas.object.oracle.OracleTeacher;

public class JpaScheduleOperation extends JpaBasicOperation{
	public JpaScheduleOperation(){
		super(OracleSchedule.class);
	}
	
	public Object getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.onDate=:onDate and s.onTime=:onTime and s.studentId=:studentId");
		q.setParameter("onDate", onDate);
		q.setParameter("ontime", onTime);
		q.setParameter("studentId", studentId);
		List<OracleSchedule> list = q.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;		
	}
	
	public List getByStudentId(int studentId){		
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.studentId=:studentId");
		q.setParameter("studentId", studentId);
		List<OracleSchedule> list = q.getResultList();
		return list;		
	}
	
	public List getByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List<OracleSchedule> list = q.getResultList();
		return list;	
		
	}
	
	
	public List getByDateAndTime(Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.onDate=:onDate and d.onTime=:onTime order by s.onDate,d.onTime");
		q.setParameter("onDate", onDate);
		q.setParameter("ontime", onTime);
		List<OracleSchedule> list = q.getResultList();			
		return list;		
	}
	
	public static void main(String[] args) {
		JpaScheduleOperation operation = new JpaScheduleOperation();
		
	}

}