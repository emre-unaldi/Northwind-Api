package emreunaldi.northwind.business.concretes;

import emreunaldi.northwind.business.abstracts.ProductService;
import emreunaldi.northwind.core.utilities.results.DataResult;
import emreunaldi.northwind.core.utilities.results.Result;
import emreunaldi.northwind.core.utilities.results.SucceesDataResult;
import emreunaldi.northwind.core.utilities.results.SuccessResult;
import emreunaldi.northwind.dataAccess.abstracts.ProductRepository;
import emreunaldi.northwind.entities.concretes.Product;
import emreunaldi.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.findAll(),
                "Data listelendi"
        );
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SucceesDataResult<Product>(
                this.productRepository.getByProductName(productName),
                "Data fetched"
        );
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SucceesDataResult<Product>(
                this.productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId),
                "Data fetched"
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId),
                "Data fetched"
        );
    }

    // getByCategoryIdIn - kaldır
    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.getByCategoryIn(categories),
                "Data fetched"
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.getByProductNameContains(productName),
                "Data fetched"
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.getByProductNameStartsWith(productName),
                "Data fetched"
        );
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SucceesDataResult<List<Product>>(
                this.productRepository.getByNameAndCategory(productName, categoryId),
                "Data fetched"
        );
    }

    // Pagination
    @Override
    public DataResult<List<Product>> getAll(int pageNo, int PageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, PageSize);

        return new SucceesDataResult<List<Product>>(
                this.productRepository.findAll(pageable).getContent(),
                "Data fetched"
        );
    }

    // Sorted
    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");

        return new SucceesDataResult<List<Product>>(
                this.productRepository.findAll(sort),
                "Data fetched"
        );
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SucceesDataResult<List<ProductWithCategoryDto>>(
                this.productRepository.getProductWithCategoryDetails(),
                "Data fetched"
        );
    }
}
