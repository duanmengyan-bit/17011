package com.duanmengyan.demoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.duanmengyan.demoo.domain.Product;

@Controller
public class ProductController {
	@Autowired
	RedisTemplate redisTemplate;
	
	@RequestMapping("findAll")
	public String findAll(Model model,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		List<Product> list = redisTemplate.opsForList().range("redisList", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		model.addAttribute("list", list);
		
		if(page!=1) {
			model.addAttribute("prePage",page-1);
		}else {
			model.addAttribute("prePage",1);
		}
		
		model.addAttribute("nextPage",page+1);
		return "list";
		
	}
	
}
