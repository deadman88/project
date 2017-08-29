package ua.diamant.entity.cost;

import java.util.Scanner;

/**
 * Created by Макс on 20.08.2017.
 */
public class Cost {
        double costOfRepair;
        double costOfBurnedFuel;
        double tax;
        Scanner inReader = new Scanner(System.in);
        int salary;

    public double getCostOfRepair() {
        return costOfRepair;
    }

    public void setCostOfRepair(double costOfRepair) {
        this.costOfRepair = costOfRepair;
    }

    public double getCostOfBurnedFuel() {
        return costOfBurnedFuel;
    }

    public void setCostOfBurnedFuel(double costOfBurnedFuel) {
        this.costOfBurnedFuel = costOfBurnedFuel;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary() {
        this.salary = inReader.nextInt();;
    }


}
