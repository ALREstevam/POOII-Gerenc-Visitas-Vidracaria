package timeHlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import visit.Visit;

/**
 * This class represents a {@code visit} record according to time, a list keeps which 
 * visits are marked, each list element represents {@code blockSizeInMinutes} 
 * minutes, so contiguous blocks with the same visit element represent the same 
 * action.
 * A block is a set of contiguous list elements that point to a visit or to {@code null}
 * An element represents a component of the list that points to a visit or to {@code null}
 * 
 * This class can allocate or remove blocks of time, search trought the list for 
 * not allocated spaces, compare different agendas, etc.
 * @author andre
 * @see List
 */
public class Agenda {

    private List<Visit> dat;
    private int blockSizeInMinutes;

    public Agenda(int initialSize, int blockSize) {
        dat = new ArrayList<>();
        
        for(int i = 0; i < initialSize; i++){
            dat.add(null);
        }
        
        this.blockSizeInMinutes = blockSize;
    }
    
    /**
     * 
     * Combines agendas to find matching null contiguous spaces
     * @param agendas an list of agendas to analyze
     * @param reqBlocks size of block of not allocated time
     * @return An index for the first occurrence in which all elements of the 
     * list when combined have at least {@code reqBlocks} contiguous null values or -1 
     * if no match can be found.
     */
    public static int findFirstMatchFit(List<Agenda> agendas, int reqBlocks){
        if(agendas.size() < 2){
            return -1;
        }
        
        int smaller = agendas.get(0).getTimeAllocArray().size();
        for(Agenda elem : agendas){
            int current = elem.getTimeAllocArray().size();
            if(current < smaller){
                smaller = current;
            }
        }
        Agenda auxtm = new Agenda(smaller, 1);
        Visit auxVisit;
        for(int i = 0; i < smaller; i++){
            auxVisit = null;
            for(Agenda elem : agendas){
                Visit v = elem.getTimeAllocArray().get(i);
                if(v != null){
                    auxVisit = v;
                }
            }
            auxtm.insert(auxVisit, i, 1);
        }
        return auxtm.findNextFit(reqBlocks);
    }

