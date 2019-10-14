package com.duanemngyan.demoo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.duanmengyan.demoo.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ReadProduct {
	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void testRead() {
		for (int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setId(i);
			product.setName("商品"+i);
			product.setPrice(1+i);
			product.setBaifen("80%");
			redisTemplate.opsForList().leftPush("redisList", product);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testList() {
		 List<Product> range = redisTemplate.opsForList().range("redisList", 0, -1);
		String jsonString = JSON.toJSONString(range);
		System.out.println(jsonString);
	}
	
	
}
