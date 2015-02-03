package com.kevin.aeas.excel;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.ScheduleOperation;
import com.kevin.aeas.operation.db.SecondCourseOperation;
import com.kevin.aeas.operation.db.StudentOperation;
import com.kevin.aeas.operation.db.TeacherOperation;
import com.kevin.aeas.utils.GradeHelp;

public class GenerateStudentCourse {

	public static final int column1 = 960;
	public static final int column2 = 460;
	public static final int column3 = 420;
	public static final int column4 = 285;
	public static final int column5 = 780;
	public static final int column6 = 760;
	public static final int column7 = 780;
	public static final int column8 = 1400;
	public static final int column9 = 1280;
	public static final int column10 = 570;
	public static final int column11 = 270;
	public static final int column12 = 270;
	public static final int column13 = 270;
	public static final int column14 = 270;

	public static final Colour SPEAK_COLOUR = Colour.BRIGHT_GREEN;
	public static final Colour LISTEN_COLOUR = Colour.TURQUOISE;
	public static final Colour READ_COLOUR = Colour.BRIGHT_GREEN;
	public static final Colour WRITE_COLOUR = Colour.YELLOW;
	public static final Colour VOCABULARY_COLOUR = Colour.LAVENDER;
	public static final Colour MATH_COLOUR = Colour.RED;
	
	public static HashMap<String, Colour> colourMap = new HashMap<String, Colour>();
	static {
		colourMap.put("口语", SPEAK_COLOUR);
		colourMap.put("听力", LISTEN_COLOUR);
		colourMap.put("阅读", READ_COLOUR);
		colourMap.put("写作", WRITE_COLOUR);
		colourMap.put("词汇", VOCABULARY_COLOUR);
		colourMap.put("数学和逻辑", MATH_COLOUR);
		colourMap.put("终模", Colour.WHITE);
		colourMap.put("冲刺", Colour.WHITE);
		colourMap.put("语法", Colour.WHITE);
		colourMap.put("班主任补课", Colour.WHITE);
	}
	
	
	private int studentId;
	private Student student;
	private double totalHours = 0;;

	private void generateRowSize(WritableSheet sheet) {
		try {
			sheet.setRowView(0, column1);
			sheet.setRowView(1, column2);
			sheet.setRowView(2, column3);
			sheet.setRowView(3, column4);
			sheet.setRowView(4, column5);
			sheet.setRowView(5, column6);
			sheet.setRowView(6, column7);
			sheet.setRowView(7, column8);
			sheet.setRowView(8, column9);
			sheet.setRowView(9, column10);
			sheet.setRowView(10, column11);
			sheet.setRowView(11, column12);
			sheet.setRowView(12, column13);
			sheet.setRowView(13, column14);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		}

	}

	private void generateColumnSize(WritableSheet sheet) {
		for (int i = 0; i < 60; i++) {
			sheet.setColumnView(i, 100 / 9);
		}

	}

