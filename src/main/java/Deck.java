import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * Represents a deck of playing cards.
 *
 * <p>
 * The Deck class encapsulates a collection of {@link Card} objects and provides
 * methods to initialize the deck, draw cards, shuffle the deck, add cards, and
 * reshuffle the deck with additional cards.
 * </p>
 */

public class Deck {
    private List<Card> cards;

    /**
     * Constructs a deck from an array of {@link Card} objects.
     *
     * <p>
     * This constructor initializes the deck by adding each non-null card from the
     * provided array into the internal card list.
     * </p>
     *
     * @param cardArray an array of {@code Card} objects to initialize the deck.
     */
    public Deck(Card[] cardArray) {
        cards = new ArrayList<>();
        for (Card c : cardArray) {
            if (c != null) {
                cards.add(c);
            }
        }
    }

    /**
     * Constructs a standard deck of 52 playing cards.
     *
     * <p>
     * This default constructor creates a new deck containing 52 cards. The deck
     * is built using the four suits ("Hearts", "Clubs", "Diamonds", "Spades")
     * and thirteen names for each suit ("Ace", "2", ... "King"). The rank (or
     * value) of each card starts at 1 and is incremented for each card in the suit.
     * </p>
     */
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // For each suit create a card for every name with an incrementing value (rank).
        for (String suit : suits) {
            int rank = 1;
            for (String name : names) {
                cards.add(new Card(name, suit, rank++));
            }
        }
    }

    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the current size of the deck.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Draws a card from the top of the deck.
     *
     * <p>
     * This method removes and returns the card at the beginning of the deck.
     * If the deck is empty, it returns {@code null}.
     * </p>
     *
     * @return the top {@link Card} from the deck, or {@code null} if the deck is empty.
     */
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        } 
        return cards.remove(0);
    }

    /**
     * Shuffles the deck using selection sort(in a way).
     *
     * <p>
     * This method randomly swaps cards in the deck to produce a uniformly
     * randomized order.
     * </p>
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            // Generate a random index in the range of [0, i] which allow them to be randomize
            int j = (random.nextInt(i + 1));
            Card temp = cards.get(i);
            // Swap the card at index i with the card at index j
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Adds a non-null card to the deck.
     *
     * <p>
     * This method is used to add a card to the deck. If the card reference is
     * {@code null}, the card is not added.
     * </p>
     *
     * @param card the {@link Card} to add to the deck; must not be {@code null}.
     */
    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    /**
     * Reshuffles the deck by adding a set of new cards and then shuffling the deck.
     *
     * <p>
     * This method iterates over the provided array of {@link Card} objects, adds
     * each non-null card to the current deck, and then shuffles the entire deck.
     * </p>
     *
     * @param newCards an array of {@code Card} objects to add before shuffling.
     */
    public void reshuffle(Card[] newCards) {
        for (Card card : newCards) {
            if (card != null) {
                cards.add(card);
            }
        }
        shuffle();
    }
}
