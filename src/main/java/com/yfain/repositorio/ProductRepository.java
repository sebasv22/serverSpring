package com.yfain.repositorio;

import com.yfain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
