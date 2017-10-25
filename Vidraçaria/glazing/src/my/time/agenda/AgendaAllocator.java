package my.time.agenda;

import my.exceptions.NotAllowedValueException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andre
 * This class manages the allocation of tasks to some other object
 * @param <E> a type of class that represents a task
 */
public class AgendaAllocator<E> implements Serializable, Cloneable{
    public enum allocationStrategy {
        BEST_FIT, WORST_FIT
    }
    private final int minutesPerBlock;
    private List<TimeObj<E>> agendaList;
    private FreeBlocksManager<E> freeBlocks;
    private LocalDateTime beginDate;

    /*===== CONSTRUCTOR =====*/
    
    /**
     * Constructor of the class
     * @param minutesPerBlock how many minutes each "block" of time has. 
     * A block is the minimum amount of time represented by the class (in minutes)
     * @param amountOfBlocks initial amount of time blocks
     * @param beginDate the first date to be considered, the start date of the 
     * first block, standard for the calculation of the start and end date of 
     * each block of time
     */
    public AgendaAllocator(int minutesPerBlock, int amountOfBlocks, LocalDateTime beginDate) {
        this.beginDate = beginDate;
        this.minutesPerBlock = minutesPerBlock;
        this.agendaList = new ArrayList<>(amountOfBlocks);
        this.freeBlocks = new FreeBlocksManager<E>(amountOfBlocks);

        setup(amountOfBlocks);
    }

    /**
     * Constructor of the class
     * @param minutesPerBlock how many minutes each "block" of time has. 
     * A block is the minimum amount of time represented by the class (in minutes)
     * @param insertList a predefined task list
     * @param beginDate the first date to be considered, the start date of the 
     * first block, standard for the calculation of the start and end date of 
     * each block of time
     */
    public AgendaAllocator(int minutesPerBlock, List<TimeObj<E>> insertList, LocalDateTime beginDate) {
        
        this.minutesPerBlock = minutesPerBlock;
        this.beginDate = beginDate;
        this.agendaList = new ArrayList<>(insertList.size());
        this.freeBlocks = new FreeBlocksManager<E>(insertList.size());
        
        setup(insertList);
    }
    
