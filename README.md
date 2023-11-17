# Software Developer Training Camp (JAVA)

This backend project was bootstrapped with [Java Spring Boot](https://spring.io)
> This Web API project was developed for the Software Developer Training Camp (JAVA + React) backend on the [Kodlama.io](https://www.kodlama.io) platform.

> This project was implemented with `n-Layered Architecture`, complying with `SOLID` and `Clean Code` principles.

## `Used Technologies`

- JDK 20
- Java 17
- Spring Framework
- Spring Core
- Spring Web
- Spring Data
- Spring Rest
- Spring Boot Dev Tools
- PostreSQL
- Lombok
- Swagger

## `Run Application`

> Before running the project, the database must be configured and the `postgresql_script.sql` file must be added to the database.

> After running the project, the application will run at [http://localhost:8001](http://localhost:8001)

- Swagger : http://localhost:8001/swagger-ui/index.html

## `User Endpoints`

| Route                     | HTTP   | POST body	                               | Description             |
|---------------------------|--------|------------------------------------------|-------------------------|
| /api/users/add            | `POST` | {"email": "string","password": "string"} | Create a new user.      |
| /api/users/getFindByEmail | `GET`  | {"email": "string"}                      | Fetching users by email |

---

## `Product Endpoints`

| Route                                       | HTTP   | POST body	                                                                                             | Description                                     |
|---------------------------------------------|--------|--------------------------------------------------------------------------------------------------------|-------------------------------------------------|
| /api/products/add                           | `POST` | {"productName": "string","unitPrice": 0,"unitsInStock": 0,"quantityPerUnit": "string","categoryId": 0} | Create a new product.                           |
| /api/products/getProductWithCategoryDetails | `GET`  | Empty                                                                                                  | Get product with category details.              |
| /api/products/getByProductName              | `GET`  | {"productName": "string"}                                                                              | Get product by product name.                    |
| /api/products/getByProductNameStartsWith    | `GET`  | {"productName": "string"}                                                                              | Get products starting with the entered letters. |
| /api/products/getByProductNameOrCategoryId  | `GET`  | {"productName": "string", "categoryId": 0}                                                             | Get products by product name or category ID.    |
| /api/products/getByProductNameContains      | `GET`  | {"productName": "string"}                                                                              | Get products containing product name.           |
| /api/products/getByProductNameAndCategoryId | `GET`  | {"productName": "string", "categoryId": 0}                                                             | Get product by product name and category ID.    |
| /api/products/getByNameAndCategory          | `GET`  | {"productName": "string", "categoryId": 0}                                                             | Get product by product name and category ID.    |
| /api/products/getAll                        | `GET`  | Empty                                                                                                  | Get all products.                               |
| /api/products/getAllSortedDesc              | `GET`  | Empty                                                                                                  | Get all products in DESC order.                 |
| /api/products/getAllByPage                  | `GET`  | {"pageNo": 0, "pageSize": 0}                                                                           | Get products according to pagination structure. |
