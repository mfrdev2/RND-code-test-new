import model.DDL;
import model.DeviceTokenBean;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String PERSON_NAME_REX = "^[a-zA-Z]+(([',. --'][a-zA-Z ])?[a-zA-Z]*)*$";
    private static final List<DDL> ddlList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello world!");
        populateDDL();
        System.out.println(ddlList);


        Map<String, String> listMap = ddlList.stream().collect(Collectors.toMap(DDL::getTextEn, DDL::getId, (a, b) -> a,LinkedHashMap::new));

        listMap.putAll(ddlList.stream().collect(Collectors.toMap(DDL::getTextBn,DDL::getId,(a,b)->a)));



        System.out.println(listMap);

        String name = "MD Fazle RABBI";

        Pattern pattern = Pattern.compile(PERSON_NAME_REX);

        Matcher matcher = pattern.matcher("");
        boolean matches = matcher.matches();
        System.out.println(matches);


        new Test().predicate();

        String replace = name.replace("FA", "xa");
        System.out.println(replace);




    }

    private static String getServiceFormScriptInfoData(String data){
        String[] split = data.split(";");
        String replace = split[0].replace("||", "-");
        String[] split1 = replace.split("-");
        return split1[3];
    }



    private static void populateDDL() {
        ddlList.addAll(Arrays.asList(
                new DDL("Dhaka","Dha"),
                new DDL("Rajshahi","Raj"),
                new DDL("Khulna","khul"),
                new DDL("Khulna","khul")
        ));
    }

}