//作用1-封装变量
var cache={}
var mult=function(){
    var args=Array.prototype.join.call(arguments,',');
    Array.prototype.push()
    if(cache[args])
    {
        return cache[args];
    }
    var a=1;
    for(var i=0,l=arguments.length;i<l;i++)
    {
        a=a*arguments[i];
    }
    return cache[args]=a;
};

var mult2=(function () {
    var cache={};
    return function () {
        var args=Array.prototype.join.call(arguments,',');
        if(cache[args])
        {
            return cache[args];
        }
        var a=1;
        for(var i=0,l=arguments.length;i<l;i++)
        {
            a=a*arguments[i];
        }
        return cache[args]=a;
    }
})();

console.log(mult(9,9,9));
console.log(mult2(9,9,9));
