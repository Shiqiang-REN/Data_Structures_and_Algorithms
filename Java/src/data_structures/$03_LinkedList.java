package data_structures;

/**
 * ClassName: $03_LinkedList
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Shiqiang Ren
 * @Create 16/1/2024 13:04
 * @Version 1.0
 */
public class $03_LinkedList {
    private LinkedListNode head;

    public $03_LinkedList(int value){
        head = new LinkedListNode(value);
        head.value = value;
    }

    //O(1)
    public void prepend(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //O(N)
    public void append(int value){
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode pointer = head;
        while(pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = newNode;
    }

    //O(N)
    public void insert(int index, int value){
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode currentNode = get(index);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    //O(N)
    public void delete(int index) {
        if(index == 0){
            head = head.next;
        }else{
            LinkedListNode preNode = get(index - 1);
            preNode.next = get(index).next;
        }
    }

    public void reverse(){
        LinkedListNode pointer = this.head;
        LinkedListNode currentNode = this.head;
        LinkedListNode preNode = null;

        while(pointer.next != null){
            pointer = pointer.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = pointer;
        }
        currentNode.next = preNode;
        this.head = currentNode;
    }

    //O(N)
    public LinkedListNode get(int index){
        LinkedListNode node = this.head;
        if(index > 0){
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    //O(N)
    public int size() {
        LinkedListNode pointer = head;
        int i = 1;
        while(pointer.next != null){
            pointer = pointer.next;
            i++;
        }
        return i;
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
        myLinkedList.reverse();
        myLinkedList.print();
    }
}



