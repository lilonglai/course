package com.kevin.course.operation.db.engine;

import com.google.appengine.api.datastore.*;
import com.kevin.course.object.Student;
import com.kevin.course.operation.db.IStudentOperation;
import com.kevin.course.utils.TableName;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EngineStudentDao extends EngineBaseDao<Student> implements IStudentOperation {
	protected Student generateObject(Entity entity){
		Student student = new Student();
		student.setId((int)entity.getKey().getId());
		student.setName(getString(entity.getProperty("name")));
		student.setShortName(getString(entity.getProperty("shortname")));
		student.setGrade(getInt(entity.getProperty("grade")));
		student.setTestScore(getString(entity.getProperty("testscore")));
		student.setTargetScore(getString(entity.getProperty("targetscore")));

		student.setExamineDate(getDate(entity.getProperty("examinedate")));
		student.setExaminePlace(getString(entity.getProperty("examineplace")));
		student.setTeacherId(getInt(entity.getProperty("teacherid")));
		student.setDescription(getString(entity.getProperty("description")));
		student.setIsAlive((boolean)entity.getProperty("isalive"));
		return student;
	}
	
	public Student getByName(String name) {
		List<Student> list = new ArrayList<Student>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("name", Query.FilterOperator.EQUAL, name);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list.isEmpty()? null : list.get(0);
	}
	

	public List<Student> getByGrade(int grade) {
		List<Student> list = new ArrayList<Student>();
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
	
	public List<Student> getAlive() {
		List<Student> list = new ArrayList<Student>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("isalive", Query.FilterOperator.EQUAL, true);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list;
	}
	
	public List<Student> getNotAlive() {
		List<Student> list = new ArrayList<Student>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("isalive", Query.FilterOperator.EQUAL, false);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list;
	}

	public List<Student> getByTeacherId(int teacherId) {
		List<Student> list = new ArrayList<Student>();
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

	public void add(final Student student){
		Entity entity = new Entity(getTableName());
		entity.setProperty("name", student.getName());
		entity.setProperty("shortname", student.getShortName());
		entity.setProperty("grade", student.getGrade());
		entity.setProperty("testscore", student.getTestScore());
		entity.setProperty("targetscore", student.getTargetScore());
		entity.setProperty("examinedate", student.getExamineDate());
		entity.setProperty("examineplace", student.getExaminePlace());
		entity.setProperty("teacherid", student.getTeacherId());
		entity.setProperty("description", student.getDescription());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	public void update(final Student student) {
		Entity entity = new Entity(getTableName(), student.getId());
		entity.setProperty("name", student.getName());
		entity.setProperty("shortname", student.getShortName());
		entity.setProperty("grade", student.getGrade());
		entity.setProperty("testscore", student.getTestScore());
		entity.setProperty("targetscore", student.getTargetScore());
		entity.setProperty("examinedate", student.getExamineDate());
		entity.setProperty("examineplace", student.getExaminePlace());
		entity.setProperty("teacherid", student.getTeacherId());
		entity.setProperty("description", student.getDescription());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}
	
	public void retire(int id) {
		Entity entity = new Entity(getTableName(), id);
		entity.setProperty("isalive", false);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	@Override
	protected String getTableName() {
		return TableName.STUDENT;
	}

}
