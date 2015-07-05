package com.kevin.course.operation.db.engine;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;
import com.kevin.course.utils.TableName;

import java.util.ArrayList;
import java.util.List;

public class EngineTeacherDao extends EngineBaseDao<Teacher> implements ITeacherOperation {
	protected Teacher generateObject(Entity entity){
		Teacher teacher = new Teacher();
		teacher.setId((int)entity.getKey().getId());
		teacher.setName(getString(entity.getProperty("name")));
		teacher.setShortName(getString(entity.getProperty("shortname")));
		teacher.setPhone(getString(entity.getProperty("phone")));
		teacher.setIsMaster((boolean)entity.getProperty("ismaster"));
		teacher.setIsAlive((boolean)entity.getProperty("isalive"));
		return teacher;
	}
	
	public Teacher getByName(String name){
		List<Teacher> list = new ArrayList<Teacher>();
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
	
	
	public Teacher getByShortName(String shortName){
		List<Teacher> list = new ArrayList<Teacher>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("shortname", Query.FilterOperator.EQUAL, shortName);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list.isEmpty()? null : list.get(0);
	}
	
	public List<Teacher> getAlive(){
		List<Teacher> list = new ArrayList<Teacher>();
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
	
	public List<Teacher> getNotAlive(){
		List<Teacher> list = new ArrayList<Teacher>();
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
	
	public Teacher getByCondition(Teacher condition){
        return null;
	}
	
	public void add(final Teacher teacher){
		Entity entity = new Entity(getTableName());
		entity.setProperty("name", teacher.getName());
		entity.setProperty("shortname", teacher.getShortName());
		entity.setProperty("phone", teacher.getPhone());
		entity.setProperty("ismaster", teacher.getIsMaster());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}
	
	public void update(final Teacher teacher){
		Entity entity = new Entity(getTableName(), teacher.getId());
		entity.setProperty("name", teacher.getName());
		entity.setProperty("shortname", teacher.getShortName());
		entity.setProperty("phone", teacher.getPhone());
		entity.setProperty("ismaster", teacher.getIsMaster());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}
	
	public void retire(int id){
		Entity entity = new Entity(getTableName(), id);
		entity.setProperty("isalive", false);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHER;
	}
	

}
