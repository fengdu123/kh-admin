package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  测试是否能连上本地的redis
 * @Date: Created in 17:30 2017/6/22
 */
public class RedisTest {

    /**
    * @Author:wangyp
    * @Description:  测试是否连上redis
     * @param
    * @return:
    * @Date: Created int 17:39 2017/6/22
    */
    @Test
    public void linkUpRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
    }

    /**
    * @Author:wangyp
    * @Description:  在redis上面set一个值，并得到這个值
     * @param
    * @return:
    * @Date: Created int 17:40 2017/6/22
    */
    @Test
    public void stringRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
    }

    /**
    * @Author:wangyp
    * @Description: 在redis上面设置一个list集合并输出這个list集合
     * @param
    * @return:
    * @Date: Created int 17:41 2017/6/22
    */
    @Test
    public void listRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }

    /**
    * @Author:wangyp
    * @Description: 输出redis上面所有的key值
     * @param
    * @return:
    * @Date: Created int 17:42 2017/6/22
    */
    @Test
    public void keysRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }

}
