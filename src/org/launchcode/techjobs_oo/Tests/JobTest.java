package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void emptyConstructorSetsId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
        assertTrue(job1.getId() +1 == job2.getId());
    }

    @Test
    public void fullConstructorSetsFields() {
        Job job3 = new Job("Field Set Test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Field Set Test", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Equality Test", new Employer("A"), new Location("B"), new PositionType("C"), new CoreCompetency("D"));
        Job job5 = new Job("Equality Test", new Employer("A"), new Location("B"), new PositionType("C"), new CoreCompetency("D"));
        assertFalse(job4.equals(job5));
    }

    @Test
public void testJobToString() {
    Job all_fields_object = new Job("ToString Test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job missing_name_object = new Job("",new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
    Job missing_employer_object = new Job("A", new Employer(""), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
    Job missing_location_object =  new Job("A", new Employer("B"), new Location(""), new PositionType("D"), new CoreCompetency("E"));
    Job missing_position_object = new Job("A", new Employer("B"), new Location("C"), new PositionType(""), new CoreCompetency("E"));
    Job missing_competency_object =  new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency(""));
    Job missing_location_competency = new Job("A", new Employer("B"), new Location(""), new PositionType("D"), new CoreCompetency(""));
        assertEquals("\n" +
                "ID:  "+ all_fields_object.getId() +
                "\nName:  ToString Test" +
                "\nEmployer:  ACME" +
                "\nLocation:  Desert" +
                "\nPosition Type:  Quality control" +
                "\nCore Competency:  Persistence" +
                "\n", all_fields_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_name_object.getId() +
                "\nName:  Data not available" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n", missing_name_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_employer_object.getId() +
                "\nName:  A" +
                "\nEmployer:  Data not available" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n", missing_employer_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_location_object.getId() +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  Data not available" +
                "\nPosition Type:  D" +
                "\nCore Competency:  E" +
                "\n",missing_location_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_position_object.getId() +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  Data not available" +
                "\nCore Competency:  E" +
                "\n",missing_position_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_competency_object.getId() +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  C" +
                "\nPosition Type:  D" +
                "\nCore Competency:  Data not available" +
                "\n", missing_competency_object.toString());
        assertEquals("\n" +
                "ID:  "+ missing_location_competency.getId() +
                "\nName:  A" +
                "\nEmployer:  B" +
                "\nLocation:  Data not available" +
                "\nPosition Type:  D" +
                "\nCore Competency:  Data not available" +
                "\n", missing_location_competency.toString());
    }

}
