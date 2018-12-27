[![Build Status](https://travis-ci.com/mtumilowicz/java11-category-theory-set-coproduct.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-category-theory-set-coproduct)

# java11-category-theory-set-coproduct
_Reference_: https://bartoszmilewski.com/2015/01/07/products-and-coproducts/  
_Reference_: https://www.amazon.com/Category-Theory-Oxford-Logic-Guides/dp/0199237182  
_Reference_: https://en.wikiversity.org/wiki/Introduction_to_Category_Theory/Products_and_Coproducts

# definition
For product please refer my other github project:
https://github.com/mtumilowicz/java11-category-theory-set-product

The **coproduct** of objects `A` and `B` is an object `P` 
together with morphisms (injections):
* `i1 :: A -> P`
* `i2 :: B -> P`
that satisfy the following property:
* If `X` is any object in the category, and `f1 :: A -> X` 
and `f2 :: B -> X` are any morphisms, then there exists a 
unique morphism `g :: X -> P` such that:
* `f1 = g . i1`
* `f2 = g . i2`

# disjoint union of sets is a coproduct in the Set category
_Reference_: https://en.wikipedia.org/wiki/Disjoint_union

let `A + B := {(a, 1) | a e A} u {(b, 2) | b e B}` be the coproduct
with injections:
* `i1(a) = (a, 1)`
* `i2(b) = (b, 2)`
    
if there is other object `X` with injections `f1` and `f2` we 
define
```
g(x, delta) = f(x) if delta = 1 or g(x) if delta = 2
```
then
* `g . i1 = f1`
* `g . i2 = f2`

# project description
We provide basic implementation of `Either` + tests:
```
public interface Either<L, R> {

    static <L, R> Either<L, R> right(R right) {
        return new Right<>(right);
    }

    static <L, R> Either<L, R> left(L left) {
        return new Left<>(left);
    }

    L getLeft();

    boolean isLeft();

    boolean isRight();

    R getRight();

    final class Left<L, R> implements Either<L, R> {

        private final L value;

        private Left(L value) {
            this.value = value;
        }

        @Override
        public R getRight() {
            throw new NoSuchElementException();
        }

        @Override
        public L getLeft() {
            return value;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Left && Objects.equals(value, ((Left) obj).value));
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Left" + "(" + value + ")";
        }
    }

    final class Right<L, R> implements Either<L, R> {

        private final R value;

        private Right(R value) {
            this.value = value;
        }

        @Override
        public R getRight() {
            return value;
        }

        @Override
        public L getLeft() {
            throw new NoSuchElementException();
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Right && Objects.equals(value, ((Right) obj).value));
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Right" + "(" + value + ")";
        }
    }
}
```
full implementation could be found in VAVR:
https://github.com/vavr-io/vavr/blob/master/vavr/src/main/java/io/vavr/control/Either.java