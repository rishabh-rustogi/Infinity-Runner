/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rishabhrustogi
 */
public class CheckTest {
    
    public CheckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of begin method, of class Check.
     */
    @Test
    public void testBegin() throws Exception {
        System.out.println("begin");
        Check instance = new Check();
        boolean expResult = false;
        boolean result;
        //result = instance.begin();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Check.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Check instance = new Check();
        //instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class Check.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        Check instance = new Check();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blue method, of class Check.
     */
    @Test
    public void testBlue() {
        System.out.println("blue");
        float t = 0.0F;
        Check instance = new Check();
        double expResult = 0.0;
        double result = instance.blue(t);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renderGL method, of class Check.
     */
    @Test
    public void testRenderGL() {
        System.out.println("renderGL");
        Check instance = new Check();
        instance.renderGL();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
