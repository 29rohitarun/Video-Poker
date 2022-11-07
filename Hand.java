import java.util.*;

/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Rohit Arun
 */
public class Hand {

    /** Cards in hand constant variable */
    public static final int CARDS_IN_HAND = 5;

    /** Value for increment in hasOnePair() method */
    public static final int HAS_ONE_PAIR_INCREMENT1 = 13;

    /** Value for second increment in hasOnePair() method */
    public static final int HAS_ONE_PAIR_INCREMENT2 = 7;

    /** Value for increment in hasTwoPairs() method */
    public static final int HAS_TWO_PAIRS_INCREMENT = 9;

    /** Value for increment in hasThreeOfAKind() method */
    public static final int HAS_THREE_OF_A_KIND_INCREMENT = 12;

    /** Value for increment in hasFourOfAKind() method */
    public static final int HAS_FOUR_OF_A_KIND_INCREMENT = 8;

    /** Value for isRoyalFlush() method */
    public static final int IS_ROYAL_FLUSH_VALUE = 10;

    /** Contains cards in hand */
    private Card[] hand;

    /**
     * Constructor for class Hand
     * throws exceptions and instantiates
     * Card[] hand
     * 
     * @param hand cards array
     * @throws IllegalArgumentException Null array, if hand is null
     * @throws IllegalArgumentException Invalid array length, if length of hand not equal to 5.
     * @throws IllegalArgumentException Null element, if any element in Card[] hand is null.
     */
    public Hand(Card[] hand){

        if (hand == null){
            throw new IllegalArgumentException("Null array");
        }

        if (hand.length != CARDS_IN_HAND){
            throw new IllegalArgumentException("Invalid array length");
        }

        for (int i = 0; i < hand.length; i++){
            if (hand[i] == null){
                throw new IllegalArgumentException("Null element");
            }
        }

        this.hand = hand;
    }

    /**
     * Obtains card at specified index value.
     * 
     * @param index index of array
     * @return individual card 
     * @throws IllegalArgumentException Invalid index, if index less than 0 or greater than 5
     */
    public Card getCard(int index){

        if (index < 0 || index >= CARDS_IN_HAND){
            throw new IllegalArgumentException("Invalid index");
        }
        return this.hand[index];
    }

    /**
     * Method that replaces array at specified
     * index with value of card (type Card).
     * 
     * @param index index of array
     * @param card card in array
     * @throws IllegalArgumentException Invalid index, if index less than 0 or greater than 5
     * @throws IllegalArgumentException Null card, if card is null
     */
    public void replace(int index, Card card){
        if (index < 0 || index >= CARDS_IN_HAND){
            throw new IllegalArgumentException("Invalid index");
        }

        if (card == null){
            throw new IllegalArgumentException("Null card");
        }
        this.hand[index] = card;
    }

    /**
     * Converts array to its
     * string interpretation using
     * a for loop
     * 
     * @return string version of hand array (type Card[])
     */
    public String toString(){
        String handString = "";

        handString += "[";
        for (int i = 0; i < CARDS_IN_HAND; i++){
            handString += this.hand[i];
            if (i < CARDS_IN_HAND - 1){
                handString += ", ";
            }
        }
        handString += "]";
        return handString;
    }

    /**
     * Boolean method that checks if
     * this instance of class is equal to 
     * instance of Object o by comparing the string 
     * values for each.
     * 
     * @param o instance of Hand class.
     * @return if this instance is equal to, or not equal to, other instance
     */
    public boolean equals(Object o){
    
        if (o == null){
            return false;
        }
        try {
            Hand oHand = (Hand) o;
            if (this.toString().equals(oHand.toString())){
                return true;
            }
            else {
                return false;
            }
        } 
        catch (Exception e){
            return false;
        }
    }

    /**
     * Checks if the hand is flush 
     * using a for loop.
     * 
     * @return if hand is flush (T/F)
     */
    public boolean isFlush(){
        char suitHolder = this.hand[0].getSuit();
        char suitChecker = 'a';
        boolean isSame = true;
       
        for(int i = 1; i < CARDS_IN_HAND; i++){
            suitChecker = this.hand[i].getSuit();
            if (suitChecker != suitHolder){
                isSame = false;
            }
        }
        return isSame;
    }

