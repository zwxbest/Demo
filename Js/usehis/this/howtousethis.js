/**
 * Created by zhangweixiao on 2018/5/13.
 */
/*//1.作为对象的方法调用
var obj={
    a:1,
    getA:function () {
        console.log(this==obj);
        console.log(this.a);
    }
};
//true
//1
obj.getA();*/
//——————————————————————————————————
//1.5 测试作用于
// global.name="globalName";
// name="name";
// var name="varName";
// console.log(name);
//——————————————————————————————————
// //2 作为普通函数调用
// //1和2一样，3不一样
// global.name='globalName';
// //不适用
// name='globalName1';
// var name='partialName';
// var getName=function () {
//     return this.name;
// };
// //globalName
// console.log(getName());
//
// var myObject={
//     name:'seven',
//     getName:function () {
//         return this.name;
//     }
// };
// var getName=myObject.getName;
// console.log(getName());
//——————————————————————————————————
/*
//3.在构造器中调用
var myClass=function () {
    this.name='seven';
};
var obj=new myClass();
console.log(obj.name);*/
//——————————————————————————————————
//4 function.prototype.call或者apply调用
var obj1={
    name:'zhangweixiao',
    getName:function () {
        return this.name;
    }
};
var obj2={
    name:'anne'
};
console.log(obj1.getName());
console.log(obj1.getName.call(obj2));