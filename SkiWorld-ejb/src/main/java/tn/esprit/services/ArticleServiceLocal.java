package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Article;

@Local
public interface ArticleServiceLocal {
	public boolean Create(Article article);
	public boolean Update(Article article);
	public boolean Delet(Article article);
	public List<Article> getAll();

}
