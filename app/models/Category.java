package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;

//Product Entity managed by the ORM
@Entity
public class Category extends Model{

    //Properties
    //Annotate id as the primary key
    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<Product> products;

    //Default Constructor
    public Category(){

    }

    public Category(Long id, String name, List<Product> products){
        this.setId(id);
        this.setName(name);
        this.setProducts(products);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Category> find = new Finder<Long, Category>(Category.class);

    //Find all Products in the database in ascending order by name
    public static List<Category> findAll(){
        return Category.find.where().orderBy("name asc").findList();
    }
}
