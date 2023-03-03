import static org.junit.jupiter.api.Assertions.*;

import model.Card;
import model.Suit;
import model.Value;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void testCompareSingleCardAceTie() {
        Card cardBlack = new Card(Suit.CLUBS, Value.ACE);
        Card cardWhite = new Card(Suit.HEARTS, Value.ACE);
        assertEquals(0, cardBlack.compareTo(cardWhite));
    }

    @Test
    void testCompareSingleCardAceWinKing() {
        Card cardBlack = new Card(Suit.CLUBS, Value.ACE);
        Card cardWhite = new Card(Suit.HEARTS, Value.KING);
        assertTrue(cardBlack.compareTo(cardWhite) > 0);
    }

    @Test
    void testCompareSingleCardDeduceLoseAce() {
        Card cardBlack = new Card(Suit.CLUBS, Value.DEDUCE);
        Card cardWhite = new Card(Suit.HEARTS, Value.ACE);
        assertTrue(cardBlack.compareTo(cardWhite) < 0);
    }

}
