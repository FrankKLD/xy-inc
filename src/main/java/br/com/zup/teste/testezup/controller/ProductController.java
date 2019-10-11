package br.com.zup.teste.testezup.controller;

import br.com.zup.teste.testezup.model.Product;
import br.com.zup.teste.testezup.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "Products")
@RestController
@Controller
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    @ApiOperation(value = "Get All Products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    @ApiOperation(value = "Get Product by idProduct")
    public ResponseEntity<Product> getByIdProduct(@PathVariable(value = "idProduct") Long idProduct){
        Product products = productRepository.findByIdProduct(idProduct);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Post a new Product")
    public ResponseEntity<Product> postToSaveProduct(@RequestBody Product product){
        Product productReturn = productRepository.save(product);

        return new ResponseEntity<>(productReturn, HttpStatus.OK);
    }

    @DeleteMapping()
    @ApiOperation(value = "Delete a saved Product")
    public ResponseEntity<Product> deleteSavedProduct(@RequestBody Product product){
        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    @ApiOperation(value = "Put to update a saved Product")
    public ResponseEntity<Product> putToUpdateProductSaved(@RequestBody Product product){
        Product productReturn = productRepository.save(product);

        return new ResponseEntity<>(productReturn, HttpStatus.OK);
    }
}
