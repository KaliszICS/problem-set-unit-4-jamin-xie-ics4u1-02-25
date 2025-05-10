//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Random;

public class ProblemSetTest {

   //THE TEST CASE WAS GENERATED WITH AI (I'm not sure if I can do it or no since you didn't mention whether we can use AI to make test case).

   public static void main(String[] args) {
      // --- Initialize a standard deck and shuffle it!
      Deck deck = new Deck();
      deck.shuffle();
      int initialDeckSize = deck.size(); // Expected: 52 (or based on the standard deck creation)
      System.out.println("Initial deck size (should be 52): " + initialDeckSize);

      // --- Create an empty discard pile
      DiscardPile discardPile = new DiscardPile();

      // --- Randomly draw some cards from the deck and sometimes discard them.
      Random random = new Random();
      // Draw a random number between 5 and (deck.size()-1) cards.
      int draws = random.nextInt(deck.size() - 5) + 5;
      System.out.println("Randomly drawing " + draws + " cards from the deck...");

      // Count how many drawn cards are actually discarded.
      int discardedCount = 0;
      for (int i = 0; i < draws; i++) {
         Card drawn = deck.draw();
         System.out.println("Drawn card: " + drawn);
         // With a 50/50 chance, discard the drawn card.
         if (random.nextBoolean()) {
            discardPile.addCard(drawn);
            discardedCount++;
            System.out.println("Discarded card: " + drawn);
         } else {
            System.out.println("Kept card: " + drawn);
         }
      }

      // --- Check the card count invariant
      // All cards should still be present between the deck and the discarded ones.
      // Note: The cards that were not discarded (kept aside) are "lost" in this
      // simulation,
      // so to check invariants we assume that when a card is drawn, it moves either
      // to the discard pile
      // or is conceptually "held" by the player. In this test, we only check that the
      // discard and remaining deck
      // do not exceed the initial total.
      int deckNow = deck.size();
      int currentDiscard = discardPile.size();
      System.out.println("\nAfter drawing:");
      System.out.println("Deck size: " + deckNow);
      System.out.println("Discard pile size: " + currentDiscard);
      System.out.println("Total cards accounted for in deck and discard (ideal if no cards are " +
            "lost): " + (deckNow + currentDiscard) +
            " (initial deck size was " + initialDeckSize + ")");

      if (deckNow + currentDiscard <= initialDeckSize) {
         System.out.println("Card count invariant check passed!");
      } else {
         System.out.println("Card count invariant check failed!");
      }

      // --- Test reshuffle: add a couple of new cards to the deck and reshuffle it.
      System.out.println("\nTesting reshuffle by adding extra cards...");
      Card extraCard1 = new Card("Joker", "Red", 0);
      Card extraCard2 = new Card("Joker", "Black", 0);
      Card[] extraCards = { extraCard1, extraCard2 };
      int deckSizeBeforeReshuffle = deck.size();
      deck.reshuffle(extraCards);
      int deckSizeAfterReshuffle = deck.size();
      System.out.println("Deck size before reshuffle: " + deckSizeBeforeReshuffle +
            ", after reshuffle (should be increased by 2): " + deckSizeAfterReshuffle);
      if (deckSizeAfterReshuffle == deckSizeBeforeReshuffle + 2) {
         System.out.println("Reshuffle test passed!");
      } else {
         System.out.println("Reshuffle test failed!");
      }

      // --- Test removal from discard pile with a random card present in the discard
      // pile.
      if (discardPile.size() > 0) {
         Card[] discardCards = discardPile.getCards();
         // Pick a random card from the discard pile.
         Card cardToRemove = discardCards[random.nextInt(discardCards.length)];
         System.out.println("\nAttempting to remove a random card from the discard pile: " + cardToRemove);
         Card removed = discardPile.removeCard(cardToRemove);
         if (removed != null && removed.equals(cardToRemove)) {
            System.out.println("Discard pile removal test passed! Removed: " + removed);
         } else {
            System.out.println("Discard pile removal test failed!");
         }
      } else {
         System.out.println("\nDiscard pile is empty, skipping removal test.");
      }

      // --- Test toString() method of DiscardPile.
      System.out.println("\nDiscard pile representation: " + discardPile.toString());

      // --- Test adding null values: expect sizes to remain unchanged since null is
      // not added.
      System.out.println("\nTesting addition of nulls:");
      int deckSizeBeforeNull = deck.size();
      int discardSizeBeforeNull = discardPile.size();
      deck.addCard(null);
      discardPile.addCard(null);
      if (deck.size() == deckSizeBeforeNull && discardPile.size() == discardSizeBeforeNull) {
         System.out.println("Null addition test passed! (Sizes unchanged)");
      } else {
         System.out.println("Null addition test failed!");
      }
   }
}
