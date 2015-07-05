package com.kevin.course.operation.db.engine;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;
import com.kevin.course.utils.TableName;

import java.util.ArrayList;
import java.util.List;

public class EngineFirstCourseDao extends EngineBaseDao<FirstCourse> implements IFirstCourseOperation {
	protected FirstCourse generateObject(Entity entity){
		FirstCourse firstCourse = new FirstCourse();
		firstCourse.setId((int)entity.getKey().getId());
		firstCourse.setGrade(getInt(entity.getProperty("grade")));
		firstCourse.setName(getString(entity.getProperty("name")));
		firstCourse.setShortName(getString(entity.getProperty("shortname")));
		firstCourse.setDescription(getString(entity.getProperty("description")));
		return firstCourse;
	}

	public List<FirstCourse> getByGrade(int grade) {
		List<FirstCourse> list = new ArrayList<FirstCourse>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("grade", Query.FilterOperator.EQUAL, grade);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list;
	}

	public void add(final FirstCourse firstCourse) {
		Entity entity = new Entity(getTableName());
		entity.setProperty("grade", firstCourse.getGrade());
		entity.setProperty("name", firstCourse.getName());
		entity.setProperty("shortname", firstCourse.getShortName());
		entity.setProperty("description", firstCourse.getDescription());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	public void update(final FirstCourse firstCourse) {
		Entity entity = new Entity(getTableName(), firstCourse.getId());
		entity.setProperty("grade", firstCourse.getGrade());
		entity.setProperty("name", firstCourse.getName());
		entity.setProperty("shortname", firstCourse.getShortName());
		entity.setProperty("description", firstCourse.getDescription());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);

	}

	@Override
	protected String getTableName() {
		return TableName.FIRSTCOURSE;
	}

}
