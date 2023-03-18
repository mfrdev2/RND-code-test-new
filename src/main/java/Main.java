import factor.Factor;
import model.DDL;
import model.DeviceTokenBean;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

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

    private static final String PERSON_NAME_REX = "^[a-zA-Z]+(([',. --'][a-zA-Z ])?[a-zA-Z]*)*$";
    private static final List<DDL> ddlList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        populateDDL();
        System.out.println(ddlList);


        Map<String, String> listMap = ddlList.stream().collect(Collectors.toMap(DDL::getTextEn, DDL::getId, (a, b) -> a, LinkedHashMap::new));

        listMap.putAll(ddlList.stream().collect(Collectors.toMap(DDL::getTextBn, DDL::getId, (a, b) -> a)));


        System.out.println(listMap);

        String name = "report";

        Pattern pattern = Pattern.compile(PERSON_NAME_REX);

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

}