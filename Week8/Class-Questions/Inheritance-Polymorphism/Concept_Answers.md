# Week 8 Inheritance & Polymorphism — Concept Answers

## 1. Inheritance and specialization
Inheritance lets a child class reuse fields and methods from a parent class. The child can keep inherited behavior, add new behavior, or override a method when its rule is different. For example, `Employee` can provide common name and ID data, while `Professor` and `LabAssistant` provide their own salary calculations.

## 2. Is-a relationship
An is-a relationship means the child is a specialized form of the parent. For example, a `Car` is a `Vehicle`. Identifying a genuine is-a relationship is important because inheritance creates a strong parent-child dependency and should represent a real conceptual hierarchy.

## 3. Method overriding
Method overriding happens when a subclass provides its own implementation of an inherited method with the same signature. For example, `Employee.calculateSalary()` can be overridden by `Professor.calculateSalary()` and `LabAssistant.calculateSalary()`.

## 4. Runtime polymorphism
A base-type reference can point to a derived object. When an overridden method is called, Java uses the actual object type at runtime to select the method implementation. This is dynamic dispatch.

## 5. Polymorphic collections
A collection can store references of a common base type while the actual objects belong to different subclasses. For example, `Employee[] employees` can contain `Professor`, `LabAssistant`, and `AdministrativeStaff` objects. One loop can call `calculateSalary()` on every element.

## 6. Polymorphism vs repeated conditionals
With repeated `if-else` or `switch` logic, the central code must know every concrete type. With polymorphism, each subclass owns its behavior and the common processing code calls one shared method. This reduces coupling and makes extensions easier.

## 7. Adding a new derived type
A new `PaymentMethod` such as `WalletPayment` can extend the common base class and override its payment behavior. Existing code that works with `PaymentMethod` references can process it without changing the common iteration logic.

## 8. Inherited vs overridden behavior
A subclass inherits a method when the base implementation already fits its needs. It overrides the method when the subclass needs different behavior. A common `display()` method can be inherited, while `calculateSalary()` may be overridden by each employee subtype.

## 9. Inheritance only for code reuse
Using inheritance without a real is-a relationship creates tight coupling and can produce a misleading design. Changes in the parent can unexpectedly affect children. Composition or a shared helper is often better when the classes are unrelated.

## 10. Vehicle rental example
`CarRental` and `TruckRental` can share booking ID, customer, rental duration, and common billing behavior through `VehicleRental`. Specialized rules such as car insurance or truck load limits can be implemented in subclasses. The rental system can then process all rentals through `VehicleRental` references.
