/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    /**
    * Code from a public source that is cited and not required
    * by the assignment may be used.
    */
    @Test
    public void testPublicCitedCodeAllowed() {
    assertTrue("Expected true: cited public code that is not required",
    RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }
    /**
    * Another student's 6.005 course work may never be used,
    * even if you cite it.
    */
    @Test
    public void testCourseWorkFromOthersNotAllowed() {
    assertFalse("Expected false: someone else's 6.005 course work",
    RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
    /**
    * Public cited code is not allowed when the assignment asks you
    * to implement that code yourself.
    */
    @Test
    public void testImplementationRequiredNotAllowed() {
    assertFalse("Expected false: assignment requires your own implementation",
    RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}
