package com.kevin.aeas.operation.v2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasSchedule;
import com.kevin.aeas.object.v2.AeasStudent;
import com.kevin.aeas.object.v2.AeasTeacher;

public class AeasScheduleOperation extends AeasBasicOperation<AeasSchedule>{
	public AeasScheduleOperation(){
		super(AeasSchedule.class);
	}
	
	public AeasSchedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime){
		AeasStudent aeasStudent = EntityManangerUtil.getInstance().find(AeasStudent.class, studentId);
		for(AeasSchedule aeasSchedule: aeasStudent.getAeasSchedules()){
			if(aeasSchedule.getOnDate().equals(onDate) && (aeasSchedule.getOnTime() == onTime))
				return aeasSchedule;
		}
		return null;		
	}
	
	public List<AeasSchedule> getByStudentId(int studentId){		
		AeasStudent aeasStudent = EntityManangerUtil.getInstance().find(AeasStudent.class, studentId);
		List<AeasSchedule> list = null;
		if(aeasStudent.getAeasSchedules() instanceof List){
			list = (List<AeasSchedule>)aeasStudent.getAeasSchedules();
		}
		else{
			list = new ArrayList<AeasSchedule>();
			list.addAll(aeasStudent.getAeasSchedules());
		}
		return list;		
	}
	
	public List<AeasSchedule> getByTeacherId(int teacherId){
		AeasTeacher aeasTeacher = EntityManangerUtil.getInstance().find(AeasTeacher.class, teacherId);
		List<AeasSchedule> list;
		if(aeasTeacher.getAeasSchedules() instanceof List){
			list = (List<AeasSchedule>)aeasTeacher.getAeasSchedules();
		}
		else{
			list = new ArrayList<AeasSchedule>();
			list.addAll(aeasTeacher.getAeasSchedules());
		}
		return list;
		
	}
	
	
	public List<AeasSchedule> getByDateAndTime(Date onDate, int onTime){
		Query q = EntityManangerUtil.getInstance().createQuery("select s from AeasSchedule s where s.onDate=:onDate and d.onTime=:onTime order by s.onDate,d.onTime");
		q.setParameter("onDate", onDate);
		q.setParameter("ontime", onTime);
		List<AeasSchedule> list = q.getResultList();			
		return list;		
	}
	
	public static void main(String[] args) {
		AeasScheduleOperation operation = new AeasScheduleOperation();
		
	}

}
