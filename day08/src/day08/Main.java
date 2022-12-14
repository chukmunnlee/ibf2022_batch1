package day08;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
       Deck deck = new Deck();
       System.out.println(deck) ;

       deck.shuffle();

       // ? what is the danger
       Optional<Card> opt =  deck.take();
       if (opt.isPresent()) {
            Card c = opt.get();
            System.out.printf("suit: %s\n", c.getSuit());
       }

       opt.ifPresent(c -> {
            System.out.printf("suit: %s\n", c.getSuit());
       });
    }
}
