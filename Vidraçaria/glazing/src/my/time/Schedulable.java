/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time;

import java.util.List;
import my.time.agenda.AgendaAllocator;
import my.time.helper.NoWorkPattern;

/**
 *
 * @author andre
 * @param <E>
 */
public interface Schedulable<E> {
    public AgendaAllocator<E> getAgenda();
    public NoWorkPattern getNoWorkPattern();
}
