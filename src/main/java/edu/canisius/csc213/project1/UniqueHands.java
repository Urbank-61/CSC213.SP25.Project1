package edu.canisius.csc213.project1;

/**
 * UniqueHands class to analyze how long it takes to see every possible hand 
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {
    public static void main(String[] args) {
        int[] deckSizes = {24, 28}; // Deck sizes to test
        int[] handSizes = {6, 7}; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");

        // TODO: Implement nested loops
        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!
        for (int size: deckSize){
            for(int handsize: handSize){
                for (int trial = 1; trial <= trials; trial++){
                    long startTime = System.nanoTime();
                    int attempts = countAttemptsToSeeAllHands(size, handSize);
                    long endTime = System.nanoTime();
                    double elapsedTime = (endTime - startTime) / 1_000_000_000.0;

                    System.out.printf("Deck Size: %d | Hnad Size: %d | Trail %d | Attempts: |%,d | Time: %.3f sec%n", size, handSize, trial, attempts, elapsedTime);
                }
            }
        }
    }

    public static int countAttemptsToSeeAllHands(int deckSize, int handSize){
        Deck desk = new Deck(deckSize);
        Set<Set<Card>> uniqueHands = new HashSet<>();
        Random random = new Random();
        int attempts = 0;
        int totalUniqueHands = calculateTotalUniqueHands(deckSize, handSize);\

        while (uniqueHands.size() < totalUniqueHands){
            attempts++;
            deck.shuffle();
            Set<Card> hand = new HashSet<>();
            for (int i = 0; i < handSize; i++){
                hand.add(deck.draw());
            }

            uniqueHands.add(hand);
            deck = new Deck(deckSize);

            if (attempts % 100_000 == 0) {
                double covergae = (uniqueHands.size() / (double)totalUniqueHands) * 100;
                int needed = totalUniqueHands - uniqueHands.size();
                System.out.printf("Progress: %.2f%% coverage after %,d attempts (Unique Hands: %,d / %,d | %,d | Needed: %,d)%n",
                 coverage, attempts, uniqueHands.size(), totalUniqueHands, needed);
            }
        }

        return attempts;
    }

    public static int calculateTotalUniqueHands(int deckSize, int handSize){
        long numerator = 1;
        long denominator = 1;

        for (int i = 0; i < handSize; i++){
            numerator *= (deckSize - i);
            denominator *= (i + 1);
        }
        return (int) (numerator / denominator);
    }

    // TODO: Implement countAttemptsToSeeAllHands()
    // TODO: Implement calculateTotalUniqueHands()
}