package com.nineleaps.order.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nineleaps.order.model.Product;

@FeignClient(name="nineleaps-apigateway") // it'll worke with zuul gateway
//@FeignClient(name="nineleaps-registry", url="localhost:1020")
@RibbonClient(name="product")
public interface ProductProxy {
	
	@GetMapping("/product/product/{id}")
	public Product checkProductAvailability( @PathVariable("id") String string);

}