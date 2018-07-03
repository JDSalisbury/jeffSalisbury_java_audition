# PokerHands Kata

[PokerHand Kata Link](http://codingdojo.org/kata/PokerHands/)

# Solution
Using OOP and TDD, I Read an input.txt file and separated each player with their hand. Then played each hand against each other in Poker.

![Eclipse running PokerKataApp](/images/inputAndConsole.png)



Poker Rules:
```
Straight Flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.

Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.

Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.
```

Sample input:
```
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
```
Each row of input is a game with two players. The first five cards belong to the player named “Black” and the second five cards belong to the player named “White”.

Sample output:
```
White wins. - with high card: Ace 
Black wins. - with full house: 4 over 2 
Black wins. - with high card: 9
Tie.
```
