package com.assignment;

import java.util.List;

public class Report {
    public  static void reportAll(List<FeyisayoCompetitor> competitors){
        System.out.println("This is the general report of competitiors");
        for (FeyisayoCompetitor comp : competitors) {
            String name = comp.getCompetitorName();
            while(name.length() < 8){
                name += " ";
            }
            System.out.println(comp.getCompetitorID() + "\t" + name + "\t" + comp.getCompetitorLevel() + "\t" + comp.getOverallScore());
        }
        FeyisayoCompetitor best = findBest(competitors);
        System.out.println("The best competitor is " + best.getCompetitorName() + " with an overall score of " + best.getOverallScore());
    }

    private static FeyisayoCompetitor findBest(List<FeyisayoCompetitor> competitors){
        FeyisayoCompetitor best = competitors.get(0);
        for (FeyisayoCompetitor comp : competitors) {
            if (comp.getOverallScore() > best.getOverallScore()) {
                best = comp;
            }
        }
        return best;
    }
}
