package com.kevin.aeas.excel;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.Schedule;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.Student;
import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.FirstCourseOperation;
import com.kevin.aeas.operation.ScheduleOperation;
import com.kevin.aeas.operation.SecondCourseOperation;
import com.kevin.aeas.operation.StudentOperation;
import com.kevin.aeas.operation.TeacherOperation;
import com.kevin.aeas.utils.GradeHelp;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;

public class ReadStudentCourse {

	private String filePath;
	private Workbook book;

	private String studentName;
	private String studentCount;
	private String studentGrade;
	private String studentTestScore;
	private String studentExaminedate;
	private String studentExaminePlace;
	private String masterName;
	private String masterPhone;

	private double totalHours;
	private String studentTargetScore;

	TreeMap<Date, String[]> courses = new TreeMap<Date, String[]>();
	
	Date firstDate = null;
	
	static HashMap<String, String> keyWorldMap = new HashMap<String, String>();
	static{
		keyWorldMap.put("词汇", "词汇");
		keyWorldMap.put("单词", "词汇");
		keyWorldMap.put("V", "词汇");
		
		keyWorldMap.put("听力", "听力");
		keyWorldMap.put("L", "听力");
		
		keyWorldMap.put("口语", "口语");
		
		keyWorldMap.put("阅读", "阅读");
		keyWorldMap.put("R", "阅读");
		
		keyWorldMap.put("写作", "写作");
		keyWorldMap.put("W", "写作");
		
		keyWorldMap.put("数学和逻辑", "数学和逻辑");
		keyWorldMap.put("逻辑", "数学和逻辑");
		keyWorldMap.put("数学", "数学和逻辑");
		keyWorldMap.put("M", "数学和逻辑");
		
		keyWorldMap.put("终模", "终模");
		keyWorldMap.put("终1", "终模");
		keyWorldMap.put("终2", "终模");
		keyWorldMap.put("分析", "终模");
		
		keyWorldMap.put("冲刺", "冲刺");
		
		keyWorldMap.put("语法", "语法");
		keyWorldMap.put("音标", "语法");
		
		keyWorldMap.put("班主任补课", "班主任补课");
		keyWorldMap.put("班主任", "班主任补课");
	}

	public ReadStudentCourse(String filePath) {
		this.filePath = filePath;
	}

	private void analyzeFirstRow(String rowString) {
		String[] splits = rowString.split(" ");
		for (int i = 0; i < splits.length; i++) {
			String[] property = splits[i].split("[：:]");
			if (property.length == 2) {
				String propertyName = property[0];
				if (propertyName.indexOf("学生姓名") != -1) {
					studentName = property[1];
				} else if (propertyName.indexOf("人数") != -1) {
					studentCount = property[1];
				} else if (propertyName.indexOf("年级") != -1) {
					i++;
					studentGrade = splits[i];

				} else if (propertyName.indexOf("测试原成绩") != -1) {
					studentTestScore = property[1];
				} else if (propertyName.indexOf("考试时间") != -1) {
					int beginIndex = property[1].indexOf("(");
					int endIndex = property[1].indexOf(")");
					if(beginIndex == -1 || endIndex == -1){
						studentExaminedate = property[1];
						studentExaminePlace = "";
					}
					else{
					    studentExaminedate = property[1].substring(0, beginIndex);
					    studentExaminePlace = property[1].substring(beginIndex + 1, endIndex);
					}
				} else if (propertyName.indexOf("班主任") != -1) {
					int beginIndex = 0;
					int endIndex = property[1].indexOf("老师");
					if(endIndex >= 0){
						masterName = property[1].substring(beginIndex, endIndex);
						beginIndex = endIndex + 2;
						masterPhone = property[1].substring(beginIndex);
					}else{
						endIndex = property[1].indexOf("1");
						if(endIndex >=0){
							masterName = property[1].substring(beginIndex, endIndex);
							beginIndex = endIndex;
							masterPhone = property[1].substring(beginIndex);
						}else{
							masterName = property[1];
							masterPhone= "";
						}
					}
				}
			} else if (property.length == 3) {
				int endIndex = property[1].indexOf("老师");
				masterName = property[1].substring(0, endIndex);
				masterPhone = property[2];

			}
		}

	}

	private void analyzeSecondRow(String rowString) {
		int endIndex = rowString.indexOf("课时");
		//String strNumber = rowString.substring(4, endIndex);
		//totalHours = Double.valueOf(strNumber);
	}

	private void analyzeThirdRow(String rowString1, String rowString2) {
		if(rowString2 != null && !rowString2.equals("")){
			studentTargetScore = rowString2;
		}else{
			int index = rowString1.lastIndexOf(":");
			if(index == -1){
				index = rowString1.lastIndexOf("：");
			}
			if(index != -1){
				studentTargetScore = rowString1.substring(index+1);
			}
		}
	}

