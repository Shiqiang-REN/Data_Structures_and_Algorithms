import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: $02_HashTable
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Shiqiang Ren
 * @Create 14/1/2024 10:06
 * @Version 1.0
 */
public class $02_HashTable {
    private ArrayList<HashtableItem>[] data;

    public $02_HashTable(int size) {
        data = new ArrayList[size];
    }

    //Hash Function
    private int _hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % data.length;
        }
        return hash;
    }

    public void set(String key, String value){
        int index = _hash(key);
        if(data[index] == null){
            ArrayList<HashtableItem> bucket = new ArrayList<>();
            data[index] = bucket;
        }
        HashtableItem keyValue = new HashtableItem(key, value);
        data[index].add(keyValue);
    }

    public String get(String key){
        int index = _hash(key);
        if(data[index] != null){
            for (HashtableItem hashtableItem : data[index]) {
                if (hashtableItem.getKey().equals(key)){
                    return hashtableItem.getValue();
                }
            }
        }
        return null;
    }

    public List<String> keys(){
        List<String> keys = new ArrayList<>();
        for (ArrayList<HashtableItem> bucket: data) {
            if(bucket != null){
                for(HashtableItem hashtableItem : bucket){
                    keys.add(hashtableItem.getKey());
                }
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        $02_HashTable table = new $02_HashTable(50);
        table.set("ta", "1000");
        table.set("tu", "589");
        table.set("e", "10");
        System.out.println(table.keys());
        System.out.println(table.get("ta"));
        System.out.println(table.get("tu"));
        System.out.println(table.get("e"));
    }
}


