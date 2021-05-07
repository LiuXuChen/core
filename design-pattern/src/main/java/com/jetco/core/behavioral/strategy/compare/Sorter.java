package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 比较排序
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = comparator.compare(arr[j], arr[min]) == -1 ? j : min;
            }
            swap(arr, i, min);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
