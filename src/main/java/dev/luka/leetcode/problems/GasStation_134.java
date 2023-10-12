package dev.luka.leetcode.problems;

public class GasStation_134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int finalRemainGas = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            finalRemainGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0){
                startStation = i + 1; // move to next station to check
                currentGas = 0; // reset currentGas to 0 to make this is a new starting station.
            }
        }

        return finalRemainGas >= 0 ? startStation : -1; // if finalRemainGas < 0 means it's not enough gas to complete the circle
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // return 3
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // return -1
    }
}
