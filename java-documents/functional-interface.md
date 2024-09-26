# Functional Interface 


> The question is how can we *inject function inside a function* but still keep the strictlness of the code

> Java Team decide to use the stuff là Functional interface which will become a prototype of a function, và kèm thêm các cách implementation phù hợp cho nó.

>- Functional interface là interface có duy nhất 1 abstract method, có thể không có hoặc có nhiều default/static method.

## Available Functional Inteface
- https://viblo.asia/p/4-functional-interface-co-san-va-vi-du-voi-stream-api-RQqKL6L4l7z

```java
List.of(2, 3, 5, 7).stream() // Lấy ra stream từ List
    .map(num -> num * 2) // Mỗi phần tử sẽ được nhân đôi
    .filter(num -> num < 10) // Chỉ giữ lại các phần tử nhỏ hơn 10
    .forEach(num -> System.out.println(num)); // In ra các phần tử còn lại
```

- Here map(), filter() và forEach() is stream operation. Each will perform other function and will use correcponding functional interface:
    - *map()* để biến đổi phần tử 1-1, nên nó dùng Function<T, R>
    - *filter()* để lọc ra các phần tử phù hợp, nên nó dùng Predicate<T>
    - *forEach()* chỉ dùng in ra thôi, không return gì nữa, nên nó dùng Consumer<T>


## Sample
>Thay vì truyền trực tiếp function B vào function A, thì phải "gói" function B vào một object (có dạng của functional interface).

>Sau đó mới truyền object đó vào cho function A. Function A chỉ cần lấy ra và sử dụng thôi.
```java
// Định nghĩa khuôn mẫu cho method truyền vô
@FunctionalInterface
interface Calculable {
    double calculate();
}
...
// Có thể gọi được method trong khuôn mẫu
public void printResult(Calculable func) {
    System.out.println("Result: " + func.calculate());
}
...
// Method thực sự truyền vào, được wrap vô trong khuôn mẫu
printResult(new Calculable() {
    @Override
    public double calculate() {
        return 3.14;
    }
})
```