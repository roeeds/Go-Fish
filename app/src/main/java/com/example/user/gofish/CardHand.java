package com.example.user.gofish;


import java.util.Random;

public class CardHand {
    private int[] hand =new int[12];
    private GameDeck d;
    private boolean[] aicheck = new boolean[12];
    private int turn=0;
    public CardHand(GameDeck d){
        for (int i=0;i<5;i++){
            hand[d.takecard()]++;
        }
    }

    public void DeckToHand(){
        int c = d.takecard();
        if (c!=-1){
            hand[c]++;
        }
    }
    public boolean HasCards(){
        for (int i=0;i<12;i++){
            if (hand[i]>0)
                return true;
        }
        return false;
    }

    public void PlayerToHand(CardHand ch,int c){ //if i have cards
        if (ch.hand[c]== 0)
            DeckToHand();
        else{
            hand[c]+=ch.hand[c];
            ch.hand[c]=0;
        }
        ch.aicheck[c]=true;
        this.turn++;
    }

    public void AiToHand(CardHand ch){
        if (!HasCards()){
            DeckToHand();
            turn++;

        } else {
            for (int i = 0; i < 12; i++) {
                if (aicheck[i] && hand[i] > 0) {
                    hand[i] += ch.hand[i];
                    ch.hand[i] = 0;
                    turn++;
                    aicheck[i] = false;
                } else {
                    Random r = new Random();
                    int a;
                    do {
                        a = r.nextInt(12);
                    } while (hand[a] == 0);

                    if (ch.hand[a] == 0)
                        DeckToHand();
                    else {
                        hand[a] += ch.hand[i];
                        ch.hand[a] = 0;
                    }
                    turn++;
                }
            }
        }
    }

}
