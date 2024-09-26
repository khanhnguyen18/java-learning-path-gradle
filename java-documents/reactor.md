# Reactor

Reactor Core is a Java 8 library that implements the *reactive programming* model. It’s built on top of the Reactive Streams specification, a standard for building reactive applications.

- https://www.baeldung.com/reactor-core
- https://www.baeldung.com/reactor-bus
- https://viblo.asia/p/gioi-thieu-reactor-core-Qpmlegk9Krd

## 4. Producing a Stream of Data

## 4.1 Flux
The first way of doing this is with Flux. It’s a stream that can emit 0..n elements. Let’s try creating a simple one:

```java
Flux<Integer> just = Flux.just(1, 2, 3, 4);

```

## 4.2 Mono
The second way of doing this is with a Mono, which is a stream of 0..1 elements. Let’s try instantiating one:


```java
Mono<Integer> just = Mono.just(1);
```

## 5.1. Collecting Elements
```java
List<Integer> elements = new ArrayList<>();

Flux.just(1, 2, 3, 4)
  .log()
  .subscribe(elements::add);

assertThat(elements).containsExactly(1, 2, 3, 4);
```

## 5.3. Comparison to Java 8 Streams
It still might appear that we have something synonymous to a Java 8 Stream doing collect:

```java
List<Integer> collected = Stream.of(1, 2, 3, 4)
  .collect(toList());
```

- The core difference is that Reactive is a **push model**, whereas the Java 8 Streams are a **pull model**. In a reactive approach, events are pushed to the subscribers as they come in.

- With Reactive we could have an infinite stream coming in from an external resource, with multiple subscribers attached and removed on an ad hoc basis. We can also do things like combine streams, throttle streams, and apply backpressure, which we will cover next.

## 6. Backpressure

## 8.1. Creating a ConnectableFlux


## 9 Concurrency

```java
Flux.just(1, 2, 3, 4)
  .log()
  .map(i -> i * 2)
  .subscribeOn(Schedulers.parallel())
  .subscribe(elements::add);
```