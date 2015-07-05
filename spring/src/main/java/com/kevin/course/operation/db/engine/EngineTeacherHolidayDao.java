package com.kevin.course.operation.db.engine;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import com.kevin.course.utils.TableName;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EngineTeacherHolidayDao extends EngineBaseDao<TeacherHoliday> implements ITeacherHolidayOperation {
	protected TeacherHoliday generateObject(Entity entity){
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setId((int)entity.getKey().getId());
		teacherHoliday.setTeacherId((int)entity.getProperty("teacherid"));
		teacherHoliday.setAdjustDate(Date.valueOf((String)entity.getProperty("adjustdate")));
		teacherHoliday.setIsHoliday((boolean)entity.getProperty("isholiday"));
		return teacherHoliday;
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		List<TeacherHoliday> list = new ArrayList<TeacherHoliday>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("teacherid", Query.FilterOperator.EQUAL, teacherId);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list;
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String adjustDate) {
        List<TeacherHoliday> list = new ArrayList<TeacherHoliday>();
        Query query = new Query(getTableName());
        Query.Filter filter = Query.CompositeFilterOperator.and(
                new Query.FilterPredicate("teacherId", Query.FilterOperator.EQUAL, teacherId),
                new Query.FilterPredicate("adjustdate", Query.FilterOperator.EQUAL, adjustDate));
        query.setFilter(filter);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            list.add(generateObject(entity));
        }
        return list.isEmpty() ? null : list.get(0);
	}

	public void add(final TeacherHoliday teacherHoliday) {
		Entity entity = new Entity(getTableName());
		entity.setProperty("teacherid", teacherHoliday.getTeacherId());
		entity.setProperty("adjustdate", teacherHoliday.getAdjustDate());
		entity.setProperty("isholiday", teacherHoliday.getIsHoliday());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	public void update(final TeacherHoliday teacherHoliday) {
		Entity entity = new Entity(getTableName(), teacherHoliday.getId());
		entity.setProperty("teacherid", teacherHoliday.getTeacherId());
		entity.setProperty("adjustdate", teacherHoliday.getAdjustDate());
		entity.setProperty("isholiday", teacherHoliday.getIsHoliday());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHERHOLIDAY;
	}

}
