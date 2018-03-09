package question;

import java.util.HashMap;
import java.util.Map;

public class authorizationTest2 {

    class A{
        public Map<Integer, Integer> map = new HashMap<>();

        public int get(int key){
            return map.get(key);
        }

        public void set(int key, Object value){
//            map.put(key, value);
        }
    }


    public static void main(String[] args) {
    }

}
