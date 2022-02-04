package com.example.bookercatalogddd.domain.product.delete;

import com.example.bookercatalogddd.domain.core.AbstractProcessImpl;
import com.example.bookercatalogddd.domain.core.Result;
import com.example.bookercatalogddd.infra.facade.ProductInfra;

public class ProductDeleteProcessImpl extends AbstractProcessImpl<ProductDeleteInput> implements ProductDeleteProcess{

    private final ProductInfra productInfra;

    public ProductDeleteProcessImpl(ProductInfra productInfra) {
        this.productInfra = productInfra;
    }

    @Override
    public void validate(ProductDeleteInput abstractProcessInput, Result result) {
        // TODO document why this method is empty
    }

    @Override
    public void run(ProductDeleteInput abstractProcessInput, Result result) {
       int res= productInfra.delete(abstractProcessInput.getId());
       if(res==1) result.getInfos().add("product deleted");
       if(res==-1)  result.getInfos().add("product not deleted");
    }
}
