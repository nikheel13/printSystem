package sample;

public class ModelPrinters {

    String printerid, printername, printertype, printerstatus;

    public ModelPrinters(String printerid, String printername, String printertype, String printerstatus) {
        this.printerid = printerid;
        this.printername = printername;
        this.printertype = printertype;
        this.printerstatus = printerstatus;
    }

    public String getPrinterid() {
        return printerid;
    }

    public void setPrinterid(String printerid) {
        this.printerid = printerid;
    }

    public String getPrintername() {
        return printername;
    }

    public void setPrintername(String printername) {
        this.printername = printername;
    }

    public String getPrintertype() {
        return printertype;
    }

    public void setPrintertype(String printertype) {
        this.printertype = printertype;
    }

    public String getPrinterstatus() {
        return printerstatus;
    }

    public void setPrinterstatus(String printerstatus) {
        this.printerstatus = printerstatus;
    }
}
