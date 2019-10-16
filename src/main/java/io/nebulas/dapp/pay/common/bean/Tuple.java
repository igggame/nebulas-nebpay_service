package io.nebulas.dapp.pay.common.bean;

import java.io.Serializable;

/**
 * Desc:
 * User: nathan
 * Date: 2018-05-15
 */
public abstract class Tuple implements Serializable {

    private static final long serialVersionUID = -8719929625763890308L;

    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<A, B>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<A, B, C>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple4<A, B, C, D>(a, b, c, d);
    }

    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<A, B, C, D, E>(a, b, c, d, e);
    }

    public static final class Tuple2<A, B> extends Tuple implements Serializable {

        private static final long serialVersionUID = 7263645006696591635L;
        private A a;
        private B b;

        private Tuple2(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public A first() {
            return this.a;
        }

        public B second() {
            return this.b;
        }

        @Override
        public boolean equals(Object obj) {
            if (hashCode() != obj.hashCode()) {
                return false;
            }
            Tuple2 target = (Tuple2) obj;
            return target.a.equals(a) && target.b.equals(b);
        }

        @Override
        public int hashCode() {
            return String.valueOf("" + a.hashCode() + b.hashCode()).hashCode();
        }
    }

    public static final class Tuple3<A, B, C> extends Tuple implements Serializable {

        private static final long serialVersionUID = 482545776907024160L;

        private A a;
        private B b;
        private C c;

        private Tuple3(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public A first() {
            return this.a;
        }

        public B second() {
            return this.b;
        }

        public C third() {
            return this.c;
        }

        @Override
        public int hashCode() {
            return String.valueOf("" + a.hashCode() + b.hashCode() + c.hashCode()).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Tuple3 target = (Tuple3) obj;
            if (target == null) {
                return false;
            }
            if (target.a.equals(a) && target.b.equals(b) && target.c.equals(c)) {
                return true;
            }
            return false;
        }
    }

    public static final class Tuple4<A, B, C, D> extends Tuple implements Serializable {

        private static final long serialVersionUID = 482545776907024160L;

        private A a;
        private B b;
        private C c;
        private D d;

        private Tuple4(A a, B b, C c, D d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public A first() {
            return this.a;
        }

        public B second() {
            return this.b;
        }

        public C third() {
            return this.c;
        }

        public D fourth() {
            return this.d;
        }

        @Override
        public int hashCode() {
            return String.valueOf("" + a.hashCode() + b.hashCode() + c.hashCode() + d.hashCode()).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            Tuple4 target = (Tuple4) obj;
            if (target.a.equals(a) && target.b.equals(b) && target.c.equals(c) && target.d.equals(d)) {
                return true;
            }
            return false;
        }
    }

    public static final class Tuple5<A, B, C, D, E> extends Tuple implements Serializable {

        private static final long serialVersionUID = 482545776907024160L;

        private A a;
        private B b;
        private C c;
        private D d;
        private E e;

        private Tuple5(A a, B b, C c, D d, E e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public A first() {
            return this.a;
        }

        public B second() {
            return this.b;
        }

        public C third() {
            return this.c;
        }

        public D fourth() {
            return this.d;
        }

        public E fifth() {
            return this.e;
        }

        @Override
        public int hashCode() {
            return String.valueOf("" + a.hashCode() + b.hashCode() + c.hashCode() + d.hashCode() + e.hashCode()).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Tuple5 target = (Tuple5) obj;
            if (target == null) {
                return false;
            }
            if (target.a.equals(a) && target.b.equals(b) && target.c.equals(c) && target.d.equals(d) && target.e.equals(e)) {
                return true;
            }
            return false;
        }
    }
}
