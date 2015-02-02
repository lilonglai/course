package com.kevin.aeas.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map.Entry;
import java.util.TreeMap;

import jxl.Workbook;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.ScheduleOperation;
import com.kevin.aeas.operation.db.StudentOperation;
import com.kevin.aeas.operation.db.TeacherOperation;

public class GenerateReport {
	private Date startDate;
	private Date endDate;
	private Calendar startCalendar;
	private Calendar endCalendar;
	public GenerateReport(Date startDate, Date endDate){
		this.startDate = startDate;
		this.endDate= endDate;
		startCalendar = Calendar.getInstance();
		if(startDate != null){
		  startCalendar.setTime(startDate);
		}
		while(startCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
			startCalendar.add(Calendar.DAY_OF_WEEK, -1);
		}
		
		endCalendar = Calendar.getInstance();
		if(endDate != null){
		  endCalendar.setTime(endDate);
		}
		else{
			endCalendar.setTime(startCalendar.getTime());
			endCalendar.add(Calendar.DAY_OF_MONTH, 30);
		}
	}
	
	private void generateColumnSize(WritableSheet sheet) {
		for (int i = 0; i < 7; i++) {
			sheet.setColumnView(i, 13);
		}

	}
	private void generateWeek(WritableSheet sheet, int rowIndex){
		try {
			sheet.setRowView(rowIndex, 32*20);
			WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 8,
					WritableFont.BOLD);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			String stringValue;
			for(int i = 0; i < 6; i++){
				stringValue = "周" + (i+1);
				Label head = new Label(i, rowIndex, stringValue, format);
				sheet.addCell(head);
			}
			
			stringValue = "周" + "日";
			Label head = new Label(6, rowIndex, stringValue, format);
			sheet.addCell(head);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	private void fillDate(WritableSheet sheet, int columnIndex, int rowIndex, String value){
		try {
			WritableFont font = new WritableFont(WritableFont.TIMES, 8,
					WritableFont.BOLD);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
		    Label head = new Label(columnIndex, rowIndex, value, format);
			sheet.addCell(head);
			
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	private void fillCourse(WritableSheet sheet, int columnIndex, int rowIndex, String value){
		try {
			WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 8);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setWrap(true);
			format.setShrinkToFit(true);
		    Label head = new Label(columnIndex, rowIndex, value, format);
			sheet.addCell(head);
			
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	private int generateContent(WritableSheet sheet, int rowIndex){
		
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		TeacherOperation teacherOperation = new TeacherOperation();
		StudentOperation studentOperation = new StudentOperation();
		Calendar calandar = startCalendar;
		int maxRowIndex = rowIndex;
		int currentRowIndex;
		TreeMap<Integer, Schedule[]> scheduleMap;
		for(int i = 0; i < 7; i++){
			String stringValue;
			stringValue = (calandar.get(Calendar.MONTH)+1) + "/" + calandar.get(Calendar.DAY_OF_MONTH);
			fillDate(sheet, i, rowIndex, stringValue);
			Date currentDate = new Date(calandar.getTime().getTime());
			ArrayList<Schedule> scheduleList = scheduleOperation.getByDateAndTime(currentDate, 0);
			scheduleMap = new TreeMap<Integer, Schedule[]>();
			for(Schedule schedule:scheduleList){
				Schedule[] scheduleArray = scheduleMap.get(schedule.getStudentId());
				if(scheduleArray == null){
					scheduleArray = new Schedule[3];
					scheduleMap.put(schedule.getStudentId(), scheduleArray);
				}
				
				scheduleArray[schedule.getOnTime()-1] = schedule;
			}
			
			currentRowIndex = rowIndex+1;
			for(Entry<Integer, Schedule[]> entry : scheduleMap.entrySet()){
				Student student = studentOperation.get(entry.getKey());
				if(student == null){ //student has been deleted
					continue;
				}
				stringValue="";
				for(int j = 0; j < 3; j++){
					Schedule schedule = entry.getValue()[j];
					if(schedule != null){
						Teacher teacher = teacherOperation.get(schedule.getTeacherId());
						stringValue += teacher.getShortName();
						
					}else{
						stringValue += "N";
					}
					
					if(j != 2){
						stringValue += ",";
					}
				}
				
				stringValue += "(" + student.getName() + ")";
				fillCourse(sheet, i, currentRowIndex, stringValue);
				currentRowIndex++;
			}
			
			if(currentRowIndex > maxRowIndex){
				maxRowIndex = currentRowIndex;
			}
			calandar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return maxRowIndex;
	}
	
	public void generate(OutputStream servletOutputStream){
		try {			
			WritableWorkbook book = Workbook.createWorkbook(servletOutputStream);
			WritableSheet sheet = book.createSheet("第一页", 0);
			generateColumnSize(sheet);
			int rowIndex = 0 ;
			while(startCalendar.compareTo(endCalendar) < 0){
				generateWeek(sheet, rowIndex);
				rowIndex++;
				rowIndex = generateContent(sheet, rowIndex);
			}
			book.write();
			
			book.close();
			

		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}
	

}
