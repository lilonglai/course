package com.kevin.course.operation.db.engine;

import com.google.appengine.api.datastore.*;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import com.kevin.course.utils.TableName;

import java.util.ArrayList;
import java.util.List;

public class EngineTeacherAbilityDao extends EngineBaseDao<TeacherAbility> implements ITeacherAbilityOperation {
	protected TeacherAbility generateObject(Entity entity){
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setId((int)entity.getKey().getId());
		teacherAbility.setTeacherId((int)entity.getProperty("teacherid"));
		teacherAbility.setCourseId((int)entity.getProperty("courseid"));
		return teacherAbility;
	}

    /*
	public List<TeacherAbility> getAll() {
		String sqlFormat = "select %1$s.*" +
                " from %1$s,%2$s"
				+ " where %2$s.id=%1$s.courseid"
				+ " order by %2$s.grade";
		String sql = String.format(sqlFormat, TableName.TEACHERABILITY, TableName.FIRSTCOURSE);
		return query(sql, this);
	}

	*/
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
        List<TeacherAbility> list = new ArrayList<TeacherAbility>();
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
	
	public List<TeacherAbility> getByCourseId(int courseId) {
        List<TeacherAbility> list = new ArrayList<TeacherAbility>();
        Query query = new Query(getTableName());
        Query.FilterPredicate filter = new Query.FilterPredicate("courseid", Query.FilterOperator.EQUAL, courseId);
        query.setFilter(filter);
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for(Entity entity: p.asIterable()){
            list.add(generateObject(entity));
        }
        return list;
	}
	
	public void add(final TeacherAbility teacherAbility){
		Entity entity = new Entity(getTableName());
		entity.setProperty("teacherid", teacherAbility.getTeacherId());
		entity.setProperty("courseid", teacherAbility.getCourseId());
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
	}

	public void update(final TeacherAbility teacherAbility){
		Entity entity = new Entity(getTableName(), teacherAbility.getId());
		entity.setProperty("teacherid", teacherAbility.getTeacherId());
		entity.setProperty("courseid", teacherAbility.getCourseId());
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
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
        Query query = new Query(getTableName());
        Query.FilterPredicate filter = new Query.FilterPredicate("teacherid", Query.FilterOperator.EQUAL, teacherId);
        query.setFilter(filter);
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for(Entity entity: p.asIterable()){
            int courseId = (int) entity.getProperty("courseid");
            Key key = KeyFactory.createKey(TableName.FIRSTCOURSE, courseId);
            try {
                Entity entity2 = datastoreService.get(key);
                int grade2 = (int) entity2.getProperty("grade");
                if(grade2 == grade){
                    datastoreService.delete(entity.getKey());
                }
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
            query.setFilter(filter);
        }
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHERABILITY;
	}
	
}


