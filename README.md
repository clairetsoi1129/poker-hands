# Poker Hands

## Introduction
This is a simple program to compare several pairs of poker hands and to indicate which, if either, has a higher rankType.

## Technology
Java 17

## UML Diagram
![class diagram](poker-hands.drawio.png)


![class diagram](poker-hands-new.drawio.png)

## Key Notes
1. Used Criteria design pattern for deciding which catergory the hands of cards belong to.
2. Used Single Responsibility Principle to avoid a list of if else
3. Used stream in toString method in Hand class to convert the cards list to a string.
```java
public String toString() {
   return cards.stream()
   .map(String::valueOf)
   .collect(Collectors.joining(" ", "{", "}"));
   }
```
4. Used stream in grouping the cards by cards Value (2,3,4...K, A) as key in a map with their count in map value.
```java
    Map<Value, Long> groupByValueMap =
        cards.stream().collect(
            Collectors.groupingBy(
            Card::getValue, Collectors.counting()
            )
        );
```
5. Used stream & lambda in sorting the map in 4 by the count.
```java
    HashMap<Value, Long> sortedGroupByValueMap = new LinkedHashMap<>();

    groupByValueMap.entrySet().stream()
    .sorted(Map.Entry.<Value, Long>comparingByKey().reversed()) // sort by card's value desc
    .sorted(Map.Entry.<Value, Long>comparingByValue().reversed()) // sort by card value's count desc
    .forEachOrdered(e ->
    sortedGroupByValueMap.put(e.getKey(), e.getValue()));
    return sortedGroupByValueMap;
```
6. Used stream in sorting in StraightCriteria class to sort the cards in list.
```java
    protected List<Card> sort() {
        return cards.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
```

## How to launch
1. Run the Main class for text UI input 
2. Run the RandomMain class for program to generate the cards and result 

## Approach
1. Compare 1 card  
2. Add a pair in comparison
3. Add two pairs in comparison
4. Add 3 of a kinds in comparison
5. Add straight in comparison
6. Add flush in comparison
7. Add full house in comparison
8. Add four of a kind in comparison
9. Add straight flush in comparison
10. Add handling of string input
11. Add main class

## Future Thoughts
1. Eliminate the no. of call of sortedGroupByValueMap
2. Add GUI
