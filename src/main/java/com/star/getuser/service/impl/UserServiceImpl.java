package com.star.getuser.service.impl;

import com.star.getuser.dao.UserDao;
import com.star.getuser.entity.User;
import com.star.getuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //    --------------------------------------------------------------------------
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Map<String, Object> getCreateTime(String timeRange) {
        List<User> all = userDao.getAll();

        List<String> dateRange;
        LocalDate today = LocalDate.now();
        switch (timeRange) {
            case "week":
                LocalDate lastWeek = today.minusWeeks(1);
                dateRange = getDateRange(lastWeek, today);
                break;
            case "month":
                LocalDate lastMonth = today.minusMonths(1);
                dateRange = getDateRange(lastMonth, today);
                break;
            case "month3":
                LocalDate threeMonthsAgo = today.minusMonths(3);
                dateRange = getDateRange(threeMonthsAgo, today);
                break;
            case "month6":
                LocalDate sixMonthsAgo = today.minusMonths(6);
                dateRange = getDateRange(sixMonthsAgo, today);
                break;
            default:
                dateRange = new ArrayList<>();
        }

        int[] countArray = new int[dateRange.size()];
        for (User user : all) {
            String date = userDateToString(user.getCreatetime());
            int index = dateRange.indexOf(date);
            if (index != -1) {
                countArray[index]++;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("date", dateRange);
        result.put("count", countArray);

        return result;
    }

    private List<String> getDateRange(LocalDate startDate, LocalDate endDate) {
        List<String> dateRange = new ArrayList<>();
        LocalDate current = startDate;
        while (!current.isAfter(endDate)) {
            dateRange.add(current.toString());
            current = current.plusDays(1);
        }
        return dateRange;
    }

    private String userDateToString(long timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(timestamp);
        return simpleDateFormat.format(date);
    }
//-----------------------------------------------------------------------------------------------------
    @Override
    public Map<String, Object> compare(@Value("month") String timeRange) throws ParseException {
        Map<String, Object> resultMap = new HashMap<>();

        List<User> all = userDao.getAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<String> months = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        for (User user : all) {
            Date date = new Date(user.getCreatetime());
            String dateString = simpleDateFormat.format(date);

            // 获取日期中的年份和月份
            String yearMonth = dateString.substring(0, 7);

            if (!months.contains(yearMonth)) {
                months.add(yearMonth);
                nums.add(1);
            } else {
                int index = months.indexOf(yearMonth);
                int count = nums.get(index);
                nums.set(index, count + 1);
            }
        }

        resultMap.put("month", months);
        resultMap.put("num", nums);

        return resultMap;
    }

//  -------------------------------------------------------------------------------------------------------------------
@Override
    public Map<String, Object> getSource() {
        List<User> userList = userDao.getAll(); // 获取所有用户数据

        Map<String, Integer> sourceCount = new HashMap<>(); // 存储每个 category 的数量

        for (User user : userList) {
            String category = user.getUsersource();

            // 只处理非空的 category
            if (category != null && !category.isEmpty()) {
                sourceCount.put(category, sourceCount.getOrDefault(category, 0) + 1);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("categories", sourceCount.keySet()); // 获取所有种类
        resultMap.put("sourceCount", sourceCount.values()); // 种类对应的数量

        return resultMap;
    }
}



