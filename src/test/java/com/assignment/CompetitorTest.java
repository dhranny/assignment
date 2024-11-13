package com.assignment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class CompetitorTest {
    @InjectMocks
    CompetitorTest gameSetup;

    @Test
    public void testCreation() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(1, "Feyisayo", FeyisayoCompetitor.Level.BEGINNER);
        assert(comp.getCompetitorID() == 1);
        assert(comp.getCompetitorName() == "Feyisayo");
        assert(comp.getCompetitorLevel() == FeyisayoCompetitor.Level.BEGINNER);
    }

    @Test
    public void testSetterEquals() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(0, "Feyi", FeyisayoCompetitor.Level.ADVANCED);
        comp.setCompetitorID(1);
        comp.setCompetitorName("Feyisayo");
        comp.setCompetitorLevel(FeyisayoCompetitor.Level.BEGINNER);
        assert(comp.getCompetitorID() == 1);
        assert(comp.getCompetitorName() == "Feyisayo");
        assert(comp.getCompetitorLevel() == FeyisayoCompetitor.Level.BEGINNER);
    }

    @Test
    public void testSetterNotNull() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(1, "Feyisayo", FeyisayoCompetitor.Level.BEGINNER);
        assertNotNull(comp.getCompetitorID());
        assertNotNull(comp.getCompetitorName());
        assertNotNull(comp.getCompetitorLevel());
    }

    @Test
    public void testFullDetailsNotNull() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(1, "Feyisayo", FeyisayoCompetitor.Level.BEGINNER);
        assertNotNull(comp.getFullDetails());
    }

    @Test
    public void testFullDetailsEquals() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(1, "Bolu", FeyisayoCompetitor.Level.ADVANCED);
        comp.addScore(30);
        comp.addScore(30);
        comp.addScore(30);
        System.out.println(comp.getFullDetails());
        assert(comp.getFullDetails().equals("Competitor ID is 1, name Bolu. Bolu is a ADVANCED competitor with overall score of 90.0.\n"));
    }
    
    @Test
    public void testOverallScore() {
        FeyisayoCompetitor comp = new FeyisayoCompetitor(1, "Bolu", FeyisayoCompetitor.Level.ADVANCED);
        comp.addScore(30);
        comp.addScore(30);
        comp.addScore(30);
        assert(comp.getOverallScore() == 90);
    }
}
