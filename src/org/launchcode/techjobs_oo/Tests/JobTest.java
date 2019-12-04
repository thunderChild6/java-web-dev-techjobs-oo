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
    Job missing_name_object;
    Job missing_employer_object;
    Job missing_location_object;
    Job missing_position_object;
    Job missing_competency_object;
    Job missing_location_competency;

    @Before
    public void createJobObject() {
        empty_test_job_one = new Job();
        empty_test_job_two = new Job();
        new_job_object = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_equality_job_object_one = new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        test_equality_job_object_two = new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        missing_name_object = new Job("",new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        missing_employer_object = new Job("A", new Employer(""), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        missing_location_object =  new Job("A", new Employer("B"), new Location(""), new PositionType("D"), new CoreCompetency("E"));
        missing_position_object = new Job("A", new Employer("B"), new Location("C"), new PositionType(""), new CoreCompetency("E"));
        missing_competency_object =  new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency(""));
        missing_location_competency = new Job("A", new Employer("B"), new Location(""), new PositionType("D"), new CoreCompetency(""));
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

    @Test
    public void testJobToString() {
        assertEquals("\n" +
                "ID:  3" +
                "\nName:  Product tester" +
                "\nEmployer:  ACME" +
                "\nLocation:  Desert" +
                "\nPosition Type:  Quality control" +
                "\nCore Competency:  Persistence" +
                "\n", new_job_object.toString());
        assertEquals("\n" +
                "ID:  6" +
                "\nName:  Data not available" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n", missing_name_object.toString());
        assertEquals("\n" +
                "ID:  7" +
                "\nName:  A" +
                "\nEmployer:  Data not available" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n", missing_employer_object.toString());
        assertEquals("\n" +
                "ID:  8" +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  Data not available" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n",missing_location_object.toString());
        assertEquals("\n" +
                "ID:  9" +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  Data not available" +
                "\nCore Competency:  E" +
                "\n",missing_position_object.toString());
        assertEquals("\n" +
                "ID:  10" +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  Data not available" +
                "\n", missing_competency_object.toString());
        assertEquals("\n" +
                "ID:  11" +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  Data not available" +
                "\nPosition Type:  D" +
                "\nCore Competency:  Data not available" +
                "\n", missing_location_competency.toString());
    }

}
