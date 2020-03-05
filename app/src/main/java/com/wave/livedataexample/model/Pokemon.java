
package com.wave.livedataexample.model;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("is_hidden")
    private boolean mIsHidden;
    @SerializedName("slot")
    private int mSlot;


    public boolean getmIsHidden() {
        return mIsHidden;
    }

    public void setmIsHidden(boolean mIsHidden) {
        this.mIsHidden = mIsHidden;
    }

    public int getmSlot() {
        return mSlot;
    }

    public void setmSlot(int mSlot) {
        this.mSlot = mSlot;
    }
}
