import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {
    public  static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        addIntToList(numbers);

        findEvenNum(numbers); //no. 1 find even numbers in list
        findOnes(numbers); //no. 2 find numbers with 1
        findTotal(numbers); //no. 3 find total of elements
        sortValues(numbers); //no. 4 sort values

    }

    private static void addIntToList(ArrayList<Integer> list){
        int num = 0;
        Random r = new Random();

        while (num <= 20){
            list.add(r.nextInt(100));
            num++;
        }

        System.out.println(list);
    }

    private static void findEvenNum(ArrayList<Integer> list){
        List<Integer> evenNums = list.stream()
                .filter(even -> even % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNums);
    }

    private static void findOnes(ArrayList<Integer> list){
        List<Integer> numWith1 = list.stream()
                .filter(num -> num.toString().contains("1"))
                .collect(Collectors.toList());

        System.out.println(numWith1);
    }

    private static void findTotal(ArrayList<Integer> list){
        Integer total = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(total);
    }

    private static void sortValues(ArrayList<Integer> list){
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());

        System.out.println(sorted);
    }
}
