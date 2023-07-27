package com.mfrdev.test;

import com.mfrdev.test.comress.FileCompress;
import com.mfrdev.test.enumUtils.DeviceType;
import com.mfrdev.test.factor.Factor;
import com.mfrdev.test.model.DDL;
import com.mfrdev.test.model.DeviceTokenBean;
import com.mfrdev.test.regularExpression.Rx;
import com.mfrdev.test.time.TimeUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    static ModelMapper modelMapper;

    static {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    private static final List<DDL> ddlList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        populateDDL();
        System.out.println(ddlList);


        Map<String, String> listMap = ddlList.stream().collect(Collectors.toMap(DDL::getTextEn, DDL::getId, (a, b) -> a, LinkedHashMap::new));

        listMap.putAll(ddlList.stream().collect(Collectors.toMap(DDL::getTextBn, DDL::getId, (a, b) -> a)));


        System.out.println(listMap);

        String name = "report";

        Pattern pattern = Pattern.compile(Rx.PERSON_NAME_REX);

        Matcher matcher = pattern.matcher(name);
        boolean matches = matcher.matches();
        System.out.println(matches);


        new Test().predicate();

        String replace = name.replace("FA", "xa");
        System.out.println(replace);

        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());

        Field[] allFields = Factor.getAllFields(DeviceTokenBean.class);
        for (Field f : allFields
        ) {
            System.out.println(f);
        }
        Map<String,String> quaryParam = new LinkedHashMap<>();
        quaryParam.put("userId","Aditto");
        DeviceTokenBean map = modelMapper.map(quaryParam, DeviceTokenBean.class);

        System.out.println(map.toString());

        textLocalDataRx("2021-02-15");

//        String ss = null;
//
//        if(ss == null){
//            ss = "";
//        }
//        String s = Instant.now().toString();
//        System.out.println(s);
//
//        String di = "15";
//
//        System.out.println(di.matches(RX_FOR_IS_DIGIT));
        Date date = new Date();
        boolean isBoo = TimeUtils.isTimeIntervalOver(date,2);

        String s = " ";
        String w = "";

        System.out.println(Objects.equals(s,w));

        System.out.println(isBoo);

        System.out.println(DeviceType.WEB);


        System.out.println(checkEmail("md@gmail.com"));

        System.out.println("====================================================");
        System.out.println();

String inputFilePath = "C:\\Users\\User\\FingerprintApplication\\RIGHT_HAND\\FINAL\\fp_right_hand.bmp";
        try {
            FileCompress.imageCompress(new File(inputFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println();


    }

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    private static boolean checkEmail(String emailAddresses){
        String[] emails = emailAddresses.split(",");
        for (String email : emails) {
            if(!email.matches(EMAIL_REGEX)){
                return false;
            }
        }
        return true;
    }

    private static String getServiceFormScriptInfoData(String data) {
        String[] split = data.split(";");
        String replace = split[0].replace("||", "-");
        String[] split1 = replace.split("-");
        return split1[3];
    }

    public static<K, V> void removeNullsOrEmptyElement(Map<K, V> map)
    {
        Iterator<Map.Entry<K, V>> itr = map.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<K, V> curr = itr.next();
            if (curr.getValue() == null || curr.getValue().equals("") || curr.getValue().equals("null")) {
                itr.remove();
            }
        }
    }

    private static void populateDDL() {
        ddlList.addAll(Arrays.asList(
                new DDL("Dhaka", "Dha"),
                new DDL("Rajshahi", "Raj"),
                new DDL("Khulna", "khul"),
                new DDL("Khulna", "khul")
        ));
    }

    private static void textLocalDataRx(String dateString){
        if (dateString.matches(Rx.RX_FOR_LOCAL_DATE)) {
            LocalDate date = LocalDate.parse(dateString);
            System.out.println(date);
        }else {
            System.out.println("Date not a local date format");
        }
    }


}