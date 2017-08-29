package sample.dialogJobWindow;

/**
 * Created by Макс on 25.08.2017.
 */
public class Job {
    private String nameOfMachin;
    private String nameOfEmployee;
    private String time;
    private int cost;
    private int costOfCarriage;
    private String nameOfJob;
    private String payment;
    private boolean noOrYesPayment;

    public String getNameOfMachin() {
        return nameOfMachin;
    }

    public void setNameOfMachin(String nameOfMachin) {
        this.nameOfMachin = nameOfMachin;
    }

    public String getNameOfEmployee() {
        return nameOfEmployee;
    }

    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee = nameOfEmployee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCostOfCarriage() {
        return costOfCarriage;
    }

    public void setCostOfCarriage(int costOfCarriage) {
        this.costOfCarriage = costOfCarriage;
    }

    public String getNameOfJob() {
        return nameOfJob;
    }

    public void setNameOfJob(String nameOfJob) {
        this.nameOfJob = nameOfJob;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean isNoOrYesPayment() {
        return noOrYesPayment;
    }

    public void setNoOrYesPayment(boolean noOrYesPayment) {
        this.noOrYesPayment = noOrYesPayment;
    }

    public Job() {
        this.nameOfMachin = nameOfMachin;
        this.nameOfEmployee = nameOfEmployee;
        this.time = time ;
        this.cost = cost;
        this.costOfCarriage = costOfCarriage;
        this.nameOfJob = nameOfJob;
        this.payment = payment;
        this.noOrYesPayment = false;
    }
}