	private void generateHead(WritableSheet sheet) {

		try {			
			TeacherOperation teacherOperation = new TeacherOperation();
			Teacher teacher = teacherOperation.get(student.getTeacherId());
			String studentInfo = "学生姓名:" + student.getName()
					           + "    人数:1"
					           + "    年级:Level " + GradeHelp.getStringByNumber(student.getGrade())
					           + "    测试原成绩:" + student.getTestScore()
					           + "    考试时间:" + student.getExamineDate() + "(" + student.getExaminePlace() + ")";
			if(teacher != null){
				studentInfo += "    班主任:" + teacher.getShortName()+ ":" + teacher.getPhone();
			}else{
				studentInfo += "    班主任:" + "待定";
			}
			
			WritableFont font = new WritableFont(WritableFont.createFont("宋体"),
					10, WritableFont.BOLD);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			Label head = new Label(
					0,
					0,
					studentInfo,
					format);
			sheet.addCell(head);
			sheet.mergeCells(0, 0, 11, 0);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	private void generateHours(WritableSheet sheet) {

		try {
			WritableFont font = new WritableFont(WritableFont.TIMES, 14,
					WritableFont.BOLD, true);
			font.setColour(Colour.RED);
			WritableCellFormat format = new WritableCellFormat(font);
			String stringHours = "AEAS" + totalHours + "课时班";
			Label head = new Label(0, 1, stringHours, format);
			sheet.addCell(head);
			sheet.mergeCells(0, 1, 16, 1);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	private void generateTarget(WritableSheet sheet) {
		try {
			WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10,WritableFont.BOLD);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			Label head = new Label(
					0,
					2,
					"目标分数:",
					format);
			sheet.addCell(head);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10,WritableFont.BOLD);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.LEFT);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			head = new Label(
					1,
					2,
					student.getTargetScore(),
					format);
			sheet.addCell(head);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	private Colour decideColour(int firstCourseId){
		FirstCourseOperation firstCourseOperation = new FirstCourseOperation();
		FirstCourse firstCourse = firstCourseOperation.get(firstCourseId);
		return colourMap.get(firstCourse.getName());
		
	}
	
	private void generateContent(WritableSheet sheet) throws WriteException{
		int dayCount = 1;
		double dayHours = 0;		
		totalHours = 0; 
		
		ScheduleOperation scheduleOperation = new ScheduleOperation();
		List<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);
		TreeMap<Date, Schedule[]> sortedMap = new TreeMap<Date, Schedule[]>();
		for(Schedule schedule : scheduleList){
			Schedule[] scheduleArray = sortedMap.get(schedule.getOnDate());
			if(scheduleArray == null){
				scheduleArray = new Schedule[3];
				sortedMap.put(schedule.getOnDate(), scheduleArray);
			}			
			scheduleArray[schedule.getOnTime()-1] = schedule;			
		}
		int columnIndex = 0;
		TeacherOperation teacherOperation = new TeacherOperation();
		SecondCourseOperation secondCourseOperation = new SecondCourseOperation();
		
		WritableFont font;
		WritableCellFormat format;
		String stringValue = "";
		Label head;
		for(Entry<Date, Schedule[]> entry : sortedMap.entrySet()){
			Schedule[] scheduleArray = entry.getValue();
			dayHours = 0;
			// 4 row information : Day 1(9-8)			
			font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			format.setWrap(true);
			String stringDate = entry.getKey().toString().substring(5);
			stringValue = "Day " + dayCount + "(" +stringDate + ")";
			head = new Label(columnIndex, 3, stringValue, format);
			sheet.addCell(head);
			sheet.mergeCells(columnIndex, 3, columnIndex + 1, 3);
			
			// 5 row first course 9:00-11:30
			font = new WritableFont(WritableFont.TIMES, 10);
			format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "9:00-11:30";
			head = new Label(columnIndex, 4, stringValue, format);
			sheet.addCell(head);
			sheet.mergeCells(columnIndex, 4, columnIndex, 5);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			format.setWrap(true);
			if(scheduleArray[0] != null){
				SecondCourse secondCourse = secondCourseOperation.get(scheduleArray[0].getCourseId());
				Teacher teacher = teacherOperation.get(scheduleArray[0].getTeacherId());
				if(secondCourse == null){
					stringValue = "待定" + "(" + teacher.getShortName() + ")";
				}
				else {
				    stringValue = secondCourse.getName() + "(" + teacher.getShortName() + ")";
				    format.setBackground(decideColour(secondCourse.getFirstCourseId()));
				}
				dayHours += 2.5;
				
			}else{
				stringValue = "休息";
			}
			head = new Label(columnIndex+1, 4, stringValue, format);
			sheet.addCell(head);
			sheet.mergeCells(columnIndex+1, 4, columnIndex+1, 5);
			
			// 7 row 11:45-12:30
			font = new WritableFont(WritableFont.TIMES, 10);
			format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "11:45-12:30";
			head = new Label(columnIndex, 6, stringValue, format);
			sheet.addCell(head);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "休息";
			head = new Label(columnIndex+1, 6, stringValue, format);
			sheet.addCell(head);
			
			// 8 row 12:30-14:30
			font = new WritableFont(WritableFont.TIMES, 10);
			format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "12:30-14:30";
			head = new Label(columnIndex, 7, stringValue, format);
			sheet.addCell(head);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			format.setWrap(true);
			if(scheduleArray[1] != null){
				SecondCourse secondCourse = secondCourseOperation.get(scheduleArray[1].getCourseId());
				Teacher teacher = teacherOperation.get(scheduleArray[1].getTeacherId());
				if(secondCourse == null){
					stringValue = "待定" + "(" + teacher.getShortName() + ")";
				}
				else{
				    stringValue = secondCourse.getName() + "(" + teacher.getShortName() + ")";
				    format.setBackground(decideColour(secondCourse.getFirstCourseId()));
				}
				dayHours += 2;
				
			}else{
				stringValue = "休息";
			}
			head = new Label(columnIndex+1, 7, stringValue, format);
			sheet.addCell(head);
			
			// 9 row 14:45-16:45
			font = new WritableFont(WritableFont.TIMES, 10);
			format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "14:45-16:45";
			head = new Label(columnIndex, 8, stringValue, format);
			sheet.addCell(head);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			format.setWrap(true);
			if(scheduleArray[2] != null){
				SecondCourse secondCourse = secondCourseOperation.get(scheduleArray[2].getCourseId());
				Teacher teacher = teacherOperation.get(scheduleArray[2].getTeacherId());
				if(secondCourse == null){
					stringValue = "待定" + "(" + teacher.getShortName() + ")";
				}
				else{
				    stringValue = secondCourse.getName() + "(" + teacher.getShortName() + ")";
				    format.setBackground(decideColour(secondCourse.getFirstCourseId()));
				}
				dayHours += 2;
				
			}else{
				stringValue = "休息";
			}
			head = new Label(columnIndex+1, 8, stringValue, format);
			sheet.addCell(head);
			
			// 10 row  16:45-17:15
			font = new WritableFont(WritableFont.TIMES, 10);
			format = new WritableCellFormat(font);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "16:45-17:15";
			head = new Label(columnIndex, 9, stringValue, format);
			sheet.addCell(head);
			
			font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			stringValue = "休息";
			head = new Label(columnIndex+1, 9, stringValue, format);
			sheet.addCell(head);
			
			// 11 row hour calculation
			font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
			format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			//format.setBorder(Border.ALL, BorderLineStyle.THIN);
			jxl.write.Number hourLabel =  new jxl.write.Number(columnIndex+1, 10,dayHours, format);
			sheet.addCell(hourLabel);
			
			totalHours += dayHours;
			columnIndex += 2;
			dayCount++;
		}
		
		//total hours
		font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD);
		format = new WritableCellFormat(font);
		format.setAlignment(Alignment.CENTRE);
		format.setVerticalAlignment(VerticalAlignment.CENTRE);
		//format.setBorder(Border.ALL, BorderLineStyle.THIN);
		jxl.write.Number totalHourLabel =  new jxl.write.Number(columnIndex, 10,totalHours, format);
		sheet.addCell(totalHourLabel);
		
	}

	private void generateTail(WritableSheet sheet) {
		try {

			WritableCellFormat format = new WritableCellFormat();
			format.setAlignment(Alignment.CENTRE);
			Label notes = new Label(0, 11, "Notes:", format);
			sheet.addCell(notes);

			jxl.write.Number note1 = new jxl.write.Number(1, 11, 1, format);
			Label noteMessage1 = new Label(2, 11,
					"以上是学生安排的个性化作息表，包含短期培训的所有课程时间安排。");
			sheet.addCell(note1);
			sheet.addCell(noteMessage1);

			jxl.write.Number note2 = new jxl.write.Number(1, 12, 2, format);
			Label noteMessage2 = new Label(2, 12, "参与以上课时提供午饭，标准15元/餐。");
			sheet.addCell(note2);
			sheet.addCell(noteMessage2);

			jxl.write.Number note3 = new jxl.write.Number(1, 13, 3, format);
			Label noteMessage3 = new Label(2, 13, "提供免费送考服务（上海考场考生）。");
			sheet.addCell(note3);
			sheet.addCell(noteMessage3);

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	
	public GenerateStudentCourse(int studentId) {
		this.studentId = studentId;
		StudentOperation studentOperation = new StudentOperation();
		this.student = studentOperation.get(studentId);
	}
	
	public void exportCourse(){
		try {
			long currentTime = System.currentTimeMillis();
			String filePath = "c:/btm/aeas" + "/" + "temp/" + currentTime + ".xls";
			WritableWorkbook book = Workbook.createWorkbook(new File(filePath));
			WritableSheet sheet = book.createSheet("第一页", 0);

			generateRowSize(sheet);
			generateColumnSize(sheet);
			generateHead(sheet);			
			generateTarget(sheet);
						
			generateContent(sheet);
						
			generateHours(sheet); // need to calculate the value
			generateTail(sheet);
			book.write();
			
			book.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	public void exportCourse(OutputStream servletOutputStream){
		try {			
			WritableWorkbook book = Workbook.createWorkbook(servletOutputStream);
			WritableSheet sheet = book.createSheet("第一页", 0);

			generateRowSize(sheet);
			generateColumnSize(sheet);
			generateHead(sheet);			
			generateTarget(sheet);
						
			generateContent(sheet);
						
			generateHours(sheet); // need to calculate the value
			generateTail(sheet);
			book.write();
			
			book.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	
}
