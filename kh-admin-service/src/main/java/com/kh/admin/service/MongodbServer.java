package com.kh.admin.service;


import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description: 在java中使用mongodb数据库
 * @Date: Created in 13:50 2017/7/30
 */

public class MongodbServer {
    /**
     * test方法的使用
     * 1.BeforeClass和Before在方法运行前执行，AfterClass和After会在所有方法运行前执行
     *
     *
     * @BeforeClass修饰的方法会在所有方法被调用前被执行，而且该方法是静态的，所以但测试类被加载后接着就会运行它，
     * 而且在内存中它只会存在一份实例，它比较适合加载配置文件。
     * 2.@AfterClass所修饰的方法通常用来对资源的清理，如关闭数据库的连接
     * 3.@Before和@After会在每个测试方法的前后各执行一次
     * 4.Ignore:所修饰的方法会被测试运行器忽略
     * <p>
     * 测试套件就是组织测试类一起运行的
     * 写一个作为测试套件的入口类，这个类里不包含其他的方法
     * 更改测试运行器Suite.class
     * 将要测试的类作为数组传入suite.SuiteClass({})
     */

    public static void main(String[] args) {
        try {

            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //连接到数据库
            MongoDatabase mongodbDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }


    //利用mongodb数据库无需用户名和密码验证。如果你的mongodb需要验证用户名及密码
    @Test
    public void UsernameAndPasswordTest() {

        try {
            //连接到Mongodb服务，如果是远程连接可以替换"localhost"为服务器所在IP地址
            //ServerAddress()两个参数分别为服务器地址和端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            MongoCredential credential = MongoCredential.createScramSha1Credential
                    ("username", "databaseName", "password".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取mongodb连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

    /**
     * @Author:wangyp
     * @Description
     * @return: 创建集合
     * @Date: Created int 16:19 2017/7/30
     */
    @Test
    public void createCollectionTest() {
        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("test");
            System.out.println("集合创建成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

    /**
     * @Author:wangyp
     * @Description: 获取集合
     * @return:
     * @Date: Created int 16:24 2017/7/30
     */
    @Test
    public void getCollectionTest() {

        try {
            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
            //获取到test集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合test选择成功");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

    /**
     * 插入文档
     * com.mongodb.client.MongoCollection类的insertMany()方法来插入一个文档
     */
    @Test
    public void insertManyTest() {
        try {

            //连接mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
            //连接到数据库中的集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合test 选择成功");
            //插入文档
            /**
             * 1.创建文档 org.bson.Dcument 参数为key-value 的格式
             * 2.创建文档集合 List<Document>
             * 3.将文档集合插入数据库集合中mongoCollection.insertManyTest(List<Document>) 插入单个文档可以用mongoCollection.insertOne(Document)
             */

            Document document = new Document("title", "MongoDB").
                    append("description", "database").append("likes", "100").append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }

    /**
     * 检索所有文档
     * 我们可以使用 com.mongodb.client.MongoCollection 类中的 find() 方法来获取集合中的所有文档
     */
    @Test
    public void findCollectionTest() {

        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 更新文档
     * 你可以使用 com.mongodb.client.MongoCollection 类中的 updateMany() 方法来更新集合中的文档。
     */
    @Test
    public void updateManyTest() {
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //查看更新前的文档
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
            //更新文档   将文档中likes=100的文档修改为likes=200 这里需要注意下，我们插进数据库的是一定字符串的likes，
            //所有在插入的时候，也需要转成字符串插入
            collection.updateOne(Filters.eq("likes", "100"), new Document("$set",new Document("likes","300")));
            //检索查看结果
            mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }

    /**
     * 删除第一个文档
     * 要删除集合中的第一个文档，首先你需要使用com.mongodb.DBCollection类中的
     * findOne()方法来获取第一个文档，然后使用remove 方法删除。
     */
    @Test
    public void findOneTest(){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");
            collection.findOneAndDelete(Filters.eq("likes","200"));

            //删除符合条件的第一个文档
//            collection.deleteOne(Filters.eq("likes", 100));
            //删除所有符合条件的文档
//            collection.deleteMany (Filters.eq("likes", 200));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }

}
