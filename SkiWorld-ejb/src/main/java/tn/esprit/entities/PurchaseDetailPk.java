package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PurchaseDetailPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int articleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public PurchaseDetailPk() {
		super();
	}
	public PurchaseDetailPk(int userId, int articleId) {
		super();
		this.userId = userId;
		this.articleId = articleId;
	}
	
	

}
