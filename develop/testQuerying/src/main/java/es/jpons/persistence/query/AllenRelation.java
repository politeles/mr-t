/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jpons.persistence.query;

/**
 * The allen relations
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public enum AllenRelation {
    equal,
    before, after,
    meets,meet_by,
    overlaps, overlapped_by,
    during, contains,
    starts, started_by,
    finishes, finished_by;
    
    /**
     * Function that provides the inverse of a given allen relation.
     * @param ar The allen relation
     * @return The inverse allen relation
     */
    public static AllenRelation inverseOf(AllenRelation ar){
        
        
        switch (ar){
            case equal: return equal;
            case before: return after;
            case after: return before;
            case meets: return meet_by;
            case meet_by: return meets;
            case overlaps: return overlapped_by;
            case overlapped_by: return overlaps;
            case during: return contains;
            case contains: return during;
            case starts: return started_by;
            case started_by: return starts;
            case finishes: return finished_by;
            case finished_by: return finishes;
                
            default: return equal;
        }
        
    }
    
  
}
