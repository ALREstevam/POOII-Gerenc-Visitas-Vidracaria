/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds and manages the list of free blocks
 * @author andre
 */
public class FreeBlocksManager<E> implements Cloneable, Serializable{

    private List<ElementPosition> freeBlocks;

    /**
     * Constructor of the class
     * @param amountOfBlocks inital amount of blocks 
     */
    public FreeBlocksManager(int amountOfBlocks) {
        this.freeBlocks = new ArrayList<>(amountOfBlocks);
    }

    /**
     * Adds a element to the list of free blocks
     * @param elem 
     */
    private void add(ElementPosition elem) {
        freeBlocks.add(elem);
    }

    /**
     * Uses a list of time object to generate the list
     * @param agendaList
     * @return a list of free blocks
     */
    public List<ElementPosition> generateFreeBlocksList(List<TimeObj<E>> agendaList) {
        List<ElementPosition> localListFreeBlocks = new ArrayList<>();
        Integer freeBlock = -1, freeCount = 0, elemCount = 0;

        for (TimeObj elem : agendaList) {
            if (elem.getStatus() == TimeObj.timeStatus.NOT_ALLOCATED && !elem.isConsumed()) {
                if (freeBlock == -1) {
                    freeCount = 1;
                    freeBlock = elemCount;
                } else {
                    freeCount++;
                }
                
            } else if (freeBlock != -1) {
                ElementPosition elemPos = new ElementPosition(freeBlock, freeCount);
                localListFreeBlocks.add(elemPos);
                freeBlock = -1;
                freeCount = 0;
            }
            if((elemCount == agendaList.size()-1 && elem.hasStatus(TimeObj.timeStatus.NOT_ALLOCATED))){
                    ElementPosition elemPos = new ElementPosition(freeBlock, freeCount);
                    localListFreeBlocks.add(elemPos);
            }
            elemCount++;
        }
        Collections.sort(localListFreeBlocks);
        this.freeBlocks = localListFreeBlocks;
        return localListFreeBlocks;
    }

    /**
     * Checks whether a certain element can be allocated in the calendar
     * @param blocks amount of blocks
     * @param position first position
     * @return <code>true</code> only if the given amount of blocks can be allocated
     * in the agenda that generated the list of free blocks 
     */
    public boolean fits(int blocks, int position) {
        for(ElementPosition elem : this.freeBlocks) {
            if (elem.getPosition() == position
                    && elem.getValue() >= blocks) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the size of the free blocs list
     */
    public int getSize() {
        return this.freeBlocks.size();
    }

    /**
     * @param index index in the free blocks list
     * @return the element in this index
     */
    public ElementPosition getElement(int index) {
        return this.freeBlocks.get(index);
    }

    /**
     * Clones the object
     * @return 
     */
    public FreeBlocksManager<E> getClone() {
        try {
            return (FreeBlocksManager<E>) this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Returs a string representing the object
     * @return a string representing the object
     */
    @Override
    public String toString() {
        String rsp = "";
        for (ElementPosition elem : this.freeBlocks) {
            rsp += String.format("[ON POS[%d]: %d FREE BLOCKS ],\n", elem.getPosition(), elem.getValue());
        }
        return rsp;
    }


}
