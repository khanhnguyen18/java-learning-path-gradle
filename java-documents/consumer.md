# Consumer
Nhận vào một param kiểu T, không trả về gì cả. Nói cách dân dã là chỉ thích nhận lại nhưng không thèm cho đi.

```java
Consumer<Integer> print = num -> System.out.println(num);
print.accept(3); // 3
```


