/**
 * Card Class
 * @author Rohit Arun
 */
public class Card {

    /** Clubs variable */
    public static final char CLUBS = 'c';

    /** Diamonds variable */
    public static final char DIAMONDS = 'd';

    /** Spades variable */
    public static final char SPADES = 's';

    /** Hearts variable */
    public static final char HEARTS = 'h';

    /** Lowest value variable */
    public static final int LOWEST_VALUE = 2;

    /** Highest value variable */
    public static final int HIGHEST_VALUE = 14;

    /** private variable value */
    private int value;

    /** private variable suit */
    private char suit;

    /**
     * Constructor that
     * instantiates value and suit
     * 
     * @param value value of card
     * @param suit suit of card
     * @throws IllegalArgumentException Invalid value, if value less than lowest 
     * value or more than highest value
     * @throws IllegalArgumentException Invalid suit, if suit not equal to one of 
     * four characters.
     */
    public Card(int  value, char suit){
        this.value = value;
        this.suit = suit;

        if (this.value < LOWEST_VALUE || this.value > HIGHEST_VALUE){
            throw new IllegalArgumentException("Invalid value");
        }

        if (this.suit != CLUBS && this.suit != DIAMONDS && 
            this.suit != SPADES && this.suit != HEARTS){
            throw new IllegalArgumentException("Invalid suit");
        }
    }

    /**
     * Getter method for the value
     * 
     * @return value of type integer
     */
    public int getValue(){
        return value;
    }

    /**
     * Getter method for the suit
     * 
     * @return suit of type char
     */
    public char getSuit(){
        return suit;
    }

    /**
     * Checks if the cards of this instance
     * are equal to that of Object o's instance
     * by comparing their string values
     * 
     * @param o object o, other instance
     * @return if cards are equal (T/F)
     */
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if (this.toString().equals(o.toString())){
            return true;
        } 
        else {
            return false;
        }
    }

    /**
     * Converts the suit and value 
     * into one string representing a 
     * card
     * 
     * @return string version of individual cards
     */
    public String toString(){
        String suitValue;

        suitValue = Character.toString(this.suit);
        suitValue += Integer.toString(this.value);

        return suitValue;
    }

    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
}