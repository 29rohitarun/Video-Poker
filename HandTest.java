import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Hand class
 * @author Suzanne Balik
 * @author Rohit Arun
 */
public class HandTest {
    
    /** hand for testing */
    private Hand hand;

    /**
     * Creates hand for testing
     */
    @BeforeEach
    public void setUp() {
        Card[] cards = {new Card(2,'c'), new Card(3,'d'), new Card(4,'s'), new Card(5,'h'), 
                        new Card(6,'c')};
        hand = new Hand(cards);
    }

    /**
     * Tests that the constant is correct
     */
    @Test
    public void testConstant() {
        // The following test tests that the constant is defined as specified
        assertEquals(5, Hand.CARDS_IN_HAND, "CARDS_IN_HAND");
    }

    /**
     * Tests the getCard() method
     */
    @Test
    public void testGetCard() {
        assertEquals(new Card(2,'c'), hand.getCard(0), "Card 2 c");
        assertEquals(new Card(3,'d'), hand.getCard(1), "Card 3 d");
        assertEquals(new Card(4,'s'), hand.getCard(2), "Card 4 s");
        assertEquals(new Card(5,'h'), hand.getCard(3), "Card 5 h");
        assertEquals(new Card(6,'c'), hand.getCard(4), "Card 6 c");
    }

    /**
     * Tests the replace() method
     */
    @Test
    public void testReplace() {
        hand.replace(2, new Card(8, 'h'));
        assertEquals(new Card(8,'h'), hand.getCard(2), "Card 8 h");
    }
    
    /**
     * Tests the toString() method
     */
    @Test
    public void testToString() {
        assertEquals("[c2, d3, s4, h5, c6]", hand.toString(), "toString  after constructed");
    }

    /**
     * Tests the equals() method
     */
    @Test
    public void testEquals() {
        Card[] cards = {new Card(2,'c'), new Card(3,'d'), new Card(4,'s'), new Card(5,'h'), 
                        new Card(6,'c')};
        Hand sameHand = new Hand(cards);
        Card[] differentCards = {new Card(10,'c'), new Card(3,'d'), new Card(14,'s'), 
                                 new Card(5,'h'), new Card(6,'c')};
        Hand differentHand = new Hand(differentCards);
        assertTrue(hand.equals(hand), "hand equals with same instance");
        assertTrue(hand.equals(sameHand), "hand equals with different instances");
        assertFalse(hand.equals(differentHand), "hand with different hand");
        assertFalse(hand.equals(null), "hand compared to null object");
        assertFalse(hand.equals("Hand"), "hand compared to String");
    }

    /**
     * Tests the isFlush() method
     */
    @Test 
    public void testIsFlush() {
        Card[] cards = {new Card(2,'c'), new Card(3,'c'), new Card(10,'c'), new Card(12,'c'), 
                        new Card(6,'c')};
        Hand flushHand = new Hand(cards);
        assertTrue(flushHand.isFlush(), "Flush hand");
        assertFalse(hand.isFlush(), "Not flush hand");
    } 

    /**
     * Tests the isStraight() method
     */
    @Test 
    public void testIsStraight() {
        Card[] cards = {new Card(2,'d'), new Card(5,'c'), new Card(4,'c'), new Card(9,'c'), 
                        new Card(3,'d')};
        Hand straightHand = new Hand(cards);
        assertTrue(hand.isStraight(), "Straight hand");
        assertFalse(straightHand.isStraight(), "Not straight hand");
    } 


    /**
     * Tests the isStraightFlush() method
     */
    @Test 
    public void testIsStraightFlush() {
        Card[] cards = {new Card(2,'c'), new Card(3,'c'), new Card(4,'c'), new Card(5,'c'), 
                        new Card(6,'c')};
        Hand straightFlushHand = new Hand(cards);
        assertTrue(straightFlushHand.isStraightFlush(), "Straight flush hand");
        assertFalse(hand.isStraightFlush(), "Not straight flush hand");
    } 
    
    /**
     * Tests the isRoyalFlush() method
     */
    @Test 
    public void testIsRoyalFlush() {
        Card[] cards = {new Card(10,'c'), new Card(11,'c'), new Card(12,'c'), new Card(13,'c'), 
                        new Card(14,'c')};
        Hand royalFlushHand = new Hand(cards);
        assertTrue(royalFlushHand.isRoyalFlush(), "Royal flush hand");
        assertFalse(hand.isRoyalFlush(), "Not Royal flush hand");
    } 
    
