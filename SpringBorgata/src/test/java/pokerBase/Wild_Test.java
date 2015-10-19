package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Wild_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void FiveOfAKind() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());

	}

	@Test
	public void RoyalFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		// System.out.println(h.getHandStrength());
	}

	@Test
	public void StraightFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHands(h);
		System.out.println(Hand.EvalHands(h));

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);

	}

	@Test
	public void Flush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void Straight() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHands(h);
		;
		System.out.println(Hand.EvalHands(h));
		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void FourOfAKind_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}

	@Test
	public void FourOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}

	@Test
	public void ThreeOfAKind_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}

	@Test
	public void ThreeOfAKind_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());

		// Check to see if the first kicker is a KING
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

		// Check to see if the second kicker is a NINE
		assertTrue(c2.getRank().getRank() == eRank.NINE.getRank());
	}

	@Test
	public void ThreeOfAKind_3() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());

		// Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.THREE.getRank());

		// Check to see if the second kicker is a TWO
		assertTrue(c2.getRank().getRank() == eRank.TWO.getRank());
	}

	@Test
	public void FullHouse_1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void FullHouse_2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void TwoPair() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());

		// Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.ACE.getRank());
	}

	@Test
	public void Pair() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.JOKER, eRank.JOKER, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());

		// Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.TEN.getRank());

		// Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());

		// Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());

	}

	@Test
	public void HighCard() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h = Hand.EvalHands(h);
		;

		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 4);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		Card c4 = h.getKicker().get(eCardNo.FourthCard.getCardNo());

		// Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

		// Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.TEN.getRank());

		// Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.THREE.getRank());

		// Check value of kicker
		assertTrue(c4.getRank().getRank() == eRank.TWO.getRank());

	}

	// ---------------------------------------------------------------------
	// 						WILDS TESTS
	// ---------------------------------------------------------------------

	@Test
	public void testWild() {
		ArrayList<Card> wilds = new ArrayList<Card>();
		int numJokers = 0;

		wilds.add(new Card(eSuit.CLUBS, eRank.TWO, 0));
		wilds.add(new Card(eSuit.SPADES, eRank.TWO, 0));
		wilds.add(new Card(eSuit.HEARTS, eRank.TWO, 0));
		wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO, 0));

		Deck d = new Deck(numJokers, wilds);
		Hand h = new Hand(d);

		h = Hand.EvalHands(h);
		assertTrue(h != null);
	}

	@Test
	public void straightFlushWild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.EIGHT.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void fiveOfAKindWild() {

		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		System.out.println(h.getLowPairStrength());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);

	}

	@Test
	public void FourOfAKind1Wild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());

	}

	@Test
	public void FourOfAKind2Wild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}

	@Test
	public void fullHouse1Wild() {
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));

		h = Hand.EvalHands(h);
		System.out.println(h.getHandStrength());
		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void flushWild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, true));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);

	}

	@Test
	public void straightWild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void threeOfAKindWild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.EIGHT.getRank());
		c1 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.FOUR.getRank());
	}

	@Test
	public void threeOfAKind2Wild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.FOUR.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.TEN.getRank());
		c1 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.EIGHT.getRank());
	}

	// IF THERE'S A WILD IN A HAND IT WILL NEVER EVALUATE TO TWO PAIR.
	// IT WILL EVALUATE TO THREE OF A KIND INSTEAD.

	@Test
	public void pairWild() { 
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));

		h = Hand.EvalHands(h);

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.QUEEN.getRank());
		c1 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.TEN.getRank());
		c1 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.FOUR.getRank());

	}

	// IF THERE'S A WILD IN A HAND IT WILL NEVER EVALUATE TO A HIGH CARD.
	// IT WILL EVALUATE TO A PAIR INSTEAD.

	@Test
	public void CompareTwoHands() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h1.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h1.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));

		h1 = Hand.EvalHands(h1);

		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h2.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));

		h2 = Hand.EvalHands(h2);

		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);

		Collections.sort(TwoHands, Hand.HandRank);

		Hand winningHand = new Hand();

		winningHand = TwoHands.get(0);

		assertTrue(winningHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.NINE.getRank());

	}
}