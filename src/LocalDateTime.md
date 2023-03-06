# LocalDateTiME以及时间相关类型
## 1.Date  
注意与sql.Date区分 sql.Date用于数据库没有格式化的Date,Date可读性差可以用simpleDateForMat,
但是simpleDateForMat线程不安全,计算时间也不方便。  
## 2. Canlendar 
可以用于获取并设置年、月、日、时、分、秒，它和Date比， 主要多了一个可以做简单的日期和时间运算的功能，Canlendar 
变量是全局变量，会导致脏变量情况产生， 并且这个共享变量没有做线程安全控制，也就是多线程的情况下是线程不安全的。
## 3. LocalDate、LocalTime、LocalDateTime
java8更新，API线程安全。  
LocalDate ：表示当前日期，相当于：yyyy-MM-dd  
LocalTime ：表示当前时间，相当于：HH:mm:ss (24小时制) 或者 hh:mm:ss(12小时制)  
LocalDateTime ：表示当前日期时间，相当于：yyyy-MM-ddTHH:mm:ss ,是前两者的结合  
DateTimeFormatter ：表示格式化类型，可以取代SimpleDateFormat  
Instant ：表示时刻，用来表示时间线上的一个点（瞬时），也可以说是时间戳  
ZoneId、ZoneOffset ：表示时区  
ZonedDateTime ：表示带时区的日期和时间，是前两者的结合  
Duration ：表示两个时刻之间的时间间隔  
Period ：表示两个日期之间的天数  
### String转LocalDateTime
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");  

LocalDateTime parse1 = LocalDateTime.parse("字符串", dateTimeFormatter);
### LocalDateTime转String
DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
String date = localDateTime.format(DATE_TIME_FORMATTER);