package JavaLanguage;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args){
        //可以传null的
        Map<String,String> map = new HashMap<>();
        map.put(null,"test");
        System.out.println(map);

    }

}
