package com.ust.Service;

import com.ust.dto.ProductDto;

public interface ProductService {

	boolean addProduct(ProductDto product);
	boolean updateProduct(ProductDto product);
	ProductDto getProduct(int productId);
}
