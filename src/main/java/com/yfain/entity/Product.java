package com.yfain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {
    @Id
    @Column(name = "PRO_ID")
    private int id;
    @Column(name = "PRO_TITLE")
    private String title;
    @Column(name = "PRO_PRICE")
    private double price;
    @Column(name = "PRO_RATING")
    private double rating;
    @Column(name = "PRO_SHORTDESCRIPTION")
    private String shortDescription;
    @Column(name = "PRO_DESCRIPTION")
    private String description;

   // public String[] categories;
   public Product() {
		super();
	 }
    public Product(int id, String title, double price, double rating,
                   String shortDescription, String description /*, String[] categories*/){
        this.id=id;
        this.title=title;
        this.price=price;
        this.rating=rating;
        this.shortDescription=shortDescription;
        this.description=description;
      //  this.categories=categories;
    }

    @Override
    public String toString() {
      return "{" +
        " id='" + getId() + "'" +
        ", title='" + getTitle() + "'" +
        ", price='" + getPrice() + "'" +
        ", rating='" + getRating() + "'" +
        ", shortDescription='" + getShortDescription() + "'" +
        ", description='" + getDescription() + "'" +
        "}";
    }

    public int getId() {
      return this.id;
    }
  
    public void setId(int id) {
      this.id = id;
    }
  
    public String getTitle() {
      return this.title;
    }
  
    public void setTitle(String title) {
      this.title = title;
    }
  
    public double getPrice() {
      return this.price;
    }
  
    public void setPrice(double price) {
      this.price = price;
    }
  
    public double getRating() {
      return this.rating;
    }
  
    public void setRating(double rating) {
      this.rating = rating;
    }
  
    public String getShortDescription() {
      return this.shortDescription;
    }
  
    public void setShortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
    }
  
    public String getDescription() {
      return this.description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }

    
}
