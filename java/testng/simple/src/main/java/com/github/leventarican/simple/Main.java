package com.github.leventarican.simple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Levent
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("testng");

        Stream.of(args).forEach((arg) -> System.out.println(arg));

        int[] numbers = IntStream.of(8, 3, 4).toArray();
//        Arrays.binarySearch()
        int index = binarySearch(numbers, 3);

        System.out.println("index: " + index);
    }

    public static int binarySearch(int[] numbers, int number) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = numbers[mid];
            if (guess == number) {
                return mid;
            }
            if (guess > number) {
                high = mid - 1;
            } else {
                high = mid + 1;
            }
        }

        return -1;
    }
}
