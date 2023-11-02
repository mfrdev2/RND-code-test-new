package com.mfrdev.test;

import com.mfrdev.test.model.DeviceTokenBean;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public void predicate(){
        List<DeviceTokenBean> deviceTokenList = getDeviceTokenList();
        List<DeviceTokenBean> collect = deviceTokenList.stream().filter(distinctByKey(DeviceTokenBean::getDeviceType)).collect(Collectors.toList());

        System.out.println(collect);


    }

    public   <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        System.out.println();
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        Boolean web = map.put("web", true);
        System.out.println("F "+web);
        return t -> {
            Object apply = keyExtractor.apply(t);
            System.out.println(apply);
            Boolean aBoolean = map.putIfAbsent(apply, Boolean.TRUE);
            System.out.println(aBoolean);
            boolean b = aBoolean == null;
            System.out.println(b);
            return b;
        };
    }

    public List<DeviceTokenBean> getDeviceTokenList(){
        return Arrays.asList(
                new DeviceTokenBean("web"),
                new DeviceTokenBean("web"),
                new DeviceTokenBean("ios")
        );
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // Get the current date and time
        cal.setTime(new Date());

        // Set the time to the start of the day (midnight)
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dayStart = cal.getTime();

        // Set the time to the end of the day (just before midnight)
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        Date dayEnd = cal.getTime();

        System.out.println("Start of the day: " + dayStart);
        System.out.println("End of the day: " + dayEnd);
    }

}
