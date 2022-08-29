package cn.itcast.user.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

//Jedis连接池的工具类

public class JedisUtils {
private static JedisPool jedisPool = null;

//创建连接池的操作只需要做一次，所以将代码放在静态代码块中
static {

        //是jdk中提供的工具类，可以很快捷的获取properties文件的内容
        //getBundle方法参数我们要传递properties文件的路径，这个路径是基于类路径的。
        //注意：如果在getBundle写properties文件的路径，一定要省略扩展名
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");
        //通过bundle直接获取properties配置文件中的内容
        String maxTotal = bundle.getString("jedis.maxTotal");
        String maxIdle = bundle.getString("jedis.maxIdle");
        String maxWaitMillis = bundle.getString("jedis.maxWaitMillis");
        String host = bundle.getString("jedis.host");
        String port = bundle.getString("jedis.port");

        // 创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));//最大连接数
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));//最大空闲数
        jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(maxWaitMillis));//最大等待时间
        //创建连接池对象【指定redis服务器的ip地址和端口号】
        jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));


        }

    /*
        提供获取Jedis连接的方法
     */
public static Jedis getJedis() {

        //从连接池获取连接
        Jedis jedis = jedisPool.getResource();
        //将连接返回
        return jedis;
        }
}
