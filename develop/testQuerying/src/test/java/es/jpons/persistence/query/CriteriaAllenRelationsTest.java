/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jpons.persistence.query;

import es.jpons.temporal.types.PossibilisticVTP;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.TestCase;
import org.hibernate.Criteria;

/**
 * Tests for Criteria Allen Relations class
 * @author Jose Enrique Pons Frías <jpons@decsai.ugr.es>
 */
public class CriteriaAllenRelationsTest extends TestCase {
    
    public CriteriaAllenRelationsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of before method, of class CriteriaAllenRelations.
     */
    public void testBefore() {
        System.out.println("before");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.before(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeBeforeSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeBeforeSatisfactionDegree() {
        System.out.println("computeBeforeSatisfactionDegree");
        
        System.out.println("Computing degree in [0,1]");
        PossibilisticVTP i = new PossibilisticVTP(10, 1,2012, 1, 1, 6, 1, 2012, 2,2);
        PossibilisticVTP j = new PossibilisticVTP(6,1,2012,1,1,9,1,2012,1,1);
        
        Double expResult = 2.0/3.0;
        Double result = CriteriaAllenRelations.computeBeforeSatisfactionDegree(i, j);
        System.out.println("result: "+result);
        assertEquals(expResult, result);
        
        System.out.println("Computing degree = 1");
        
        i = new PossibilisticVTP(10, 1,2012, 1, 1, 16, 1, 2012, 2,2);
        j = new PossibilisticVTP(16,3,2012,1,1,19,3,2012,1,1);
        expResult = 1D;
        
        result = CriteriaAllenRelations.computeBeforeSatisfactionDegree(i, j);
        System.out.println("result: "+result);
        assertEquals(expResult, result);
        
        System.out.println("Computing degree = 0");
        
       
        expResult = 0D;
        result = CriteriaAllenRelations.computeBeforeSatisfactionDegree(j, i);
        System.out.println("result: "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of after method, of class CriteriaAllenRelations.
     */
    public void testAfter() {
        System.out.println("after");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.after(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meets method, of class CriteriaAllenRelations.
     */
    public void testMeets() {
        System.out.println("meets");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.meets(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meet_by method, of class CriteriaAllenRelations.
     */
    public void testMeet_by() {
        System.out.println("meet_by");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.meet_by(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of overlaps method, of class CriteriaAllenRelations.
     */
    public void testOverlaps() {
        System.out.println("overlaps");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.overlaps(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of overlapped_by method, of class CriteriaAllenRelations.
     */
    public void testOverlapped_by() {
        System.out.println("overlapped_by");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.overlapped_by(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of during method, of class CriteriaAllenRelations.
     */
    public void testDuring() {
        System.out.println("during");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.during(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class CriteriaAllenRelations.
     */
    public void testContains() {
        System.out.println("contains");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.contains(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class CriteriaAllenRelations.
     */
    public void testEquals() {
        System.out.println("equals");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.equals(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of starts method, of class CriteriaAllenRelations.
     */
    public void testStarts() {
        System.out.println("starts");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.starts(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ends method, of class CriteriaAllenRelations.
     */
    public void testEnds() {
        System.out.println("ends");
        Criteria initializedCriteria = null;
        PossibilisticVTP pvp = null;
        Criteria expResult = null;
        Criteria result = CriteriaAllenRelations.ends(initializedCriteria, pvp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeMeetsSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeMeetsSatisfactionDegree() {
        System.out.println("computeMeetsSatisfactionDegree");
        PossibilisticVTP i =new PossibilisticVTP(10,1,2012,1,1,16,1,2012,1,1);
        PossibilisticVTP j = new PossibilisticVTP(15,1,2012,1,1,19,1,2012,1,1);
        Double expResult = 0.5;
        Double result = CriteriaAllenRelations.computeMeetsSatisfactionDegree(i, j);
        System.out.println("result = "+result);
        assertEquals(expResult, result);
        
        System.out.println("result = 0");
        //j = new PossibilisticVTP(16,3,2012,1,1,19,3,2012,1,1);
        expResult = 0.0;
        result = CriteriaAllenRelations.computeMeetsSatisfactionDegree(j, i);
        System.out.println("result = "+result);
        assertEquals(expResult, result);
        
        System.out.println("result = 1");
        j = new PossibilisticVTP(16,1,2012,1,1,19,1,2012,1,1);
        expResult = 1.0;
        result = CriteriaAllenRelations.computeMeetsSatisfactionDegree(i, j);
        System.out.println("result = "+result);
        assertEquals(expResult, result);
        
        
        
        
        
       
    }

    /**
     * Test of computeOverlapsSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeOverlapsSatisfactionDegree() {
        System.out.println("computeOverlapsSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,2,2);
        PossibilisticVTP j = new PossibilisticVTP(17,1,2012,1,1,19,2,2012,1,1);
        
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        i = new PossibilisticVTP(17,3,2012,1,1,19,5,2012,1,1);
        result = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
        //left:
        expResult = 0.5;
        i = new PossibilisticVTP(17,1,2012,1,1,16,2,2012,1,1);
        result = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
        //right:
        expResult = 0.5;
        i = new PossibilisticVTP(10,1,2012,1,1,19,2,2012,1,1);
        result = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        //both left and right:
        expResult = 0.5;
        i = new PossibilisticVTP(17,1,2012,1,1,19,2,2012,1,1);
        result = CriteriaAllenRelations.computeOverlapsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of computeContainsSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeContainsSatisfactionDegree() {
        System.out.println("computeContainsSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,2,2);
        PossibilisticVTP j = new PossibilisticVTP(17,1,2012,1,1,19,1,2012,1,1);
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeContainsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        result = CriteriaAllenRelations.computeContainsSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        //testing the right side
        j = new PossibilisticVTP(10,1,2012,1,1,19,1,2012,1,1);
        expResult = 0.5;
        result = CriteriaAllenRelations.computeContainsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        //testing the left side
        
        j = new PossibilisticVTP(17,1,2012,1,1,16,2,2012,2,2);
        expResult = 0.5;
        result = CriteriaAllenRelations.computeContainsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
        
        
        
        
    }

    /**
     * Test of computeDuringSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeDuringSatisfactionDegree() {
        System.out.println("computeDuringSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        PossibilisticVTP j = new PossibilisticVTP(16,1,2012,1,1,19,1,2012,1,1);
        Double expResult = 0.0;
        Double result = CriteriaAllenRelations.computeDuringSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        expResult = 1.0;
        result = CriteriaAllenRelations.computeDuringSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        //left side:
        j = new PossibilisticVTP(17,1,2012,1,1,16,2,2012,1,1);
        expResult = 0.5;
        result = CriteriaAllenRelations.computeDuringSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        //right side:
         j = new PossibilisticVTP(10,1,2012,1,1,19,1,2012,1,1);
        expResult = 0.5;
        result = CriteriaAllenRelations.computeDuringSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of computeEqualsSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeEqualsSatisfactionDegree() {
        System.out.println("computeEqualsSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        PossibilisticVTP j = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        i = new PossibilisticVTP(10,2,2012,1,1,16,3,2012,1,1);
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        expResult = 0.5;
        i = new PossibilisticVTP(11,1,2012,1,1,16,2,2012,1,1);
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        expResult = 0.5;
        i = new PossibilisticVTP(10,1,2012,1,1,17,2,2012,1,1);
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        result = CriteriaAllenRelations.computeEqualsSatisfactionDegree(j, i);
        assertEquals(expResult, result);
        
        
       
    }

    /**
     * Test of computeStartsSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeStartsSatisfactionDegree() {
        System.out.println("computeStartsSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        PossibilisticVTP j = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeStartsSatisfactionDegree(i, j);
        System.out.println("result = "+result);
        assertEquals(expResult, result);
        
        
        expResult = 0.0;
        j = new PossibilisticVTP(6,1,2012,1,1,16,2,2012,1,1);
        result = CriteriaAllenRelations.computeStartsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
         expResult = 0.5;
        j = new PossibilisticVTP(9,1,2012,1,1,16,2,2012,1,1);
        result = CriteriaAllenRelations.computeStartsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
        
    }

    /**
     * Test of computeFinishesSatisfactionDegree method, of class CriteriaAllenRelations.
     */
    public void testComputeFinishesSatisfactionDegree() {
        System.out.println("computeFinishesSatisfactionDegree");
        PossibilisticVTP i = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        PossibilisticVTP j = new PossibilisticVTP(10,1,2012,1,1,16,2,2012,1,1);
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeFinishesSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        j = new PossibilisticVTP(6,1,2012,1,1,18,2,2012,1,1);
        result = CriteriaAllenRelations.computeStartsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
         expResult = 0.5;
        j = new PossibilisticVTP(9,1,2012,1,1,15,2,2012,1,1);
        result = CriteriaAllenRelations.computeStartsSatisfactionDegree(i, j);
        assertEquals(expResult, result);
        
        
        
        
        
    }

    /**
     * Test of computeIntersections method, of class CriteriaAllenRelations.
     */
    public void testComputeIntersections() {
        System.out.println("computeIntersections");
        Long ai = 1L;
        Long bi = 1L;
        Long di = 6L;
        Long a1j = 1L;
        Long b1j = 1L;
        Long d1j = 6L;
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeIntersections(ai, bi, di, a1j, b1j, d1j);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        d1j = 10L;
        result = CriteriaAllenRelations.computeIntersections(ai, bi, di, a1j, b1j, d1j);
        assertEquals(expResult, result);
        
        expResult = 0.5;
        d1j = 7L;
        result = CriteriaAllenRelations.computeIntersections(ai, bi, di, a1j, b1j, d1j);
        assertEquals(expResult, result);
        
        d1j = 5L;
        result = CriteriaAllenRelations.computeIntersections(ai, bi, di, a1j, b1j, d1j);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of computeIntersectionLt method, of class CriteriaAllenRelations.
     */
    public void testComputeIntersectionLt() {
        System.out.println("computeIntersectionLt");
        Long ai = 1L;
        Long bi = 1L;
        Long di = 6L;
        Long aj = 1L;
        Long b1j = 1L;
        Long dj = 6L;
        Double expResult = 0.5;
        Double result = CriteriaAllenRelations.computeIntersectionLt(ai, bi, di, aj, dj);
        assertEquals(expResult, result);
       
        
        expResult = 1.0;
        di = 5L;
        result = CriteriaAllenRelations.computeIntersectionLt(ai, bi, di, aj, dj);
        assertEquals(expResult, result);
        
        
        expResult = 0.0;
        di = 9L;
        result = CriteriaAllenRelations.computeIntersectionLt(ai, bi, di, aj, dj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of computeIntersectionLte method, of class CriteriaAllenRelations.
     */
    public void testComputeIntersectionLte() {
        System.out.println("computeIntersectionLte");
         Long ai = 1L;
        Long bi = 1L;
        Long di = 6L;
        Long aj = 1L;
        Long bj = 1L;
        Long dj = 6L;
        Double expResult = 1.0;
        Double result = CriteriaAllenRelations.computeIntersectionLte(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        
         expResult = 1.0;
        di = 4L;
        result = CriteriaAllenRelations.computeIntersectionLte(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        
        
        expResult = 0.5;
        di = 7L;
        result = CriteriaAllenRelations.computeIntersectionLte(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        
        expResult = 0.0;
        di = 9L;
        result = CriteriaAllenRelations.computeIntersectionLte(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        
        
        
        
        
        
        
    }

    /**
     * Test of computeIntersectionGt method, of class CriteriaAllenRelations.
     */
    public void testComputeIntersectionGt() {
        System.out.println("computeIntersectionGt");
        Long ai = null;
        Long bi = null;
        Long di = null;
        Long aj = null;
        Long bj = null;
        Long dj = null;
        Double expResult = null;
        Double result = CriteriaAllenRelations.computeIntersectionGt(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeIntersectionGte method, of class CriteriaAllenRelations.
     */
    public void testComputeIntersectionGte() {
        System.out.println("computeIntersectionGte");
        Long ai = null;
        Long bi = null;
        Long di = null;
        Long aj = null;
        Long bj = null;
        Long dj = null;
        Double expResult = null;
        Double result = CriteriaAllenRelations.computeIntersectionGte(ai, bi, di, aj, bj, dj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
