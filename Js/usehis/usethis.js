function Person() {}
Person.prototype.name="zwx";
Person.prototype.say=function () {
console.log(this.name);
}
var z=new Person();
var x=new Person();
z.name="xiao";
console.log(x.name);
console.log(z.name);
console.log(x.say());
console.log(z.say());
// console.log(z.say());

