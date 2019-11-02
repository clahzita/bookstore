/**
 * 
 */
package com.bookstore.codehome.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author clarissa
 *
 */
@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Long id; 
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Title is a required information.")
	private String title;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Author is a required information.")
	private String author;
	
	@Column(nullable = false, length = 255)
	@NotBlank(message = "Description is a required information.")
	private String description;
	
	private Integer pages;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Publication Date is a required information.")
	private Date publicationDate;

	public Product() {}
			
	public Product(Long id, @NotBlank(message = "Title is a required information.") String title,
			@NotBlank(message = "Author is a required information.") String author,
			@NotBlank(message = "Description is a required information.") String description, Integer pages,
			@NotNull(message = "Publication Date is a required information.") Date publicationDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pages = pages;
		this.publicationDate = publicationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
	
	
}
