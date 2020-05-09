package bafy.pharmacy.milkbank.bll;

public class PatList {
    private String patBedNo;
    private String patName;
    private String patWard;

    public PatList(String patBedNo,String patName,String patWard){
        this.patBedNo = patBedNo;
        this.patName = patName;
        this.patWard = patWard;
    }

    public String getPatBedNo() {
        return patBedNo;
    }

    public String getPatName() {
        return patName;
    }

    public String getPatWard() {
        return patWard;
    }
}
