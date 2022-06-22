##Принцип разделения интерфейсов

При реализации больших интерфейсов могут возникать проблемы. Допустим, у нас есть интерфейс
```java
interface Shape {
    drawCircle();
    drawSquare();
    drawRectangle();
}
```

При реализации этого интерфейса какой-либо фигурой, она будет также реализовывать методы неактуальные для себя
```java
class Circle implements Shape {
    drawCircle(){
    }
    drawSquare(){
    }
    drawRectangle(){
    }    
}
class Square implements Shape {
    drawCircle(){
    }
    drawSquare(){
    }
    drawRectangle(){
    }    
}
class Rectangle implements Shape {
    drawCircle(){
    }
    drawSquare(){
    }
    drawRectangle(){
    }    
}
```
Также при последующем расширении интерфейса, придется вносить правки во все реализации. Очевидно что здесь необходимо
разделить перегруженный интерфейс на несколько. Пример.
```java
interface Shape {
    draw();
}
interface ICircle {
    drawCircle();
}
interface ISquare {
    drawSquare();
}
interface IRectangle {
    drawRectangle();
}

class Circle implements ICircle {
    drawCircle() {
    }
}
class Square implements ISquare {
    drawSquare() {
    }
}
class Rectangle implements IRectangle {
    drawRectangle() {
    }
}
```