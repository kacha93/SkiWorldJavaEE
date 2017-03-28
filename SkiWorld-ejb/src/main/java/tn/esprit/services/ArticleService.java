package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Article;

/**
 * Session Bean implementation class ArticleService
 */
@Stateless
@LocalBean
public class ArticleService implements ArticleServiceLocal {

	@PersistenceContext
	EntityManager em;
 
    public ArticleService() {
       
    }

	@Override
	public boolean Create(Article article) {
		try
		{
			em.persist(article);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean Update(Article article) {
		try
		{
			em.merge(article);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean Delet(Article article) {
		try
		{
			em.remove(em.merge(article));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Article> getAll() {
		try
		{
			Query query = em.createQuery("select a from Article a");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	}


