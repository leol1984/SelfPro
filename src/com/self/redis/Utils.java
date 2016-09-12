package com.self.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Utils {
	private static final String ip = "127.0.0.1";
	private static final Integer port = 6379;
	
	public  Jedis connection() throws Exception{
		Jedis jedis = new Jedis(ip,port);
		return jedis;
	}
	 
	public static Utils createFactory() throws Exception{
		return new Utils();
	}
}
