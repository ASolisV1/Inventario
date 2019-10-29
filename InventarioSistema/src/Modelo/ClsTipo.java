package Modelo;
public class ClsTipo {
    private int usutipid;
    private String usutiponom;
    private int usutipcod;

    public ClsTipo() {
    }

    public ClsTipo(int usutipid, String usutiponom, int usutipcod) {
        this.usutipid = usutipid;
        this.usutiponom = usutiponom;
        this.usutipcod = usutipcod;
    }
    
    public int getUsutipid() {
        return usutipid;
    }
    public void setUsutipid(int usutipid) {
        this.usutipid = usutipid;
    }
    public String getUsutiponom() {
        return usutiponom;
    }
    public void setUsutiponom(String usutiponom) {
        this.usutiponom = usutiponom;
    }
    public int getUsutipcod() {
        return usutipcod;
    }
    public void setUsutipcod(int usutipcod) {
        this.usutipcod = usutipcod;
    }
    public String toString() {
	return this.usutiponom;
}

}
