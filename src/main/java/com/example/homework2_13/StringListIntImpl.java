package com.example.homework2_13;

import java.util.Arrays;
import java.util.Random;

public class StringListIntImpl {
    private final Integer[] array;
    private int size;

    public StringListIntImpl() {
        array = new Integer[11];
    }

    public StringListIntImpl(int initSize) {
        array = new Integer[initSize];
    }

    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        array[size++] = item;
        return item;
    }

    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;

        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }

        size--;
        return item;
    }

    public Integer remove(int index) {
        validateIndex(index);

        Integer item = array[index];

        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }

        size--;
        return item;
    }

    public boolean contains(Integer item) {
        Integer[] arr = createNewArray();
        sort(arr);
        return binarySearch(arr, item);
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    public boolean equals(Integer[] w) {
        return Arrays.equals(array, w);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeAllOf() {
        size = 0;
    }

    public Integer[] createNewArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Значениене может быть пустым");
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException("Массив переполнен");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new invalidIndexException("Неправильный индекс");
        }
    }
    public void sort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public boolean binarySearch(Integer[] arr, Integer item){
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private static void swapElements(Integer[] arr, Integer j){
        arr[j] = arr[j+1];
        arr[j+1] = arr[j];
    }

    private static void sortedi(){
        Random random = new Random();
      //  Integer[] arr = new Integer[100000];
       // for (Integer i:arr) {
        //    i = random.nextInt(100001);
       // }

        //Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        //Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr = {4, 6, 5 , 7, 55, 1};

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
