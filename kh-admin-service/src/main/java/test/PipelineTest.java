package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  测试redis的管道优点 pipeline还是有明显的优势
 * @Date: Created in 20:32 2017/6/22
 */
public class PipelineTest {

    /**
     * 通过pipeline方式当有大批量的操作时候。我们可以节省很多原来浪费在网络延迟的时间。需要注意到是用 pipeline方式打包命令发送，
     * redis必须在处理完所有命令前先缓存起所有命令的处理结果。打包的命令越多，缓存消耗内存也越多。所以并是不是打包的命令越多越好。
     * 具体多少合适需要根据具体情况测试。
     */

    public static void main(String[] args) {
        int count = 1000;
        long start = System.currentTimeMillis();
        withoutPipeline(count);
        long end = System.currentTimeMillis();
        System.out.println("withoutPipeline: " + (end-start));
        start = System.currentTimeMillis();
        usePipeline(count);
        end = System.currentTimeMillis();
        System.out.println("usePipeline: " + (end-start));
    }

    private static void withoutPipeline(int count){
        Jedis jr = null;
        try {
            jr = new Jedis("localhost",6379);
            for(int i =0; i<count; i++){
                jr.incr("testKey1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(jr!=null){
                jr.disconnect();
            }
        }
    }

    private static void usePipeline(int count){
        Jedis jr = null;
        try {
            jr = new Jedis("localhost", 6379);
            Pipeline pl = jr.pipelined();  //pipeline还是有明显的优势
            for(int i =0; i<count; i++){
                pl.incr("testKey2");
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(jr!=null){
                jr.disconnect();
            }
        }
    }
}
