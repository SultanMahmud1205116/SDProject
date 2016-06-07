package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 6/6/16.
 */
public class TaxCalculationParameter implements  java.io.Serializable  {
    /*
    * CREATE TABLE `tax_calculation_parameters` (
	`first_slot_if_freedom_fighter`	REAL NOT NULL,
	`first_slot_if_retired`	REAL NOT NULL,
	`first_slot_if_female`	REAL NOT NULL,
	`regular_first_slot`	REAL NOT NULL,
	`second_slot`	REAL NOT NULL,
	`third_slot`	REAL NOT NULL,
	`fourth_slot`	REAL NOT NULL,
	`fifth_slot`	REAL NOT NULL,
	`first_slot_multiplier`	REAL NOT NULL,
	`second_slot_multiplier`	REAL NOT NULL,
	`third_slot_multiplier`	REAL NOT NULL,
	`fourth_slot_multiplier`	REAL NOT NULL,
	`fifth_slot_multiplier`	REAL NOT NULL,
	`tax_lowest_highest_value`	REAL NOT NULL,
	`tax_lowest_second_highest_value`	REAL NOT NULL,
	`tax_lowest_lowest_value`	REAL NOT NULL,
	`year`	TEXT NOT NULL,
	`tax_lowest_highest_place`	TEXT NOT NULL,
	`tax_lowest_second_highest_place`	TEXT NOT NULL
)*/
    double firstSlotIfFreedomFighter;
    double firstSlotIfRetired;
    double firstSlotIfFemale;
    double regularFirstSlot;
    double secondSlot;
    double thirdSlot;
    double fourthSlot;
    double fifthSlot;
    double firstSlotMultiplier;
    double secondSlotMultiplier;
    double thirdSlotMultiplier;
    double fourthSlotMultiplier;
    double fifthSlotMultiplier;
    double taxLowestHighestValue;
    double taxLowestSecondHighestValue;
    double taxLowestLowestValue;
    int year;
    String taxLowestHighestPlace;
    String taxLowestSecondHighestPlace;

    public TaxCalculationParameter(double firstSlotIfFreedomFighter, double firstSlotIfRetired, double firstSlotIfFemale, double regularFirstSlot, double secondSlot, double thirdSlot, double fourthSlot, double fifthSlot, double firstSlotMultiplier, double secondSlotMultiplier, double thirdSlotMultiplier, double fourthSlotMultiplier, double fifthSlotMultiplier, double taxLowestHighestValue, double taxLowestSecondHighestValue, double taxLowestLowestValue, int year, String taxLowestHighestPlace, String taxLowestSecondHighestPlace) {
        this.firstSlotIfFreedomFighter = firstSlotIfFreedomFighter;
        this.firstSlotIfRetired = firstSlotIfRetired;
        this.firstSlotIfFemale = firstSlotIfFemale;
        this.regularFirstSlot = regularFirstSlot;
        this.secondSlot = secondSlot;
        this.thirdSlot = thirdSlot;
        this.fourthSlot = fourthSlot;
        this.fifthSlot = fifthSlot;
        this.firstSlotMultiplier = firstSlotMultiplier;
        this.secondSlotMultiplier = secondSlotMultiplier;
        this.thirdSlotMultiplier = thirdSlotMultiplier;
        this.fourthSlotMultiplier = fourthSlotMultiplier;
        this.fifthSlotMultiplier = fifthSlotMultiplier;
        this.taxLowestHighestValue = taxLowestHighestValue;
        this.taxLowestSecondHighestValue = taxLowestSecondHighestValue;
        this.taxLowestLowestValue = taxLowestLowestValue;
        this.year = year;
        this.taxLowestHighestPlace = taxLowestHighestPlace;
        this.taxLowestSecondHighestPlace = taxLowestSecondHighestPlace;
    }

    @Override
    public String toString() {
        return "TaxCalculationParameter{" +
                "firstSlotIfFreedomFighter=" + firstSlotIfFreedomFighter +
                ", firstSlotIfRetired=" + firstSlotIfRetired +
                ", firstSlotIfFemale=" + firstSlotIfFemale +
                ", regularFirstSlot=" + regularFirstSlot +
                ", secondSlot=" + secondSlot +
                ", thirdSlot=" + thirdSlot +
                ", fourthSlot=" + fourthSlot +
                ", fifthSlot=" + fifthSlot +
                ", firstSlotMultiplier=" + firstSlotMultiplier +
                ", secondSlotMultiplier=" + secondSlotMultiplier +
                ", thirdSlotMultiplier=" + thirdSlotMultiplier +
                ", fourthSlotMultiplier=" + fourthSlotMultiplier +
                ", fifthSlotMultiplier=" + fifthSlotMultiplier +
                ", taxLowestHighestValue=" + taxLowestHighestValue +
                ", taxLowestSecondHighestValue=" + taxLowestSecondHighestValue +
                ", taxLowestLowestValue=" + taxLowestLowestValue +
                ", year=" + year +
                ", taxLowestHighestPlace='" + taxLowestHighestPlace + '\'' +
                ", taxLowestSecondHighestPlace='" + taxLowestSecondHighestPlace + '\'' +
                '}';
    }
}
