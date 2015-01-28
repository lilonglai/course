package com.kevin.aeas.operation.v2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleSchedule;
import com.kevin.aeas.object.oracle.OracleStudent;
import com.kevin.aeas.object.oracle.OracleTeacher;

public class AeasScheduleOperation extends AeasBasicOperation<OracleSchedule>{
	public AeasScheduleOperation(){
		super(OracleSchedule.class);
	}
	
	public OracleSchedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		OracleStudent aeasStudent = EntityManangerUtil.getInstance().find(OracleStudent.class, studentId);
		for(OracleSchedule aeasSchedule: aeasStudent.getAeasSchedules()){
			if(aeasSchedule.getOnDate().equals(onDate) && (aeasSchedule.getOnTime() == onTime))
				return aeasSchedule;
		}
		return null;		
	}
	
	public List<OracleSchedule> getByStudentId(int studentId){		
		OracleStudent aeasStudent = EntityManangerUtil.getInstance().find(OracleStudent.class, studentId);
		List<OracleSchedule> list = null;
		if(aeasStudent.getAeasSchedules() instanceof List){
			list = (List<OracleSchedule>)aeasStudent.getAeasSchedules();
		}
		else{
			list = new ArrayList<OracleSchedule>();
			list.addAll(aeasStudent.getAeasSchedules());
		}
		return list;		
	}
	
	public List<OracleSchedule> getByTeacherId(int teacherId){
		OracleTeacher aeasTeacher = EntityManangerUtil.getInstance().find(OracleTeacher.class, teacherId);
		List<OracleSchedule> list;
		if(aeasTeacher.getAeasSchedules() instanceof List){
			list = (List<OracleSchedule>)aeasTeacher.getAeasSchedules();
		}
		else{
			list = new ArrayList<OracleSchedule>();
			list.addAll(aeasTeacher.getAeasSchedules());
		}
		return list;
		
	}
	
	
	public List<OracleSchedule> getByDateAndTime(Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.onDate=:onDate and d.onTime=:onTime order by s.onDate,d.onTime");
		q.setParameter("onDate", onDate);
		q.setParameter("ontime", onTime);
		List<OracleSchedule> list = q.getResultList();			
		return list;		
	}
	
	public static void main(String[] args) {
		AeasScheduleOperation operation = new AeasScheduleOperation();
		
	}

}
