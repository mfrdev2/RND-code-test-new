import model.DeviceTokenBean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

}
