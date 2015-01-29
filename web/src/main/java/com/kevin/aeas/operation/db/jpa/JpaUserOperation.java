package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleUser;

public class JpaUserOperation extends JpaBasicOperation<OracleUser> {
	public JpaUserOperation() {
		super(OracleUser.class);
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

	public static void main(String[] args) {
		JpaUserOperation operation = new JpaUserOperation();
		System.out.println(operation.getAll());
	}

}
