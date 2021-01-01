package com.systelab.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static int[] divisibleBy(int[] numbers, int divider) {
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        List<Integer> dividers = numbersList.stream()
                                            .filter(number -> (number%divider) == 0).collect(Collectors.toList());

        return dividers.stream().mapToInt(i->i).toArray();
    }
}
