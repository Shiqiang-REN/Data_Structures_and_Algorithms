class LinkedList {
    constructor(value) {
        this.head = {
            value,
            next: null
        };
        this.tail = this.head;
        this.size = 1;
    }

    prepend(value){
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    append(value){
        const newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    insert(index, value){
        const node = this.get(index);
        const newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
        this.size++;
    }

    delete(index){
        if(index === this.size - 1){
            const preNode = this.get(index - 1)
            preNode.next = null;
            this.tail = preNode;
        }else{
            this.get(index - 1).next = this.get(index).next;
        }
        this.size--;
    }

    //return the node and index begin with 0 to length -1
    get(index){
        let node = this.head;
        if(index > 0){
            for (let i = 1; i <= index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    print(){
        let currentNode = this.head;
        let values = [currentNode.value];
        while(currentNode.next != null){
            currentNode = currentNode.next;
            values.push(currentNode.value);
        }
        return values.toString();
    }

}

class Node{
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

let myLinkedList = new LinkedList(15);
myLinkedList.prepend(25);
myLinkedList.append(10);
myLinkedList.prepend(30);
myLinkedList.insert(1, 20);
myLinkedList.delete(1);
// myLinkedList.delete(2);
console.log(myLinkedList.print());
console.log(myLinkedList.size);
//30-25-20-15-10
// console.log(myLinkedList.get(0));