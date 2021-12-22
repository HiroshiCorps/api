package fr.redxil.api.common.utils;

public class Pair<A, B> {

    A one;
    B two;

    public Pair(A one, B two) {
        this.one = one;
        this.two = two;
    }

    public A getOne() {
        return this.one;
    }

    public B getTwo() {
        return two;
    }
}
