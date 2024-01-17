// mergeSortedArrays([0,3,4,31], [3,4,6,30])
// [0, 3, 4, 4, 6, 30, 31]

const mergeSortedArrays = (arr1, arr2) => {
    let sortedArr = [];
    let i = 0;
    let j = 0;
    while (i < arr1.length || j < arr2.length) {
        if (j >= arr2.length || arr1[i] <= arr2[j]){
            sortedArr.push(arr1[i]);
            i++;
        } else {
            sortedArr.push(arr2[j]);
            j++;
        }
    }
    return sortedArr;


}
 console.log(mergeSortedArrays([0,3,4,31], [3,4,6,30]));