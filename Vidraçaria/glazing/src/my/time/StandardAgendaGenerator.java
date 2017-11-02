/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import my.time.agenda.AgendaAllocator;
import my.time.helper.NoWorkElem;
import my.time.helper.NoWorkPattern;
import visit.Visit;

/**
 * Factory to generate a agenda configured with default values
 * @author andre
 */
public class StandardAgendaGenerator {

    private NoWorkPattern noWorkPattern;
    public static final int minutePerBloc = 10;
    public static final int blocksPerAgenda = ((30 * 24 * 60) / minutePerBloc);
    private LocalDateTime beginDate;
    private int agendas;
    
    /**
     * Instantiate a new StandardAgendaGenerator
     * @param patt
     * @param beginDate 
     * @param agendas 
     */
    public StandardAgendaGenerator(NoWorkPattern patt, LocalDateTime beginDate, int agendas) {
        this.noWorkPattern = patt;
        this.beginDate = beginDate;
        this.agendas = agendas;
    }
    
    /**
     * Generates a agenda using both the default and given values
     * @return a preconfigured agenda
     */
    public List<AgendaAllocator<Visit>> generate(){
        List<AgendaAllocator<Visit>> bgLst = new ArrayList<>();
        
        for(int i = 0; i < agendas; i++){
            AgendaAllocator<Visit> agd = new AgendaAllocator<Visit>(minutePerBloc, blocksPerAgenda, beginDate);
        
            for(NoWorkElem elem : this.noWorkPattern.getPatterns()){
                agd.setDoNotAllocateEveryNBlocks(minutePerBloc, elem.getSpan(), elem.getBlockAmount());
            }
        }
        
        return bgLst;
    }
    
}
