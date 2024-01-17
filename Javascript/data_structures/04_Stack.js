class Stack_LinkedList{
    constructor() {
        this.top = null;
        this.size = 0;
    }

    push(value){
        const newNode = new Node(value);
        if (this.size !== 0) {
            newNode.next =  this.top;
        }
        this.top = newNode;
        this.size++;
    }

    pop(){
        this.top = this.top.next;
    }

    peek() {
        return this.top.value;
    }

}

class Stack_Array {
    constructor() {
        this.array = [];
    }

    peek() {
        return this.array[this.array.length-1];
    }
    push(value){
        this.array.push(value);
        return this;
    }
    pop(){
        this.array.pop();
        return this;
    }
}

class Node{
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}


const myStack = new Stack_LinkedList();
myStack.push('google');
myStack.push('ztm');
myStack.push('discord');
console.log(myStack.peek());