package br.flaviosdelima.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

public class DAO {
	
	private EntityManagerFactory emf;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public DAO() {
		emf = Persistence.createEntityManagerFactory("sistema");
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema"); 
		//EntityManager em = emf.createEntityManager(); 
	}
	public Session getSession()
	{
		Session session = null;
		if(getEntityManager().getDelegate() instanceof EntityManagerImpl)
		{
			EntityManagerImpl entityManagerImpl = (EntityManagerImpl)getEntityManager();
			session= entityManagerImpl.getSession();
		}else
		{
			session =(Session)getEntityManager().getDelegate();
		}
		return session;
	}
}
