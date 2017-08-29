package sample.repairScene.dialogRepairWindow;

/**
 * Created by Макс on 29.08.2017.
 */
public class Repair {
    private String nameOfRepair;
    private int costOfRepair;
    private String timeOfRepair;

    public Repair() {
        this.nameOfRepair = nameOfRepair;
        this.costOfRepair = costOfRepair;
        this.timeOfRepair = timeOfRepair;
    }

    public String getNameOfRepair() {

        return nameOfRepair;
    }

    public void setNameOfRepair(String nameOfRepair) {
        this.nameOfRepair = nameOfRepair;
    }

    public int getCostOfRepair() {
        return costOfRepair;
    }

    public void setCostOfRepair(int costOfRepair) {
        this.costOfRepair = costOfRepair;
    }

    public String getTimeOfRepair() {
        return timeOfRepair;
    }

    public void setTimeOfRepair(String timeOfRepair) {
        this.timeOfRepair = timeOfRepair;
    }
}
