import java.util.ArrayList;
import java.util.List;

/**
 * Represents a discard pile for storing used or removed cards.
 *
 * <p>
 * The {@code DiscardPile} class maintains a collection of {@link Card} objects that
 * have been discarded during gameplay. It provides methods to add, remove, retrieve,
 * and clear cards in the pile.
 * </p>
 */
public class DiscardPile {
    private List<Card> pile;

    /**
     * Constructs a discard pile from an array of {@link Card} objects.
     *
     * <p>
     * This constructor initializes the discard pile by adding each non-null card
     * from the provided array into the pile.
     * </p>
     *
     * @param cardArray an array of {@code Card} objects to initialize the pile.
     */
    public DiscardPile(Card[] cardArray) {
        pile = new ArrayList<>();
        // Adds each non-null card to discard pile.
        for (Card c : cardArray) {
            if (c != null) {
                pile.add(c);
            }
        }
    }

    /**
     * Constructs an empty discard pile.
     *
     * <p>
     * This default constructor initializes an empty discard pile with no cards.
     * </p>
     */
    public DiscardPile() {
        pile = new ArrayList<>();
    }

    /**
     * Returns an array of all cards currently in the discard pile.
     *
     * @return an array containing all cards in the pile.
     */
    public Card[] getCards() {
        return pile.toArray(new Card[0]);
    }

    /**
     * Returns the number of cards in the discard pile.
     *
     * @return the number of discarded cards.
     */
    public int size() {
        return pile.size();
    }

    /**
     * Adds a card to the discard pile.
     *
     * <p>
     * This method adds the specified card to the pile if the card is not {@code null}.
     * </p>
     *
     * @param card the {@link Card} to be discarded; must not be {@code null}.
     */
    public void addCard(Card card) {
        if (card != null) {
            pile.add(card);
        }
    }

    /**
     * Removes a specific card from the discard pile.
     *
     * <p>
     * If the specified card exists in the pile, it is removed and returned.
     * If the card is not found, {@code null} is returned.
     * </p>
     *
     * @param card the {@link Card} to remove from the pile.
     * @return the removed {@code Card}, or {@code null} if not found.
     */
    public Card removeCard(Card card) {
        int index = pile.indexOf(card);
        if (index != -1) {
            return pile.remove(index);
        }
        return null;
    }

    /**
     * Removes all cards from the discard pile and returns them.
     *
     * <p>
     * This method clears the discard pile and returns an array of all removed cards.
     * </p>
     *
     * @return an array containing all discarded cards.
     */
    public Card[] removeAll() {
        Card[] removeCards = getCards();
        pile.clear();
        return removeCards;
    }

    /**
     * Returns a formatted string representation of the discard pile.
     *
     * <p>
     * The output consists of a comma-separated list of cards, followed by a period.
     * If the pile is empty, an empty string is returned.
     * </p>
     *
     * @return a string representation of the discard pile.
     */
    @Override
    public String toString() {
        if (pile.isEmpty()) {
            return "";
        }

        // Generate a comma-seperated string of all discarded cards.
        String result = "";
        for (int i = 0; i < pile.size(); i++) {
            result += pile.get(i).toString();
            if (i < pile.size() - 1) {
                result += ", ";
            } else {
                result += ".";
            }
        }
        return result;
    }
}