    /**
     * Checks if the hand is straight
     * using a for loop and an incrementing 
     * system.
     * 
     * @return if hand is straight (T/F)
     */
    public boolean isStraight(){
        int valueHolder = this.hand[0].getValue();
        int valueChecker;
        boolean isStraight = true;

        for (int i = 1; i < CARDS_IN_HAND; i++){
            valueChecker = this.hand[i].getValue();
            if (valueChecker != valueHolder + 1){
                return false;
            }
            else {
                valueHolder++;
            }
        }
        return isStraight;
    }

    /**
     * Checks if the isStraight 
     * and isFlush() methods are 
     * true to determine if the hand is 
     * straight flush
     * 
     * @return if hand is straight flush (T/F)
     */
    public boolean isStraightFlush(){
        if (isStraight() == true && isFlush() == true){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if the hand is royal flush
     * using a for loop and incrementing number
     * system.
     * 
     * @return if the hand is a royal flush (T/F)
     */
    public boolean isRoyalFlush(){
        int valueHolder = this.hand[0].getValue();
        int valueChecker;
        boolean isRoyalFlush = true;

        if (valueHolder != IS_ROYAL_FLUSH_VALUE){
            return false;
        }

        if (isFlush() != true){
            return false;
        }

        for (int i = 1; i < CARDS_IN_HAND; i++){
            valueChecker = this.hand[i].getValue();
            if (valueChecker != valueHolder + 1){
                return false;
            }
            else {
                valueHolder++;
            }
        }
        return isRoyalFlush;
    }

    /**
     * Checks if the hand has four of 
     * a kind using a nested for loop with
     * an incrementing system.
     * 
     * @return if hand has four of a kind (T/F)
     */
    public boolean hasFourOfAKind(){
        int handCards = 0;
        int valueIncrement = 0;

        for (int i = 0; i < CARDS_IN_HAND; i++){
            handCards = this.hand[i].getValue();
            for (int j = 0; j < CARDS_IN_HAND; j++){
                if (this.hand[j].getValue() != handCards){
                    valueIncrement++;
                }
            }
        }
        if (valueIncrement <= HAS_FOUR_OF_A_KIND_INCREMENT){ 
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if the hand has three of 
     * a kind using a nested for loop with
     * an incrementing system.
     * 
     * @return if hand has three of a kind (T/F)
     */
    public boolean hasThreeOfAKind(){
        int handCards = 0;
        int valueIncrement = 0;

        for (int i = 0; i < CARDS_IN_HAND; i++){
            handCards = this.hand[i].getValue();
            for (int j = 0; j < CARDS_IN_HAND; j++){
                if (this.hand[j].getValue() != handCards){
                    valueIncrement++;
                }
            }
        }
        if (valueIncrement == HAS_THREE_OF_A_KIND_INCREMENT){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if the hand has 
     * two pairs of cards using a nested
     * for loop system and an incrementing number
     * system.
     * 
     * @return if hand has two pairs (T/F)
     */
    public boolean hasTwoPairs(){
        int handCards = 0;
        int valueIncrement = 0;

        for (int i = 0; i < CARDS_IN_HAND; i++){
            handCards = this.hand[i].getValue();
            for (int j = 0; j < CARDS_IN_HAND; j++){
                if (this.hand[j].getValue() == handCards){
                    valueIncrement++;
                }
            }
        }
        if (valueIncrement == HAS_TWO_PAIRS_INCREMENT){ 
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if the hand has one pair of
     * cards using a nested for loop, 
     * incrementing number system.
     * 
     * @return if hand has one pair (T/F)
     */
    public boolean hasOnePair(){

        int handCards = 0;
        int valueIncrement = 0;

        for (int i = 0; i < CARDS_IN_HAND; i++){
            handCards = this.hand[i].getValue();
            for (int j = 0; j < CARDS_IN_HAND; j++){
                if (this.hand[j].getValue() == handCards){
                    valueIncrement++;
                }
            }
        }
        if (hasFourOfAKind() == true){
            return false;
        }

        if (hasThreeOfAKind() == true){
            if (valueIncrement == HAS_ONE_PAIR_INCREMENT1){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (valueIncrement == HAS_ONE_PAIR_INCREMENT2){
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * Checks if the hand has
     * a full house by checking
     * the values of the 
     * hasOnePair() method and
     * the hasThreeOfAKind() method.
     * 
     * @return if hand is a full house (T/F)
     */
    public boolean isFullHouse(){

        if (hasOnePair() == true && hasThreeOfAKind() == true){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
}