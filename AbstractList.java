/**
 * Group 4
 * Mar 1 2021
 * CS 211
 * Team Project 2
 * This is the Abstract class with the mixed duplicates from the ArrayList and LinkedList
 */

import java.util.*;

public abstract class AbstractList<E> implements List<E>
{
    // current number of elements in the list
    public int size;

    // post: returns the current number of elements in the list
    public int size()
    {
        return size;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty()
    {
        return size == 0;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    public void checkIndex(int index)
    {
        // checks if index being requested by checking if it out of bounds
        // by checking if it is negative or larger than its size
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value)
    {
        return indexOf(value) >= 0;
    }

    // Standard Java toString
    // Jashanpreet
    public String toString()
    {
        String string = "[";
        Iterator<E> iter = this.iterator();

        // checks if there are still elements
        if(iter.hasNext())
        {
            // adds the next element to the string
            string += iter.next();
        }

        //  while loop to go through full list
        while(iter.hasNext())
        {
            // adds values
            string +=  ", " + iter.next();
        }

        // returns string
        return string + "]";
    }

    // post: appends the given value to the end of the list
    // Jashanpreet
    public void add (E value)
    {
        // adds the value to the end by passing its size
        add(size(), value);
    }

    public abstract void add(int index, E value);

    public void addAll(List<E> other)
    {
        for (E value: other)
        {
            add(value);
        }
    }

    // post: list is empty
    // Jashanpreet
    public void clear()
    {
        Iterator<E> itrE = this.iterator();
        // while loop that checks if there is still elements left, and if so it removes it until it is empty
        while(itrE.hasNext())
        {
            itrE.next();
            itrE.remove();
        }
    }

    // imports the iterator of the List and returns them
    // Jashanpreet
    public E get(int index)
    {
        // checks index
        checkIndex(index);

        // decalre iterator
        Iterator<E> list = iterator();

        E num = null;

        // for loop to go through elements until the index we need
        for(int i = 0; i < index; i++)
        {
            // sets num to the next element
            num = list.next();
        }

        // returns the number at the desired index
        return num;
    }

    //Imports iterator versions of the list and removes the selected item
    public void remove(int index)
    {
        // declare iterator
        Iterator<E> iter = this.iterator();

        // for loop to go through the elements
        for (int i = 0; i < size; i++)
        {
            iter.next();
            // checks if the next index = the index passed to the method
            if (index == i)
            {
                // if so it removes that element at that index and decreases size
                iter.remove();
                size--;
                return;
            }
        }
    }

    // returns the index of the value
    public int indexOf(E value)
    {
        // for loop to go through all of the elements
        for (int i = 0; i < size(); i++)
        {
            // checks if the value is equal to the element at i index
            if (value.equals(get(i)))
            {
                return i; // returns index that value is in
            }
        }
        return -1;
    }

    public void set(int index, E value)
    {

    }

    public abstract Iterator<E> iterator();
}