package com.example.user.gofish;

import java.security.PublicKey;

/**
 * Created by user on 10/01/2016.
 */
public class Card {
    protected int index;
    private int ImageID;
    private int x;
    private int y;
    public Card(int n,int i){
        this.index=n;
        this.ImageID=i;
    }
    public Card(int i){};
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
