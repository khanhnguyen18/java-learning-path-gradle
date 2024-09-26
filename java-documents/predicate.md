# Predicate

## Introduction
- Is a [[Functional Interface]] could use with [[Lambda expression]] or [[Method References]]
- Return true false of  T
```java
public interface Predicate<T> {
    boolean test(T t);
```
## Example
### 1. Test
```java
// Predicate String
Predicate<String> predicateString = s -> {
    return s.equals("test");
};
System.out.println(predicateString.test("test")); // true
```
### 2. and(), or(), negate(), isEqual()
```java
 
import java.util.function.Predicate;
 
public class PredicateExample2 {
 
    public static void main(String[] args) {
 
        Predicate<String> predicate = s -> {
            return s.equals("test");
        };
 
        // AND logical operation
        Predicate<String> predicateAnd = predicate.and(s -> s.length() == 11);
        System.out.println(predicateAnd.test("test")); // false
 
        // OR logical operation
        Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
        System.out.println(predicateOr.test("test")); // true
 
        // NEGATE logical operation
        Predicate<String> predicateNegate = predicate.negate();
        System.out.println(predicateNegate.test("test")); // false
    }
}
```
6. BiPredicate

## Links
- https://gpcoder.com/3963-predicate-trong-java-8/
- https://viblo.asia/p/huong-dan-su-dung-predicatevi-ngu-trong-java-8-3KbvZ1qzGmWB

## What is it?
- This is one interface