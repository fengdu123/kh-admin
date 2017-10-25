package com.kh.admin.service;

import com.kh.admin.model.Person;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  在redis中存入list，并取出
 * @Date: Created in 15:53 2017/6/28
 */
public class RedisList{

    public static void main(String[] args) {
        //连接 Redis 服务
        Jedis jedis =  new Jedis( "127.0.0.1" ,6379);
        //密码验证-如果你没有设置 redis 密码可不验证即可使用相关命令
        //jedis.auth(" abcdefg ");
        //简单的key-value 存储
        jedis.set( "redis" ,  "myredis" );
        System. out .println(jedis.get( "redis" ));
        //在原有值得基础上添加,如若之前没有该key，则导入该key
        //之前已经设定了 redis 对应" myredis ",此句执行便会使 redis 对应" myredisyourredis"
        jedis.append( "redis" ,  "yourredis" );
        jedis.append( "content" ,  "rabbit" );
        // mset  是设置多个key-value值   参数（key1,value1,key2,value2,..., keyn , valuen ）
        // mget  是获取多个key所对应的value值  参数（key1,key2,key3,..., keyn ）  返回的是个list
        jedis.mset( "name1" , "yangw" , "name2" , "demon" , "name3" , "elena" );
        System. out .println(jedis.mget( "name1" , "name2" , "name3" ));
        //map
        Map<String,String> user =  new HashMap<String,String>();
        user.put( "name" ,  "cd" );
        user.put( "password" ,  "123456" );
        //map存入 redis
        jedis.hmset( "user" , user);
        // mapkey 个数
        System. out .println(String. format ( "len:%d" , jedis.hlen( "user" )));
        //map中的所有键值
        System. out .println(String. format ( "keys: %s" , jedis.hkeys( "user" ) ));
        //map中的所有value
        System. out .println(String. format ( "values: %s" , jedis.hvals( "user" ) ));
        //取出map中的name字段值
        List<String> rsmap = jedis.hmget( "user" ,  "name" , "password" );
        System. out .println(rsmap);
        //删除map中的某一个键值 password
        jedis.hdel( "user" ,  "password" );
        System. out .println(jedis.hmget( "user" ,  "name" ,  "password" ));
        //list
        jedis.del( "listDemo" );
        System. out .println(jedis.lrange( "listDemo" , 0, -1));
        jedis.lpush( "listDemo" ,  "A" );
        jedis.lpush( "listDemo" ,  "B" );
        jedis.lpush( "listDemo" ,  "C" );
        System. out .println(jedis.lrange( "listDemo" , 0, -1));
        System. out .println(jedis.lrange( "listDemo" , 0, 1));
        //set
        jedis.sadd( "sname" ,  "wobby" );
        jedis.sadd( "sname" ,  "kings" );
        jedis.sadd( "sname" ,  "demon" );
        System. out .println(String. format ( "set num: %d" , jedis.scard( "sname" )));
        System. out .println(String. format ( "all members: %s" , jedis.smembers( "sname" )));
        System. out .println(String. format ( "is member: %B" , jedis.sismember( "sname" ,  "wobby" )));
        System. out .println(String. format ( "rand member: %s" , jedis.srandmember( "sname" )));
        //删除一个对象
        jedis.srem( "sname" ,  "demon" );
        System. out .println(String. format ( "all members: %s" , jedis.smembers( "sname")));
    }

    @Test
    public void RedisPersonTest() throws IOException, ClassNotFoundException {
        //         Jedis redis = new   Jedis ("192.168.88.15");
        Jedis redis =  new Jedis( "127.0.0.1" , 6379);
        // connect可以不要，因为在执行set操作的时候会先进行判断客户端是否于服务器端建立了连接，若无，则启动连接过程
        redis.connect();
        String set = redis.set( "mingyuan" ,  "1" );
        System.out.println( " set result \t" + set);
        redis.incr( "mingyuan" );
        String string = redis.get( "mingyuan" );
        System.out.println( " get result of key 'mingyuan' \t" + string);
        // 下面是对对象进行存储的测试代码
        ByteArrayOutputStream bos =  new ByteArrayOutputStream();
        ObjectOutputStream oos =  new ObjectOutputStream(bos);
        Person person =  new Person( "liudehua" ,22);
        oos.writeObject(person);
        byte [] byteArray = bos.toByteArray();
        oos.close();
        bos.close();
        String setObjectRet = redis.set( "mingyuan" .getBytes(), byteArray);
        System.out.println( " set object return \t" + setObjectRet);
        byte [] bs = redis.get( "mingyuan" .getBytes());
        ByteArrayInputStream bis =  new ByteArrayInputStream(bs);
        ObjectInputStream inputStream =  new ObjectInputStream(bis);
        Person readObject = (Person) inputStream.readObject();
        System.out.println( " read object \t" + readObject.toString());
        inputStream.close();
        bis.close();
        redis.disconnect();

    }

    /**
     * 类名: RedisListJava </br>
     * 包名： com.souvc.redis
     * 描述: Redis Java List(列表) 实例  </br>
     * 开发人员： souvc  </br>
     * 创建时间：  2015-12-9 </br>
     * 发布版本：V1.0  </br>
     */
    @Test
    public void RedisListTest(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接本地的 Redis 服务成功！");

        // 存储数据到列表中
        jedis.lpush("kecheng", "java");
        jedis.lpush("kecheng", "php");
        jedis.lpush("kecheng", "Mysql");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("kecheng", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("redis list里面存储的值是:" + list.get(i));
        }
    }
}