    /**
     * Combines agendas to find matching null contiguous spaces
     * @param agendas an list of agendas to analyze
     * @param reqBlocks size of block of not allocated time
     * @return An index for the occurrence in which all elements of the 
     * list when combined have at least {@code reqBlocks} contiguous null values 
     * (choosing the smaller one whose can fits {@code reqBlocks} blocks) or -1 
     * if no match can be found.
     */
    public static int findBestMatchFit(List<Agenda> agendas, int reqBlocks){
        if(agendas.size() < 2){
            return -1;
        }
        
        int smaller = agendas.get(0).getTimeAllocArray().size();
        for(Agenda elem : agendas){
            int current = elem.getTimeAllocArray().size();
            if(current < smaller){
                smaller = current;
            }
        }
        Agenda auxtm = new Agenda(smaller, 1);
        Visit auxVisit;
        for(int i = 0; i < smaller; i++){
            auxVisit = null;
            for(Agenda elem : agendas){
                Visit v = elem.getTimeAllocArray().get(i);
                if(v != null){
                    auxVisit = v;
                }
            }
            auxtm.insert(auxVisit, i, 1);
        }
        //System.out.println(auxtm);
        return auxtm.findBestFit(reqBlocks);
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
     * Converts a certain quantity of minutes in how many blocks there will be 
     * if the {@code blockSizeInMinutes} quantity of minutes per element was used. 
     * @param minutes A certain amount of time in minutes
     * @return How many blocks are in {@code minutes} considering that a single 
     * element represents {@code this.blockSizeInMinutes} minutes.
     */
    public int minutesToBlocks(int minutes){
        return (int)Math.ceil( minutes/this.blockSizeInMinutes );
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
   
    /**
     * Searches for contiguous not allocated time blocks 
     * @param reqBlocks How many contiguous not allocated elements are being sought
     * @return An index to the first occurence or -1 if what is being searched is not found 
     */
    public int findNextFit(int reqBlocks){
        return findNextFit(reqBlocks, 0);
    }
    
    /**
     * Searches for contiguous not allocated time blocks 
     * @param reqBlocks How many contiguous not allocated elements are being sought
     * @param beginIndex The initial index to search till the end of the list
     * @return An index to the first occurence searching from {@code beginIndex}
     * till the end of the list or -1 if what is being searched is not found 
     */
    public int findNextFit(int reqBlocks, int beginIndex){
        int reqBlocksCount = reqBlocks;  
        int firstNull = -1;
        
        if(reqBlocks <= 0 || reqBlocks > dat.size() || beginIndex < 0 || beginIndex > dat.size()){
            return -1;
        }
        
        while(true){
            for(int index = beginIndex; index < dat.size(); index++){

                if(dat.get(index) == null){//Elemento com null encontrado
                    if(reqBlocksCount == reqBlocks){//Encontrei o primeiro nulo, guardo o index dele
                        firstNull = index;
                    }
                    reqBlocksCount--;
                }

                if(reqBlocksCount == 0){//A sequência de nulos chegou a 0, é possível alocar
                    return firstNull;
                }

                if(dat.get(index) != null){//Elemento não null encontrado
                    reqBlocksCount = reqBlocks;
                }
            }
            
            return -1;
        }
    }
    
     /**
     * Searches for contiguous not allocated time blocks, if what is being searched
     * was not found the list grows increasing the amount of not allocated time
     * @param reqBlocks How many contiguous not allocated elements are being sought
     * @return An index to the first occurence
     */
    public int findNextFitAllowGrow(int reqBlocks){
        return this.findNextFitAllowGrow(reqBlocks, 0);
    }
    
    /**
     * Searches for contiguous not allocated time blocks, if what is being searched
     * was not found the list grows increasing the amount of not allocated time
     * @param reqBlocks How many contiguous not allocated elements are being sought
     * @param beginIndex The initial index to search till the end of the list
     * @return An index to the first occurence
     */
    public int findNextFitAllowGrow(int reqBlocks, int beginIndex){
        int reqBlocksCount = reqBlocks;  
        int firstNull = -1;
        
        if(reqBlocks <= 0 || reqBlocks > dat.size() || beginIndex < 0 || beginIndex > dat.size()){
            return -1;
        }
        
        while(true){
            for(int index = beginIndex; index < dat.size(); index++){

                if(dat.get(index) == null){//Elemento com null encontrado
                    if(reqBlocksCount == reqBlocks){//Encontrei o primeiro nulo, guardo o index dele
                        firstNull = index;
                    }
                    reqBlocksCount--;
                }

                if(reqBlocksCount == 0){//A sequência de nulos chegou a 0, é possível alocar
                    return firstNull;
                }

                if(dat.get(index) != null){//Elemento não null encontrado
                    reqBlocksCount = reqBlocks;
                }
            }
            
            for(int i = 0; i < reqBlocks; i++){
                dat.add(null);
            }
        }
    }
    
    /**
     * Searches trought the list looking for the smallest block that can allocate
     * {@code reqBlocks} blocks
     * @param reqBlocks
     * @return An index to the best fit of @code{reqBlocks} in the list.
     */
    public int findBestFit(int reqBlocks){
        int lowerestValue = Integer.MAX_VALUE;
        int lowerestIndex = -1;
        
        for(int i = 0; i < dat.size(); i++){//Gerando os indexes
            if(dat.get(i) == null){//Se null encontrado
                int rsp = this.getSizeOfBlocks(i);//Calcular o tamannho do bloco
                if(rsp < lowerestValue && rsp >= reqBlocks){//Se o tamanho do bloco lido for menor que o anterior e maior ou igual que o tamanho mínimo
                    lowerestValue = rsp;
                    lowerestIndex = i;
                }
                i += rsp;//O index vai para o final do bloco
            }
        }
        return lowerestIndex;
    }
    
    /**
     * 
     * @param reqBlocks A certain amount of blocks that shoud be greater than zero
     * and less than or equal to the size of the list
     * @param init A initial index that when summed up with {@code reqBlocks} 
     * shoud be greater than zero and less than or equal to the size of the list
     * @return {@code true} if the given values could be used safely and 
     * {@code false} in the other case
     */
    private boolean validateInsertInstruction(int reqBlocks, int init){
        return !(reqBlocks <= 0 || reqBlocks > dat.size() || reqBlocks + init > dat.size());
    }
    
    /**
     * Makes an allocation of time
     * @param value Task that should be allocated
     * @param init Initial index to allocate
     * @param reqBlocks Amount of blocks to allocate starting from {@code init}
     * @return @code{true} if the task was properly allocated and {@code false} in the other case
     */
    public boolean insert(Visit value, int init, int reqBlocks){
        if(!this.validateInsertInstruction(reqBlocks, init)){
            return false;
        }
        
        for(int i = init; i < (init + reqBlocks); i++){
            dat.set(i, value);
        }
        return true;
    }
    
    /**
     * Makes an allocation of time ensuring that there will not be overlapping in an already allocated task
     * @param value Task that should be allocated
     * @param init Initial index to allocate
     * @param reqBlocks Amount of blocks to allocate starting from {@code init}
     * @return @code{true} if the task was properly allocated and {@code false} in the other case
     */
    public boolean insertSecure(Visit value, int init, int reqBlocks){
        if(!this.validateInsertInstruction(reqBlocks, init) || this.getSizeOfBlocks(init) < reqBlocks){
            return false;
        }
        return insert(value, init, reqBlocks);
    }
    
    /**
     * Removes an allocation of time
     * @param firstIndex the first element of the task to be removed
     * @return @code{true} if the task was properly removed and {@code false} in the other case
     */
    public boolean remove(int firstIndex){
        if(firstIndex < 0 || firstIndex > dat.size() || dat.get(firstIndex) == null){
            return false;
        }
        
        Visit value = dat.get(firstIndex);
        int index = firstIndex;
        
        do{
            dat.set(index, null);
            index++;
        }while(index < dat.size() && Objects.equals(dat.get(index), value));
        return true;
    }
    
    /**
     * Searches for the first index of the given {@code Visit} in the list
     * @param value
     * @return The first index of {@code value} in the list or -1 if the 
     * element cannot be found
     */
    public int getFirstIndex(Visit value){
        if(value == null){
            return -1;
        }
        
        int index = 0;
        for(Visit elem : this.dat){
            if(elem != null){
                if(elem.equals(value)){
                    return index;
                }
            }
            index ++;
        }
        return -1;
    }
    
    /**
     * Counts how many equal elements there are in a block starting from {@code firstIndex}
     * @param firstIndex
     * @return The amount of contiguous and equal objects in the block 
     * which starts at  {@code firstIndex}
     */
    public int getSizeOfBlocks(int firstIndex){
         if(firstIndex < 0 || firstIndex > dat.size()){
            return 0;
        }
        
        Visit value = dat.get(firstIndex);
        int index = firstIndex, count = 0;
        
        do{
            index++;
            count++;
        }while(index < dat.size() && dat.get(index) == value);
        return count;
    }
    
    /*============================================================*/

    @Override
    public String toString() {
        String str = "Agenda{blockSizeInMinutes=" + blockSizeInMinutes + "\n";
        
        int indexCount = 0;
        for(Visit elem : this.dat){
            if(elem == null){
                str += String.format("[%4d]: null\n", indexCount);
            }else{
                str += String.format("[%4d]: \""+elem.getName()+"\"\n", indexCount);
            }
            indexCount++;
        }
        str+= '}';
        return str;
    }

    public List<Visit> getTimeAllocArray() {
        return dat;
    }

    public void setgetTimeAllocArray(List<Visit> dat) {
        this.dat = dat;
    }

    public int getBlockSizeInMinutes() {
        return blockSizeInMinutes;
    }

    public void setBlockSizeInMinutes(int blockSizeInMinutes) {
        this.blockSizeInMinutes = blockSizeInMinutes;
    }

    /*---*/
}


