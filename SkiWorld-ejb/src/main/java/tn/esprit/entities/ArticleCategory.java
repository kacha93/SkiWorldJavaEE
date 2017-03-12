package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ArticleCategory
 *
 */
@Entity

public class ArticleCategory implements Serializable {

	
	private int id;
	private String category;
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
   
	
}
