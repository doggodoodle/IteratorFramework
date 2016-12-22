package main;

import java.util.*;

/**
 * Created by ritvikmathur on 12/18/16.
 */
public class FilteringIterator<T> implements Iterator {

    Iterator<T> iterator;

    List<T> filteredElements;

    public FilteringIterator(Iterator<T> myIterator, IObjectTest<T> myTest){

        if(myIterator != null && myTest!=null){
            filteredElements = new ArrayList<T>();
            while (myIterator.hasNext()){
                T element = myIterator.next();
                if(myTest.test(element))
                    filteredElements.add(element);
            }
            iterator = filteredElements.iterator();
        }
        else
            iterator = myIterator; //uses original iterator if test passed is null
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        return iterator.next();
    }
}
