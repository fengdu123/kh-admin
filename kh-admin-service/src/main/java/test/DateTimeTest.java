package test;


import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  测试时间的格式
 * @Date: Created in 16:16 2017/7/3
 */
public class DateTimeTest {

    @Test
    public void subStringTest(){
       String date = DateTime.now().plusDays(-1).toString("yyyy-MM-dd");
       System.out.println(date);
        String y = date.substring(0, 4);
        System.out.println(y);
        String m = date.substring(5, 7);
        System.out.println(m);
        String d = date.substring(8, 10);
        System.out.println(d);

        date = y + "-" + m + "-" + d;
        System.out.println(date);
    }


    /**
     * 关于Joda时间的测试
     */
    @Test
    public void JodaTimeTest(){
        //得到一个DateTime的实体类
        DateTime nowTime = new DateTime();
        //获得今天开始的时间
        DateTime startOfDay =  nowTime.withTimeAtStartOfDay();
        System.out.println("获得今天开始的时间："+startOfDay.toString("YYYY-MM-dd"));
        //获得今天结束的时间
        DateTime endTime = nowTime.millisOfDay().withMaximumValue();
        System.out.println("获得今天结束的时间："+endTime);
        //在当前的时间上面加上90天
        System.out.println("在当前的时间上面加上90天："+startOfDay.plusDays(90).toString("YYYY-MM-dd HH:mm:ss"));
        //在当前时间上面加上90个小时
        System.out.println("在当前的时间上面加上90个小时："+startOfDay.plusHours(90).toString("YYYY-MM-dd HH:mm:ss:sss"));

        //将不同对象的传递给DateTime的构造函数
        System.out.println(new DateTime(Calendar.getInstance()));
        String timeString = "2017-07-03T13:30:00-06:00";
        //将字符串类型赋值给DateTime
        System.out.println(new DateTime(timeString));
        System.out.println(new DateTime("2006-01-26"));
        System.out.println(new DateTime("2006-01-26").toString("YYYY-MM-DD"));

        //LocalDate封装了年月日
        System.out.println("得到转换的时间："+new LocalDate("2017-07-03"));
        //LocalTime封装了一天中的某个时间
        System.out.println(new LocalTime(13,13,13,11));

        //比较两个时间的前后顺序
        if(new DateTime().withTimeAtStartOfDay().isBefore(nowTime.millisOfSecond().withMaximumValue().getMillis())){
            System.out.println("今天结束的时间大于今天开始的时间");
        }else{
            System.out.println("今天结束的时间小于今天开始的时间");
        }

        //比较两个时间的前后顺序
        if(new DateTime().withTimeAtStartOfDay().isAfter(nowTime.millisOfSecond().withMaximumValue().getMillis())){
            System.out.println("今天结束的时间大于今天开始的时间");
        }else{
            System.out.println("今天结束的时间小于今天开始的时间");
        }
    }

    @Test
    public void JodaTest(){

        //初始化时间
        DateTime dateTime=new DateTime(2012, 12, 13, 18, 23,55);
        System.out.println("得到初始化的时间："+dateTime);
        // 年,月,日,时,分,秒,毫秒
        DateTime dt3 = new DateTime(2011, 2, 13, 10, 30, 50, 333);// 2010年2月13日10点30分50秒333毫秒
        System.out.println("得到设定时间的格式:"+dt3);
        //下面就是按照一点的格式输出时间
        System.out.println(dateTime.toString("MM/dd/yyyy hh:mm:ss.SSSa"));
        System.out.println(dateTime.toString("dd-MM-yyyy HH:mm:ss"));
        System.out.println( dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa"));
        System.out.println(dateTime.toString("MM/dd/yyyy HH:mm ZZZZ"));
        System.out.println(dateTime.toString("MM/dd/yyyy HH:mm Z"));

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        //时间解析
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);
        System.out.println(dateTime2);

        //时间格式化，输出==> 2012/12/21 23:22:45 Fri
        String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE");
        System.out.println(string_u);

        //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
        String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.CHINESE);
        System.out.println(string_c);

        DateTime dt1 = new DateTime();// 取得当前时间

        // 根据指定格式,将时间字符串转换成DateTime对象,这里的格式和上面的输出格式是一样的
        DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2012-12-26 03:27:39");

        //计算两个日期间隔的天数
        LocalDate start=new LocalDate(2012, 12,14);
        LocalDate end=new LocalDate(2013, 01, 15);
        int days = Days.daysBetween(start, end).getDays();

