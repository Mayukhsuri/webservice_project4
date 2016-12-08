package com.web.service.resource.product;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import com.web.service.representation.product.ProductRepresentation;
import com.web.service.representation.product.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> searchProduct(String productName);

	public ProductRepresentation getProduct(int productId);

	public ProductRepresentation addProduct(ProductRequest productRequest);

}
