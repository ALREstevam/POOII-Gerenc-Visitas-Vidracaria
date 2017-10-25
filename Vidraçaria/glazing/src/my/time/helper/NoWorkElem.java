/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

/**
 *
 * @author andre
 */
public class NoWorkElem {
    private int blockAmount;
    private int span;

    public NoWorkElem(int blockAmount, int span) {
        this.blockAmount = blockAmount;
        this.span = span;
    }

    public int getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        this.span = span;
    }
    
    
}
