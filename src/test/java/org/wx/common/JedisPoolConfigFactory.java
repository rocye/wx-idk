package org.wx.common;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 单例Redis连接池配置
 * @author Rocye
 * @version 2017.08.21
 */
public class JedisPoolConfigFactory {
	
	private JedisPoolConfig config;

	private JedisPoolConfigFactory() {
		config = new JedisPoolConfig();
		//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
    	config.setBlockWhenExhausted(true);
    	//设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
    	config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
    	//是否启用pool的jmx管理功能, 默认true
    	config.setJmxEnabled(true);
    	//是否启用后进先出, 默认true
    	config.setLifo(true);
    	//最大空闲连接数, 默认8个
    	config.setMaxIdle(Integer.parseInt(Config.getAttribute("maxIdle")));
    	//最大连接数, 默认8个
    	config.setMaxTotal(Integer.parseInt(Config.getAttribute("maxTotal")));
    	//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
    	config.setMaxWaitMillis(Integer.parseInt(Config.getAttribute("maxWait")));
    	//最小空闲连接数, 默认0
    	config.setMinIdle(Integer.parseInt(Config.getAttribute("minIdle")));
    	//在获取连接的时候检查有效性, 默认false
    	config.setTestOnBorrow(Boolean.parseBoolean(Config.getAttribute("testOnBorrow")));
    	//在空闲时检查有效性, 默认false
    	config.setTestWhileIdle(Boolean.parseBoolean(Config.getAttribute("testOnReturn")));
	}

	private static class SingletonHolder {
		private static JedisPoolConfigFactory instance = new JedisPoolConfigFactory();
	}

	public static JedisPoolConfig getInstance() {
		return SingletonHolder.instance.config;
	}
	
}
