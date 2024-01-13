const str = 'A B C D'

const reverse = (str) => {
    let reversedStr = [];
    for (let i = str.length - 1; i >= 0; i--){
        reversedStr.push(str.charAt(i));
    }
    return reversedStr.join('');

}

const reverse2 = (str) => {
    return str.split('').reverse().join('')
}
console.log(reverse2(str));

