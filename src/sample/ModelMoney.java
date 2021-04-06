package sample;

public class ModelMoney {

    String workid,aliasname,workname,numbsheets,numbcopies, worktype, workstatus,workcost;

    public ModelMoney(String workid, String aliasname, String workname, String numbsheets, String numbcopies, String worktype, String workstatus, String workcost) {
        this.workid = workid;
        this.aliasname = aliasname;
        this.workname = workname;
        this.numbsheets = numbsheets;
        this.numbcopies = numbcopies;
        this.worktype = worktype;
        this.workstatus = workstatus;
        this.workcost = workcost;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getNumbsheets() {
        return numbsheets;
    }

    public void setNumbsheets(String numbsheets) {
        this.numbsheets = numbsheets;
    }

    public String getNumbcopies() {
        return numbcopies;
    }

    public void setNumbcopies(String numbcopies) {
        this.numbcopies = numbcopies;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public String getWorkcost() {
        return workcost;
    }

    public void setWorkcost(String workcost) {
        this.workcost = workcost;
    }
}
