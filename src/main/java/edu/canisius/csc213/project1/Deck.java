package edu.canisius.csc213.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Represents a deck of playing cards with a configurable size.
 */
public class Deck {
    private final List<Card> cards;

    /**
     * Creates a deck with a given size.
     * The size must be a multiple of 4 and at most 52.
     * 
     * @param size The number of cards in the deck.
     * @throws IllegalArgumentException if size is invalid.
     */
    public Deck(int size) {
        if (size % 4 != 0 || size > 52 || size <= 0){
            throw new IllegalArgumentException("Size must be a multiple of 4 and between 4 and 52.");
        }
        cards = new ArrayList<>();

        int cardTypes = size /4;
        Card.Rank[] ranks = Card.Rank.values();
        for (int i = 0; i < cardTypes; i++){
            for (Card.Suit suit : Card.Suit.values()){
                cards.add(new Card(suit, ranks[i]));
            }
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);

        /* or self implemented 
        Random random = new Random();
        for (int i = cards.size() -1; i > 0; i--){
            // pick a random index
            int j = random.nextInt(i + 1);
            // swap cards[i] cards[j]
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
        */

    }

    /**
     * Draws the top card from the deck.
     * 
     * @return The drawn card.
     * @throws NoSuchElementException if the deck is empty.
     */
    public Card draw() {
        // TODO: Implement draw logic.
        if (cards.isEmpty()){
            throw new NoSuchElementException("Deck is empty");
        }
        return cards.remove(0);
    }

    /**
     * Gets the number of remaining cards in the deck.
     *
     * @return The number of cards left.
     */
    public int size() {

        // TODO: Implement size method.
        return cards.size();
    }
}