package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.*;

public class JobTest {

    Job empty_test_job_one;
    Job empty_test_job_two;
    Job new_job_object;
    Job test_equality_job_object_one;
    Job test_equality_job_object_two;

    @Before
    public void createJobObject() {
        empty_test_job_one = new Job();
        empty_test_job_two = new Job();
        new_job_object = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_equality_job_object_one = new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        test_equality_job_object_two = new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, empty_test_job_one.getId());
        assertEquals(2, empty_test_job_two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(3, new_job_object.getId());

        assertEquals("Product tester", new_job_object.getName());

        assertTrue(new_job_object.getEmployer() instanceof Employer);
        assertEquals("ACME", new_job_object.getEmployer().getValue());

        assertTrue(new_job_object.getLocation() instanceof Location);
        assertEquals("Desert", new_job_object.getLocation().getValue());

        assertTrue(new_job_object.getPositionType() instanceof PositionType);
        assertEquals("Quality control", new_job_object.getPositionType().getValue());

        assertTrue(new_job_object.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", new_job_object.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_equality_job_object_one.equals(test_equality_job_object_two));
    }

}
