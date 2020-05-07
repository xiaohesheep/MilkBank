package bafy.pharmacy.milkbank.bll;

public class OrdList {
    private String desc;
    private String dose;
    private String inst;
    private String freq;
    private String status;

    public OrdList(String desc,String dose,String inst,String freq,String status){
        this.desc = desc;
        this.dose = dose;
        this.inst = inst;
        this.freq = freq;
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public String getDose() {
        return dose;
    }

    public String getFreq() {
        return freq;
    }

    public String getInst() {
        return inst;
    }

    public String getStatus() {
        return status;
    }
}
