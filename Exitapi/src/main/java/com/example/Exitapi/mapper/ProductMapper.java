package com.example.Exitapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Exitapi.dto.ProductDTO;
import com.example.Exitapi.dto.UserDTO;
import com.example.Exitapi.entity.Product;
import com.example.Exitapi.entity.User;

public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductDTO productDto;
	
	public ProductDTO producttodto(Product product) {
		ProductDTO productdto = mapper.map(product,ProductDTO.class);
		return productdto;
		
	}
	
	public Product dtotoproduct(ProductDTO productdto) {
		Product product =mapper.map(productdto, Product.class);
		return product;
	}

}
