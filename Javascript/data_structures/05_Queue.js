class Queue{
    constructor() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    add(value){
        const newNode = new Node(value);
        if (this.size === 0) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    poll(){
        this.first = this.first.next;
        this.size--;
    }

    peek() {
        return this.first.value;
    }

}

class Node{
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

const myQueue = new Queue();
myQueue.add("Joy");
myQueue.add("Matt");
myQueue.add("Pavel");
myQueue.add("Samir");
myQueue.poll();
myQueue.poll();
myQueue.peek();
console.log(myQueue.peek());
//Joy
//Matt
//Pavel
//Samir