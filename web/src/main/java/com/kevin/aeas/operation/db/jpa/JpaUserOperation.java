package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.User;
import com.kevin.aeas.object.mysql.MySqlUser;
import com.kevin.aeas.object.oracle.OracleUser;
import com.kevin.aeas.utils.ConfigurationManager;

public class JpaUserOperation extends JpaBasicOperation {
	public JpaUserOperation() {
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlUser.class);
		}
		else{
			setActualClass(OracleUser.class);
		}
	}

	public boolean isExistUser(String userName, String userPassword) {
		String hsql = "select u from AeasUser u where u.name='" + userName
				+ "' and u.password='" + userPassword + "'";
		Query q = EntityManangerUtil.getInstance().createQuery(hsql);
		List list = q.getResultList();
		if (list.isEmpty())
			return false;
		return true;
	}

	protected  Object changeToJpa(Object t){
		User newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlUser();
		}
		else{
			newObject = new OracleUser();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	
	
	public static void main(String[] args) {
		JpaUserOperation operation = new JpaUserOperation();
		System.out.println(operation.getAll());
	}

}
