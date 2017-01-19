package com.laoniu.codewars.RankingPokerHands;

import org.junit.Test;

import static com.laoniu.codewars.RankingPokerHands.PokerHand.Type.FOUR_OF_A_KIND;
import static com.laoniu.codewars.RankingPokerHands.PokerHand.Type.FULL_HOUSE;
import static org.junit.Assert.*;

public class Tests {
    private PokerHand.Result loss = PokerHand.Result.LOSS;
    private PokerHand.Result win = PokerHand.Result.WIN;
    private PokerHand.Result tie = PokerHand.Result.TIE;

    @Test
    public void testStraightFlushWin4OfAKind(){
        Test("Straight flush wins of 4 of a kind", win, "2H 3H 4H 5H 6H", "AS AD AC AH JD");
    }

    @Test
    public  void testStraightFlush(){
        Test("Highest straight flush wins", loss, "2H 3H 4H 5H 6H", "KS AS TS QS JS");
    }

    @Test
    public void PokerHandRankingTest() {
        Test("Highest straight flush wins", loss, "2H 3H 4H 5H 6H", "KS AS TS QS JS");
        Test("Straight flush wins of 4 of a kind", win, "2H 3H 4H 5H 6H", "AS AD AC AH JD");
        Test("Highest 4 of a kind wins", win, "AS AH 2H AD AC", "JS JD JC JH 3D");
        Test("4 Of a kind wins of full house", loss, "2S AH 2H AS AC", "JS JD JC JH AD");
        Test("Full house wins of flush", win, "2S AH 2H AS AC", "2H 3H 5H 6H 7H");
        Test("Highest flush wins", win, "AS 3S 4S 8S 2S", "2H 3H 5H 6H 7H");
        Test("Flush wins of straight", win, "2H 3H 5H 6H 7H", "2S 3H 4H 5S 6C");
        Test("Equal straight is tie", tie, "2S 3H 4H 5S 6C", "3D 4C 5H 6H 2S");
        Test("Straight wins of three of a kind", win, "2S 3H 4H 5S 6C", "AH AC 5H 6H AS");
        Test("3 Of a kind wins of two pair", loss, "2S 2H 4H 5S 4C", "AH AC 5H 6H AS");
        Test("2 Pair wins of pair", win, "2S 2H 4H 5S 4C", "AH AC 5H 6H 7S");
        Test("Highest pair wins", loss, "6S AD 7H 4S AS", "AH AC 5H 6H 7S");
        Test("Pair wins of nothing", loss, "2S AH 4H 5S KC", "AH AC 5H 6H 7S");
        Test("Highest card loses", loss, "2S 3H 6H 7S 9C", "7H 3C TH 6H 9S");
        Test("Highest card wins", win, "4S 5H 6H TS AC", "3S 5H 6H TS AC");
        Test("Equal cards is tie", tie, "2S AH 4H 5S 6C", "AD 4C 5H 6H 2C");
    }

    private void Test(String description, PokerHand.Result expected, String playerHand, String opponentHand) {
        PokerHand player = new PokerHand(playerHand);
        PokerHand opponent = new PokerHand(opponentHand);
        assertEquals(description + ":", expected, player.compareWith(opponent));
    }

    @Test
    public void testIsFlush() {
        PokerHand pokerHand = new PokerHand("2H 3H 4H 5H 6H");
        assertTrue(pokerHand.isFlush());
    }

    @Test
    public void testIsStraight() {
        PokerHand pokerHand = new PokerHand("2H 3H 4H 5H 6H");
        assertTrue(pokerHand.isStraight());
    }

    @Test
    public void testNotStraight() {
        PokerHand pokerHand = new PokerHand("2H 7H 4H 5H 6H");
        assertFalse(pokerHand.isStraight());
    }

    @Test
    public void testIsFourOfAKind() {
        PokerHand pokerHand = new PokerHand("AS AH AD AC 6H");
        assertTrue(FOUR_OF_A_KIND.isThisType(pokerHand));

        pokerHand = new PokerHand("AS 2H AD AC 6H");
        assertFalse(FOUR_OF_A_KIND.isThisType(pokerHand));
    }

    @Test
    public void testFullHouse() {
        PokerHand pokerHand = new PokerHand("2S AH 2H AS AC");
        assertTrue(FULL_HOUSE.isThisType(pokerHand));
    }
}
