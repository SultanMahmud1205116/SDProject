package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class TaxCalculator {
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
    double forthSlotMultiplier;
    double fifthSlotMultiplier;
    int taxLowestHighestValue;
    int taxLowestSecondHighestValue;
    int taxLowestLowestValue;
    int age;
    String gender;
    String city;
    String retirementStatus;
    String freedomFighterStatus;

    String year;
    String taxLowestHighestPlaceString;
    String taxLowestSecondHighestPlaceString;

    double calculationFirstSlot;


    double totalIncome;
    double exemptedExpenditure;

    public TaxCalculator(double firstSlotIfFreedomFighter, double firstSlotIfRetired, double firstSlotIfFemale, double regularFirstSlot, double secondSlot, double thirdSlot, double fourthSlot, double fifthSlot, double firstSlotMultiplier, double secondSlotMultiplier, double thirdSlotMultiplier, double forthSlotMultiplier, double fifthSlotMultiplier, int taxLowestHighestValue, int taxLowestSecondHighestValue, int taxLowestLowestValue, int age, String gender, String city, String retirementStatus, String freedomFighterStatus, String year, String taxLowestHighestPlaceString, String taxLowestSecondHighestPlaceString,  double totalIncome, double exemptedExpenditure) {
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
        this.forthSlotMultiplier = forthSlotMultiplier;
        this.fifthSlotMultiplier = fifthSlotMultiplier;
        this.taxLowestHighestValue = taxLowestHighestValue;
        this.taxLowestSecondHighestValue = taxLowestSecondHighestValue;
        this.taxLowestLowestValue = taxLowestLowestValue;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.retirementStatus = retirementStatus;
        this.freedomFighterStatus = freedomFighterStatus;
        this.year = year;
        this.taxLowestHighestPlaceString = taxLowestHighestPlaceString;
        this.taxLowestSecondHighestPlaceString = taxLowestSecondHighestPlaceString;
        //this.calculationFirstSlot = calculationFirstSlot;
        this.totalIncome = totalIncome;
        this.exemptedExpenditure = exemptedExpenditure;
    }

    public double getFirstSlotIfFreedomFighter() {
        return firstSlotIfFreedomFighter;
    }

    public void setFirstSlotIfFreedomFighter(double firstSlotIfFreedomFighter) {
        this.firstSlotIfFreedomFighter = firstSlotIfFreedomFighter;
    }

    public double getFirstSlotIfRetired() {
        return firstSlotIfRetired;
    }

    public void setFirstSlotIfRetired(double firstSlotIfRetired) {
        this.firstSlotIfRetired = firstSlotIfRetired;
    }

    public double getFirstSlotIfFemale() {
        return firstSlotIfFemale;
    }

    public void setFirstSlotIfFemale(double firstSlotIfFemale) {
        this.firstSlotIfFemale = firstSlotIfFemale;
    }

    public double getRegularFirstSlot() {
        return regularFirstSlot;
    }

    public void setRegularFirstSlot(double regularFirstSlot) {
        this.regularFirstSlot = regularFirstSlot;
    }

    public double getSecondSlot() {
        return secondSlot;
    }

    public void setSecondSlot(double secondSlot) {
        this.secondSlot = secondSlot;
    }

    public double getThirdSlot() {
        return thirdSlot;
    }

    public void setThirdSlot(double thirdSlot) {
        this.thirdSlot = thirdSlot;
    }

    public double getFourthSlot() {
        return fourthSlot;
    }

    public void setFourthSlot(double fourthSlot) {
        this.fourthSlot = fourthSlot;
    }

    public double getFifthSlot() {
        return fifthSlot;
    }

    public void setFifthSlot(double fifthSlot) {
        this.fifthSlot = fifthSlot;
    }

    public double getFirstSlotMultiplier() {
        return firstSlotMultiplier;
    }

    public void setFirstSlotMultiplier(double firstSlotMultiplier) {
        this.firstSlotMultiplier = firstSlotMultiplier;
    }

    public double getSecondSlotMultiplier() {
        return secondSlotMultiplier;
    }

    public void setSecondSlotMultiplier(double secondSlotMultiplier) {
        this.secondSlotMultiplier = secondSlotMultiplier;
    }

    public double getThirdSlotMultiplier() {
        return thirdSlotMultiplier;
    }

    public void setThirdSlotMultiplier(double thirdSlotMultiplier) {
        this.thirdSlotMultiplier = thirdSlotMultiplier;
    }

    public double getForthSlotMultiplier() {
        return forthSlotMultiplier;
    }

    public void setForthSlotMultiplier(double forthSlotMultiplier) {
        this.forthSlotMultiplier = forthSlotMultiplier;
    }

    public double getFifthSlotMultiplier() {
        return fifthSlotMultiplier;
    }

    public void setFifthSlotMultiplier(double fifthSlotMultiplier) {
        this.fifthSlotMultiplier = fifthSlotMultiplier;
    }

    public int getTaxLowestHighestValue() {
        return taxLowestHighestValue;
    }

    public void setTaxLowestHighestValue(int taxLowestHighestValue) {
        this.taxLowestHighestValue = taxLowestHighestValue;
    }

    public int getTaxLowestSecondHighestValue() {
        return taxLowestSecondHighestValue;
    }

    public void setTaxLowestSecondHighestValue(int taxLowestSecondHighestValue) {
        this.taxLowestSecondHighestValue = taxLowestSecondHighestValue;
    }

    public int getTaxLowestLowestValue() {
        return taxLowestLowestValue;
    }

    public void setTaxLowestLowestValue(int taxLowestLowestValue) {
        this.taxLowestLowestValue = taxLowestLowestValue;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRetirementStatus() {
        return retirementStatus;
    }

    public void setRetirementStatus(String retirementStatus) {
        this.retirementStatus = retirementStatus;
    }

    public String getFreedomFighterStatus() {
        return freedomFighterStatus;
    }

    public void setFreedomFighterStatus(String freedomFighterStatus) {
        this.freedomFighterStatus = freedomFighterStatus;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTaxLowestHighestPlaceString() {
        return taxLowestHighestPlaceString;
    }

    public void setTaxLowestHighestPlaceString(String taxLowestHighestPlaceString) {
        this.taxLowestHighestPlaceString = taxLowestHighestPlaceString;
    }

    public String getTaxLowestSecondHighestPlaceString() {
        return taxLowestSecondHighestPlaceString;
    }

    public void setTaxLowestSecondHighestPlaceString(String taxLowestSecondHighestPlaceString) {
        this.taxLowestSecondHighestPlaceString = taxLowestSecondHighestPlaceString;
    }

    public double getCalculationFirstSlot() {
        return calculationFirstSlot;
    }

    public void setCalculationFirstSlot(double calculationFirstSlot) {
        this.calculationFirstSlot = calculationFirstSlot;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getExemptedExpenditure() {
        return exemptedExpenditure;
    }

    public void setExemptedExpenditure(double exemptedExpenditure) {
        this.exemptedExpenditure = exemptedExpenditure;
    }

    public double getCalculatedTax(){

        double  finalTax=0;

        if ((freedomFighterStatus.toUpperCase()).equals("YES")){
            calculationFirstSlot=firstSlotIfFreedomFighter;
        }
        else if((retirementStatus.toUpperCase()).equals("YES")){
            calculationFirstSlot=firstSlotIfRetired;
        }
        else if ((age>=65)||(gender.toUpperCase()).equals("FEMALE")){
            calculationFirstSlot=firstSlotIfFemale;
        }
        else{
            calculationFirstSlot=regularFirstSlot;
        }

        if ((totalIncome>=calculationFirstSlot)){
            //double calculationsecondSlot=secondSlot;
            //double calculationthirdSlot=thirdSlot;
            //double calculationfourthSlot=fourthSlot;
            //double calculationfifthSlot=fifthSlot;
            //System.out.println(firstSlot);

            if (totalIncome<=(calculationFirstSlot+secondSlot)){
                finalTax=(totalIncome-calculationFirstSlot)*(firstSlotMultiplier);
                System.out.println("one");
                System.out.println("%% "+finalTax);
            }
            else if(totalIncome<=(calculationFirstSlot+secondSlot+thirdSlot)){
                finalTax=(secondSlot*(firstSlotMultiplier))+((totalIncome-(calculationFirstSlot+secondSlot))*(secondSlotMultiplier));
                System.out.println("two");
            }
            else if (totalIncome<=(calculationFirstSlot+secondSlot+thirdSlot+fourthSlot)){

                finalTax=(secondSlot*(firstSlotMultiplier))+(thirdSlot*(secondSlotMultiplier))+((totalIncome-(calculationFirstSlot+secondSlot+thirdSlot))*(thirdSlotMultiplier));
                System.out.println("three");
                System.out.println((secondSlot)+"   "+(thirdSlot)+"   "+((totalIncome-(calculationFirstSlot+secondSlot+thirdSlot))));
            }
            else if (totalIncome<=(calculationFirstSlot+secondSlot+thirdSlot+fourthSlot+fifthSlot)){
                finalTax=(secondSlot*(firstSlotMultiplier))+(thirdSlot*(secondSlotMultiplier))+(fourthSlot*(thirdSlotMultiplier))+((totalIncome-(calculationFirstSlot+secondSlot+thirdSlot+fourthSlot))*(forthSlotMultiplier));
                System.out.println("four");
            }
            else {
                finalTax=(secondSlot*(firstSlotMultiplier))+(thirdSlot*(secondSlotMultiplier))+(fourthSlot*(thirdSlotMultiplier))+(fifthSlot*(forthSlotMultiplier))+((totalIncome-(calculationFirstSlot+secondSlot+thirdSlot+fourthSlot+fifthSlot))*(fifthSlot));
                System.out.println("five");


            }

            finalTax-=exemptedExpenditure;
            System.out.println(" && "+finalTax);


        }
        if ((totalIncome<calculationFirstSlot)||(finalTax <3000)){
            if((city.toUpperCase()).equals("DHAKA")||(city.toUpperCase()).equals("CHITTAGONG")){
                finalTax=5000;
            }
            else if ((city.toUpperCase()).equals("BARISAL")||(city.toUpperCase()).equals("KHULNA")||(city.toUpperCase()).equals("RAJSHAHI")||(city.toUpperCase()).equals("RANGPUR")||(city.toUpperCase()).equals("SYLHET")){
                finalTax=4000;
            }
            else{
                finalTax=3000;
            }

        }




        return finalTax;



    }
}
