package timeHlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import visit.Visit;

/**
 *
 * @author andre
 */
public class TimeAllocationHelper {

    private List<Visit> dat;
    private int blockSizeInMinutes;

    public TimeAllocationHelper(int initialSize, int blockSize) {
        dat = new ArrayList<>();
        
        for(int i = 0; i < initialSize; i++){
            dat.add(null);
        }
        
        this.blockSizeInMinutes = blockSize;
    }
    
    public static int minutesToBlocks(int minutes, int blockMinutes){
        return (int)Math.ceil( minutes/blockMinutes );
    }
    
    public int minutesToBlocks(int minutes){
        return (int)Math.ceil( minutes/this.blockSizeInMinutes );
    }
    
    public static int timeToMinutes(int hour, int minutes){
        return (hour * 60) + minutes;
    }
   
    public int findNextFitAllowGrow(int reqBlocks){
        int reqBlocksCount = reqBlocks;  
        int firstNull = -1;
        
        if(reqBlocks <= 0 || reqBlocks > dat.size()){
            return -1;
        }
        
        while(true){
            for(int index = 0; index < dat.size(); index++){

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
    
    public int findNextFit(int reqBlocks){
        int reqBlocksCount = reqBlocks;  
        int firstNull = -1;
        
        if(reqBlocks <= 0 || reqBlocks > dat.size()){
            return -1;
        }
        
        while(true){
            for(int index = 0; index < dat.size(); index++){

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
    
    public int findBestFit(int reqBlocks){
        int lowerestValue = Integer.MAX_VALUE;
        int lowerestIndex = -1;
        
        for(int i = 0; i < dat.size(); i++){//Gerando os indexes
            
            if(dat.get(i) == null){//Se null encontrado
                //System.out.println("FOUND NULL IN INDEX: " + i);
                int rsp = this.getSize(i);//Calcular o tamannho do bloco
                //System.out.println("NULL BLOCK SIZE IS: "+ rsp);
                
                if(rsp < lowerestValue && rsp >= reqBlocks){//Se o tamanho do bloco lido for menor que o anterior e maior ou igual que o tamanho mínimo
                    lowerestValue = rsp;
                    lowerestIndex = i;
                }
                i += rsp;//O index vai para o final do bloco
            }
        }
        return lowerestIndex;
    }
    
    public boolean insert(Visit value, int init, int reqBlocks){
        if(reqBlocks <= 0 || reqBlocks > dat.size() || reqBlocks + init > dat.size()){
            return false;
        }
        
        for(int i = init; i < (init + reqBlocks); i++){
            dat.set(i, value);
        }
        return true;
    }
    
    public boolean remove(int firstIndex){
        if(firstIndex < 0 || firstIndex > dat.size()){
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
    
    public int getSize(int firstIndex){
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
        String str = "TimeAllocationHelper{blockSizeInMinutes=" + blockSizeInMinutes + "\n";
        
        int indexCount = 0;
        for(Visit elem : this.dat){
            str += String.format("[4%d]:"+elem.getName()+",...,\n", indexCount);
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
    
    
    
}


