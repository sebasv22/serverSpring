package com.yfain.crudDB;
 
import com.yfain.entity.Product;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(int id);

    Product saveOrUpdate(Product product);

    void delete(int id);

	void replace(int id, Product product);

    
}