    /**
     * This method helps the constructor
     * @param amountOfBlocks initial amount of time blocks
     */
    private void setup(int amountOfBlocks) {
        ElementPosition elem = new ElementPosition(0, amountOfBlocks);
        LocalDateTime iterDate = this.beginDate;
        
        for (int i = 0; i < amountOfBlocks; i++) {
            LocalDateTime nextDate = iterDate.plusMinutes(minutesPerBlock);
            
            boolean isConsumed = false;
            if(iterDate.isBefore(LocalDateTime.now())){
                isConsumed = true;
            }
            
            agendaList.add(i, new TimeObj<>(iterDate, iterDate.plusMinutes(minutesPerBlock), TimeObj.timeStatus.NOT_ALLOCATED, isConsumed));
            iterDate = iterDate.plusMinutes(minutesPerBlock);
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }
    
    /**
     * This method helps the constructor
     * @param values a pre-prepared list of tasks
     */
    private void setup(List<TimeObj<E>> values) {
        //System.out.println("$" + values.size());
        ElementPosition elem = new ElementPosition(0, values.size());
        LocalDateTime iterDate = this.beginDate;
       
        for (int i = 0; i < values.size()-1; i++) {
            LocalDateTime nextDate = iterDate.plusMinutes(minutesPerBlock);
            
            boolean isConsumed = false;
            if(iterDate.isBefore(LocalDateTime.now())){
                isConsumed = true;
            }
            this.agendaList.add(i, 
                    new TimeObj<>(
                            iterDate, 
                            iterDate.plusMinutes(minutesPerBlock), 
                            values.get(i).getStatus(),
                            values.get(i).getTask(), 
                            isConsumed
                    )
            );
            iterDate = iterDate.plusMinutes(minutesPerBlock);
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }
    
    /*===== UTILITY STATIC METHODS =====*/
     /**
     * This method sums the values across multiple schedules and preserves 
     * fields that indicate free time in all of them.
     * The method calculates which time slots are available relative to the 
     * current time.
     * Can be used to search for a task allocation location for multiple objects.
     * @param agendas an array of agendas to add
     * @return AgendaAllocator indicating the sum of all the sent agendas
     * @throws NotAllowedValueException if an empty task vector is sent or if 
     * the attributes that indicate time are not equal
     */
    public static AgendaAllocator sum(AgendaAllocator... agendas) throws NotAllowedValueException{
        if(agendas.length == 0){
            throw new NotAllowedValueException();
        }
        
        int lastTime = agendas[0].minutesPerBlock;
        LocalDateTime dt = agendas[0].beginDate;
        
        for(AgendaAllocator elem : agendas){
            if(elem.minutesPerBlock != lastTime || !elem.beginDate.equals(dt)){
                throw new NotAllowedValueException();
            }
        }
        
        int smallestAgenda = agendas[0].maxPosition();
        for(AgendaAllocator agenda : agendas){
            if(agenda.maxPosition() < smallestAgenda){
                smallestAgenda = agenda.maxPosition();
            }
        }
        smallestAgenda++;
        
        List<TimeObj<String>> rsp = new ArrayList<>(smallestAgenda);
        String virtualTask = "taskn";
        
        TimeObj.timeStatus statusSum = TimeObj.timeStatus.NOT_ALLOCATED;
        int tskCount = 0;
        
        int i;
        
        for(i = 0; i < smallestAgenda; i++){
            TimeObj obj;
            for(AgendaAllocator elem : agendas){
                obj = (TimeObj) elem.agendaList.get(i);
                statusSum = TimeObj.sum(statusSum, obj.getStatus());
            }
            
            if(statusSum != TimeObj.timeStatus.ALLOCATED){
                virtualTask = null;
            }else{
                virtualTask = "# aTask #";
            }
            
            rsp.add(new TimeObj<>(virtualTask, statusSum));
            tskCount++;
            statusSum = TimeObj.timeStatus.NOT_ALLOCATED;
        }
        return new AgendaAllocator<>(lastTime, rsp, dt);
    }
    
    /**
     * Converts a certain quantity of minutes in how many blocks there will be 
     * if the sent quantity of minutes per element was used. 
     * @param minutes A certain amount of time in minutes
     * @param blockMinutes How much minutes a single block element represents
     * @return How many blocks are in {@code minutes} 
     */
    public static int minutesToBlocks(int minutes, int blockMinutes){
        return (int)Math.ceil( minutes/blockMinutes );
    }
    
    /**
     * 
     * @param hour A certain amount of time in hours
     * @param minutes A certain amount of time in minutes
     * @return how many minutes there are in {@code hours} and {@code minutes} 
     * together
     */
    public static int timeToMinutes(int hour, int minutes){
        return (hour * 60) + minutes;
    }
    
    /*===== UTILITY NON-STATIC METHODS =====*/
    /**
     * Calculates the maximum amount of blocks of time that the object can allocate
     * @return the maximum amount of blocks of time that the object can allocate
     */ 
    public int maxPosition(){
        return this.agendaList.size() - 1;
    }
    
    /**
     * Converts a certain quantity of minutes in how many blocks there will be 
     * if the {@code blockSizeInMinutes} quantity of minutes per element was used. 
     * @param minutes A certain amount of time in minutes
     * @return How many blocks are in {@code minutes} considering that a single 
     * element represents {@code this.blockSizeInMinutes} minutes.
     */
    public int minutesToBlocks(int minutes){
        return (int)Math.ceil( minutes/this.minutesPerBlock );
    }

    /**
     * Blocks the allocation of tasks in cycles until the end of the agenda
     * @param offsetFromStart How many blocks from the beginning of the agenda 
     * should be disregarded
     * @param everyBlocks A range of free blocks between blocks that will be 
     * blocked for allocation
     * @param notAllocateBlockAmount How many blocks of time should be 
     * blocked in each cycle
     */
    public void setDoNotAllocateEveryNBlocks(int offsetFromStart, int everyBlocks, int notAllocateBlockAmount) {
        for (int countJmp = offsetFromStart; countJmp < this.agendaList.size(); countJmp += everyBlocks) {
            for (int countElem = 0; countElem < notAllocateBlockAmount; countElem++) {
                TimeObj elem = this.agendaList.get(countElem + countJmp);
                elem.setStatus(TimeObj.timeStatus.DO_NOT_ALLOCATE);
            }
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }

    /*===== FIT-FIND METHODS =====*/
    /**
     * Finds the worst fit in the agenda for any task that consumes a certain
     * quantity of blocks
     * @param blocks how many blocks are needed
     * @return The index in the agenda that can holds this allocation
     * @throws NotAllowedValueException if an invalid input was given 
     */
    public int findWorstFit(int blocks) throws NotAllowedValueException{
        return findWorstFit(blocks, 0, maxPosition());
    }

    /**
     * Finds the worst fit in the agenda for any task that consumes a certain
     * quantity of blocks in a certain range of the agenda
     * @param blocks how many blocks are needed
     * @param fromBlock the last block considered in the search of free blocks
     * @param toBlock the first block considered in the search of free blocks
     * @return The index in the agenda that can holds this allocation
     * @throws NotAllowedValueException if an invalid input was given 
     */
    public int findWorstFit(int blocks, int fromBlock, int toBlock) throws NotAllowedValueException{
        if (fromBlock >= toBlock|| fromBlock < 0 || toBlock < 0|| fromBlock > maxPosition()|| toBlock > maxPosition()) {
            throw new NotAllowedValueException();
        }
        this.recalculateConsumed();
        for (int i = this.freeBlocks.getSize()-1; i > 0; i--){
            ElementPosition elem = this.freeBlocks.getElement(i);
            if (elem.getValue() >= blocks && elem.getPosition() >= fromBlock && elem.getPosition() <= toBlock) {
                return elem.getPosition();
            }
        }
        return -1;
    }

    /**
     * Finds the best fit in the agenda for any task that consumes a certain
     * quantity of blocks
     * @param blocks how many blocks are needed
     * @return The index in the agenda that can holds this allocation
     * @throws NotAllowedValueException if an invalid input was given 
     */
    public int findBestFit(int blocks) throws NotAllowedValueException{
        return findBestFit(blocks, 0, maxPosition());
    }

    /**
     * Finds the best fit in the agenda for any task that consumes a certain
     * quantity of blocks in a certain range of the agenda
     * @param blocks  how many blocks are needed
     * @param fromBlock the first block considered in the search of free blocks
     * @param toBlock the last block considered in the search of free blocks
     * @return The index in the agenda that can holds this allocation
     * @throws NotAllowedValueException if an invalid input was given 
     */
    public int findBestFit(int blocks, int fromBlock, int toBlock) throws NotAllowedValueException{
        this.recalculateConsumed();
        if (fromBlock >= toBlock|| fromBlock < 0 || toBlock < 0|| fromBlock > maxPosition()|| toBlock > maxPosition()) {
            throw new NotAllowedValueException();
        }
        int firstFits = -1;
        int lastPosition = -1;
        int count = 0;
        for (int i = 0; i < this.freeBlocks.getSize() ; i++) {
            ElementPosition elem = this.freeBlocks.getElement(i);
            
            if (elem.getValue() >= blocks && elem.getPosition() >= fromBlock && elem.getPosition() <= toBlock) {
                if(firstFits == -1){
                    firstFits = elem.getValue();
                }else{
                    if(elem.getValue() > firstFits || count == this.freeBlocks.getSize()-1){
                        return elem.getPosition();
                    }
                    lastPosition = elem.getPosition();
                }
            }
            count++;
        }
        return -1;
    }

    /*===== ALLOCATION AND MARKING METHODS =====*/
 
    /**
     * Allocates a given task using a allocation method
     * @param blocks how many blocks are needed
     * @param task the object that represents the task
     * @param stat the allocation strategy
     * @param fromBlock the first block considered in the search of free blocks
     * @param toBlock the last block considered in the search of free blocks
     * @return the position in the agenda where the task was allocated
     */
    public int allocate(int blocks, E task, allocationStrategy stat, int fromBlock, int toBlock) {
        int fit;
        switch (stat) {
            case BEST_FIT:
                fit = findBestFit(blocks, fromBlock, toBlock);
                if (fit != -1) {
                    if (setOnPosition(blocks, fit, task)) {
                        return fit;
                    } else {
                        return -1;
                    }
                } else {
                    return fit;
                }
            case WORST_FIT:
                fit = findWorstFit(blocks, fromBlock, toBlock);
                if (fit != -1) {
                    if (setOnPosition(blocks, fit, task)) {
                        return fit;
                    } else {
                        return -1;
                    }
                }
        }
        return -1;
    }

    /**
     * Allocates a given task using a allocation method
     * @param blocks how many blocks are needed
     * @param task the object that represents the task
     * @param stat the allocation strategy
     * @return the position in the agenda where the task was allocated
     */
    public int allocate(int blocks, E task, allocationStrategy stat) {
        return allocate(blocks, task, stat, 0, maxPosition());
    }

    /**
     * Allocates a certain task in a free-standing agenda position
     * @param blocks how many blocks are needed
     * @param onPosition the first position of the allocation
     * @param task a object that represents the task
     * @return <code>True</code> only if the task was allocated
     */
    private boolean setOnPosition(int blocks, int onPosition, E task) {
        if (blocks <= 0 || 
                blocks > maxPosition() ||
                onPosition < 0 || 
                (onPosition + blocks -1) > maxPosition()) {
            throw new NotAllowedValueException();
        }

        if (freeBlocks.fits(blocks, onPosition)) {
            for (int i = onPosition; i < (onPosition + blocks -1); i++) {
                TimeObj elem = this.agendaList.get(i);
                elem.setTask(task);
                elem.setStatus(TimeObj.timeStatus.ALLOCATED);
            }
            freeBlocks.generateFreeBlocksList(this.agendaList);
            return true;
        }
        return false;
    }


    /**
     * Set a certain position of the agenda as time already consumed (in the past)
     * @param blocks how many blocks will be changed
     * @param onPosition the first position
     * @throws NotAllowedValueException if an invalid input was given  
     */
    private void consume(int blocks, int onPosition) throws NotAllowedValueException{
        if (blocks <= 0 || blocks > maxPosition() || onPosition < 0 || (onPosition + blocks -1) > maxPosition()) {
            throw new NotAllowedValueException();
        }

        for (int i = onPosition; i < (onPosition + blocks); i++) {
            TimeObj task = this.agendaList.get(i);
            task.setConsumed(true);
            this.agendaList.set(i, task);
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }
    
    /**
     * Updates the agenda marking the blocks of time that cannot be used because
     * they are in the past
     */
    private void recalculateConsumed(){
        for(TimeObj elem : this.agendaList){
            if(elem.getInitDate().isBefore(LocalDateTime.now())){
                elem.setConsumed(true);
            }else{
                elem.setConsumed(false);
            }
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }

    /**
     * Marks a certain quantity of blocks as not allocable
     * @param blocks  how many blocks will be changed
     * @param onPosition the first position
     * @throws NotAllowedValueException if an invalid input was given  
     */
    public void doNotAllocate(int blocks, int onPosition) throws NotAllowedValueException{
        if (blocks <= 0 || blocks >= maxPosition() || onPosition <= 0 || (onPosition + blocks -1) >= maxPosition()) {
            throw new NotAllowedValueException();
        }

        for (int i = onPosition; i < (onPosition + blocks); i++) {
            TimeObj task = this.agendaList.get(i);
            task.setStatus(TimeObj.timeStatus.DO_NOT_ALLOCATE);
            this.agendaList.set(i, task);
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }

    /**
     * Marks a certain amount of blocks containing the given task as free
     * @param onPosition the first position
     * @param task the task to be deleted
     * @throws NotAllowedValueException if an invalid input was given  
     */
    public boolean free(int onPosition, E task) throws NotAllowedValueException{
        if (onPosition < 0 || onPosition > maxPosition()) {
            throw new NotAllowedValueException();
        }
        TimeObj elem;

        int i = onPosition;
        while(true){
            elem = this.agendaList.get(i);
            
            if(elem.hasStatus(TimeObj.timeStatus.ALLOCATED) && elem.getTask() != null && elem.getTask().equals(task)){
                elem.setStatus(TimeObj.timeStatus.NOT_ALLOCATED);
                elem.setTask(null);
            }else{
                break;
            }
            i++;
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
        return true;
    }
    
    /**
     * Marks a certain amount of blocks containing any task as free
     * @param onPosition the first position
     */
    public void free(int onPosition){
        if (onPosition < 0 || onPosition > maxPosition()) {
            throw new NotAllowedValueException();
        }
        
        int i = onPosition;
        TimeObj elem = this.agendaList.get(i);
        TimeObj previous = elem;

        while(true){
            elem = this.agendaList.get(i);
            
            if(elem.hasStatus(TimeObj.timeStatus.ALLOCATED) 
                    && elem.getTask() != null 
                    && elem.getTask().equals(previous.getTask())){
                elem.setStatus(TimeObj.timeStatus.NOT_ALLOCATED);
                previous = elem.getClone();
                elem.setTask(null);
            }else{
                break;
            }
            i++;
        }
        freeBlocks.generateFreeBlocksList(this.agendaList);
    }
    
    /**
     * Removes all refrerences to a certain task marking the positions as free
     * @param task the task to be deleted
     * @return <code>true</code> only if the given task was found and deleted
     */
    public boolean free(E task){
        boolean altered = false;
        for(TimeObj<E> elem : this.agendaList){
            if(elem.getTask() != null && elem.getTask().equals(task)){
                altered = true;
                elem.setStatus(TimeObj.timeStatus.NOT_ALLOCATED);
                elem.setTask(null);
            }
        }
        return altered;
    }
    
    /*===== ELEMENT SEACH AND DESCRIPTION METHODS =====*/
    /**
     * Finds all ocurrences of a given task in the agenda
     * @param searchedElem the element to be finded
     * @param firstPosition the first position of search
     * @param lastPosition the last position of serch
     * @return a list containing the index and the amount of blocks used from this
     * index
     */
    public List<ElementPosition> findElement(E searchedElem, int firstPosition, int lastPosition){
        List<ElementPosition> rsp = new ArrayList<>();
        
        for(int countPosition = firstPosition; countPosition < lastPosition; countPosition++){
            TimeObj<E> elem = this.agendaList.get(countPosition);
            
            int amount = countOnPosition(searchedElem, countPosition);
            
            if(amount > 0){
                rsp.add(new ElementPosition(countPosition, amount));
                countPosition += amount;
            }
        }
        
        return rsp;
    }
    
    public List<Integer> count(){
        List<Integer> rsp = new ArrayList<>();
        
        for(int i = 0; i < maxPosition(); i++){
            try{
                Integer elemcount = countOnPosition(this.agendaList.get(i).getTask(), i);
                i += elemcount;
                rsp.add(i);
            }catch(Exception e){
            
            }
        }
        return rsp;
    }
    
    /**
     * Calculates how many blocks a given task uses in the agenda
     * @param elem the element to be counted
     * @param firstPosition the first position of the element
     * @return how many blocks a certain task uses
     * @throws NotAllowedValueException if an invalid input was given   
     */
    private int countOnPosition(E elem, int firstPosition) throws NotAllowedValueException{
        if (firstPosition < 0 || firstPosition > maxPosition() || elem == null) {
            throw new NotAllowedValueException();
        }
        int countEqual = 0;
        for(int i = firstPosition; i < this.maxPosition(); i++){
            TimeObj<E> iterElem = this.agendaList.get(i);
            
            if(iterElem.getTask() != null && iterElem.getTask().equals(elem)){
               countEqual++;
            }else{
                return countEqual;
            }
        }
        return 0;
    }
    
   
    
    /*===== OVERRIDE / COMMON METHODS =====*/
    /**
     * @return A string showing some parameters of the object in a formatted way
     */
    @Override
    public String toString() {
        String rsp = "";
        String consumedStr = "";
        int elemCount = 0;

        for (TimeObj elem : agendaList) {
            if (null != elem.getStatus()) {
                consumedStr = (elem.isConsumed())?("#"):(" ");
                String tskStts = TimeObj.getSmallName(elem.getStatus());
                
                if(elem.getTask() != null){
                    tskStts = elem.getTask().toString();
                }
                
                rsp += String.format(
                        "%3d : [%-15s | [%s] | %s]\n", 
                        elemCount, 
                        tskStts, 
                        consumedStr, 
                        elem.getInitDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                );
                elemCount++;
            }
        }
        return rsp;
    }
    
    /**
     * Gets a clone of the free blocks list
     * @return clone of the free blocks list
     */
    public FreeBlocksManager<E> getFreeBlocks() {
        return this.freeBlocks.getClone();
    }
    
    /**
     * Clones the object
     * @return 
     */
    public AgendaAllocator getClone(){
        try {
            return (AgendaAllocator<E>) this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Clones the object
     * @return 
     */
    public List<TimeObj<E>> getTimeObjectClone(){
        List<TimeObj<E>> newList = new ArrayList<>();
        Collections.copy(newList, this.agendaList);
        return (List<TimeObj<E>> )newList;
    }
}
