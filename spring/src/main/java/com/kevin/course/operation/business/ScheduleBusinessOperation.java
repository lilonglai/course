package com.kevin.course.operation.business;

import com.kevin.course.object.*;
import com.kevin.course.operation.db.*;
import com.kevin.course.utils.DateHelp;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by loli on 2015/4/4.
 */
public class ScheduleBusinessOperation implements IScheduleBusinessOperation{
    @Autowired
    private ISecondCourseOperation secondCourseOperation;
    @Autowired
    private IScheduleOperation scheduleOperation;
    @Autowired
    private ITeacherOperation teacherOperation;
    @Autowired
    private ITeacherAbilityOperation teacherAbilityOperation;
    @Autowired
    private ITeacherDefaultHolidayOperation teacherDefaultHolidayOperation;
    @Autowired
    private ITeacherHolidayOperation teacherHolidayOperation;

    public void add(Schedule schedule) {
        scheduleOperation.add(schedule);
    }

    public void update(Schedule schedule) {
        scheduleOperation.update(schedule);
    }

    public Schedule get(int id) {
        return scheduleOperation.get(id);
    }

    public void delete(int id) {
        scheduleOperation.delete(id);
    }

    public List<Schedule> getAll() {
        return scheduleOperation.getAll();
    }

    public List<Schedule> getByStudentId(int studentId) {
        return scheduleOperation.getByStudentId(studentId);
    }

    public List<SecondCourse> getSecondCourseList(int studentId, int firstCourseId) {
        List<SecondCourse> secondCourseList = secondCourseOperation.getByFirstCourseId(firstCourseId);
        List<Schedule> scheduleList = scheduleOperation.getByStudentId(studentId);
        List<SecondCourse> resultList = new ArrayList<>();
        for (SecondCourse secondCourse : secondCourseList) {
            if (isScheduled(secondCourse, scheduleList)) {
                continue;
            }
            resultList.add(secondCourse);
        }

        return resultList;
    }

    private boolean isScheduled(SecondCourse secondCourse, List<Schedule> scheduleList) {
        for (Schedule schedule : scheduleList) {
            if (secondCourse.getId() == schedule.getCourseId()) {
                return true;
            }
        }
        return false;
    }

    public List<Teacher> getTeacherList(Date onDate, int onTime, int firstCourseId) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(onDate);

        List<TeacherAbility> teacherAbilityList = teacherAbilityOperation.getByCourseId(firstCourseId);
        List<Teacher> teacherList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);

        for (TeacherAbility teacherAbility : teacherAbilityList) {
            int teacherId = teacherAbility.getTeacherId();

            if (isTeacherInHoliday(teacherId, calendar)) {
                continue;
            }

            if (isScheduled(teacherId, scheduleList)) {
                continue;
            }
            teacherList.add(teacherOperation.get(teacherId));

        }
        return teacherList;
    }

    private boolean isTeacherInHoliday(int teacherId, Calendar calendar) {
        TeacherDefaultHoliday teacherDefaultHoliday = teacherDefaultHolidayOperation.getByTeacherId(teacherId);
        List<TeacherHoliday> holidayList = teacherHolidayOperation.getByTeacherId(teacherId);
        if (DateHelp.isHoliday(calendar, teacherDefaultHoliday, holidayList)) {
            return true;
        }
        return false;
    }

    /*
 * decide teacher has been arranged a class.
 * @param teacherId the teacher identification.
 * @param Schedule the arranged list
 */
    private boolean isScheduled(int teacherId, List<Schedule> scheduleList) {
        for (Schedule schedule : scheduleList) {
            if (schedule.getTeacherId() == teacherId) {
                return true;
            }
        }
        return false;
    }

    public List<Teacher> getAvailableTeacherList(Date onDate, int onTime) {
        List<Schedule> scheduleList = scheduleOperation.getByDateAndTime(onDate, onTime);
        List<Teacher> teacherList = teacherOperation.getAll();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(onDate);

        ArrayList<Teacher> resultList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            int teacherId = teacher.getId();

            if (isTeacherInHoliday(teacherId, calendar)) {
                continue;
            }

            // decide the teacher's scheduling time
            if (isScheduled(teacher.getId(), scheduleList)) {
                continue;
            }

            resultList.add(teacher);

        }

        return resultList;
    }
}
