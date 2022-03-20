package sbp.CustomDigitComparator;

import java.util.Comparator;

public class CustomDigitComparator implements  Comparator<Integer> {

    /**
     * Идет сортировка чисел Lhs b rhs
     * 1 if проверка на 0
     * 2 if если числа равны возвращает 0
     * 3 if  сортирует четные числа
     * 4 if  сортирует переход между четными и нечетными чмслами
     * 5 if  сортирует нечетные числа
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public int compare(Integer lhs, Integer rhs) {

        if (lhs == null || rhs == null) {
            throw new NullPointerException("не должно быть значений равных null");
        }

        if (lhs == rhs) {
            return 0;
        }

        if ( lhs > rhs && rhs % 2 == 0 ) {
            return 1;
        } else if (lhs < rhs && rhs % 2 == 0 && lhs % 2 != 0){
            return 1;
        }else if (lhs > rhs && rhs % 2 != 0 && lhs % 2 != 0){
            return 1;
        }else {
            return  -1;
        }
    }
}



