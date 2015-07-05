package com.kevin.course.operation.db.engine;

import com.kevin.course.utils.TableName;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class EngineBaseDao<T>{

    protected int getInt(Object value){
        Long newValue = (Long)value;
        return newValue.intValue();
    }

    protected  String getString(Object value){
        return (String)value;
    }

    protected Date getDate(Object value){
        String newValue = (String)value;
        try{
            return Date.valueOf(newValue);
        }
        catch (Exception e){
            return null;
        }
    }

    protected DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();

    protected abstract T generateObject(Entity entity);

    protected abstract String getTableName();

    public T get(int id) {
        try {
            Key key = KeyFactory.createKey(getTableName(), id);
            Entity entity = datastoreService.get(key);
            return generateObject(entity);
        }catch(Exception e){
            return null;
        }

    }

    public List<T> getAll() {
        List<T> list = new ArrayList();
        Query query = new Query(getTableName());
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for(Entity entity: p.asIterable()){
            list.add(generateObject(entity));
        }
        return list;
    }


    public void delete(int id) {
        Key key = KeyFactory.createKey(TableName.TEACHER, id);
        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();
        datastoreService.delete(key);
    }


}
