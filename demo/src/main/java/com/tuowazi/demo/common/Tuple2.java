package com.tuowazi.demo.common;

/**
 * turple：元祖，表示多个类的组合，用于方法返回值有多个时使用，此为turple2，可用于2个元素，若要3个，构建turple3
 *
 * @param <A>
 * @param <B>
 */
public class Tuple2<A, B> {

    private A a;

    private B b;

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public Tuple2() {

    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public static <A, B> Tuple2<A, B> buildTuple2(A a, B b) {
        return new Tuple2(a, b);
    }

    @Override public String toString() {
        return a.toString() + "," + b.toString();
    }
}