    /**
     * Tests the hasFourOfAKind() method
     */
    @Test 
    public void testhasFourOfAKind() {
        Card[] cards = {new Card(10,'c'), new Card(10,'h'), new Card(10,'c'), new Card(10,'c'), 
            new Card(9,'d')};

        Card[] cards1 = {new Card(10,'c'), new Card(10,'h'), new Card(10,'c'), new Card(9,'c'), 
            new Card(9,'d')};   
        
        Card[] cards2 = {new Card(9,'c'), new Card(9,'h'), new Card(10,'c'), new Card(10,'c'), 
            new Card(10,'d')};   
                        
        Hand fourOfAKindHand = new Hand(cards);
        Hand fourOfAKindHand1 = new Hand(cards1);
        Hand fourOfAKindHand2 = new Hand(cards2);

        assertTrue(fourOfAKindHand.hasFourOfAKind(), "Four of a kind hand");
        assertFalse(hand.hasFourOfAKind(), "Not four of a kind hand");
        assertFalse(fourOfAKindHand1.hasFourOfAKind(), "Not four of a kind hand");
        assertFalse(fourOfAKindHand2.hasFourOfAKind(), "Not four of a kind hand");
    } 
    
     /**
     * Tests the hasThreeOfAKind() method
     */
    @Test 
    public void testhasThreeOfAKind() {
        Card[] cards = {new Card(10,'c'), new Card(10,'h'), new Card(10,'c'), new Card(9,'c'), 
            new Card(9,'d')};

        Card[] cards1 = {new Card(10,'c'), new Card(9,'h'), new Card(10,'c'), new Card(10,'c'), 
            new Card(9,'d')};   
        
        Card[] cards2 = {new Card(9,'c'), new Card(9,'h'), new Card(8,'c'), new Card(10,'c'), 
            new Card(10,'d')};   
                        
        Hand threeOfAKindHand = new Hand(cards);
        Hand threeOfAKindHand1 = new Hand(cards1);
        Hand threeOfAKindHand2 = new Hand(cards2);

        assertTrue(threeOfAKindHand.hasThreeOfAKind(), "Three of a kind hand");
        assertFalse(hand.hasThreeOfAKind(), "Not three of a kind hand");
        assertTrue(threeOfAKindHand1.hasThreeOfAKind(), "Three of a kind hand");
        assertFalse(threeOfAKindHand2.hasThreeOfAKind(), "Not three of a kind hand");
    } 

    /**
     * Tests the hasTwoPairs() method
     */
    @Test 
    public void testhasTwoPairs() {
        Card[] cards = {new Card(4,'c'), new Card(4,'h'), new Card(10,'c'), new Card(6,'c'), 
            new Card(6,'d')};

        Card[] cards1 = {new Card(5,'c'), new Card(9,'h'), new Card(9,'c'), new Card(3,'c'), 
            new Card(3,'d')};   
        
        Card[] cards2 = {new Card(4,'c'), new Card(3,'h'), new Card(4,'c'), new Card(4,'c'), 
            new Card(4,'d')};   
                        
        Hand twoPairsHand = new Hand(cards);
        Hand twoPairsHand1 = new Hand(cards1);
        Hand twoPairsHand2 = new Hand(cards2);

        assertTrue(twoPairsHand.hasTwoPairs(), "Two pairs hand 4,6");
        assertFalse(hand.hasTwoPairs(), "Not two pairs hand");
        assertTrue(twoPairsHand1.hasTwoPairs(), "Two pairs hand 9,3");
        assertFalse(twoPairsHand2.hasTwoPairs(), "Not two pairs hand three 4's");
    } 

