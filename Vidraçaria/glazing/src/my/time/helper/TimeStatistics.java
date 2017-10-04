/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

import my.time.agenda.AgendaAllocator;
import java.util.ArrayList;
import java.util.List;
import java.math.*;

/**
 *
 * @author andre
 */
public final class TimeStatistics<E> {
    private double averageTimeTaken;
    private double standatdDeviation;

    public TimeStatistics(List<AgendaAllocator<E>> agendas) {
        calculate(agendas);
    }
    
    public void calculate(List<AgendaAllocator<E>> agendas) {
        List<Integer> countAgenda = new ArrayList<>();
        for(AgendaAllocator agenda : agendas){
            countAgenda.addAll(agenda.count());
        }
        this.averageTimeTaken = TimeStatistics.average(countAgenda);
        this.standatdDeviation = TimeStatistics.stdDeviation(countAgenda, averageTimeTaken);
    }
    
    private static double average(List<Integer> lst){
        int sum = 0;
        int total = lst.size();
        
        for(Integer elem : lst){
            sum += elem;
        }
        return sum/total;
    }
    
    private static double stdDeviation(List<Integer> lst, double average){
        long fst = 0;
        
        int i = 0;
        for(Integer elem : lst){
            fst += Math.pow((elem - average), 2);
        }
        return Math.sqrt(fst / lst.size() - 1);
    }
    
}
