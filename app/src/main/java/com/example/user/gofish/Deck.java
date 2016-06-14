package com.example.user.gofish;

import java.util.Random;
import java.util.Stack;



public class Deck {
    private Stack<Integer> cdeck;

    public Deck() {
        fdeck();
    }

    private boolean checkstack(Stack<Integer> s, int r) {
        Stack<Integer> a = new Stack<>();
        boolean flag = false;
        while (!s.empty() && !flag) {
            if (s.peek() == r) {
                flag = true;
            } else {
                a.push(s.pop());
            }
        }
        while (!a.empty()) {
            s.push(a.pop());
        }
        return flag;
    }

    public Stack<Integer> getCdeck() {
        return cdeck;
    }

    public void fdeck() {
        cdeck = new Stack<Integer>();
        int cnt = 0;
        Random r = new Random();
        while (cnt < 48) {
            int a = r.nextInt(48);
            if (!checkstack(cdeck, a)) {
                cnt++;
                cdeck.push(a);
            }
        }
    }
}
