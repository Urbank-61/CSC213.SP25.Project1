package edu.canisius.csc213.project1;

import java.util.List;

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


     // TODO: Validate size (must be a multiple of 4 and at most 52).
     // TODO: Initialize the deck with the correct cards.
    public Deck(int size) {
        if (size % 4 != 0 || size > 52 || size <= 0){
            throw new IllegalArgumentException("Size must be a multiple of 4 and between 4 and 52.");
        }
        cards new ArrayList<>();
        int cardTypes = size / 4;

        for (Card.Rank rank : Card.Rank.values()){
            if (cardTypes-- == 0){
                for(Card.Suit suit : Card.Suit.values()){
                    cards.add(new Card(suit, rank));
                }
            }
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collection.shuffle(cards);
        // TODO: Implement shuffle logic.
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