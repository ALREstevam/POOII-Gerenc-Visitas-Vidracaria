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
    private int spanBetweenBlocks;
    private int initialSpan;
    

    public NoWorkElem(int blockAmount, int spanBetweenBlocks, int initialSpan) {
        this.blockAmount = blockAmount;
        this.spanBetweenBlocks = spanBetweenBlocks;
        this.initialSpan = initialSpan;
    }

    public NoWorkElem(
            int days, 
            int hours, 
            int minutes, 
            int spanDays, 
            int spanHours, 
            int spanMinutes,
            int initialSpanDays,
            int initalSpanHours,
            int initialSpanMinutes,
            int minutesPerBlock
    ) {
        int totalMinutes = TimeConverter.minutesSum
        (
                TimeConverter.daysToMinutes(days), 
                TimeConverter.hoursToMinutes(hours), 
                minutes
        );
        
        int totalSpanMinutes = TimeConverter.minutesSum
        (
                TimeConverter.daysToMinutes(spanDays), 
                TimeConverter.hoursToMinutes(spanHours), 
                spanMinutes
        );
        
        int totalInitialSpanMinutes = TimeConverter.minutesSum
        (
                TimeConverter.daysToMinutes(initialSpanDays), 
                TimeConverter.hoursToMinutes(initalSpanHours), 
                initialSpanMinutes
        );
        
        this.blockAmount = totalMinutes / minutesPerBlock;
        this.spanBetweenBlocks = totalSpanMinutes / minutesPerBlock;
        this.initialSpan = totalInitialSpanMinutes / minutesPerBlock;
    }

    public int getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    public int getSpanBetweenBlocks() {
        return spanBetweenBlocks;
    }

    public void setSpanBetweenBlocks(int spanBetweenBlocks) {
        this.spanBetweenBlocks = spanBetweenBlocks;
    }

    public int getInitialSpan() {
        return initialSpan;
    }

    public void setInitialSpan(int initialSpan) {
        this.initialSpan = initialSpan;
    }
    
    
}
