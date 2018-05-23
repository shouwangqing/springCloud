package com.qing.cloud.m1.ribbon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

//自定义负载均衡算法，每5次切换一个服务
public class MyRandomRule extends AbstractLoadBalancerRule{
	private final static Logger LOG=LoggerFactory.getLogger(MyRandomRule.class);
	
	private static Integer total=1;  //静态方法，共享数据 
	private static Integer index=0;
	
	public Server choose(ILoadBalancer lb,Object key) {
		if(lb==null) {
			return null;
		}
		Server server=null;
		
		while(server==null) {
			if(Thread.interrupted()) {
				return null;
			}
			
			List<Server> upList=lb.getReachableServers();
			List<Server> allList=lb.getAllServers();
			
			if(allList.size()==0) {
				return null;
			}
			
			if(total<=5) {
				server=upList.get(index);
				total++;
			}else {
				total=1;
				index++;
				if(index>=upList.size()) {
					index=0;
				}
			}
			
			if(server==null) {
				Thread.yield();
				continue;
			}
			
			if(server.isAlive()) {
				return (server);
			}
			
			server=null;
			Thread.yield();
		}
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		LOG.debug("total:==================================="+total);
		return choose(getLoadBalancer(),key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}


}