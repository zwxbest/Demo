/**
 * Created by zhangweixiao on 2018/5/21.
 */
//like-array test

//1. 元素下标不是数字，未定义length
function func1() {
    var likeArray={};
    var i=0;
    for(;i<2;i++)
    {
        likeArray["i"+i]=i*5;
    }
    // likeArray.length=i;
    Array.prototype.push.call(likeArray,'first');
    console.log(likeArray.length);
    console.log(likeArray[0])
    console.log(likeArray[1])
    console.log(likeArray[2])
};
func1();
console.log("---------------------------------");
//6. 元素下标不是数字，定义length
function func6() {
    var likeArray={};
    var i=0;
    for(;i<2;i++)
    {
        likeArray["i"+i]=i*5;
    }
    likeArray.length=i;
    Array.prototype.push.call(likeArray,'first');
    console.log(likeArray.length);
    console.log(likeArray["i0"])
    console.log(likeArray["i1"])
    console.log(likeArray[2])
};
func6();
console.log("---------------------------------");
//2.元素下表是数字，未定义length
function func2() {
    var likeArray={};
    var i=0;
    for(;i<2;i++)
    {
        likeArray[i]=i*5;
    }
    // likeArray.length=i;
    Array.prototype.push.call(likeArray,'first');
    console.log(likeArray.length);
    console.log(likeArray[0])
    console.log(likeArray[1])
    console.log(likeArray[2])
};
func2();
console.log("---------------------------------");
//3.元素下标是数字，定义length
function func3() {
    var likeArray={};
    var i=0;
    for(;i<2;i++)
    {
        likeArray[i]=i*5;
    }
    likeArray.length=i;

    Array.prototype.push.call(likeArray,'first');
    console.log(likeArray.length);
    console.log(likeArray[0])
    console.log(likeArray[1])
    console.log(likeArray[2])
};
func3();
console.log("---------------------------------");
// 4.length不可写
// function func4()
// {
//     var func41=function()
//     {
//         console.log(Object.getOwnPropertyDescriptor(func41,'length'));
//     };
//     Array.prototype.push.call(func41,'first');
//     console.log(func41.length);
//
// }
// func4();
// console.log("---------------------------------");
//5.对象不可存取
function func5()
{
    var num=1;
    Array.prototype.push.call(num,'first');
    console.log(num.length);
}
func5();


