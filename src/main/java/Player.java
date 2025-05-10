import java.util.ArrayList;

/**
 * Represents a player in the card game.
 *
 * <p>
 * A {@code Player} has a name, age, and a hand consisting of {@link Card} objects.
 * Players can draw cards from a {@link Deck}, discard cards to a {@link DiscardPile},
 * and return cards back to the deck.
 * </p>
 */
public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int age;

    /**
     * Constructs a player with a predefined hand.
     *
     * <p>
     * Initializes a player with the provided name, age, and an initial set of cards.
     * If a card in the provided array is {@code null}, it is ignored.
     * </p>
     *
     * @param name         the name of the player.
     * @param age          the age of the player.
     * @param initialHand  the initial set of cards in the player's hand.
     */
    public Player(String name, int age, Card[] initialHand) {
        this.name = name;
        this.age = age;
        hand = new ArrayList<>();
        for (Card card : initialHand) {
            if (card != null) {
                hand.add(card);
            }
        }
    }

    /**
     * Constructs a player with an empty hand.
     *
     * <p>
     * Initializes a player with the provided name and age.
     * The player's hand starts as an empty list.
     * </p>
     *
     * @param name the name of the player.
     * @param age  the age of the player.
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        hand = new ArrayList<>();
    }

    /**
     * Returns the player's name.
     *
     * @return the name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the player's age.
     *
     * @return the age of the player.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns an array of all cards in the player's hand.
     *
     * @return an array containing the player's cards.
     */
    public Card[] getHand() {
        return this.hand.toArray(new Card[this.hand.size()]);
    }

    /**
     * Returns the number of cards currently in the player's hand.
     *
     * @return the number of cards in the player's hand.
     */
    public int size() {
        return hand.size();
    }

    /**
     * Draws a card from the deck and adds it to the player's hand.
     *
     * <p>
     * If the deck is empty, no card is drawn.
     * </p>
     *
     * @param deck the {@link Deck} from which the card is drawn.
     */
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }

    /**
     * Discards a specified card from the player's hand into a discard pile.
     *
     * <p>
     * If the card exists in the player's hand, it is removed and added to the discard pile.
     * </p>
     *
     * @param card         the {@link Card} to be discarded.
     * @param discardPile  the {@link DiscardPile} where the card is discarded.
     * @return {@code true} if the card was discarded successfully, {@code false} otherwise.
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (hand.contains(card)) {
            hand.remove(card);
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Returns a specified card from the player's hand back to the deck.
     *
     * <p>
     * If the card exists in the player's hand, it is removed and added back to the deck.
     * </p>
     *
     * @param card the {@link Card} to be returned.
     * @param deck the {@link Deck} to return the card to.
     * @return {@code true} if the card was returned successfully, {@code false} otherwise.
     */
    public boolean returnCard(Card card, Deck deck) {
        if (hand.contains(card)) {
            hand.remove(card);
            deck.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the player.
     *
     * <p>
     * The format is "name, age, card1, card2, ...".
     * If the player has no cards, only the name and age are shown.
     * </p>
     *
     * @return a formatted string representing the player.
     */
    @Override
    public String toString() {
        String result = name + ", " + age;
        if (!hand.isEmpty()) {
            for (int i = 0; i < hand.size(); i++) {
                result += hand.get(i).toString();
                if (i < this.hand.size() - 1) {
                    result += ", ";
                }
            }
            result += ".";
        }
        return result;
    }
}