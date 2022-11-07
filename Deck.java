import java.util.*;
import java.io.*;

/**
 * Deck class
 * @author Rohit Arun
 */
public class Deck {
    
    /** Cards in deck variable */
    public static final int CARDS_IN_DECK = 52;

    /** Random game variable */
    public static int NEXT_HOLDER;

    /** private variable cards */
    private Card[] cards;

    /** private variable next */
    private int next;

    /** private variable seed */
    private int seed;

    /**
     * Constructor for Deck class 
     * that constructs an array of the deck
     * of cards using 4 different for loops
     * 
     * @param seed the seed for the random number generator
     */
    public Deck(int seed){
        this.cards = new Card[CARDS_IN_DECK]; 
        Card cardObject;
        this.seed = seed;
        this.next = 0;

        for (int i = Card.LOWEST_VALUE; i <= Card.HIGHEST_VALUE; i++){
            cardObject = new Card(i, Card.CLUBS);
            this.cards[this.next] = cardObject;
            this.next++;
        }

        for (int j = Card.LOWEST_VALUE; j <= Card.HIGHEST_VALUE; j++){
            cardObject = new Card(j, Card.DIAMONDS);
            this.cards[this.next] = cardObject;
            this.next++;
        }

        for (int k = Card.LOWEST_VALUE; k <= Card.HIGHEST_VALUE; k++){
            cardObject = new Card(k, Card.HEARTS);
            this.cards[this.next] = cardObject;
            this.next++;
        }

        for (int l = Card.LOWEST_VALUE; l <= Card.HIGHEST_VALUE; l++){
            cardObject = new Card(l, Card.SPADES);
            this.cards[this.next] = cardObject;
            this.next++;
        }
        this.next = 0;
    }

    /**
     * void method that shuffles the
     * deck after it is constructed
     */
    public void shuffle(){
        Card objectHolder;
        int randHolder;
        Random rand = new Random();

        for (int i = CARDS_IN_DECK - 1; i >= 1; i--){
            objectHolder = this.cards[i];
            randHolder = rand.nextInt(i + 1);
            this.cards[i] = this.cards[randHolder];
            this.cards[randHolder] = objectHolder;
        }
    }

    /**
     * increments the value of next
     * in order to return the next card 
     * up
     * 
     * @return next card in deck.
     * @throws IllegalStateException no more cards, if next greater than
     * or equal to cards in deck
     */
    public Card nextCard(){

        if (this.next >= CARDS_IN_DECK){
            throw new IllegalStateException("No more cards");
        }
        return cards[this.next++];
    }

    /**
     * checks if this instance of 
     * deck is equal to Object o's 
     * instance of the deck
     * 
     * @param o Object o
     * @return if two instances are equal (T/F)
     */
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        
        try {
            Deck oDeck = (Deck) o;

            if (this.seed != oDeck.seed){
                return false;
            }
            if (this.toString().equals(oDeck.toString())){
                return true;
            } 
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Converts cards in deck 
     * into a string with the 
     * order of the string
     * 
     * @return string value of deck array
     */
    public String toString(){
        String cardsInDeck = "";
        for (int i = 0; i < CARDS_IN_DECK; i++){
            cardsInDeck += "card " + i + ": " + this.cards[i].toString() + "\n";
        }
        return cardsInDeck;
    }
}