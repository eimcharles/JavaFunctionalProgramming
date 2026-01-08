### Java Functional Programming

#### This repository serves as a guide for learning core Java functional programming concepts, it contains practice implementations and exercises focused on functional interfaces and data processing using the Streams API.

![Functional](https://img.shields.io/badge/Paradigm-Functional-FFD166?logo=lambdatest&logoColor=black)
![Java Streams](https://img.shields.io/badge/Java-Streams_API-FFD166?logo=openjdk&logoColor=black)

---

#### Functional Identities Examples: 
| Functional Identity | Role | Interface(s) | Example Number |
| :--- | :--- | :--- | :--- |
| **Consumer** | The "Action" | `Consumer<T>`, `BiConsumer<T, U>` | [ExampleOne.java](src/functionalInterfaces/functionalIdentities/consumer/ExampleOne.java)<br>[ExampleTwo.java](src/functionalInterfaces/functionalIdentities/consumer/ExampleTwo.java)<br>[ExampleThree.java](src/functionalInterfaces/functionalIdentities/consumer/ExampleThree.java) |
| **Supplier** | The "Origin" | `Supplier<T>` | [ExampleOne.java](src/functionalInterfaces/functionalIdentities/supplier/ExampleOne.java) |
| **Gatekeeper** | The "Validator" | `Predicate<T>`, `BiPredicate<T, U>` | [ExampleOne.java](src/functionalInterfaces/functionalIdentities/gatekeeper/ExampleOne.java)<br>[ExampleTwo.java](src/functionalInterfaces/functionalIdentities/gatekeeper/ExampleTwo.java) |
| **Transformer** | The "Mapper" | `Function<T, R>`, `BiFunction<T, U, R>` | [ExampleOne.java](src/functionalInterfaces/functionalIdentities/transformer/ExampleOne.java)<br>[ExampleTwo.java](src/functionalInterfaces/functionalIdentities/transformer/ExampleTwo.java) |

---
#### Combinator Pattern Example: used to chain validation rules into a single, fluent pipeline.

| Component | Source Link | Description |
| :--- | :--- | :--- |
| **Main Orchestrator** | [Main.java](./src/functionalInterfaces/combinatorPattern/Main.java) | Builds the validation chain and processes the `User` list. |
| **Business Contract** | [UserValidator.java](./src/functionalInterfaces/combinatorPattern/UserValidator.java) | Functional interface for "shape" of `User` validation. |
| **Concrete Rule** | [ReservedFirstNamesValidator.java](./src/functionalInterfaces/combinatorPattern/ReservedFirstNamesValidator.java) | Specific implementation for filtering system-reserved first names. |

---



