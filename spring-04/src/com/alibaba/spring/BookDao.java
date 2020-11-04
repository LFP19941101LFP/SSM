package com.alibaba.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	@Autowired
	JdbcTemplate j;
	
	/**
	 * 减余额,减去某个用户的余额
	 */
	public void updateBalance(String userName, int price) {
		String sql = "update account set balance = balance-? where username = ?";
		j.update(sql, price,userName);
	}
	
	/**
	 * 查询图书价格
	 * @param isbn
	 * @return
	 */
	public int getPrice(String isbn){
		String sql = "select price from book isbn = ?";
		return j.queryForObject(sql, Integer.class, isbn);
	}
	
	/**
	 * 减库存
	 * @param isbn
	 */
	public void updateStock(String isbn){
		String sql = "update book_stock set stock = stock-1 where isbn = ?";
		j.update(sql, isbn);
	}
	

}
