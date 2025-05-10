/**
 * Represents a playing card with name, suit, and a corresponding value.
 * 
 * <p>This class shows the details of a card and provides methods to access its
 * attributes as well as overriding basic {@code Object} methods like {@code toString} and {@code equals}.
 * </p> 
 */

public class Card {
    private String name;
    private String suit;
    private int value;

    /**
     * Constructs a new {@code Card} with the specified name, suit, and value.
     *
     * @param name  the name of the card (e.g., "Ace", "2", "Queen")
     * @param suit  the suit of the card (e.g., "Hearts", "Diamonds")
     * @param value the value associated with the card
     */
    public Card (String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the name of the card.
     *
     * @return the card's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the card's suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the numerical value assigned to the card.
     *
     * @return the card's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card in the format "name of suit".
     * For example, "Ace of Spades".
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return name + " of " + suit;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two cards are considered equal if they have the same name, suit, and value.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this card is equal to the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        // Cast and compare field values
        Card other = (Card) obj;
        return name.equals(other.name) && suit.equals(other.suit) && value == other.value;
    }
}
