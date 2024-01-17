package data_structures;

import java.util.Arrays;

/**
 * ClassName: $01_DynamicArray
 * Package: PACKAGE_NAME
 * Description: implement our own java dynamic array - ArrayList
 * @Author Shiqiang Ren
 * @Create 13/1/2024 16:02
 * @Version 1.0
 */
public class $01_DynamicArray {
    //    Declare static array
    //    int[] arr1 = {1,2,3};
    //    int[] arr2 = new int[3];

    private String[] arr;
    private int capacity;
    private int length;

    public $01_DynamicArray(){
        arr = new String[3];
        capacity = 3;
        length = 0;
    }

    public String get(int index){
        if(index>=0 && index < length){
            return arr[index];
        }else{
            return "Index Out Of Bound";
        }
    }

    public String[] push(String item){
        if(length == capacity){
            String[] newArr = new String[6];
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
            capacity *= 2;
        }
        arr[length] = item;
        length++;
        return arr;
    }

    public String pop (){
        if(length>0){
            String lastItem = arr[length-1];
            length--;
            return lastItem;
        }else{
            return "Empty Array";
        }
    }

    public String delete(int index){
        if(index<0 || index >= arr.length){
            return "Index Out Of Bound";
        }else{
            String removedItem = arr[index];
            for(int i = index; i<arr.length-1; i++) {
                arr[i] = arr[i + 1];
            }
            length--;
            return removedItem;
        }
    }

    public static void main(String[] args) {
        $01_DynamicArray myArr = new $01_DynamicArray();
        myArr.push("1");
        myArr.push("2");
        myArr.push("3");
        myArr.pop();
        System.out.println(Arrays.toString(myArr.push("4")));

        System.out.println(myArr.delete(0));
        System.out.println(myArr.length);
        System.out.println(myArr.capacity);
    }

}
