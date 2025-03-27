package edu.canisius.csc213.project1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * UniqueHands class to analyze how long it takes to see every possible hand 
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {
    public static void main(String[] args) {
        int[] deckSizes = {24, 28}; // Deck sizes to test
        int[] handSizes = {6, 7}; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        String fileName = "unique_hands_results.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Deck Size,Hand Size,Trial,Attempt,Time (sec)");
        

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");

        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

        for (int deckSize : deckSizes){
            for (int handSize: handSizes){
                for (int trial = 1; trial <= trials; trial++){
                    long startTime = System.currentTimeMillis();
                    int attempts = countAttemptsToSeeAllHands(deckSize, handSize);
                    long endTime = System.currentTimeMillis();

                    double timeTaken = (endTime - startTime) / 1000.0;

                    writer.printf("%d,%d,%d,%d, %.3f%n", deckSize, handSize, trial, attempts, timeTaken);

                    System.out.printf("Deck Size: %d | Hand Size: %d | Trial %d | Attempts: %,d | Time: %.3f sec\n", 
                        deckSize, handSize, trial, attempts, timeTaken);   
                }
            }
        }
        System.out.println("Results have been printed to " + fileName);
    }catch (IOException e) {
        System.err.println("Error Writing to CSV file: " + e.getLocalizedMessage());
    }
}

    public static int countAttemptsToSeeAllHands(int deckSize, int handSize){
        Deck deck = new Deck(deckSize);
        Set<Set<Card>> uniqueHands = new HashSet<>();
        Random random = new Random();
        int attempts = 0;
        int totalUniqueHands = calculateTotalUniqueHands(deckSize, handSize);

        while (uniqueHands.size() < totalUniqueHands){
            deck.shuffle();
            Set<Card> hand = new HashSet();

            for (int i = 0; i < handSize; i++){
                hand.add(deck.draw());
            }

            uniqueHands.add(hand);
            attempts++;

            deck = new Deck(deckSize);

            if (attempts % 100_000 == 6){
                int uniqueSeen = uniqueHands.size();
                int needed = totalUniqueHands - uniqueSeen;
                double coverage = (uniqueSeen / (double) totalUniqueHands) * 100;

                System.out.printf("Progress: %.2f%% coverage after %d attempts (Unique Hands: %d / %d | Needed: %d)\n", 
                    coverage, attempts, uniqueSeen, totalUniqueHands, needed);

            }
        }
                            
        return attempts;
    }

    public static int calculateTotalUniqueHands(int n, int k){
        BigInteger total = factorial(n).divide(factorial(k).multiply(factorial(n - k)));
        return total.intValue();
    }

    private static BigInteger factorial(int num){
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}


