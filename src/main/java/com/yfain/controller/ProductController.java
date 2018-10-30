package com.yfain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.yfain.crudDB.ProductService;
import com.yfain.crudDB.ProductServiceImpl;
import com.yfain.entity.Product;
import com.yfain.repositorio.ProductRepository;

@Controller
@RestController
@RequestMapping("/api")
public class ProductController {
        // * Simulacion de basse de datos de produtos */
        // Product products[] = new Product[6];

        @Autowired
        ProductRepository repository;
        private ProductService productService;

        /*
         * Este metodo se ejecuta despues de que se completa la inicializacion del
         * repositorio ProductRepository
         */
        @PostConstruct
        public void init() {
                productService = new ProductServiceImpl(repository);
        }

        ProductController() {

                // productService = new ProductServiceImpl(repository);

                // products[0] = new Product(0,"First product", 59.99, 4.3,
                // "This is a short description of the First Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"electronics", "hardware"}*/);

                // products[1] = new Product(1,"Second product", 64.99, 3.5,
                // "This is a short description of the Second Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"books"}*/);

                // products[2] = new Product(2,"Third product", 74.99, 4.2,
                // "This is a short description of the Third Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"electronics"}*/);
                // products[3] = new Product(3,"Fourth product", 84.99, 3.9,
                // "This is a short description of the Fourth Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"hardware"}*/);
                // products[4] = new Product(4,"Fifth product", 94.99, 5,
                // "This is a short description of the Fifth Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"electronics", "hardware"}*/);
                // products[5] = new Product(5,"Sixth product", 54.99, 4.6,
                // "This is a short description of the Sixth Product",
                // "For what you pay this is a steal."/*,
                // new String[]{"books"}*/);

        }

        /* Dos api REST */

        /*
         * En esta api REST se tiene que si en la URL se tiene un /products/id se
         * obtendra una peticion GET que redireccionara a este metodo y retornara el
         * producto correspodniente al id, buscandolo en el array de productos.
         */

        @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public Product getProductById(@PathVariable("id") String productId) {
                List<Product> products = productService.listAll();
                // List<Product> products = new ArrayList<>();
                // repository.findAll().forEach(products::add); //fun with Java 8
                int prodId = Integer.parseInt(productId);

                for (Product prd : products) {
                        if (prd.getId() == prodId) {
                                return prd;
                        }
                }

                return null;
        }

        @PostMapping(value = "/products")
        public Product postCustomer(@RequestBody Product product) {
                int id = product.getId();
                System.out.print("ENTRE A LA ID: " + id);
                Product productoRet = productService.saveOrUpdate(product);
                return productoRet;
        }

        @PutMapping(value="/products/{id}")
        public void putCustomer(@RequestBody Product product, @PathVariable int id){
                System.out.print("\nENTRE A PUT ");
                productService.replace(id, product);
        }

        @DeleteMapping(value = "/products/{id}")
        public void deleteCustomer(@PathVariable int id) {
                System.out.print("entre a eliminar");
                productService.delete(id);
        }
        /*
         * En esta api REST se tiene que si en la URL se tiene un /products se obtendra
         * una peticion GET que redireccionara a este metodo y retornara un array de
         * productos
         */

        @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Product> getProducts() {
                List<Product> products = new ArrayList<>();
                // repository.findAll().forEach(products::add); //fun with Java 8

                products = productService.listAll();
                return products;
        }
}