package com.example.spring.daoImpl;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Expression;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring.dao.LoginDAO;
import com.example.spring.model.LoginModel;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	private SessionFactory sessionfactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean validateuser(String username, String password) {
		// TODO Auto-generated method stub
		/*
		 * StandardServiceRegistry ssr = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		 * SessionFactory factory = meta.getSessionFactoryBuilder().build(); Session
		 * session = factory.openSession(); Transaction t = session.beginTransaction();
		 */

		Session session = this.sessionfactory.getCurrentSession();
		LoginModel user = null;
		boolean flag = false;
		try {
			Criteria criteria = session.createCriteria(LoginModel.class);
			criteria.add(Expression.eq("userName", username));
			criteria.add(Expression.eq("password", password));

			user = (LoginModel) criteria.uniqueResult();

			// t.commit();
			// session.close();
		} catch (NoResultException e) {
			user = null;
		}

		if (user != null) {
			logger.info(user.toString());
			return true;
		}
		return flag;
	}
}
