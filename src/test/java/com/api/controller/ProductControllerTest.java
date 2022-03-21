package com.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.service.ProductService;

public class ProductControllerTest {

	@Autowired
	ProductService ps;
	
	@Test
	void createProduct() {
		/*Product pro = new Product();
		pro.setId(4);
		pro.setName("Atun");
		pro.setPrice(3.0);
		pro.setDescription("Atun enlatado grande");
		ProductService ps = new ProductService();
		Product pro2 = ps.create(pro);
		assertEquals(pro,pro2);*/
	}
}
