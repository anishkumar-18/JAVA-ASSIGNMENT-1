# Abstraction & Interface — Concept Answers

## 1. Abstraction
Abstraction means exposing the essential operation while hiding unnecessary implementation details. For example, a food-delivery app lets a customer place an order and pay without showing how routing, database updates, and payment processing work internally.

## 2. Abstraction vs encapsulation
Abstraction focuses on what an object does and hides implementation details. Encapsulation controls how data is stored and accessed, usually by keeping fields private and exposing controlled methods. A class can use both: it may hide internal fields through encapsulation and expose only high-level operations through abstraction.

## 3. Constructor in an abstract class
An abstract class cannot be instantiated directly, but its constructor is executed when a subclass object is created. It initializes the common state that all subclasses inherit.

## 4. Abstract method restrictions
A private method cannot be overridden because subclasses cannot access it. A static method belongs to the class rather than an object and is resolved by the reference type, so it does not participate in overriding. A final method cannot be overridden by design. Therefore an abstract method cannot use private, static, or final.

## 5. Diamond problem
The diamond problem occurs when multiple inheritance could provide the same method or state through different parent paths, creating ambiguity about which implementation should be used. Java avoids this for classes by allowing only one superclass. A class can implement multiple interfaces, and conflicting default methods must be resolved explicitly by overriding the method when necessary.
