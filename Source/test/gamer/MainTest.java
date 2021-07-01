/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamer;

import javax.sound.sampled.LineUnavailableException;
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
public class MainTest {
    
    public MainTest() {
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
     * Test of run method, of class Main.
     */
    @Test
    public void testRun() throws LineUnavailableException {
        System.out.println("run");
        Main instance = new Main();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFPS method, of class Main.
     */
    @Test
    public void testUpdateFPS() throws LineUnavailableException {
        System.out.println("updateFPS");
        Main instance = new Main();
        //instance.updateFPS();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initGL method, of class Main.
     */
    @Test
    public void testInitGL() throws LineUnavailableException {
        System.out.println("initGL");
        Main instance = new Main();
        instance.initGL();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class Main.
     */
    @Test
    public void testGetTime() throws LineUnavailableException {
        System.out.println("getTime");
        Main instance = new Main();
        long expResult = 0L;
//        long result = instance.getTime();
  //      assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] argv = null;
        Main.main(argv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
