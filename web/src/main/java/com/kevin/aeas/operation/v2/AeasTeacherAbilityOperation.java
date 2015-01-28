package com.kevin.aeas.operation.v2;

import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.object.oracle.OracleTeacherAbility;

public class AeasTeacherAbilityOperation extends AeasBasicOperation<OracleTeacherAbility>{
	public AeasTeacherAbilityOperation(){
	  super(OracleTeacherAbility.class);	
	}
	
	public List<OracleTeacherAbility> getByTeacherId(int teacherId) {
		OracleTeacher aeasTeacher = EntityManangerUtil.getInstance().find(OracleTeacher.class, teacherId);
		List<OracleTeacherAbility> list;
		if(aeasTeacher.getAeasTeacherAbilities() instanceof List){
			list = (List<OracleTeacherAbility>)aeasTeacher.getAeasTeacherAbilities();
		}
		else{
			list = new ArrayList<OracleTeacherAbility>();
			list.addAll(aeasTeacher.getAeasTeacherAbilities());
		}
		return list;
	}
	
	public List<OracleTeacherAbility> getByCourseId(int courseId) {
		OracleFirstCourse aeasFirstCourse = EntityManangerUtil.getInstance().find(OracleFirstCourse.class, courseId);
		List<OracleTeacherAbility> list;
		if(aeasFirstCourse.getAeasTeacherAbilities() instanceof List){
			list = (List<OracleTeacherAbility>)aeasFirstCourse.getAeasTeacherAbilities();
		}
		else{
			list = new ArrayList<OracleTeacherAbility>();
			list.addAll(aeasFirstCourse.getAeasTeacherAbilities());
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		
		
		
	}
}


