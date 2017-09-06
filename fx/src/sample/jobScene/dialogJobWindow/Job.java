package sample.jobScene.dialogJobWindow;

import javafx.beans.property.*;

import java.io.Serializable;

/**
 * Created by Макс on 25.08.2017.
 */
public class Job implements Serializable {
    private StringProperty nameOfMachin;
    private StringProperty nameOfEmployee;
    private StringProperty time;
    private IntegerProperty cost;
    private IntegerProperty costOfCarriage;
    private StringProperty nameOfJob;
    private StringProperty payment;
    private BooleanProperty noOrYesPayment;

    public String getNameOfMachin() {
        return nameOfMachin.get();
    }

    public StringProperty nameOfMachinProperty() {
        return nameOfMachin;
    }

    public void setNameOfMachin(String nameOfMachin) {
        this.nameOfMachin.set(nameOfMachin);
    }

    public String getNameOfEmployee() {
        return nameOfEmployee.get();
    }

    public StringProperty nameOfEmployeeProperty() {
        return nameOfEmployee;
    }

    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee.set(nameOfEmployee);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public int getCost() {
        return cost.get();
    }

    public IntegerProperty costProperty() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }

    public int getCostOfCarriage() {
        return costOfCarriage.get();
    }

    public IntegerProperty costOfCarriageProperty() {
        return costOfCarriage;
    }

    public void setCostOfCarriage(int costOfCarriage) {
        this.costOfCarriage.set(costOfCarriage);
    }

    public String getNameOfJob() {
        return nameOfJob.get();
    }

    public StringProperty nameOfJobProperty() {
        return nameOfJob;
    }

    public void setNameOfJob(String nameOfJob) {
        this.nameOfJob.set(nameOfJob);
    }

    public String getPayment() {
        return payment.get();
    }

    public StringProperty paymentProperty() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment.set(payment);
    }

    public boolean isNoOrYesPayment() {
        return noOrYesPayment.get();
    }

    public BooleanProperty noOrYesPaymentProperty() {
        return noOrYesPayment;
    }

    public void setNoOrYesPayment(boolean noOrYesPayment) {
        this.noOrYesPayment.set(noOrYesPayment);
    }

    public Job() {
        this(new SimpleStringProperty("Назва техніки"), new SimpleStringProperty("Ім'я працівника"),
                new SimpleStringProperty("Час"), new SimpleIntegerProperty(0), new SimpleIntegerProperty(0),
                new SimpleStringProperty("Назва роботи"), new SimpleStringProperty("Оплата"), new SimpleBooleanProperty(false));
    }

    public Job(String nameOfMachin, String nameOfEmployee, String time, int cost,
               int costOfCarriage, String nameOfJob, String payment, boolean noOrYesPayment) {
        this.nameOfMachin = new SimpleStringProperty(nameOfMachin);
        this.nameOfEmployee = new SimpleStringProperty(nameOfEmployee);
        this.time = new SimpleStringProperty(time);
        this.cost = new SimpleIntegerProperty(cost);
        this.costOfCarriage = new SimpleIntegerProperty(costOfCarriage);
        this.nameOfJob = new SimpleStringProperty(nameOfJob);
        this.payment = new SimpleStringProperty(payment);
        this.noOrYesPayment = new SimpleBooleanProperty(noOrYesPayment);
    }

    public Job(SimpleStringProperty nameOfMachin, SimpleStringProperty nameOfEmployee, SimpleStringProperty time,
               SimpleIntegerProperty cost, SimpleIntegerProperty costOfCarriage, SimpleStringProperty nameOfJob,
               SimpleStringProperty payment, SimpleBooleanProperty noOrYesPayment) {
        this.nameOfMachin = nameOfMachin;
        this.nameOfEmployee = nameOfEmployee;
        this.time = time;

        this.cost = cost;
        this.costOfCarriage = costOfCarriage;
        this.nameOfJob = nameOfJob;
        this.payment = payment;
        this.noOrYesPayment = noOrYesPayment;
    }

    @Override
    public String toString() {
        return "Job{" +
                "nameOfMachin=" + nameOfMachin +
                ", nameOfEmployee=" + nameOfEmployee +
                ", time=" + time +
                ", cost=" + cost +
                ", costOfCarriage=" + costOfCarriage +
                ", nameOfJob=" + nameOfJob +
                ", payment=" + payment +
                ", noOrYesPayment=" + noOrYesPayment +
                '}';
    }
}