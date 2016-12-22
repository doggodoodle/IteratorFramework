package test;

import main.FilteringIterator;
import main.IObjectTest;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ritvikmathur on 12/21/16.
 */
public class FilteringIteratorTest {

    IObjectTest<Integer> positiveIntTest;

    @org.junit.Before
    public void setUp() throws Exception {
        positiveIntTest = new IObjectTest<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i>=0;
            }
        };

    }

    @org.junit.Test
    public void testIntIterator() throws Exception {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,-1,3,-2,-10,0,3));
        Iterator<Integer> iterator = new FilteringIterator<Integer>(list.iterator(),positiveIntTest);
        while (iterator.hasNext()){
            Assert.assertTrue("Only positive values should be returned by iterator",iterator.next()>=0);
        }
    }

}