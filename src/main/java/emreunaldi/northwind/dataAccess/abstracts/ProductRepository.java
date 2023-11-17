package emreunaldi.northwind.dataAccess.abstracts;

import emreunaldi.northwind.entities.concretes.Product;
import emreunaldi.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
    /*
         SQL : SELECT * FROM products WHERE product_name = ? AND category_id = ?

        JPQL yazarken sql'e benzer şekilde yazılır. Ama tam olarak onun gibi düşünülmez.
        Mesela burdaki Product bizim entity'miz ve diğer değerler onun alanıdır.
        SQL ifadelerinin yazılımı farketmez fakat entity ve parametre isimleri doğru yazılmalıdır.
    */

    @Query("Select new emreunaldi.northwind.entities.dtos.ProductWithCategoryDto" +
            "(p.id, p.productName, c.categoryName) " +
            "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //select p.productId,p.productName, c.categoryName  from Category c inner join Product p
    //on c.categoryId = p.categoryId
    // veritabanı değil nesneler üzerinden eşleşir.
    /*
        SQL :  SELECT p.product_id, p.product_name, c.category_name
               FROM categories c INNER JOIN products p
               ON c.category_id = p.category_id
    */
}
