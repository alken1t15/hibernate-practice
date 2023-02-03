package alken1t.catalog;

import alken1t.catalog.entity.Category;
import alken1t.catalog.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaLesson {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");

        EntityManager manager = factory.createEntityManager();

//        Category category = manager.find(Category.class,1L);
//
//        if (category != null) {
//            System.out.println(category.getName());
//        }
//        else {
//            System.out.println("Category not fount by provided id");
//        }

//        Product product = manager.find(Product.class, 1L);
//        System.out.println(product.getCategory().getName());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());

//        Category category = manager.find(Category.class, 2L);
//        List<Product> products = category.getProducts();
//        System.out.printf("%s:%n", category.getName());
//        for (Product product : products) {
//            System.out.printf("- %s (%d)%n", product.getName(), product.getPrice());
//        }

        try {
            manager.getTransaction().begin();

//            Category category = new Category();
//            category.setName("Мониторы");
//            manager.persist(category);

//           Category category = manager.find(Category.class,3L);
//           category.setName("Мебель");

//            Category category = manager.find(Category.class,3L);
//            manager.remove(category);

//            Product product = new Product();
//            Category category = manager.find(Category.class,2L);
//            product.setCategory(category);
//            product.setName("Kingston HyperX Cloud 2");
//            product.setPrice(98990);
//            manager.persist(product);

            Product product = manager.find(Product.class, 4L);
            product.setPrice((int) (product.getPrice() * 1.05));


            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}