/**
 * 
 */
package com.bookstore.codehome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.codehome.models.Product;

/**
 * @author clarissa
 *
 */


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }
