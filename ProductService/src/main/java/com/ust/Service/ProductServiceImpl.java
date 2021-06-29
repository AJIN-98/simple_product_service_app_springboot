package com.ust.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Repository.productRepository;
import com.ust.account.Converter.DtoConvert;
import com.ust.dto.ProductDto;
import com.ust.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	productRepository Repository;
	@Autowired
	DtoConvert convert;

	@Override
	public boolean addProduct(ProductDto product) {
		try {
			Repository.save(convert.dtoToEntity(product));
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(ProductDto product) {
		try {
			Product pro = Repository.getByProductId(product.getProductId());
			if (pro != null) {
				pro.setProductName(product.getProductName());
				pro.setProductDesc(product.getProductDesc());
				pro.setProductPrice(product.getProductPrice());
				pro.setSubscriptionType(product.getSubscriptionType());
				Repository.save(pro);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public ProductDto getProduct(int productId) {
		Product pro = Repository.getByProductId(productId);
		return convert.entityToDto(pro);
	}

}