	private Date anaylyzeDate(String cellString) {
		int beginIndex = cellString.indexOf("(");
		int endIndex = cellString.indexOf("月");
		String month = cellString.substring(beginIndex + 1, endIndex).trim();
		beginIndex = endIndex + 1;
		endIndex = cellString.indexOf("日");
		String day = cellString.substring(beginIndex, endIndex).trim();		
		if(firstDate == null){
			String firstYear;
			int firstMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
			if(Math.abs(firstMonth - Integer.valueOf(month)) <= 2){
				firstYear = Calendar.getInstance().get(Calendar.YEAR) + "";
			}else{
				firstYear = (Calendar.getInstance().get(Calendar.YEAR)+1) + "";
			}
			String firstDateString = firstYear + "-" + month + "-" + day;
			firstDate = Date.valueOf(firstDateString);
		}
		
		String year = Calendar.getInstance().get(Calendar.YEAR) + "";
		String dateString = year + "-" + month + "-" + day;
		Date date = Date.valueOf(dateString);
		
		if(date.compareTo(firstDate) <0){
			year = (Calendar.getInstance().get(Calendar.YEAR)+1) + "";
			dateString = year + "-" + month + "-" + day;
			date = Date.valueOf(dateString);
		}
		return date;
	}

	private void readExcel() {
		try {
			book = Workbook.getWorkbook(new File(filePath));
			Sheet sheet = book.getSheet(0);

			// first row value
			Cell cell = sheet.getCell(0, 0);
			String rowString = cell.getContents();
			CellFormat format = cell.getCellFormat();
			try{
			    analyzeFirstRow(rowString);
			}catch(Exception e){
				System.out.println("学生信息有问题");
			}

			// second row value
			cell = sheet.getCell(0, 1);
			rowString = cell.getContents();
			format = cell.getCellFormat();
			analyzeSecondRow(rowString);

			// third row value
			cell = sheet.getCell(0, 2);
			String rowString1 = cell.getContents();
			cell = sheet.getCell(1, 2);
			String rowString2 = cell.getContents();
			analyzeThirdRow(rowString1, rowString2);

			int column = 0;
			cell = sheet.getCell(column, 3);
			String dateString = cell.getContents();
			format = cell.getCellFormat();

			while (!dateString.equals("")) {
				Date date = null;
				try{
				    date = anaylyzeDate(dateString);
				}catch(Exception e){
					System.out.println("日期有问题");
					column += 2;
					cell = sheet.getCell(column, 3);
					dateString = cell.getContents();
					continue;
				}

				String[] stringArray = new String[3];

				// 9:00-11:30
				cell = sheet.getCell(column + 1, 4);
				stringArray[0] = cell.getContents();

				// 11:45-12:30
				cell = sheet.getCell(column + 1, 6);

				// 12:30-14:30
				cell = sheet.getCell(column + 1, 7);
				stringArray[1] = cell.getContents();

				// 14:45-16:45
				cell = sheet.getCell(column + 1, 8);
				stringArray[2] = cell.getContents();

				// 16:45-17:15
				cell = sheet.getCell(column + 1, 9);

				courses.put(date, stringArray);

				column += 2;
				cell = sheet.getCell(column, 3);
				dateString = cell.getContents();
			}

			book.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Student operateStudent() {
		StudentOperation studentOperation = new StudentOperation();
		TeacherOperation teacherOperation = new TeacherOperation();
		Student student = studentOperation.getByName(studentName);
		if (student == null) {
			student = new Student();
			student.setName(studentName);
			try{
				student.setGrade(GradeHelp.getNumberByString(studentGrade));
				student.setTargetScore(studentTargetScore);
				student.setTestScore(studentTestScore);
			    student.setExamineDate(Date.valueOf(studentExaminedate));
				student.setExaminePlace(studentExaminePlace);
				Teacher teacher = teacherOperation.getByShortName(masterName);
				if(teacher == null){
					teacher = teacherOperation.getByName(masterName);
				}
				student.setTeacherId(teacher.getId());
			}catch(Exception e){
				System.out.println("解析学生信息存在问题" + studentName);
			}
			studentOperation.add(student);
			student = studentOperation.getByName(studentName);
		} else {
			try{
				student.setExamineDate(Date.valueOf(studentExaminedate));
				student.setExaminePlace(studentExaminePlace);
				student.setGrade(GradeHelp.getNumberByString(studentGrade));
				student.setTargetScore(studentTargetScore);
				student.setTestScore(studentTestScore);
				Teacher teacher = teacherOperation.getByShortName(masterName);
				if(teacher == null){
					teacher = teacherOperation.getByName(masterName);
				}
				student.setTeacherId(teacher.getId());
			}catch(Exception e){
				System.out.println("解析学生信息存在问题" + studentName);
			}
			studentOperation.update(student);
		}
		return student;
	}

	private Teacher operateTeacher() {
		TeacherOperation teacherOperation = new TeacherOperation();
		Teacher teacher = teacherOperation.getByShortName(masterName);
		if (teacher == null) {
			teacher = teacherOperation.getByName(masterName);
			/*
			teacher = new Teacher();
			teacher.setShortName(masterName);
			teacher.setPhone(masterPhone);
			teacherOperation.add(teacher);
			teacher = teacherOperation.getByShortName(masterName);
			*/
		} 
		
		if(teacher != null) {
			teacher.setPhone(masterPhone);
			teacherOperation.update(teacher);
		}
		return teacher;
	}
	
	private SecondCourse findSecondCourse(Student student, String courseName) {
		// preprocess the courseName;
		courseName = courseName.replace("，", ",");
		courseName = courseName.replace("（", "(");
		courseName = courseName.replace("）", ")");
		
		SecondCourseOperation secondCourseOperation = new SecondCourseOperation();
		FirstCourseOperation firstCourseOperation = new FirstCourseOperation();
		String firstCourseName = null;
		for(Entry<String, String> entry : keyWorldMap.entrySet()){
			if(courseName.indexOf(entry.getKey()) != -1){
				firstCourseName = entry.getValue();
				break;
			}			
		}
		ArrayList<FirstCourse> firstCourseList = firstCourseOperation.getByGrade(student.getGrade());
		FirstCourse firstCourse =null;
		for(FirstCourse iFirstCourse : firstCourseList){
			if(iFirstCourse.getName().equals(firstCourseName)){
				firstCourse = iFirstCourse;
				break;
			}
		}
		
		if(firstCourse == null){
			System.out.println(courseName);
			return null;
		}
		
		ArrayList<SecondCourse> secondCourseList = secondCourseOperation.getByFirstCourseId(firstCourse.getId());
		SecondCourse result = null;
		int value =1000;
		for (SecondCourse secondCourse : secondCourseList) {
			if (courseName.equals(secondCourse.getName())) {
				return secondCourse;
			}
			
			int compared = StringUtils.getLevenshteinDistance(secondCourse.getName(), courseName);
			if(compared < value){
				value = compared;
				result = secondCourse;
			}
			
		}

		return result;
	}

	private Teacher findTeacher(String teacherName) {
		TeacherOperation teacherOperation = new TeacherOperation();
		Teacher teacher = teacherOperation.getByShortName(teacherName);
		if(teacher == null){
			teacher = teacherOperation.getByName(teacherName);
		}
		return teacher;
	}

	private void operateShedule(Student student) {
		ScheduleOperation scheduleOperation = new ScheduleOperation();

		for (Entry<Date, String[]> entry : courses.entrySet()) {
			Date onDate = entry.getKey();
			String[] arrayString = entry.getValue();
			for (int i = 0; i < arrayString.length; i++) {
				int onTime = i + 1;
				if (arrayString[i].equals("休息") || arrayString[i].equals(""))
					continue;
				int beginIndex = arrayString[i].lastIndexOf("(");
				if (beginIndex == -1) {
					beginIndex = arrayString[i].lastIndexOf("（");
				}

				int endIndex = arrayString[i].lastIndexOf(")");
				if (endIndex == -1) {
					endIndex = arrayString[i].lastIndexOf("）");
				}
				
				if(beginIndex == -1 || endIndex == -1){
					//没有老师上课的排课信息
					/*
					Schedule schedule = scheduleOperation
							.getByStudentIdOnDateAndTime(student.getId(),
									onDate, onTime);
					if (schedule != null) {
						scheduleOperation.delete(schedule.getId());
					}
					
					schedule = new Schedule();
					schedule.setOnDate(onDate);
					schedule.setOnTime(onTime);
					schedule.setStudentId(student.getId());
					schedule.setAddition(arrayString[i]);
					scheduleOperation.add(schedule);
					*/
					continue;
				}
				String courseName = arrayString[i].substring(0, beginIndex);
				String teacherName = arrayString[i].substring(beginIndex + 1, endIndex);
				if(teacherName.endsWith("监考")){
					endIndex = teacherName.lastIndexOf("监考");
					teacherName = teacherName.substring(0, endIndex);
				}
				teacherName = teacherName.trim();
				SecondCourse secondCourse = findSecondCourse(student,
						courseName);
				Teacher teacher = findTeacher(teacherName);
				if (teacher != null) {
					Schedule schedule = scheduleOperation
							.getByStudentIdOnDateAndTime(student.getId(),
									onDate, onTime);
					if (schedule != null) {
						scheduleOperation.delete(schedule.getId());
					}

					schedule = new Schedule();
					schedule.setOnDate(onDate);
					schedule.setOnTime(onTime);
					schedule.setStudentId(student.getId());
					schedule.setTeacherId(teacher.getId());
					if (secondCourse != null) {
						schedule.setCourseId(secondCourse.getId());
					}

					scheduleOperation.add(schedule);
				}
			}
		}
	}

	public void importCourse() {
		readExcel();
		Student student = operateStudent();
		Teacher teacher = operateTeacher();
		operateShedule(student);
	}
	
	public static void main(String[] args){
		String directoryPath = "C:/btm/aeas/学生课表";
		File directory = new File(directoryPath);
		File[] files =directory.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {
				if(name.indexOf("后期") >= 0)
				    return false;
				else 
					return true;
			}
		});
		
		for(File file: files){
			try{
			    ReadStudentCourse readStudentCourse = new ReadStudentCourse(file.getAbsolutePath());
			    readStudentCourse.importCourse();
			}catch(Exception e){
				System.out.println("导入文件存在问题:" + file.getAbsolutePath());
			}
		}
		
	}

}
