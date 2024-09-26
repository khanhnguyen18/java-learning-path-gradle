# Spring Webflux
- https://viblo.asia/p/spring-boot-xay-dung-ung-dung-reactive-voi-spring-5-webflux-924lJd6mKPM

## Overview
Spring Webflux Framework là một phần của Spring 5 và cung cấp [Reactive Programming][reactive-programming] nhằm hỗ trợ cho việc xây dựng ứng dụng web. Trong hướng dẫn này, chúng tôi sẽ đi một vài khái niệm để hiểu rõ về Spring Webflux, tiếp theo là xây dựng một ứng dụng Reactive Rest APIs đơn giản sử dụng Spring Webflux.


## Reactive Streams API
Reactive Stream API được tạo bởi các kỹ sư từ Netflix, Pivotal, Lightbend, RedHat, Twitter, and Oracle và bây giờ là một phần của Java 9. Nó định nghĩa 4 interface:

- Publisher: Phát ra một chuỗi các sự kiện đến subscriber theo yêu cầu của người mà subscriber đến nó. Một Publisher có thể phục vụ nhiều subscriber. Interface này chỉ có một phương thức:
```java
public interface Publisher<T>
{
    public void subscribe(Subscriber<? super T> s);
}
```
- Subscriber: Nhận và xử lý sự kiện được phát ra bởi Publisher. Chú ý rằng không có gì xảy ra cho tới khi Subscription – nó được gọi là báo hiệu yêu cầu cho Publisher.
```java
public interface Subscriber<T>
{
    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
    public void onComplete();
}

```
- `Subscription`: Định nghĩa mỗi quan hệ 1-1 giữa Publisher và Subscriber. Nó chỉ có thể được sử dụng bởi một Subsriber duy nhất và được sử dụng để báo hiệu yêu cầu (request) hoặc hủy (cancel) data.

- `Processor`: Đại diện cho giai đoạn xử lý gồm cả Publisher và Subscriber đồng thời tuân thủ nguyên tắc của cả 2.
```java
public interface Processor<T, R> extends Subscriber<T>, Publisher<R>
{
}
```