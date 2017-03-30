package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity

public class Provider implements Serializable {

	
	private int id;
	private String name;
	private List<Article> articles;
	private static final long serialVersionUID = 1L;

	public Provider() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="provider",
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
   
}
