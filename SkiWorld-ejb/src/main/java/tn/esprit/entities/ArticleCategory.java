package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ArticleCategory
 *
 */
@Entity

public class ArticleCategory implements Serializable {

	
	private int id;
	private String category;
	private List< Article> articles;
	private static final long serialVersionUID = 1L;

	public ArticleCategory() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@OneToMany(mappedBy="category",
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
   
	
}
