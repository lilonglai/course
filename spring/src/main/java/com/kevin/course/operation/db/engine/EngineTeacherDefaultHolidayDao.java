package com.kevin.course.operation.db.engine;

import com.google.appengine.api.datastore.*;

import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.course.utils.TableName;

import java.util.ArrayList;
import java.util.List;

public class EngineTeacherDefaultHolidayDao extends EngineBaseDao<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation {
	
	protected TeacherDefaultHoliday generateObject(Entity entity){
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setId((int)entity.getKey().getId());
		teacherDefaultHoliday.setTeacherId((int)entity.getProperty("teacherid"));
		teacherDefaultHoliday.setWeek1((boolean)entity.getProperty("week1"));
		teacherDefaultHoliday.setWeek2((boolean) entity.getProperty("week2"));
		teacherDefaultHoliday.setWeek3((boolean)entity.getProperty("week3"));
		teacherDefaultHoliday.setWeek4((boolean)entity.getProperty("week4"));
		teacherDefaultHoliday.setWeek5((boolean)entity.getProperty("week5"));
		teacherDefaultHoliday.setWeek6((boolean)entity.getProperty("week6"));
		teacherDefaultHoliday.setWeek7((boolean)entity.getProperty("week7"));
		return teacherDefaultHoliday;
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		List<TeacherDefaultHoliday> list = new ArrayList<TeacherDefaultHoliday>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("teacherid", Query.FilterOperator.EQUAL, teacherId);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list.isEmpty()? null : list.get(0);
	}

	public void add(final TeacherDefaultHoliday teacherDefaultHoliday){
		Entity entity = new Entity(getTableName());
		entity.setProperty("teacherid", teacherDefaultHoliday.getTeacherId());
		entity.setProperty("week1", teacherDefaultHoliday.getWeek1());
		entity.setProperty("week2", teacherDefaultHoliday.getWeek2());
		entity.setProperty("week3", teacherDefaultHoliday.getWeek3());
		entity.setProperty("week4", teacherDefaultHoliday.getWeek4());
		entity.setProperty("week5", teacherDefaultHoliday.getWeek5());
		entity.setProperty("week6", teacherDefaultHoliday.getWeek6());
		entity.setProperty("week7", teacherDefaultHoliday.getWeek7());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}
	
	public void update(final TeacherDefaultHoliday teacherDefaultHoliday){
		Entity entity = new Entity(getTableName(), teacherDefaultHoliday.getId());
		entity.setProperty("teacherid", teacherDefaultHoliday.getTeacherId());
		entity.setProperty("week1", teacherDefaultHoliday.getWeek1());
		entity.setProperty("week2", teacherDefaultHoliday.getWeek2());
		entity.setProperty("week3", teacherDefaultHoliday.getWeek3());
		entity.setProperty("week4", teacherDefaultHoliday.getWeek4());
		entity.setProperty("week5", teacherDefaultHoliday.getWeek5());
		entity.setProperty("week6", teacherDefaultHoliday.getWeek6());
		entity.setProperty("week7", teacherDefaultHoliday.getWeek7());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}
	
	public void deleteByTeacherId(int teacherId){
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("teacherid", Query.FilterOperator.EQUAL, teacherId);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			datastoreService.delete(entity.getKey());
		}
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHERDEFAULTHOLIDAY;
	}
	
}
