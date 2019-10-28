/**
 * 
 */
package com.bookstore.codehome.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author clarissa
 *
 */
@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Setter private Long id; 
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Title is a required information.")
	@Getter @Setter private String title;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Author is a required information.")
	@Getter @Setter private String author;
	
	@Column(nullable = false, length = 255)
	@NotBlank(message = "Description is a required information.")
	@Getter @Setter private String description;
	
	@Getter @Setter private Integer pages;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Publication Date is a required information.")
	@Getter @Setter private Date publicationDate;
	
}
