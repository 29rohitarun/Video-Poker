
/**
 * Interacts with GUI and other classes
 * to display the video poker game. 
 * 
 * @author Rohit Arun
 */
public class VideoPoker {

    /** The number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;

    /**  The number of points that the player has when the game begins */
    public static final int STARTING_POINTS = 100;

    /** The number of points needed to play a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;

    /** Indicates that a random game should be played */
    public static final int RANDOM_GAME = -1;

    /** The number of points awarded for a Royal Flush */
    public static final int ROYAL_FLUSH = 100;

    /** The number of points awarded for a Straight Flush */
    public static final int STRAIGHT_FLUSH = 60;

    /** The number of points awarded for Four of a Kind */
    public static final int FOUR_OF_A_KIND = 50;

    /** The number of points awarded for a Full House */
    public static final int FULL_HOUSE = 40;

    /** The number of points awarded for a Flush */
    public static final int FLUSH = 30;

    /**  The number of points awarded for a Straight */
    public static final int STRAIGHT = 25;

    /**  The number of points awarded for Three of a Kind */
    public static final int THREE_OF_A_KIND = 15;

    /** The number of points awarded for Two Pairs */
    public static final int TWO_PAIRS = 10;

    /**  The number of points awarded for One Pair */
    public static final int ONE_PAIR = 7;

    /** The Deck of cards that will be used to play the game */
    private Deck deck;

    /** The Hand of Cards in the game */
    private Hand hand;

    /** The current number of points */
    private int points;

    /**
     * video poker class constructor
     * instantiates deck and points
     * 
     * @param seed seed for consistent random number generation
     */
    public VideoPoker(int seed){

        this.deck = new Deck(seed);
        this.points = STARTING_POINTS;
    }

    /**
     * getter method for points
     * 
     * @return integer value of player's points
     */
    public int getPoints(){
        return points;
    }

    /**
     * uses the getCard method from the hand
     * class to construct a string that represents
     * the file locations of the card images.
     * 
     * @param index index value for the getCard (type Card) method.
     * @return string of card's file name and location
     */
    public String getCardFileName(int index){
        String cardFileName = "cards/";

        cardFileName += this.hand.getCard(index);
        cardFileName += ".gif";
        return cardFileName;
    }

    /**
     * Obtains card from getCard method in 
     * Hand class
     * 
     * @param index player's points
     * @return card of type Card at specified index.
     */
    public Card getCard(int index){
        return this.hand.getCard(index);
    }

    /**
     * void method that subtracts points,
     * shuffles the deck, and constructs new
     * array of type Card[] to instantiate hand.
     * adds points to point field accordingly.
     * 
     */
    public void newGame(){
        this.points = this.points - POINTS_FOR_NEW_GAME;
        this.deck.shuffle();

        Card[] newCards = new Card[CARDS_IN_HAND];

        for(int i = 0; i < CARDS_IN_HAND; i++){
            newCards[i] = this.deck.nextCard();
        }

        this.hand = new Hand(newCards);
    }

    /**
     * void method replaces card at
     * specified index using the nextCard
     * method in class deck.
     * 
     * @param index index value for replace method.
     */
    public void replaceCard(int index){
        this.hand.replace(index, this.deck.nextCard());
    }

    /**
     * Checks if the hand methods for hand values
     * are true and returns a string of the 
     * true value.
     * 
     * @return string of score based on hand class
     */
    public String scoreHand(){
        String value = "";

        if (hand.isRoyalFlush() == true){
            value = "Royal Flush";
            this.points = this.points + ROYAL_FLUSH;
        }
        else if (hand.isStraightFlush() == true){
            value = "Straight Flush";
            this.points = this.points + STRAIGHT_FLUSH;
        }
        else if (hand.hasFourOfAKind() == true){
            value = "Four of a Kind";
            this.points = this.points + FOUR_OF_A_KIND;
        }
        else if (hand.isFullHouse() == true){
            value = "Full House";
            this.points = this.points + FULL_HOUSE;
        }
        else if (hand.isFlush() == true){
            value = "Flush";
            this.points = this.points + FLUSH;
        }
        else if (hand.isStraight() == true){
            value = "Straight";
            this.points = this.points + STRAIGHT;
        }
        else if (hand.hasThreeOfAKind() == true){
            value = "Three of a Kind";
            this.points = this.points + THREE_OF_A_KIND;
        }
        else if (hand.hasTwoPairs() == true){
            value = "Two Pairs";
            this.points = this.points + TWO_PAIRS;
        }
        else if (hand.hasOnePair() == true){
            value = "One Pair";
            this.points = this.points + ONE_PAIR;
        }
        else {
            this.points = this.points + 0;
            value = "No Pair";
        }
        return value;
    }
}