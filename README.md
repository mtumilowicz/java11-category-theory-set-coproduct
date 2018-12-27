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