package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TripletDequeTest {
    private TripletDeque<Integer> deque;

    ///создает новый экземпляр TripletDeque с размером контейнера 5
    @Before
    public void setUp() {
        deque = new TripletDeque<>(5);
    }

    ///Добавление и удаление элементов

    @Test
    public void testAddFirst() {
        deque.addFirst(1);
        assertEquals("Size should be 1", 1, deque.size());
        assertEquals("First element should be 1", Integer.valueOf(1), deque.getFirst());
    }

    @Test
    public void testAddLast() {
        deque.addLast(2);
        assertEquals("Size should be 1", 1, deque.size());
        assertEquals("Last element should be 2", Integer.valueOf(2), deque.getLast());
    }

    @Test
    public void testRemoveFirst() {
        deque.addFirst(3);
        assertEquals("Removed element should be 3", Integer.valueOf(3), deque.removeFirst());
        assertEquals("Size should be 0", 0, deque.size());
    }

    @Test
    public void testRemoveLast() {
        deque.addLast(4);
        assertEquals("Removed element should be 4", Integer.valueOf(4), deque.removeLast());
        assertEquals("Size should be 0", 0, deque.size());
    }

    @Test
    public void testPollFirst() {
        deque.addFirst(5);
        assertEquals("Polled element should be 5", Integer.valueOf(5), deque.pollFirst());
        assertNull("Poll on empty deque should return null", deque.pollFirst());
    }

    @Test
    public void testPollLast() {
        deque.addLast(6);
        assertEquals("Polled element should be 6", Integer.valueOf(6), deque.pollLast());
        assertNull("Poll on empty deque should return null", deque.pollLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstException() {
        deque.removeFirst(); // Должно выбросить исключение
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastException() {
        deque.removeLast(); // Должно выбросить исключение
    }

    ///Параметры предложения

    @Test
    public void testOfferFirst() {
        assertTrue(deque.offerFirst(7));
        assertEquals(Integer.valueOf(7), deque.peekFirst());
    }

    @Test
    public void testOfferLast() {
        assertTrue(deque.offerLast(8));
        assertEquals(Integer.valueOf(8), deque.peekLast());
    }

    ///Проверка коллекций

    @Test
    public void testAddAll() {
        Collection<Integer> collection = Arrays.asList(9, 10, 11);
        deque.addAll(collection);
        assertEquals("Size should be 3", 3, deque.size());
        //assertEquals("First element should be 9", Integer.valueOf(9), deque.getFirst());
        assertEquals("Last element should be 11", Integer.valueOf(11), deque.getLast());
    }

    @Test
    public void testRemoveObject() {
        deque.addLast(12);
        assertTrue(deque.remove(12));
        assertFalse(deque.contains(12));
    }

    ///Проверка итератора

    @Test
    public void testIterator() {
        deque.addLast(13);
        deque.addLast(14);
        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(13), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(14), iterator.next());
        assertFalse(iterator.hasNext());
    }


    ///Тесты на пустую очередь

    @Test
    public void testPeekFirstOnEmptyDeque() {
        assertNull("Peek on empty deque should return null", deque.peekFirst());
    }

    @Test
    public void testPeekLastOnEmptyDeque() {
        assertNull("Peek on empty deque should return null", deque.peekLast());
    }
}