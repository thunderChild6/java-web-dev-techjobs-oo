package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JobTest {

    Job empty_test_job_one;
    Job empty_test_job_two;
    Job new_job_object;
    @Before
    public void createJobObject() {
        empty_test_job_one = new Job();
        empty_test_job_two = new Job();
        new_job_object = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

}
