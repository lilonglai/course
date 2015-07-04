package com.kevin.course.servlet;

import com.google.appengine.api.datastore.*;
import com.kevin.course.utils.TableName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by loli on 2015/7/1.
 */
public class GenerateDataServlet extends HttpServlet {
    private HashMap<String, List<Item>> tableMap;
    private int counter = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clearData();
        generateData();

        PrintWriter writer = response.getWriter();
        writer.print("counter:" + counter);
    }

    private void clearData() {
        clearFirstCourse();
        clearSecondCourse();
        clearTeacher();
        clearTeacherAbility();
        clearTeacherDefaultHoliday();
        clearTeacherHoliday();
        clearStudent();
        clearSchedule();
    }

    private void generateData() throws IOException {
        tableMap = new HashMap<>();

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mysql.sql");
        Reader reader= new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while(line != null){
            System.out.println(line);
            line = line.trim();
            if(line.startsWith("CREATE TABLE")){
                parseTable(bufferedReader, line);
            }
            else if(line.startsWith("INSERT INTO")){
                parseData(bufferedReader, line);
            }

            line = bufferedReader.readLine();
        }
    }

    private void parseTable(BufferedReader bufferedReader, String line)throws IOException{
        int startIndex;
        int endIndex;
        startIndex = line.indexOf("`") +1 ;
        endIndex = line.indexOf("`", startIndex);
        String tableName = line.substring(startIndex, endIndex);
        List<Item> tableList = new ArrayList<>();
        while(line.contains(";") == false){
            line = bufferedReader.readLine().trim();
            if(line.startsWith("`")) {
                Item item = new Item();
                startIndex = 1;
                endIndex = line.indexOf("`", startIndex);
                item.name = line.substring(startIndex, endIndex);

                startIndex = endIndex+2;
                endIndex = line.indexOf(" ", startIndex);
                item.type = line.substring(startIndex, endIndex);

                startIndex = line.indexOf("DEFAULT", endIndex + 1);
                if(startIndex >= 0) {
                    startIndex = startIndex + 8;
                    endIndex = line.indexOf(",");
                    item.value = line.substring(startIndex, endIndex);
                }

                tableList.add(item);

            }
        }

        tableMap.put(tableName, tableList);

    }

    private void parseData(BufferedReader bufferedReader, String line){
        int startIndex;
        int endIndex;
        startIndex = line.indexOf("`") +1 ;
        endIndex = line.indexOf("`", startIndex);
        String tableName = line.substring(startIndex, endIndex);

        DatastoreService datastoreService= DatastoreServiceFactory.getDatastoreService();

        while(line.charAt(endIndex+1) != ';'){
            Entity entity = null;
            startIndex = line.indexOf("(", endIndex) +1 ;
            endIndex = line.indexOf(")", startIndex);
            String[] columns = line.substring(startIndex, endIndex).split(",");
            for(int i =0 ; i < columns.length; i++){
                Object object = getObject(tableMap.get(tableName).get(i).type,columns[i]);
                if(i == 0){
                    int id = (int) object;
                    if(object == 0){
                        entity = new Entity(tableName);
                    }
                    else {
                        entity = new Entity(tableName, id);
                    }
                }
                else{
                    entity.setUnindexedProperty(tableMap.get(tableName).get(i).name, object);
                }
            }

            datastoreService.put(entity);
            counter++;
        }

    }

    private Object getObject(String type, String value){
        if(value.equals("NULL")){
            return null;
        }

        if(type.startsWith("int")){
            return Integer.parseInt(value);
        }else if(type.startsWith("tinyint")){
            if(value.equals("1")){
                return true;
            }else{
                return false;
            }
        }
        else if(type.startsWith("varchar")){
            return value.substring(1, value.length()-1);
        }
        else if(type.startsWith("date")){
            //return Date.valueOf(value.substring(1, value.length()-1));
            return value.substring(1, value.length()-1);
        }

        return null;
    }

    private void clearKind(String kind) {
        Query query = new Query(kind);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery p = datastoreService.prepare(query);
        for (Entity entity : p.asIterable()) {
            System.out.println(entity);
            datastoreService.delete(entity.getKey());
        }
    }

    private void clearFirstCourse() {
        clearKind(TableName.FIRSTCOURSE);
    }

    private void clearSecondCourse() {
        clearKind(TableName.SECONDCOURSE);
    }

    private void clearTeacher() {
        clearKind(TableName.TEACHER);
    }

    private void clearTeacherAbility() {
        clearKind(TableName.TEACHERABILITY);
    }

    private void clearTeacherHoliday() {
        clearKind(TableName.TEACHERHOLIDAY);
    }

    private void clearTeacherDefaultHoliday() {
        clearKind(TableName.TEACHERDEFAULTHOLIDAY);
    }

    private void clearStudent() {
        clearKind(TableName.STUDENT);
    }

    private void clearSchedule() {
        clearKind(TableName.SCHEDULE);
    }

    class Item{
        String name;
        String type;
        String length;
        String value;
    }

}
