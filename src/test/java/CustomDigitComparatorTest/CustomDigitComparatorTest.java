package CustomDigitComparatorTest;

import org.junit.jupiter.api.Test;
import sbp.CustomDigitComparator.CustomDigitComparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomDigitComparatorTest  {

    /**
     * Идет сортировка чисел, сначала четные числа, затем нечетные;
     */
    @Test
    public void sortTrue() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(8);

        System.out.println(list);
        Comparator<Integer> numbers = new CustomDigitComparator();
        list.sort(numbers);
        System.out.println(list);
        assertEquals("[2, 4, 6, 8, 1, 3, 5, 7, 9]", list.toString());
    }

    /**
     * Идет сортировка чисел и проверка, есть ли среди них null.
     */
    @Test
    public void sortNull() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(null);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(8);

        Comparator<Integer> numbers = new CustomDigitComparator();
        assertThrows(NullPointerException.class, () -> list.sort(numbers));
    }
}



