package main;



import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DemoLocalDate{

    public static void main(String[] args) {
        //1.创建LocalDate,LocalDate对象直接调用now(),获取到当前日期
        LocalDate localDateNow = LocalDate.now();
        System.out.println("1.直接调用now()创建：" + localDateNow);
        //2.直接根据（年月日）创建,如：2021-05-20
        LocalDate localDateOf = LocalDate.of(2021, 5, 20);
        System.out.println("2.根据年月日创建：" + localDateOf);
        //3.直接根据某一年的某一天创建,如 2021年中第200天
        LocalDate localDateOfYearDay = LocalDate.ofYearDay(2021, 200);
        System.out.println("3.根据某一年的某一天创建：" + localDateOfYearDay);
        //4.根据java.time.temporal.TemporalAccessor创建(包括LocalDate,LocalDateTime等等)
        LocalDate localDateFrom = LocalDate.from(LocalDate.now());
        System.out.println("4.根据TemporalAccessor创建：" + localDateFrom);
        //5.根据时间字符串转化创建,调用parse(CharSequence text)方法,此方法只支持yyyy-MM-dd格式的值
        LocalDate localDateParse = LocalDate.parse("2021-05-11");
        System.out.println("5.根据时间字符串转化创建:" + localDateParse);
        //6.根据时间字符串转化创建,调用parse(CharSequence text, DateTimeFormatter formatter)方法,此时的text可以根据formatter多变
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDateParse2 = LocalDate.parse("20210515", formatter);
        System.out.println("6.根据时间字符串转化创建:" + localDateParse2);

    }
    @Test
    public void  demo1(){
        //此处采用LocalDate对象直接调用now(),获取到当前日期,注意：如果使用我的实例，结果会不一样，因为LocalDate.now()是调用时的日期
        LocalDate currentDate = LocalDate.now();
        //1.获取年、月、日、星期几、月中天、年中天、月数
        System.out.println("------------------1.获取年、月、日、星期几、月中天、年中天、月数-----------------------");
        System.out.println("1.获取到的当前日期：" + currentDate);
        System.out.println("1.获取到的年：" + currentDate.getYear());
        System.out.println("1.获取到的月：" + currentDate.getMonthValue());
        System.out.println("1.获取到的一月中的哪一天：" + currentDate.getDayOfMonth());
        System.out.println("1.获取到的一周中的星期几：" + currentDate.getDayOfWeek().getValue());
        System.out.println("1.获取到的一年的第多少天：" + currentDate.getDayOfYear());
        System.out.println("1.获取到的一年有多少天：" + currentDate.lengthOfYear());
        System.out.println("1.获取到的一年有多少月：" + currentDate.lengthOfMonth());
        //2.时间的计算
        System.out.println("-----------------2.时间的计算,主要是加减法------------------------");
        System.out.println("2.获取到的当前日期：" + currentDate);
        System.out.println("2.加法，当前日期上加2年：" + currentDate.plusYears(2));
        System.out.println("2.加法，当前日期上加3个月：" + currentDate.plusMonths(3));
        System.out.println("2.加法，当前日期上加20天：" + currentDate.plusDays(20));
        System.out.println("2.加法，当前日期上加一周：" + currentDate.plusWeeks(1));
        System.out.println("2.减法，当前日期上减2年：" + currentDate.minusYears(2));
        System.out.println("2.减法，当前日期上减3个月：" + currentDate.minusMonths(3));
        System.out.println("2.减法，当前日期上减20天：" + currentDate.minusDays(20));
        System.out.println("2.减法，当前日期上减一周：" + currentDate.minusWeeks(1));
        //3.时间的判断及转化
        System.out.println("-----------------3.时间的判断及格式化(格式化的类型很多)------------------------");
        //新建一个格式化类型
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        //新创建一个LocalDate日期进行比较
        LocalDate localDateOf = LocalDate.of(2020, 5, 20);
        System.out.println("3.当前日期转成yyyyMMdd型的字符串：" + currentDate.format(formatter));
        System.out.println("3.当前日期是否在一个日期之后：" + currentDate.isAfter(localDateOf));
        System.out.println("3.当前日期是否在一个日期之前：" + currentDate.isBefore(localDateOf));
        System.out.println("3.当前日期是否是闰年：" + currentDate.isLeapYear());
        System.out.println("3.2020-05-20是否是闰年：" + localDateOf.isLeapYear());
        //4.根据指定数据获取日期或者时间(LocalTime)
        System.out.println("-----------------4.根据指定数据获取日期或者时间(LocalTime)------------------------");
        System.out.println("4.获取到的当前日期：" + currentDate);
        System.out.println("4.修改年数为1999年：" + currentDate.withYear(1999));
        System.out.println("4.修改月数为10月：" + currentDate.withMonth(10));
        System.out.println("4.修改天数为当月12日：" + currentDate.withDayOfMonth(12));
        System.out.println("4.获取到的当前日期的开始时间：" + currentDate.atStartOfDay());
        System.out.println("4.根据指定的时、分、秒获取时间：" + currentDate.atTime(12, 23, 45));
        System.out.println("4.根据时间LocalTime对象获取时间：" + currentDate.atTime(LocalTime.now()));
    }
    @Test
    public void demo2(){
        //1.LocalTime,LocalTime对象直接调用now(),获取到当前时间
        LocalTime now = LocalTime.now();
        System.out.println("1.获取到的当前时间：" + now);
        //2.根据指定的时分秒生成时间
        LocalTime localTimeOf = LocalTime.of(23, 59, 59);
        System.out.println("2.根据指定的时分秒生成时间：" + localTimeOf);
        //3.根据指定的时分秒生成时间
        LocalTime localTimeParse = LocalTime.parse("12:23:45");
        System.out.println("3.根据指定的时分秒生成时间：" + localTimeParse);
        //4.根据指定的时分秒和格式化类型生成时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");//注意：HH是24小时制，hh是12小时制，时间类型的不要出现年月日如：yyyyMMdd
        LocalTime localTimeParseWithFormatter = LocalTime.parse("102008", formatter);
        System.out.println("4.根据指定的时分秒和格式化类型生成时间：" + localTimeParseWithFormatter);
        //5.根据时间对象TemporalAccessor生成
        LocalTime initTime = LocalTime.of(11, 59, 59);
        System.out.println("5.根据时间对象TemporalAccessor生成:" + LocalTime.from(initTime));
    }
    @Test
    public void demo3(){
        //1.LocalDateTime对象直接调用now(),获取到当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("1.LocalDateTime对象直接调用now()获取到的时间：" + localDateTime);
        //2.根据年月日时分秒构造（此处方法比较多，不一一介绍）
        LocalDateTime localDateTimeOf = LocalDateTime.of(2021, 5, 10, 18, 30, 26);
        System.out.println("2.根据年月日时分秒构造获取到的时间：" + localDateTimeOf);
        //3.根据LocalDate和LocalTime得到(在有日期和时间的情况下可以使用)
        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("3.根据LocalDate和LocalTime得到:" + of);
        //4.LocalDate指定一个LocalTime(LocalDate只有年月日)
        LocalTime localTimeInit = LocalTime.of(14, 25, 25);
        LocalDateTime localDateWithLocalTime = LocalDate.now().atTime(localTimeInit);
        System.out.println("4.LocalDate指定一个LocalTime:" + localDateWithLocalTime);
        //5.LocalTime指定一个LocalDate(LocalTime只有时分秒)
        LocalDate localDateInit = LocalDate.of(1998, 10, 1);
        LocalDateTime localTimeWithLocalDate = LocalTime.now().atDate(localDateInit);
        System.out.println("5.LocalTime指定一个LocalDate:" + localTimeWithLocalDate);
}
    @Test
    public void demo4(){
        String date="2021-05-10T18:30:26";//定义字符串
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:ss:mm");
        LocalDateTime parse1 = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println(parse1);

        LocalDateTime now = LocalDateTime.now();
        String date1=dateTimeFormatter.format(now);
        System.out.println(date1);
    }

}