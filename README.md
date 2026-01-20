### Java Functional Programming

#### This repository serves as a guide for learning core Java functional programming concepts, it contains practice implementations and exercises focused on functional interfaces and data processing using the Streams API.

![Functional](https://img.shields.io/badge/Paradigm-Functional-FFD166?logo=lambdatest&logoColor=black)
![Java Streams](https://img.shields.io/badge/Java-Streams_API-FFD166?logo=openjdk&logoColor=black)

#### [Functional Interfaces Learning resource / certificate](https://amigoscode.com/certificates/84093b57-597d-45f4-bd17-51eb4b3e3a2a)

---

#### Functional Identities Examples: 
| Functional Identity | Role | Interface(s) | Example Number |
| :--- | :--- | :--- | :--- |
| **Consumer** | The "Action" | `Consumer<T>`, `BiConsumer<T, U>` | [ExampleOne.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/consumer/ExampleOne.java)<br>[ExampleTwo.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/consumer/ExampleTwo.java)<br>[ExampleThree.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/consumer/ExampleThree.java) |
| **Supplier** | The "Origin" | `Supplier<T>` | [ExampleOne.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/supplier/ExampleOne.java) |
| **Gatekeeper** | The "Validator" | `Predicate<T>`, `BiPredicate<T, U>` | [ExampleOne.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/gatekeeper/ExampleOne.java)<br>[ExampleTwo.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/gatekeeper/ExampleTwo.java) |
| **Transformer** | The "Mapper" | `Function<T, R>`, `BiFunction<T, U, R>` | [ExampleOne.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/transformer/ExampleOne.java)<br>[ExampleTwo.java](src/main/java/com/eimc/functionalInterfaces/functionalIdentities/transformer/ExampleTwo.java) |

---
#### Combinator Pattern Example: used to chain validation rules into a single, fluent pipeline.

| Component | Source Link | Description |
| :--- | :--- | :--- |
| **Main Orchestrator** | [Main.java](src/main/java/com/eimc/functionalInterfaces/combinatorPattern/Main.java) | Builds the validation chain and processes the `User` list. |
| **Business Contract** | [UserValidator.java](src/main/java/com/eimc/functionalInterfaces/combinatorPattern/UserValidator.java) | Functional interface for "shape" of `User` validation. |
| **Concrete Rule** | [ReservedFirstNamesValidator.java](src/main/java/com/eimc/functionalInterfaces/combinatorPattern/ReservedFirstNamesValidator.java) | Specific implementation for filtering system-reserved first names. |

---
#### [Streams Learning resource / certificate](https://amigoscode.com/certificates/536c1db4-c015-4068-913e-6a32ca130bf6)

#### Streams Transformation Examples:
| Transformation | Example |
| :--- | :--- | 
| **map()** | [MapExample.java](src/main/java/com/eimc/streams/transformations/MapExample.java)<br>
| **flatMap()** | [FlatMapExample.java](src/main/java/com/eimc/streams/transformations/FlatMapExample.java)<br>
| **reduce()** | [ReduceExample.java](src/main/java/com/eimc/streams/transformations/ReduceExample.java)<br>
| **groupingBy()** | [GroupingExample.java](src/main/java/com/eimc/streams/transformations/GroupingExample.java)<br>
| **partitioningBy()** | [PartitionExample.java](src/main/java/com/eimc/streams/transformations/PartitionExample.java)<br>
| **sorted()** | [SortingExample.java](src/main/java/com/eimc/streams/transformations/SortingExample.java)<br>
| **collect()** | [CollectorsAndCombiner.java](src/main/java/com/eimc/streams/transformations/CollectorsAndCombiner.java)<br>


---


