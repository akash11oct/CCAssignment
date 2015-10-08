package practice.CCAssignment.ch6;

import java.util.Random;

/**
 *
 * @author Akash Gandotra
 */
public class Solution07 {
    public static void runGenderRatioSimulation() {
        int totalGirls = 0;
        int totalBoys = 0;
        int total = 0;

        Random r = new Random();

        for (int numRuns = 1; numRuns < 99999; numRuns++) {
            int boys = 0;
            int girls = 0;
            
            while (girls == 0)
            {
                if(r.nextBoolean())
                    boys++;
                else
                    girls++;
            }
            totalBoys += boys;
            totalGirls += girls;
        }
        
        total = totalBoys + totalGirls;
        double percentageBoys = (double) totalBoys / total;

        System.out.println(percentageBoys); //0.5000274990375337
    }

    public static void main(String[] args) {
        runGenderRatioSimulation();
    }
}
