package com.example.homework2_13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {StringListImpl.class})
@ExtendWith(SpringExtension.class)
class StringListImplTest {
    @Autowired
    StringList stringList;

    @Test
    void add() {
        String s = "ooo";
        String r = stringList.add("ooo");
        assertEquals(s, r);
    }

    @Test
    void testAdd() {
        int i = 1;
        String s = "ww";

        String expected = "ww";
        String actual = stringList.add(i, s);
    }

    @Test
    void addWithArrayIndexOutOfBoundsException() {
        int i = 15;
        String s = "ooo";
        String expected = "Число превышает количество элементов";

        Exception e = assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    stringList.add(i, s);
                }
        );
        assertEquals(expected, e.getMessage());
    }

    @Test
    void set() {
        int i = 2;
        String r = "qq";

        String expected = "qq";

        String actual = stringList.set(i, r);
        assertEquals(expected, actual);
    }

    @Test
    void setWithArrayIndexOutOfBoundsException() {
        int i = 15;
        String s = "ooo";
        String expected = "Число превышает количество элементов";

        Exception e = assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    stringList.set(i, s);
                }
        );
        assertEquals(expected, e.getMessage());
    }

    @Test
    void removeWithIndex() {
        int i = 3;
        String s = "s";

        String expected = "s";

        stringList.add(i, s);
        String actual = stringList.remove(i);
        assertEquals(expected, actual);
    }

    @Test
    void removeWithIndexWithArrayIndexOutOfBoundsException() {
        int i = 15;
        String s = "s";

        String expected = "Неверный индекс";

        Exception e = assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    stringList.remove(i);
                }
        );
        assertEquals(expected, e.getMessage());
    }

    @Test
    void removeWithItem() {
    }

    @Test
    void contains() {
        String s = "ooo";

        stringList.add(s);
        boolean actual = stringList.contains(s);
        assertTrue(actual);
    }

    @Test
    void indexOf() {
        int e = 0;

        int t = stringList.indexOf("ooo");
        assertEquals(e, t);
    }

    @Test
    void lastIndexOf() {
        int e = 6;

        stringList.add(6, "ww");
        int t = stringList.lastIndexOf("ww");
        assertEquals(e, t);
    }

    @Test
    void get() {
        int i = 1;

        String expected = "ww";

        String actual = stringList.get(i);
        assertEquals(expected, actual);
    }
    @Test
    void getWithIndexOutOfBoundsException() {
        int i = 14;

        String expected = "Слишком большой индекс";

        Exception e = assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    stringList.get(i);
                }
        );
        assertEquals(expected, e.getMessage());
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
        int expected = 7;

        int actual = stringList.size();
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        int s = 5;

        boolean expected = s != 0;

        boolean actual = stringList.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void removeAll() {
    }

    @Test
    void createNewArray() {

    }
}