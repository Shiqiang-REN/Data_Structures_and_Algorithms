package data_structures;

/**
 * ClassName: $05_Queue
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Shiqiang Ren
 * @Create 16/1/2024 16:08
 * @Version 1.0
 */
public class $05_Queue {

    private LinkedListNode first;
    private LinkedListNode last;
    private int size;

    public $05_Queue(){
        first = null;
        last = null;
        size = 0;
    }

    public void add(int value){
        LinkedListNode newNode = new LinkedListNode(value);
        if(size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void poll(){
        first = first.next;
        this.size--;
    }

    public int peek() {
        return first.value;
    }

}
