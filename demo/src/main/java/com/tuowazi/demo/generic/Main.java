//package com.tuowazi.demo.generic;
//
//public class Main {
//
//    public static class A
//    {}
//    public static class B extends Employee
//    {
//        public B(String n, double s, int year, int month, int day) {
//            super(n, s, year, month, day);
//        }
//    }
//
//    public static void main(String[] args) {
//        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
//        ceo.setBonus(100);
//        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
//        cfo.setBonus(50);
//        Employee employee1=new Employee("zwxbest",100,2000,1,1);
//
//        //use  new Pair<>
//        //can work,but use new Pair<Manager> can raise efficiency for compile-time error
//        Pair<Manager> buddies1 = new Pair<>(ceo,cfo);
//        System.out.println(buddies1.getFirst().getBonus()+","+buddies1.getSecond().getBonus());
//        //can work if only instantiate
//        // compile-time error until using subclass's method
//        Pair<Employee> buddies11 = new Pair<>(ceo,cfo);
//        System.out.println(buddies11.getFirst().getSalary()+","+buddies11.getSecond().getSalary());
//        System.out.println(buddies11.getFirst().getBonus()+","+buddies11.getSecond().getBonus());//compile-error
//        Pair<Employee> buddies1111 = new Pair<>(new B("",1,1,1,1),cfo);//B is subclass of Employee
//        //compile-error
//        Pair<Employee> buddies111 = new Pair<>(new A(),cfo);//compile-time error ,cannot infer arguments,becanuse A is not subclass of Employee
//
//        //use new Pair
//        //can work,but use new Pair<Manager> can raise efficiency for compile-time error
//        Pair<Manager> buddies2 = new Pair(ceo,cfo);
//        System.out.println(buddies2.getFirst().getBonus()+","+buddies2.getSecond().getBonus());
//        //compile-time error until using subclass's method
//        Pair<Employee> buddies22 = new Pair(ceo,cfo);//compile-time error until using subclass's method
//        System.out.println(buddies22.getFirst().getSalary()+","+buddies22.getSecond().getSalary());
//        System.out.println(buddies22.getFirst().getBonus()+","+buddies22.getSecond().getBonus());//compile-error
//        Pair<Employee> buddies2222 = new Pair(new B("",1,1,1,1),cfo);//B is subclass of Employee
//        //can work
//        Pair<Employee> buddies222 = new Pair(new A(),cfo);//compile-time error ,cannot infer arguments,becanuse A is not subclass of Employee
//
//
//        //use new Pair<T,T>
//        //can work well
//            Pair<Manager> buddies3 = new Pair<Manager>(ceo,cfo);
//        System.out.println(buddies1.getFirst().getBonus()+","+buddies1.getSecond().getBonus());
//        //compile-error
//        Pair<Employee> buddies33 = new Pair<Manager>(ceo,cfo);//compile-time error
//
//        Pair<Manager> buddies333 = new Pair<Manager>(new A(),cfo);//compile-time error
//
//        Pair<Manager> buddies3333 = new Pair<Manager>(new B("",1,1,1,1),cfo);//compile-time error
//
//
//
//    }
//}
