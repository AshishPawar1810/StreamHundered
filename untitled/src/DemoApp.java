import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class DemoApp {

    public static void main(String[] args) {
        List<Integer> nuumbers = Arrays.asList(1,2,3,4,5,6);

        List<Integer> evenNumber =
                nuumbers.stream().filter(x -> x % 2 ==0).collect(Collectors.toList());
        System.out.println(evenNumber);

        int max = nuumbers.stream().max(Integer::compare).get();
        System.out.println(max);

        List<Integer> unsort = Arrays.asList(3,5,1,4,2);
        List<Integer> sorted = unsort.stream().sorted().toList();
        System.out.println(sorted);

        sorted = unsort.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

       int secondLarges = nuumbers.stream().sorted(Comparator.reverseOrder())
                       .skip(1).findFirst().orElse(0);
        System.out.println("Second largest - "+secondLarges);

        List<Integer> mix = Arrays.asList(1,2,3,4,4,3,2,1,5);

        List<String> word = Arrays.asList("apple", "banana", "kiwi");
        String sortest = word.stream().min(Comparator.comparing(String::length)).orElse("");
        System.out.println("Shortest string "+sortest);

        List<Person> personList = List.of(
                new Person(25,"Alice"),
                new Person(30,"Bob"),
                new Person(50,"Bob builder"));

                Map<Integer,List<Person>> personGroup =
                        personList.stream().collect(Collectors.groupingBy(Person::getAge));

        System.out.println("Shortest string "+personGroup);

        Map<Boolean, List<Integer>> map =
                nuumbers.stream().collect(Collectors.partitioningBy(x -> x % 2 ==0));

        System.out.println(map);
        List<Integer> dist = Arrays.asList(6,7);
        List<Integer> common = nuumbers.stream().filter(dist::contains).collect(Collectors.toList());
        System.out.println("Common ele -> "+common);

        List<String> fruits = List.of("apple","banana","apple","orange");
        Map<String, Long> fruitCount =
                fruits.stream()
                                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println("Word Counts: " + fruitCount);

        String name ="ashish pawar";
        Map<Character, Long> charCounter = name
                .chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x ->x, Collectors.counting()));
        System.out.println("name char are -> "+charCounter);

        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5, 6);
        List<Integer> difference = list1.stream()
                .filter(n -> !list2.contains(n))
                .collect(Collectors.toList());
        System.out.println("Difference: " + difference);

        String wordList = "hello world hello";
        Map<String, Long> wordCount = Arrays.stream(wordList.split(" "))
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println("word count -> "+wordCount);

        String str = "hello world";
        Map<Character,Long> vowelCount =
                str.chars().mapToObj(x ->(char)x)
                                .filter(x ->"aeiou".contains(String.valueOf(x)))
                                        .collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println("Vowel count => "+vowelCount);

        String digit ="hello 12323 world 42356";
        Map<Character,Long> digitGroup = digit.chars().mapToObj(x ->(char) x)
                .filter(Character::isDigit)
                .collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println("digit count -> "+digitGroup);

    }
}
