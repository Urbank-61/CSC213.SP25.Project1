package edu.canisius.csc213.project1;

import java.util.Objects;

/**
 * Represents a playing card with a suit and rank.
 * testing here
 */
public class Card {

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    public enum Rank { 
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE 
    }

    // TODO: Define private fields for suit and rank.
    private final Suit suit;
    private final Rank rank;

    // TODO: Implement the constructor.
    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }

    // TODO: Implement getters for suit and rank.
    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;

    }

    // TODO: Override toString() to return a readable format.
    @Override
    public String toString(){
        String outPut = this.rank + " of " + this.suit;
        return outPut;
    }

    // TODO: Override equals() and hashCode() for comparisons./
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Card otherCard = (Card) obj;
        return suit == otherCard.suit && rank == otherCard.rank;
    }
    }

    @Override
    public int hashCode(){
        return Objects.hash(suit, rank);
    }
}