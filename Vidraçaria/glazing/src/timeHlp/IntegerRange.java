package timeHlp;

/**
 *
 * @author andre
 */
public class IntegerRange {
    private Integer init, end;
    
    public IntegerRange(Integer init, Integer end) {
        if(init < end){
            this.init = init;
            this.end = end;
        }else{
            this.init = end;
            this.end = init;
        }
    }
    
    public Integer getInterval(){
        return (this.end - this.init);
    }
    
    public boolean isInsideOf(IntegerRange rng){
        return this.init >= rng.getInit() && this.end <= rng.getEnd();
    }
    
    public Integer getInit() {
        return init;
    }

    public void setInit(Integer init) {
        this.init = init;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("IntegerRange = (\"%d\" -> \"%d\");", this.init, this.end);
    }
}
