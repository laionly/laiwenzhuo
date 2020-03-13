package com.ep.ep.dao.producttype;

import java.util.List;

import com.ep.ep.entity.Product_type;

public interface ProductTypeDao {
    public void deleteProductType(Integer ptid);
    
    public void saveProductType(Product_type product_type);
    
    public Product_type findProductType(Integer ptid);
    
    public List<Product_type> findAllProducttype();
}
