package com.alibaba.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookDao b;
	
	public void checkOut(String userName, String isbn) {
		//减库存
		b.updateStock(isbn);
		int price = b.getPrice(isbn);
		//减余额
		b.updateBalance(userName, price);
	}

}
