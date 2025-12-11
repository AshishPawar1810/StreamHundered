import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMedium {

    public static void main(String[] args) {

        List<String > words = List.of("apple", "banana","apple","banana","banana","apple","banana");
        String mostFrequent = words.stream().collect(Collectors.groupingBy(x->x,Collectors.joining()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);

        System.out.println("Most frequest - "+mostFrequent);

        String lessFrequest = words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Less Frequent - "+lessFrequest);

        List<String> rhyms = List.of("listen", "silent", "enlist", "google", "inlets");
        String target ="silent";
        List<String> anagrams = words.stream()
                .filter(x -> Arrays.equals(
                        x.chars().sorted().toArray(),
                        target.chars().sorted().toArray()
                ))
                .collect(Collectors.toList());
        System.out.println("Anagrams is -> "+anagrams);

        List<Emp> employees = List.of(
                new Emp("Alice", "HR", 50000L),
                new Emp("Bob", "IT", 60000L),
                new Emp("Charlie", "HR", 55000L)
        );
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDepartment,
                        Collectors.averagingDouble(Emp::getSallary)
                ));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);

        String input = "hello 123 world";
        String result = input.chars()
                        .filter(c -> !Character.isDigit(c))
                                .mapToObj(c -> String.valueOf((char) c))
                                        .collect(Collectors.joining());
        System.out.println("after remove world - "+result);

        String special = "Hello @ world!";
        String specialRem = special.chars()
                .filter(x -> Character.isLetterOrDigit(x) || Character.isWhitespace(x))
                .mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining());
        System.out.println("Remove special - "+specialRem);

    }
}
