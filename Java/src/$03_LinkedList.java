/**
 * ClassName: $03_LinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Shiqiang Ren
 * @Create 25/7/2023 18:09
 * @Version 1.0
 */
public class $03_LinkedList {

    public LinkedListNode head;
    public LinkedListNode tail;
    public int size;

    public $03_LinkedList(int value) {
        head = new LinkedListNode(value);
        head.value = value;
        tail = head;
        size = 1;
    }

    //O(1)
    public void prepend(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    //O(1)
    public void append(int value){
        LinkedListNode newNode = new LinkedListNode(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //O(N)
    public void insert(int index, int value){
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode currentNode = get(index);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    //O(N)
    public void delete(int index) {
        if(index == size - 1){
            LinkedListNode preNode = get(index - 1);
            preNode.next = null;
            this.tail = preNode;
        }else{
            get(index - 1).next = get(index).next;
        }
        this.size--;
    }

    public LinkedListNode get(int index){
        LinkedListNode node = this.head;
        if(index > 0){
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    //O(1)
    public int size() {
        return size;
    }

    //O(N)
    public void print() {
        LinkedListNode pointer = head;
        StringBuilder sb = new StringBuilder();
        sb.append(pointer.value + " ");
        while(pointer.next != null){
            pointer = pointer.next;
            sb.append(pointer.value + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        $03_LinkedList myLinkedList = new $03_LinkedList(15);
        myLinkedList.prepend(25);
        myLinkedList.append(10);
        myLinkedList.prepend(30);
        myLinkedList.insert(1, 20);
        myLinkedList.delete(1);
        myLinkedList.print();
    }
}





