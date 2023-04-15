package alken1t.catalog;

import alken1t.catalog.entity.Category;
import alken1t.catalog.entity.Product;

import javax.persistence.*;
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

//        try {
//            manager.getTransaction().begin();

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

//            Product product = manager.find(Product.class, 4L);
//            product.setPrice((int) (product.getPrice() * 1.05));
//
//
//            manager.getTransaction().commit();
//        } catch (Exception e) {
//            manager.getTransaction().rollback();
//            e.printStackTrace();
//        }

        try {
            manager.getTransaction().begin();
//            Query query = manager.createQuery("" +
//                    "update Product  p set p.price = p.price * 1.1 where p.category.id = 2");
//            query.executeUpdate();

//            Query query = manager.createQuery("delete from Product p where  p.category.id = 2");
//            query.executeUpdate();

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }

//        TypedQuery<Category> categoryTypedQuery = manager.createQuery(
//                "select c from  Category c order by  c.name", Category.class);
//
//      List<Category> categories =   categoryTypedQuery.getResultList();
//      for (Category category : categories){
//          System.out.printf("%s%n",category.getName());
//          for (Product product : category.getProducts()){
//              System.out.printf(" - %s (%d)%n",product.getName(),product.getPrice());
//          }
//      }

//        int minPrice = 50_000;
//        int maxPrice = 200_000;

//        TypedQuery<Product> productTypedQuery = manager.createQuery(
//                "select  p from  Product  p where  p.price between 100000 and 200000", Product.class
//        );

//        TypedQuery<Product> productTypedQuery = manager.createQuery(
//                "select  p from  Product  p where  p.price between ?1 and ?2", Product.class
//        );
//        productTypedQuery.setParameter(1,minPrice);
//        productTypedQuery.setParameter(2,maxPrice);

//        TypedQuery<Product> productTypedQuery = manager.createQuery(
//                "select  p from  Product  p where  p.price between :min_price and :max_price", Product.class
//        );
//        productTypedQuery.setParameter("min_price",minPrice);
//        productTypedQuery.setParameter("max_price",maxPrice);
//        List<Product> products = productTypedQuery.getResultList();
//        for(Product product : products){
//            System.out.printf("%s (%d)%n", product.getName(), product.getPrice());
//        }

        int minPrice = 150_000;
        int maxPrice = 200_000;

        TypedQuery<Long> productCountTypedQuery = manager.createQuery(
                "select  count(p.id) from  Product  p where  p.price between ?1 and ?2", Long.class
        );
        productCountTypedQuery.setParameter(1, minPrice);
        productCountTypedQuery.setParameter(2, maxPrice);
        Long productCount = productCountTypedQuery.getSingleResult();
        System.out.println(productCount);
    }
}