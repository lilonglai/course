package com.kevin.aeas.operation.v2;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasUser;

public class AeasUserOperation extends AeasBasicOperation<AeasUser> {
	public AeasUserOperation() {
		super(AeasUser.class);
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
		AeasUserOperation operation = new AeasUserOperation();
		System.out.println(operation.getAll());
	}

}
