package com.kevin.course.operation.db.engine;

import com.kevin.course.object.SecondCourse;
import com.kevin.course.operation.db.ISecondCourseOperation;
import com.kevin.course.utils.TableName;

import java.util.ArrayList;
import java.util.List;

public class EngineSecondCourseDao extends EngineBaseDao<SecondCourse> implements ISecondCourseOperation {
	protected SecondCourse generateObject(Entity entity){
		SecondCourse secondCourse = new SecondCourse();
		secondCourse.setId((int)entity.getKey().getId());
		secondCourse.setName(getString(entity.getProperty("name")));
		secondCourse.setShortName(getString(entity.getProperty("shortname")));
		secondCourse.setFirstCourseId(getInt(entity.getProperty("firstcourseid")));
		secondCourse.setDescription(getString(entity.getProperty("description")));
		return secondCourse;
	}

	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
		List<SecondCourse> list = new ArrayList<SecondCourse>();
		Query query = new Query(getTableName());
		Query.FilterPredicate filter = new Query.FilterPredicate("firstcourseid", Query.FilterOperator.EQUAL, firstCourseId);
		query.setFilter(filter);
		DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
		PreparedQuery p = datastoreService.prepare(query);
		for(Entity entity: p.asIterable()){
			list.add(generateObject(entity));
		}
		return list;
	}
	
	public List<SecondCourse> getByGrade(int grade){
        List<SecondCourse> list = new ArrayList<SecondCourse>();
        Query query = new Query(TableName.FIRSTCOURSE);
        Query.FilterPredicate filter = new Query.FilterPredicate("grade", Query.FilterOperator.EQUAL, grade);
        query.setFilter(filter);
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for(Entity entity: p.asIterable()){
            int firstCourseId = (int) entity.getKey().getId();
            query = new Query(getTableName());
            filter = new Query.FilterPredicate("firstcourseid", Query.FilterOperator.EQUAL, firstCourseId);
            PreparedQuery p2 = datastoreService.prepare(query);
            for(Entity entity2: p2.asIterable()){
                list.add(generateObject(entity2));
            }

        }
        return list;
	}
	
	public void add(final SecondCourse secondCourse){
        Entity entity = new Entity(getTableName());
        entity.setProperty("name", secondCourse.getName());
        entity.setProperty("shortname", secondCourse.getShortName());
        entity.setProperty("firstcourseid", secondCourse.getFirstCourseId());
        entity.setProperty("description", secondCourse.getDescription());
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        datastoreService.put(entity);
	}
	
	public void update(final SecondCourse secondCourse){
        Entity entity = new Entity(getTableName(), secondCourse.getId());
        entity.setProperty("name", secondCourse.getName());
        entity.setProperty("shortname", secondCourse.getShortName());
        entity.setProperty("firstcourseid", secondCourse.getFirstCourseId());
        entity.setProperty("description", secondCourse.getDescription());
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        datastoreService.put(entity);
	}

	@Override
	protected String getTableName() {
		return TableName.SECONDCOURSE;
	}

}
