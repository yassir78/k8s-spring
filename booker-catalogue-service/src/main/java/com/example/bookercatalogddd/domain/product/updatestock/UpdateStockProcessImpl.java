package com.example.bookercatalogddd.domain.product.updatestock;

import com.example.bookercatalogddd.domain.core.AbstractProcessImpl;
import com.example.bookercatalogddd.domain.core.Result;
import com.example.bookercatalogddd.domain.pojo.Product;
import com.example.bookercatalogddd.domain.pojo.Stock;
import com.example.bookercatalogddd.infra.facade.ProductInfra;
import com.example.bookercatalogddd.infra.facade.StockInfra;
import com.example.bookercatalogddd.infra.facade.StoreInfra;

public class UpdateStockProcessImpl extends AbstractProcessImpl<UpdateStockInput> implements UpdateStockProcess {

    private final ProductInfra productInfra;
    private final StockInfra stockInfra;
    private final StoreInfra storeInfra;

    public UpdateStockProcessImpl(ProductInfra productInfra, StockInfra stockInfra, StoreInfra storeInfra) {
        this.productInfra = productInfra;
        this.stockInfra = stockInfra;
        this.storeInfra = storeInfra;
    }

    @Override
    public void validate(UpdateStockInput abstractProcessInput, Result result) {
        Product product = productInfra.findByReference(abstractProcessInput.getProductRef());
        if (product == null) {
            result.addErrorMessage(productInfra.getMessage("product.not.found"));
        } else {
            validateStock(abstractProcessInput, result);
            validateProductAvailability(product, result);
            valdiateStore(product, result);
        }

    }

    @Override
    public void run(UpdateStockInput abstractProcessInput, Result result) {
        Product product = productInfra.findByReference(abstractProcessInput.getProductRef());
        Stock stock = product.getStock();
        stock.setExposedQuantity(stock.getExposedQuantity() - abstractProcessInput.getQuantity());
        stock.setAvailableQuantity(stock.getAvailableQuantity() - abstractProcessInput.getQuantity());
        stockInfra.update(stock);
    }

    private void validateProductAvailability(Product product, Result result) {
        if (!product.getActive()) {
            result.addErrorMessage(productInfra.getMessage("product.not.available"));
        }

    }

    private void validateStock(UpdateStockInput abstractProcessInput, Result result) {
        Product product = productInfra.findByReference(abstractProcessInput.getProductRef());
        if (product.getStock() != null && product.getStock().getExposedQuantity() < abstractProcessInput.getQuantity()) {
            result.addErrorMessage(productInfra.getMessage("product.stock.not.enough"));
        }
    }

    private void valdiateStore(Product product, Result result) {
        // TODO document why this method is empty
    }
}
