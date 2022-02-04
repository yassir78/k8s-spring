package com.example.bookercatalogddd.application.ws;

import com.example.bookercatalogddd.domain.core.Result;
import com.example.bookercatalogddd.domain.product.delete.ProductDeleteInput;
import com.example.bookercatalogddd.domain.product.delete.ProductDeleteProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booker-catalog/")
public class ProductRest {

    @Autowired
    private final ProductDeleteProcess productDeleteProcess;

    public ProductRest(ProductDeleteProcess productDeleteProcess) {
        this.productDeleteProcess = productDeleteProcess;
    }

    @DeleteMapping("id/{id}")
    public Result deleteProduct(@PathVariable Long id){
        ProductDeleteInput productDeleteInput=new ProductDeleteInput();
        productDeleteInput.setId(id);
        return productDeleteProcess.execute(productDeleteInput);
    }
}
