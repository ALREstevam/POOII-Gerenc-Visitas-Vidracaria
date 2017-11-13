/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.neow.agenda;

import visit.Visit;

/**
 *
 * @author andre
 * @param <E>
 */
public interface AgendaDefaults extends AllocatorConsts{
    
    /**
     * Returns a <code>TimeAnswer</code> object indicating when the amount of
     * blocks will be avaliable in the current agenda
     * @param blocks amount of free blocks to find
     * @return 
     */
    public TimeAnswer whenIsAvaliable(int blocks);
    
    /**
     * Allocates a certain amount of blocks in the given position
     * @param blocks Amount of blocks to allocate
     * @param init Fist block of the allocation
     * @param elem Element representing a task
     * @return false if one of the blocks of the requested position is aleready 
     * in use
     */
    public boolean allocate(int blocks, int init, Visit elem);
    public void free(int block);
    public void free(int init, int blocks);
}
