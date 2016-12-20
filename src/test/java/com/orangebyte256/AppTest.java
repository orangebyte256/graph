package com.orangebyte256;

import com.orangebyte256.DrawObject.Edge;
import com.orangebyte256.DrawObject.Node;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test1(Method m) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 20; i++)
        {
            Node node1 = new Node(new Point(i, 20 - i), 0, null, null);
            Node node2 = new Node(new Point(i, 20 - i), 0, null, null);
            Boolean o = (Boolean)m.invoke(null, node1, node2); //use null if the method is statit
            assertTrue("Wrong equals", o);
            System.out.println("Correct - " + i);
        }
    }

    public void test2(Method m) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 20; i++)
        {
            Node node1 = new Node(new Point(i, 20 - i), 0, null, null);
            Node node2 = new Node(new Point(i, 20 - i - 1), 0, null, null);
            Boolean o = (Boolean)m.invoke(null, node1, node2); //use null if the method is statit
            assertFalse("Wrong equals", o);
            System.out.println("Correct - " + i);
        }
    }
    public void test3(Method m) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 20; i++)
        {
            Node node1 = new Node(new Point(i, 20 - i), 0, null, null);
            Node node2 = new Node(new Point(i, 20 - i), 0, null, null);
            Boolean o = (Boolean)m.invoke(null, node1, node2); //use null if the method is statit
            assertTrue("Wrong not equals", o);
            System.out.println("Correct - " + i);
        }
    }
 
    public void testApp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Node.class.getDeclaredMethod("isEquals", Node.class, Node.class);
        m.setAccessible(true);
        test1(m);
        test2(m);
        m = Node.class.getDeclaredMethod("isNotEquals", Node.class, Node.class);
        m.setAccessible(true);
	test3(m);
    }
}
