package sample;

public class ModelJobs {

    String jobid, jobname, nosheets, nocopies, jobstatus,jobcost;

    public ModelJobs(String jobid, String jobname, String nosheets, String nocopies, String jobstatus, String jobcost) {
        this.jobid = jobid;
        this.jobname = jobname;
        this.nosheets = nosheets;
        this.nocopies = nocopies;
        this.jobstatus = jobstatus;
        this.jobcost = jobcost;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getNosheets() {
        return nosheets;
    }

    public void setNosheets(String nosheets) {
        this.nosheets = nosheets;
    }

    public String getNocopies() {
        return nocopies;
    }

    public void setNocopies(String nocopies) {
        this.nocopies = nocopies;
    }

    public String getJobstatus() {
        return jobstatus;
    }

    public void setJobstatus(String jobstatus) {
        this.jobstatus = jobstatus;
    }

    public String getJobcost() {
        return jobcost;
    }

    public void setJobcost(String jobcost) {
        this.jobcost = jobcost;
    }
}
