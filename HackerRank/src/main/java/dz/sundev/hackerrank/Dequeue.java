package dz.sundev.hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dequeue {
    public static void main(String[] args) {

        /*for (int i = 0; i < m - 1; i++) {
            deque.add(in.nextInt());
        }*/

//        List<Integer> nums = Arrays.asList(3, 3, 2, 2, 3, 3);
//        List<Integer> nums = Arrays.asList(5,3,5,2,3,2);
//        List<Integer> nums = Arrays.asList(1,1,1);

        List<Integer> nums = null;
        String fileName = "input10.txt";
        int n, m = 0;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Object[] streamArr = stream.toArray(); 
            String[] nm = ((String) streamArr[0]).split("\\s");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
            nums = Arrays.stream(((String) streamArr[1])
                    .split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            System.out.println(nums.size());
            System.out.println(nums.get(nums.size()-1));
        } catch (IOException e) {
            e.printStackTrace();
        }



//        IntStream.range(0, n)
//                .forEach(value -> {
//                    nums.add(ThreadLocalRandom
//                            .current()
//                            .nextInt(1, 1_000_000));
//                });

        Deque<Integer> deque = new ArrayDeque<>(nums.subList(0, m));

        long max = deque.stream().distinct().count();

        for (int i = m; i < nums.size(); i++) {
            System.out.printf("%d/%d\n", i, nums.size());
            int num = nums.get(i);
//            System.out.printf("%s, %d", deque, num);
            if (!deque.contains(num)) {
                max++;
                if (max == m) {
                    break;
                }
            }

//            System.out.printf(" => %d", max);

            deque.add(num);
            int first = deque.poll();
            if (!deque.contains(first)) {
                max--;
            }

//            System.out.printf(" => %d\n", max);
        }

        System.out.println(deque);
        System.out.print(max);
    }
}
