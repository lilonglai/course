package com.kevin.course.operation.db.engine;

import com.kevin.course.object.Schedule;
import com.kevin.course.operation.db.IScheduleOperation;
import com.kevin.course.utils.TableName;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EngineScheduleDao extends EngineBaseDao<Schedule> implements IScheduleOperation {
    protected Schedule generateObject(Entity entity) {
        Schedule schedule = new Schedule();
        schedule.setId((int) entity.getKey().getId());
        schedule.setOnDate(Date.valueOf((String) entity.getProperty("ondate")));
        schedule.setOnTime((int) entity.getProperty("ontime"));
        schedule.setStudentId((int) entity.getProperty("studentId"));
        schedule.setCourseId((int) entity.getProperty("courseid"));
        schedule.setTeacherId((int) entity.getProperty("teacherid"));
        schedule.setAddition((String) entity.getProperty("addition"));
        schedule.setDescription((String) entity.getProperty("description"));
        return schedule;
    }

    public Schedule getByStudentIdOnDateAndTime(int studentId, Date onDate, int onTime) {
        List<Schedule> list = new ArrayList<Schedule>();
        Query query = new Query(getTableName());
        Query.Filter filter = Query.CompositeFilterOperator.and(
                new Query.FilterPredicate("studentid", Query.FilterOperator.EQUAL, studentId),
                new Query.FilterPredicate("ondate", Query.FilterOperator.EQUAL, onDate),
                new Query.FilterPredicate("ontime", Query.FilterOperator.EQUAL, onTime));
        query.setFilter(filter);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            list.add(generateObject(entity));
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public List<Schedule> getByStudentId(int studentId) {
        List<Schedule> list = new ArrayList<Schedule>();
        Query query = new Query(getTableName());
        Query.FilterPredicate filter = new Query.FilterPredicate("studentid", Query.FilterOperator.EQUAL, studentId);
        query.setFilter(filter);
        query.addSort("ondate");
        query.addSort("ontime");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            list.add(generateObject(entity));
        }
        return list;
    }

    public List<Schedule> getByTeacherId(int teacherId) {
        List<Schedule> list = new ArrayList<Schedule>();
        Query query = new Query(getTableName());
        Query.FilterPredicate filter = new Query.FilterPredicate("teacherid", Query.FilterOperator.EQUAL, teacherId);
        query.setFilter(filter);
        query.addSort("ondate");
        query.addSort("ontime");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            list.add(generateObject(entity));
        }
        return list;
    }

    public List<Schedule> getByDateAndTime(Date onDate, int onTime) {
        List<Schedule> list = new ArrayList<Schedule>();
        Query query = new Query(getTableName());
        Query.Filter filter;
        if (onTime >= 1) {
            filter = Query.CompositeFilterOperator.and(
                    new Query.FilterPredicate("ondate", Query.FilterOperator.EQUAL, onDate),
                    new Query.FilterPredicate("ontime", Query.FilterOperator.EQUAL, onTime));
        } else {
            filter = new Query.FilterPredicate("ondate", Query.FilterOperator.EQUAL, onDate);
        }
        query.setFilter(filter);
        query.addSort("ondate");
        query.addSort("ontime");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            list.add(generateObject(entity));
        }
        return list;
    }


    public void add(final Schedule schedule) {
        Entity entity = new Entity(getTableName());
        entity.setProperty("ondate", schedule.getOnDate());
        entity.setProperty("ontime", schedule.getOnTime());
        entity.setProperty("studentId", schedule.getStudentId());
        entity.setProperty("courseid", schedule.getCourseId());
        entity.setProperty("teacherid", schedule.getStudentId());
        entity.setProperty("addition", schedule.getAddition());
        entity.setProperty("description", schedule.getDescription());
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        datastoreService.put(entity);
    }

    public void update(final Schedule schedule) {
        Entity entity = new Entity(getTableName(), schedule.getId());
        entity.setProperty("ondate", schedule.getOnDate());
        entity.setProperty("ontime", schedule.getOnTime());
        entity.setProperty("studentId", schedule.getStudentId());
        entity.setProperty("courseid", schedule.getCourseId());
        entity.setProperty("teacherid", schedule.getStudentId());
        entity.setProperty("addition", schedule.getAddition());
        entity.setProperty("description", schedule.getDescription());
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        datastoreService.put(entity);
    }

    @Override
    protected String getTableName() {
        return TableName.SCHEDULE;
    }

}
