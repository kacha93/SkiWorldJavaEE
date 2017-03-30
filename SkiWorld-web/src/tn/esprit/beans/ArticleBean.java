package tn.esprit.beans;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import tn.esprit.entities.Article;
import tn.esprit.services.ArticleServiceLocal;

@ManagedBean
@ViewScoped
public class ArticleBean {

	private Article article = new Article();
	private List<Article> articles = new ArrayList<Article>();
	private Part picFile;
	private Blob picupdate;
	private boolean visible=false;
	@EJB
	ArticleServiceLocal myService;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String ajouter()
	{
		myService.Create(article);
	init();
	return null ;
		}

	public String modifier() throws IOException, SerialException, SQLException
	{ 
		if (picFile!=null){
			
			InputStream is=picFile.getInputStream();
        byte[] content = IOUtils.toByteArray(is);
        Blob blob = new javax.sql.rowset.serial.SerialBlob(content);
        article.setPicture(blob);
			
		}
		else {
			article.setPicture(picupdate);
		}
		
        
		myService.Update(article);
		setVisible(false);
		init();
		return null;
		}

	public String supprimer(Article article){
		 myService.Delet(article);
		 init();
		 return null ;
	 }

	@PostConstruct
	public void init(){ 
    articles=new ArrayList<Article>();
	List<Article> artic=myService.getAll();
	if(artic!=null){
		for(Article at:artic){
			if(at instanceof Article){
				articles.add((Article) at);
			}
		}
	}
	}
	
	public String initialiser(){
		article=new Article();
		setVisible(true);
		return null;
	}
	public Part getPicFile() {
		return picFile;
	}
	public void setPicFile(Part picFile) {
		this.picFile = picFile;
	}
	public byte[] afficherPic(Blob blob) throws SQLException{
		return blob.getBytes(1, (int) blob.length());
	}
	public Blob getPicupdate() {
		return picupdate;
	}
	public void setPicupdate(Blob picupdate) {
		this.picupdate = picupdate;
	}

	
	
	
}
