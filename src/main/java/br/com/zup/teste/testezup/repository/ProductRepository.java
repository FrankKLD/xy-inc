package br.com.zup.teste.testezup.repository;

import br.com.zup.teste.testezup.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.idProduct = :idProduct ")
    Product findByIdProduct(@Param("idProduct") Long idProduct);
}
