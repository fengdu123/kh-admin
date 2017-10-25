package com.kh.admin.service;


import com.mongodb.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description: mongodb事务操作
 * @Date: Created in 21:07 2017/8/17
 */
public class MongodbUtils {

    /**
     * 连接数据库  获得一个数据库对象,mydb为数据库民称
     * 声明一个Collection对象
     *
     * @return
     * @throws Exception
     */
    public DBCollection beforeTest() throws Exception {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("mydb");
        DBCollection collection = db.getCollection("user");
        return collection;

    }

    /**
     * 连接mongodb数据库并生成一个集合
     */
    @Test
    public void ConnectTest() throws Exception {
        //声明一个collection对象
        DBCollection collection = beforeTest();
        //声明一个document文档对象,用户存储数据
        BasicDBObject doc = new BasicDBObject();
        doc.put("name", "suruonian");
        doc.put("email", "dennisit@163.com");
        BasicDBObject experience = new BasicDBObject();
        experience.put("year of 2012", "i work in hangzhou");
        experience.put("year of 2013", "i work in shenzhen");
        doc.put("work experience", experience);
        //调用collection的insert方法,将数据持久化到磁盘上.
        collection.insert(doc);
        System.out.println("test data insert finish ");

    }

    /**
     * 通过findOne()查询一条数据
     *
     * @throws Exception
     */
    @Test
    public void findOneTest() throws Exception {

        //声明一个collection对象
        DBCollection collection = beforeTest();
        DBObject userdoc = collection.findOne();
        System.out.println("查询到的一条记录为:" + userdoc);
    }

    /**
     * mongodb更新数据库
     */
    @Test
    public void updateMongodbTest() throws Exception {

        //声明collection对象
        DBCollection collection = beforeTest();
        //定义一个查询对象,
        DBObject updateAim = new BasicDBObject();
        updateAim.put("name", "suruonian");
        System.out.println("通过用户名查找到的对象为:" + collection.findOne(updateAim));
        //定义一个更新对象,类似于set语句
        DBObject updatedValue = new BasicDBObject();
        updatedValue.put("name", "dennisit");
        //db.user.update({name："suruonian"},{$set:{name：dennisit}});
        DBObject updateSetValue = new BasicDBObject("$set", updatedValue);
        //将查询对象和更新对象作为参数传给update来完成更新.
        collection.update(updateAim, updateSetValue);
        System.out.println("更新后查询到的一条记录为:" + collection.findOne());
    }

    /**
     * mongoDB删除数据
     * 删除操作user集合中name为dennisit的用户
     *
     * @throws Exception
     */
    @Test
    public void deleteMongodbTest() throws Exception {
        //声明collection对象
        DBCollection collection = beforeTest();
        //定义一个查询对象,
        DBObject aimObj = new BasicDBObject();
        aimObj.put("name", "dennisit");
        System.out.println("通过用户名查找到的对象为:" + collection.findOne(aimObj));
        collection.remove(aimObj);
        System.out.println("删除后查询到的一条记录为:" + collection.findOne());
    }

    /**
     * mongodb保证事务的一致性
     * mongo有个内置的连接池(连接池默认可容纳10个数据库连接),在有大量写和读的环境中,为了确保在一个session中使用同一个DB时,
     * 可以通过DB类的requestStart()方法打开失去控制,待所有业务代码编写完毕后,再通过DB类的requestDone()方法结束事物控制.
     * 这样就保证了事物的原子性.
     *
     * mongobd库级别操作
     * @throws Exception
     */
    @Test
    public void RequestMongodbTest() throws Exception {
        Mongo mongo = null;
        try{
            mongo = new Mongo("127.0.0.1",27017);
            DB db = mongo.getDB("admin");
            //getAddress方法获取IP和端口
            System.out.println("当前连接的IP和端口为:" + mongo.getAddress());
            //列出所有数据库,此操作只针对超级用户
            System.out.println("系统中的所有数据库为:" + mongo.getDatabaseNames());
            //删除数据库,此操作只针对超级用户
            mongo.dropDatabase("testdb");
            System.out.println("系统中的所有数据库为:" + mongo.getDatabaseNames());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
