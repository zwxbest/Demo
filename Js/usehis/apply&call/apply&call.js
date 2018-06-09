    /**
     * Created by zhangweixiao on 2018/5/14.
     */
    // 1.改变this指向
        var obj1={
            name:'seven'
        };
        var obj2={
            name:'anne'
        };
    global.name='global';
    var getName=function () {
        console.log(this.name);
    };
    getName();//global
    getName.call(obj1);//seven
    getName.call(obj2);//anne

    //function.prototype.bind
    Function.prototype.bind=function (context) {//context表示obj
        var self=this;//保存this引用，否则就变成去全局了。
        return function () {
            console.log(this);
            return self.apply(context,arguments);//self指向=function () {console.log(this.name);}
        }
    };
    var obj={name:'seven'};
    var func=function () {
        console.log(this.name);
        console.log(arguments);
    }.bind(obj);
    func(11,22);

    Function.prototype.bind=function () {
        var self=this,//保存原函数
            context=[].shift.call(arguments),//获取第一个参数
            args=[].slice.call(arguments);//剩余参数转换成数组
        return function () {
            //组合两次的参数作为新参数
            return self.apply(context,[].concat.call(args,[].slice.call(arguments)));
        }
    };
    var obj={
        name:'svene'
    };
    var func=function (a,b,c,d) {
        console.log(this.name);
        console.log([a,b,c,d]);
    }.bind(obj,1,2);
    func(3,4);

    //3 借用其他对象的方法
    var A=function (name) {
        this.name=name;
    };
    var B=function () {
        A.apply(this,arguments);
    };
    B.prototype.getName=function () {
        return this.name;
    };
    var b=new B('seven');
    console.log(b.getName());

    (function () {
            Array.prototype.push.call(arguments,3);
            console.log(arguments);
        })(1,2);

    var a={};
    Array.prototype.push.call(a,'first');
    console.log(a.length);
    console.log(a[0]);