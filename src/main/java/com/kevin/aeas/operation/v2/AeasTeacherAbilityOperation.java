package com.kevin.aeas.operation.v2;

import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.v2.AeasFirstCourse;
import com.kevin.aeas.object.v2.AeasTeacher;
import com.kevin.aeas.object.v2.AeasTeacherAbility;

public class AeasTeacherAbilityOperation extends AeasBasicOperation<AeasTeacherAbility>{
	public AeasTeacherAbilityOperation(){
	  super(AeasTeacherAbility.class);	
	}
	
	public List<AeasTeacherAbility> getByTeacherId(int teacherId) {
		AeasTeacher aeasTeacher = EntityManangerUtil.getInstance().find(AeasTeacher.class, teacherId);
		List<AeasTeacherAbility> list;
		if(aeasTeacher.getAeasTeacherAbilities() instanceof List){
			list = (List<AeasTeacherAbility>)aeasTeacher.getAeasTeacherAbilities();
		}
		else{
			list = new ArrayList<AeasTeacherAbility>();
			list.addAll(aeasTeacher.getAeasTeacherAbilities());
		}
		return list;
	}
	
	public List<AeasTeacherAbility> getByCourseId(int courseId) {
		AeasFirstCourse aeasFirstCourse = EntityManangerUtil.getInstance().find(AeasFirstCourse.class, courseId);
		List<AeasTeacherAbility> list;
		if(aeasFirstCourse.getAeasTeacherAbilities() instanceof List){
			list = (List<AeasTeacherAbility>)aeasFirstCourse.getAeasTeacherAbilities();
		}
		else{
			list = new ArrayList<AeasTeacherAbility>();
			list.addAll(aeasFirstCourse.getAeasTeacherAbilities());
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		
		
		
	}
}


