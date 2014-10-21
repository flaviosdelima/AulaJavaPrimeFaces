package br.flaviosdelima.entidade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
 

import br.flaviosdelima.dao.DAO;

public class FornecedorDao extends DAO{
	
	public void Salvar(Fornecedor fornecedor)
	{
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction();
			em.persist(fornecedor);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			em.getTransaction().rollback();
		}
	}
	
	public Fornecedor getById(Integer id)
	{
		EntityManager em = getEntityManager();
		return em.find(Fornecedor.class, id);
	}
	
	public List<Fornecedor> GetAll()
	{
		EntityManager em = getEntityManager();
		List<Fornecedor>  lista = null;
		try 
		{
			Query q = em.createNativeQuery("Select objects(f) from Fornecedor as f");
			lista= q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}	
	public void delete(Fornecedor fornecedor)
	{
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			em.remove(f); 
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			em.getTransaction().rollback();
		}
	}	
	public void Update(Fornecedor fornecedor)
	{
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			f.setNome(fornecedor.getNome());
			f.setTelefone(fornecedor.getTelefone());
			f.setObs(fornecedor.getObs());
 
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			em.getTransaction().rollback();
		}
	}	
}