    /**
     * Tests the hasOnePair() method
     */
    @Test 
    public void testhasOnePairs() {
        Card[] cards = {new Card(4,'c'), new Card(4,'h'), new Card(10,'c'), new Card(10,'c'), 
            new Card(10,'d')};

        Card[] cards1 = {new Card(2,'c'), new Card(2,'h'), new Card(9,'c'), new Card(3,'c'), 
            new Card(4,'d')};   
        
        Card[] cards2 = {new Card(4,'c'), new Card(4,'h'), new Card(4,'c'), new Card(4,'c'), 
            new Card(4,'d')};   

        Card[] cards3 = {new Card(3,'c'), new Card(4,'h'), new Card(4,'c'), new Card(4,'c'), 
            new Card(4,'d')}; 
                        
        Hand onePairHand = new Hand(cards);
        Hand onePairHand1 = new Hand(cards1);
        Hand onePairHand2 = new Hand(cards2);
        Hand onePairHand3 = new Hand(cards3);

        assertTrue(onePairHand.hasOnePair(), "One pair hand 4,4");
        assertFalse(hand.hasOnePair(), "Not two pairs hand");
        assertTrue(onePairHand1.hasOnePair(), "One pair hand 2,2");
        assertFalse(onePairHand2.hasOnePair(), "Not one pair, all the same");
        assertFalse(onePairHand3.hasOnePair(), "Not one pair, two pairs");
    } 

    /**
     * Tests the isFullHouse() method
     */
    @Test 
    public void testisFullHouse() {
        Card[] cards = {new Card(2,'c'), new Card(2,'d'), new Card(5,'c'), new Card(5,'d'), 
            new Card(5,'h')};

        Card[] cards1 = {new Card(3,'c'), new Card(3,'h'), new Card(3,'c'), new Card(4,'c'), 
            new Card(4,'d')};   
        
        Card[] cards2 = {new Card(4,'c'), new Card(4,'h'), new Card(4,'c'), new Card(4,'c'), 
            new Card(4,'d')};   

        Card[] cards3 = {new Card(3,'c'), new Card(3,'h'), new Card(4,'c'), new Card(5,'c'), 
            new Card(6,'d')}; 
                        
        Hand fullHouseHand = new Hand(cards);
        Hand fullHouseHand1 = new Hand(cards1);
        Hand fullHouseHand2 = new Hand(cards2);
        Hand fullHouseHand3 = new Hand(cards3);

        assertTrue(fullHouseHand.isFullHouse(), "Full house hand 2,5");
        assertFalse(hand.isFullHouse(), "Not two pairs hand");
        assertTrue(fullHouseHand1.isFullHouse(), "Full house hand 3,4");
        assertFalse(fullHouseHand2.isFullHouse(), "Not full house, all the same");
        assertFalse(fullHouseHand3.isFullHouse(), "Not full house, one pair");
    } 

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        // Testing constructor with null array
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Hand(null), "Constructor null array");
        assertEquals("Null array", exception.getMessage(),
                "Constructor null array message");
        
        // Testing constructor with invalid array length
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Hand(new Card[6]), "Constructor invalid array length");
        assertEquals("Invalid array length", exception.getMessage(),
                "Constructor invalid array length message");

        // Testing constructor with null element
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Hand(new Card[5]), "Constructor null element");
        assertEquals("Null element", exception.getMessage(),
                "Constructor null element message");

        // Testing getCard() with invalid index on low boundary
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.getCard(-1), "getCard() invalid index on low boundary");
        assertEquals("Invalid index", exception.getMessage(),
                "getCard() invalid index on low boundary message");
                
        // Testing getCard() with invalid index on high boundary
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.getCard(5), "getCard() invalid index on high boundary");
        assertEquals("Invalid index", exception.getMessage(),
                "getCard() invalid index on high boundary message");
                
        // Testing getCard() with invalid index
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.getCard(8), "getCard() invalid index");
        assertEquals("Invalid index", exception.getMessage(),
                "getCard() invalid index message");
                
        // Testing replace() with invalid index on low boundary
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.replace(-1, null), "replace() invalid index on low boundary");
        assertEquals("Invalid index", exception.getMessage(),
                "replace() invalid index on low boundary message");
                
        // Testing replace() with invalid index on high boundary
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.replace(5, null), "replace() invalid index on high boundary");
        assertEquals("Invalid index", exception.getMessage(),
                "replace() invalid index on high boundary message");
                
        // Testing replace() with invalid index
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.replace(8, null), "replace() invalid index");
        assertEquals("Invalid index", exception.getMessage(),
                "replace() invalid index message"); 
                
        // Testing replace() with null card
        exception = assertThrows(IllegalArgumentException.class,
            () -> hand.replace(3, null), "replace() null card");
        assertEquals("Null card", exception.getMessage(),
                "replace() null card message"); 

    }
}