/*
package com.star.getuser;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.star.getuser.dao.UserDao;
import com.star.getuser.entity.User;
import com.star.getuser.entity.po.count;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class GetUserApplicationTests {

    @Autowired
    private UserDao userDao;

    GetUserApplicationTests() throws JsonProcessingException {
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testTime(@Value("week") String timeRange) throws ParseException, JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<String> mydate = new ArrayList<>();
        List<User> all = userDao.getAll();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < all.size(); i++) {
            Date date = new Date(all.get(i).getCreatetime());
            String s = simpleDateFormat.format(date);
            mydate.add(s);
        }

        Date today = new Date();
        List<DateTime> dateRange;
        switch (timeRange) {
            case "week":
                // offsetDay 计算时间的一个工具方法
                // rangeToList 返回从开始时间到结束时间的一个时间范围
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -6), today, DateField.DAY_OF_WEEK);
                break;
            case "month":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -29), today, DateField.DAY_OF_MONTH);
                break;
            case "month3":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -89), today, DateField.DAY_OF_MONTH);
                break;
            case "month6":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -179), today, DateField.DAY_OF_MONTH);
                break;
            default:
                dateRange = new ArrayList<>();
        }


        map.put("date", dateRange);
        List<String> dateList = new ArrayList<>(); // 日期列表
        List<Integer> countList = new ArrayList<>();
        for (DateTime dateTime : dateRange) {
            String dateStr = DateUtil.format(dateTime, "yyyy-MM-dd");
            dateList.add(dateStr);
        }
        for (String date : dateList) {
            int count = 0;
            for (User user : all) {
                String userDate = simpleDateFormat.format(new Date(user.getCreatetime()));
                if (date.equals(userDate)) {
                    count++;
                }
            }
            countList.add(count);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("date", dateList);
        resultMap.put("count", countList);
//        map.put("count",countList);
        System.out.println(map);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(resultMap);
        System.out.println(jsonResult);

        */
/*
         //测试
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = df.parse("2023-06-29");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long timestamp = cal.getTimeInMillis();

        System.out.println(timestamp);
        System.out.println(count);
        System.out.println("__________________");
        for (int i = mydate.size()-1; i >=0; i--) {
            System.out.println(mydate.get(i));

        }*//*



    }

    @Test
    public void testCount(@Value("month") String timeRange) throws ParseException {
        Map<String, Integer> monthCounts = new HashMap<>();

        List<User> all = userDao.getAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (User user : all) {
            Date date = new Date(user.getCreatetime());
            String dateString = simpleDateFormat.format(date);

            // 获取日期中的年份和月份
            int year = Integer.parseInt(dateString.substring(0, 4));
            int month = Integer.parseInt(dateString.substring(5, 7));

            // 计算日期对应的年份和月份的 key
            String key = year + "-" + month;

            // 更新相应月份的人数统计
            monthCounts.put(key, monthCounts.getOrDefault(key, 0) + 1);
        }

        // 打印每个月份的人数
        for (Map.Entry<String, Integer> entry : monthCounts.entrySet()) {
            String month = entry.getKey();
            int count = entry.getValue();
            System.out.println(month + ": " + count);
        }
    }
}
*/
