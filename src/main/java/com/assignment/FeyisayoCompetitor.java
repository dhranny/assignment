package com.assignment;
import java.util.List;
import java.util.ArrayList;

public class FeyisayoCompetitor {

    public enum Level { BEGINNER, INTERMEDIATE, ADVANCED }

    private int competitorID;
    private String competitorName;
    private Level competitorLevel;
    private List<Integer> scores;

    public FeyisayoCompetitor(int competitorID, String competitorName, Level competitorLevel) {
        
        this.competitorID = competitorID;
        this.competitorName = competitorName;
        this.competitorLevel = competitorLevel;
        scores = new ArrayList<Integer>();
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public void setCompetitorLevel(Level competitorLevel) {
        this.competitorLevel = competitorLevel;
    }

    public int getCompetitorID() {
        return competitorID;
    }
    
    public void setCompetitorID(int competitorID) {
        this.competitorID = competitorID;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public Level getCompetitorLevel() {
        return competitorLevel;
    }

    public void addScore(int score) {
        scores.add(score);
    }
    public double getOverallScore(){
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public String getFullDetails(){
        String sb = "Competitor ID is " + competitorID + ", " + "name " + competitorName + ". " + competitorName 
            + " is a " + competitorLevel + " competitor with overall score of " + getOverallScore() + ".\n";
        return sb;
    }

    public String getShortDetails(){
        String sb = "Competitor ID: " + competitorID +  ".\nOverall score: " + getOverallScore() + ".\n";
        return sb;
    }

}

