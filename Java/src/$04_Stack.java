import org.w3c.dom.Node;

/**
 * ClassName: $04_Stack
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Shiqiang Ren
 * @Create 16/1/2024 16:07
 * @Version 1.0
 */
public class $04_Stack {

    private LinkedListNode top;
    private int size;

    public $04_Stack(){
        top = null;
        size = 0;
    }
    public void push(int value){
        LinkedListNode newNode = new LinkedListNode(value);
        if (this.size != 0) {
            newNode.next =  this.top;
        }
        this.top = newNode;
        this.size++;
    }

    public void pop(){
        top = top.next;
    }

    public int peek() {
        return top.value;
    }
}
