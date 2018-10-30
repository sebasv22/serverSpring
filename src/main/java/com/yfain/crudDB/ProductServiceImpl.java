package com.yfain.crudDB;
import com.yfain.entity.Product;
import com.yfain.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

   private ProductRepository productRepository;
   public ProductServiceImpl() {
   
}

    public ProductServiceImpl(ProductRepository productRepository) {
        
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void replace(int id, Product product) {
        productRepository.delete(id);
        product.setId(id);
        productRepository.save(product);
    }

  
}
