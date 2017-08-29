package ua.diamant;


import ua.diamant.entity.cost.Cost;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cost cost = new Cost();
        Cost cost2 = new Cost();
        cost.setSalary();
        cost2.setSalary();
        int firstCost = cost.getSalary();
        int secondCost = cost2.getSalary();
        BigDecimal sum, firstVal, secondVal;
        firstVal = new BigDecimal(firstCost);
        secondVal = new BigDecimal(secondCost);
        sum = firstVal.add(secondVal);
        System.out.println(sum);


    }

}
