# Supplier
> Đích thị ông này nhóm máu O. Chỉ biết cho đi nhưng không cần nhận lại.

```java
Supplier<Double> generate = () -> Math.random(100);
generate.get(); // Số random nào đó
```

## Definition
- Là 1 [[functional interface]]
  - lambda expression
  - method reference 
- Supplier<T> làm ngược lại với Consumer<T>, nó là một phương thức trừu tượng không tham số, và trả về một đối tượng bằng cách gọi phương thức get() của nó


## Project
```shell
idea ~/project/java-learning-path-gradle
```