        //计算两个日期间隔的小时数,分钟数,秒数

        //增加日期
        DateTime dateTime1 = DateTime.parse("2012-12-03");
        dateTime1 = dateTime1.plusDays(30);
        dateTime1 = dateTime1.plusHours(3);
        dateTime1 = dateTime1.plusMinutes(3);
        dateTime1 = dateTime1.plusMonths(2);
        dateTime1 = dateTime1.plusSeconds(4);
        dateTime1 = dateTime1.plusWeeks(5);
        dateTime1 = dateTime1.plusYears(3);

        // Joda-time 各种操作.....
        dateTime = dateTime.plusDays(1) // 增加天
                .plusYears(1)// 增加年
                .plusMonths(1)// 增加月
                .plusWeeks(1)// 增加星期
                .minusMillis(1)// 减分钟
                .minusHours(1)// 减小时
                .minusSeconds(1);// 减秒数

        //判断是否闰月
        DateTime dt4 = new DateTime();
        org.joda.time.DateTime.Property month = dt4.monthOfYear();
        System.out.println("是否闰月:" + month.isLeap());

        //取得 3秒前的时间
        DateTime dt5 = dateTime1.secondOfMinute().addToCopy(-3);
        dateTime1.getSecondOfMinute();// 得到整分钟后，过的秒钟数
        dateTime1.getSecondOfDay();// 得到整天后，过的秒钟数
        dateTime1.secondOfMinute();// 得到分钟对象,例如做闰年判断等使用

        // DateTime与java.util.Date对象,当前系统TimeMillis转换
        DateTime dt6 = new DateTime(new Date());
        Date date = dateTime1.toDate();
        DateTime dt7 = new DateTime(System.currentTimeMillis());
        dateTime1.getMillis();

}

    /**
     * Calendar关于时间的测试
     */
    @Test
    public void CalendarTimeTest(){
        // 完整显示今天日期时间
        String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date());
        System.out.println(str);

        Calendar calendar = Calendar.getInstance();
        try
        {
            // 对 calendar 设置时间的方法
            // 设置传入的时间格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            // 指定一个日期
            Date date = dateFormat.parse("2013-6-1 13:24:16");
            // 对 calendar 设置为 date 所定的日期
            calendar.setTime(date);
            System.out.println("得到赋值后的calendar时间："+calendar.getTime());
            // 按特定格式显示刚设置的时间
            str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
            System.out.println(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        // 或者另一種設置 calendar 方式
        // 分別爲 year, month, date, hourOfDay, minute, second
        calendar = Calendar.getInstance();
        calendar.set(2013, 1, 2, 17, 35, 44);
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println(str);

        // Calendar 取得当前时间的方法
        // 初始化 (重置) Calendar 对象
        calendar = Calendar.getInstance();
        // 或者用 Date 来初始化 Calendar 对象
        calendar.setTime(new Date());

        // setTime 类似上面一行
        // Date date = new Date();
        // calendar.setTime(date);

        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println(str);

        // 显示年份
        int year = calendar.get(Calendar.YEAR);
        System.out.println("year is = " + String.valueOf(year));

        // 显示月份 (从0开始, 实际显示要加一)
        int month = calendar.get(Calendar.MONTH);
        System.out.println("nth is = " + (month + 1));

        // 本周几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("week is = " + week);

        // 今年的第 N 天
        int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

        // 本月第 N 天
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

        // 3小时以后
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);

        // 当前分钟数
        int MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE = " + MINUTE);

        // 15 分钟以后
        calendar.add(Calendar.MINUTE, 15);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE + 15 = " + MINUTE);

        // 30分钟前
        calendar.add(Calendar.MINUTE, -30);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE - 30 = " + MINUTE);

        // 格式化显示
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 重置 Calendar 显示当前时间
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 创建一个 Calendar 用于比较时间
        Calendar calendarNew = Calendar.getInstance();

        // 设定为 5 小时以前，后者大，显示 -1
        calendarNew.add(Calendar.HOUR, -5);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 设定7小时以后，前者大，显示 1
        calendarNew.add(Calendar.HOUR, +7);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 退回 2 小时，时间相同，显示 0
        calendarNew.add(Calendar.HOUR, -2);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 得微秒级时间差
        long val = Calendar.getInstance().getTimeInMillis() - calendarNew.getInstance().getTimeInMillis();
        // 换算后得到天数
        long day = val / (1000 * 60 * 60 * 24);
        System.out.println(day);
    }
}
