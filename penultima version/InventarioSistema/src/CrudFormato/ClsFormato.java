/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudFormato;

/**
 *
 * @author Ysrael
 */
public class ClsFormato {
    private int forcod;
    private String fornom;
    
    public ClsFormato (){
       
    }
    
    public ClsFormato (int _codFormato, String _nomFormato){
        forcod=_codFormato;
        fornom=_nomFormato;
    }
    
    public int getCodFor(){
        return forcod;
    }
    
    public void setCodFor(int _codFormato){
        forcod=_codFormato;
    }
    
    public String getNomFor(){
        return fornom;
    }
    
    public void setNomFor(String _nomFormato){
        fornom=_nomFormato;
    }
    
}
