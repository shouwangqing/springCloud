package com.qing.cloud.m1.api.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qing.cloud.m1.api.entity.Dept;

/**
 * 1、不能写@GetMapping()或@PostMapping；
 * 2、实体参数，要加@RequestBody，以实体方式传
 * 3、对于参数的注解要写内容不能为空，如@PathVariable("id")
 */
@FeignClient(name="qing-cloud-m1-provider",fallback=DeptServiceHystrix.class)
public interface DeptService {

	String PREFIX="dept";
	
	@RequestMapping(PREFIX+"/add")  
	public boolean add(@RequestBody Dept dept);
	
	@RequestMapping(PREFIX+"/find/{id}")
	public Dept findById(@PathVariable("id")Integer id);
	
	@RequestMapping(PREFIX+"/findAll")
	public List<Dept> findAll();
}




/**
 * 覆盖feign默认值
 * 解码：ResponseEntityDecoder
 * 编码：SpringEncoder
 * 日志：Slf4jLogger
 * 协议Contract：SpringMvcContract
 * builder: HystrixFeign.Builder
 * client: LoadBalancerFeignClient (在使用ribbon时)
 */
//@FeignClient(name="qing-cloud-m1-provider",fallback=DeptServiceHystrix.class)
//public interface DeptService {
//
//	String PREFIX="dept";
//	
//	@RequestMapping(PREFIX+"/add")  
//	public boolean add(@RequestBody Dept dept);
//	
//	@RequestMapping(PREFIX+"/find/{id}")
//	public Dept findById(@PathVariable("id")Integer id);
//	
//	@RequestMapping(PREFIX+"/findAll")
//	public List<Dept> findAll();
//}
