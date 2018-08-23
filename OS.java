public class OS {
    private String operatingSys;
    private int versionNum;

    public OS(String operatingSys, int versionNum ){
        this.operatingSys = operatingSys;
        this.versionNum   = versionNum;

    }

    public String getOperatingSys() {
        return operatingSys;
    }

    public int getVersionNum() {
        return versionNum;
    }
}
