class HashTable {
    constructor(size) {
        this.data = new Array(size);
    }
    //Hash Function
    _hash(key) {
        let hash = 0;
        for (let i =0; i < key.length; i++){
            hash = (hash + key.charCodeAt(i) * i) % this.data.length
        }
        return hash;
    }

    set(key, value){
        let address = this._hash(key);
        if(!this.data[address]){
            this.data[address] = [];
            this.data[address].push([key, value]);
        }
        return this.data;
    }

    get(key, value){
        let address = this._hash(key);
        const currentBucket = this.data[address]
        if(currentBucket){
            for(let i = 0; i<currentBucket.length;i++){
                if(currentBucket[i][0] === key){
                    return currentBucket[i][1]
                }
            }
        }
        return undefined;
    }

    keys(){
        let arr = [];
        // for (const item of this.data) {
        //     if(item){
        //         for (const itemElement of item) {
        //             arr.push(itemElement[1]);
        //         }
        //     }
        // }
        const flatData = this.data.flat();
        flatData.forEach( ele => arr.push(ele[0]))
        return arr;
    }

}

const myHashTable = new HashTable(50);
myHashTable.set('grapes', 10000);
// myHashTable.get('grapes');
myHashTable.set('apples', 9);
myHashTable.set('1', 9);
// myHashTable.get('apples');
console.log(myHashTable.keys());