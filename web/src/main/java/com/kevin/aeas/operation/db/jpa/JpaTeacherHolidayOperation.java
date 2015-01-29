package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.TeacherHoliday;

public class JpaTeacherHolidayOperation extends JpaBasicOperation{
	
	public JpaTeacherHolidayOperation() {
		super(TeacherHoliday.class);
	}

	public List getByTeacherId(int teacherId) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		return list;
	}
	
	public Object getByTeacherAndDate(int teacherId,String date) {		
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId and th.adjustDate=:adjustDate");
		q.setParameter("teacherId", teacherId);
		q.setParameter("adjustDate", date);
		List list = q.getResultList();
		return null;

	}

	public void deleteByTeacherId(int teacherId){
		Query q = EntityManangerUtil.getInstance().createQuery("select th from TeacherHoliday th where th.teacherId=:teacherId");
		q.setParameter("teacherId", teacherId);
		List list = q.getResultList();
		
	}


	public static void main(String[] args) {
		
	}

}
