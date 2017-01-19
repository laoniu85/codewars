package com.laoniu.codewars.RankingPokerHands;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static com.laoniu.codewars.RankingPokerHands.PokerHand.Type.*;

public class PokerHand {
    public enum Result {TIE, WIN, LOSS}

    Map<String, Set<String>> suitMap;
    Map<String, Set<String>> valueMap;
    static String[] STRAIGHT_JUDGE = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    public String[] STRAIGHT_JUDGE2 = new String[]{"A", "2", "3", "4", "5"};

    public static class Card {
        private String suit;
        private String value;

        public Card(String card) {
            this(card.substring(0, 1), card.substring(1, 2));
        }

        public Card(String value, String suit) {
            this.suit = suit;
            this.value = value;
        }

        public String getSuit() {
            return suit;
        }

        public Card setSuit(String suit) {
            this.suit = suit;
            return this;
        }

        public String getValue() {
            return value;
        }

        public Card setValue(String value) {
            this.value = value;
            return this;
        }
    }

    private Card[] cards;
    private int highPoint = 0;


    public boolean isStraight() {
        return straight() > 0;
    }

    public int straight() {
        Set<String> valueSet = new LinkedHashSet<>();
        for (int i = 0; i < cards.length; i++) {
            valueSet.add(cards[i].value);
        }
        if (valueSet.size() < 5) {
            return -1;
        }
        for (int i = 0; i < STRAIGHT_JUDGE.length - 5; i++) {
            int countInValueSet = 0;
            for (int j = 0; j < 5; j++) {
                if (valueSet.contains(STRAIGHT_JUDGE[i + j])) {
                    countInValueSet++;
                } else {
                    break;
                }
            }
            if (countInValueSet == 5) {
                return i + 6;
            }

        }
        for (int i = 0; i < STRAIGHT_JUDGE2.length; i++) {
            if (valueSet.contains(STRAIGHT_JUDGE2[i])) {
                return 5;
            }
        }
        return -1;
    }

    public boolean isFlush() {
        return suitMap.size() == 1;
    }

    public void groupValue() {
        Map<String, Set<String>> _valueMap = new LinkedHashMap<>();
        for (int i = 0; i < cards.length; i++) {
            Set<String> suitSet = _valueMap.getOrDefault(cards[i].value, new LinkedHashSet<>());
            suitSet.add(cards[i].getSuit());
            _valueMap.put(cards[i].value, suitSet);
        }
        this.valueMap = _valueMap;
    }

    public void groupSuit() {
        Map<String, Set<String>> _suitMap = new LinkedHashMap<>();
        for (int i = 0; i < cards.length; i++) {
            Set<String> valueSet = _suitMap.getOrDefault(cards[i].getSuit(), new LinkedHashSet<>());
            valueSet.add(cards[i].getValue());
            _suitMap.put(cards[i].suit, valueSet);
        }
        this.suitMap = _suitMap;
    }

    public static enum Type {
        STAIGHT_FLUSH(8) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return pokerHand.isFlush() && pokerHand.isFlush();
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return a.straight() - b.straight();
            }
        },
        FOUR_OF_A_KIND(7) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                Map<String, Set<String>> countValue = pokerHand.valueMap;
                if (countValue.size() == 2 && (countValue.get(pokerHand.getCards()[0].value).size() == 1 ||
                        countValue.get(pokerHand.getCards()[0].value).size() == 4)) {
                    return true;
                }
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {

                return 0;
            }
        },
        FULL_HOUSE(6) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                Map<String, Set<String>> countValue = pokerHand.valueMap;
                if (countValue.size() == 2 && (countValue.get(pokerHand.getCards()[0].value).size() == 2 ||
                        countValue.get(pokerHand.getCards()[0].value).size() == 3)) {
                    return true;
                }
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        FLUSH(5) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        STRAIGHT(4) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        THREE_OF_A_KIND(3) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        TWO_PAIRS(2) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        ONE_PAIR(1) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        },
        NOTHING(0) {
            @Override
            boolean isThisType(PokerHand pokerHand) {
                return false;
            }

            @Override
            int compare(PokerHand a, PokerHand b) {
                return 0;
            }
        };
        int value;

        Type(int value) {
            this.value = value;
        }

        abstract boolean isThisType(PokerHand pokerHand);

        abstract int compare(PokerHand a, PokerHand b);
    }

    public Card[] getCards() {
        return cards;
    }

    public PokerHand setCards(Card[] cards) {
        this.cards = cards;
        return this;
    }

    PokerHand(String hand) {
        String[] cardStrs = hand.split("\\s");
        cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            cards[i] = new Card(cardStrs[i]);
        }
        groupSuit();
        groupValue();
    }

    //

    Type[] types = {STAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIRS, ONE_PAIR, NOTHING};

    public Type getType() {
        for (int i = 0; i < types.length; i++) {
            if (types[i].isThisType(this)) {
                return types[i];
            }
        }
        return NOTHING;
    }

    public Result compareWith(PokerHand hand) {
        // Start your coding here...
        int result = 0;
        if (this.getType().equals(hand.getType())) {
            result = this.getType().compare(this, hand);
        } else {
            result = this.getType().value - hand.getType().value;
        }
        if (result > 0) {
            return Result.WIN;
        } else if (result == 0) {
            return Result.TIE;
        } else {
            return Result.LOSS;
        }
    }
}