package com.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.utility.Utility;


public class SaveObject {
   public static int save(Product p) {
		Session ses=Utility.getSession();
		Transaction tx=null;
			tx=ses.beginTransaction();
			Integer count=(Integer)ses.save(p);
			tx.commit();
			return count;
	}
}
