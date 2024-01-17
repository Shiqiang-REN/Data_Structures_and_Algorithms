class Node {
    constructor(value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    insert(value){
        const newNode = new Node(value);
        if (this.root === null) {
            this.root = newNode;
        } else {
            let currentNode = this.root;
            while(true){
                if(currentNode.value > value){
                    if(!currentNode.left){
                        currentNode.left = newNode;
                        break;
                    }
                    currentNode = currentNode.left;
                }else{
                    if(!currentNode.right){
                        currentNode.right = newNode;
                        break;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    remove(value){
        if (!this.root) {
            return false;
        }
        let currentNode = this.root;
        let parentNode = null;
        while(currentNode){
            if(currentNode.value === value){
                //Option 1: No right child:
                if(currentNode.right === null){
                    if(parentNode === null){
                        this.root = currentNode.left;
                    }else{
                        if(currentNode.value < parentNode.value){
                            parentNode.left = currentNode.left;
                        }else if(currentNode.value > parentNode.value){
                            parentNode.right = currentNode.left;
                        }
                    }
                //Option 2: Right child which doesn't have a left child
                } else if (currentNode.right.left === null) {
                    currentNode.right.left = currentNode.left;
                    if (parentNode === null) {
                        this.root = currentNode.right;
                    } else {
                        //if parent > current, make right child of the left the parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right;
                        //if parent < current, make right child a right child of the parent
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right;
                        }
                    }
                //Option 3: Right child that has a left child
                }else{
                    let leftmost = currentNode.right.left;
                    let leftmostParent = currentNode.right;
                    while (leftmost.left !== null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;
                    if (parentNode === null) {
                        this.root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = leftmost;
                        }
                    }
                }
                return true;
            }else if(currentNode.value > value){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }else if(currentNode.value < value){
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }
    }

    lookup(value) {
        if (!this.root) {
            return false;
        }
        let currentNode = this.root;
        while(currentNode){
            if(currentNode.value === value){
                return currentNode;
            }else if(currentNode.value > value){
                currentNode = currentNode.left;
            }else if(currentNode.value < value){
                currentNode = currentNode.right;
            }
        }
        return false;
    }
}

function traverse(node) {
    const tree = { value: node.value };
    tree.left = node.left === null ? null : traverse(node.left);
    tree.right = node.right === null ? null : traverse(node.right);
    return tree;
}

const tree = new BinarySearchTree();
tree.insert(9);
tree.insert(4);
tree.insert(6);
tree.insert(20);
tree.insert(170);
tree.insert(15);
tree.insert(1);
tree.remove(170);
console.log(tree.lookup(20));
console.log(JSON.stringify(traverse(tree.root)));
