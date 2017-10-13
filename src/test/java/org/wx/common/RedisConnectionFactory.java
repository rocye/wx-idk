package org.wx.common;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池工厂
 * @author Rocye
 * @version 2015-05-22
 */
public class RedisConnectionFactory {
    private final static Logger logger = Logger.getLogger(RedisConnectionFactory.class.getName());
    
    private static JedisPool pool = null;
    private static int _dbNum = 0;
    
    public synchronized static JedisPool getPool(){
        if(pool == null){
        	JedisPoolConfig config = JedisPoolConfigFactory.getInstance();
            _dbNum = Integer.parseInt(Config.getAttribute("dbnum"));
            if(Config.getAttribute("pass") == null){
                pool = new JedisPool(config, Config.getAttribute("host"), Integer.parseInt(Config.getAttribute("port")), Integer.parseInt(Config.getAttribute("timeout")));
            }else{
                pool = new JedisPool(config, Config.getAttribute("host"), Integer.parseInt(Config.getAttribute("port")), Integer.parseInt(Config.getAttribute("timeout")), Config.getAttribute("pass"));
            }
        }
        return pool;
    }
    
    public static Jedis getJedisInstance(){
        Jedis jedis = null;
        try {
            getPool();
            if(pool != null){
                jedis = pool.getResource();
                jedis.select(_dbNum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("从pool中获取链接时：" + ex.toString());
        }
        return jedis;
    }
    
}

