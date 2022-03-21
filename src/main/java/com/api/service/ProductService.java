package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exception.EmptyInputException;
import com.api.exception.NotExistIdException;
import com.api.model.Product;
import com.api.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
ProductRepository pr;

public Product  create(Product pro)
{
	if(pro.getName().isEmpty() || pro.getPrice()==null ) {
				throw new EmptyInputException("601","Input Field is empty"); 
			}
	return pr.save(pro);
}

public List<Product> findAll(){
	List<Product> list = pr.findAll();
		/*if(list.isEmpty()){
			throw new Message("no products yet.");
		}*/
	return list;  
}

public Product getOne(int idpro){
	return pr.findById(idpro).get(); 
}


public void delete (int idpro) {
	if(this.existsById(idpro)) {
		pr.deleteById(idpro);
	}
	throw new NotExistIdException("602","No exist Id");
}

public boolean existsById(int idpro) {
	return pr.existsById(idpro); 
}

}
