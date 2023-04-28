package edu.guilford;

import java.util.Random;

public class Computer {
    //attributes
    private String cPUString;
    private boolean isIntel;
    private int coreCount;
    private double coreClock;
    private int ram;
    private int ramSpeed;
    private boolean hasSSD;
    private int sSDSize;
    private double availableStorage;
    private String gPUString;
    private String operatingSystem;

    private Random rand = new Random();

    //constructor
    public Computer() {
        //set the CPU string
        this.isIntel = rand.nextBoolean();
        if(isIntel){ 
            this.cPUString = "Intel Core i" + (rand.nextInt(4)*2 + 3) + "-" + (rand.nextInt(13) + 1) + "000";
        } else {
            //generates a random amd cpu
            this.cPUString = "AMD Ryzen " + (rand.nextInt(4)*2 + 3) + " " + (rand.nextInt(3)*2 + 3) + "" + (rand.nextInt(5)+5)+"00";
        }
        //set the core count
        this.coreCount = rand.nextInt(8) + 1;
        //set the core clock
        //this.coreClock = rand.nextDouble()*4.9 + .1;
        this.coreClock = (rand.nextInt(50) + 1)/10.0;
        
        //set the ram
        this.ram = (rand.nextInt(4) + 1) * 4;
        //set the ram speed
        this.ramSpeed = (rand.nextInt(10) + 1) * 100;
        //set the hasSSD
        this.hasSSD = rand.nextBoolean();
        //set the SSD size
        this.sSDSize = (int)(Math.pow(2, rand.nextInt(4) + 8));
        //set the available storage
        this.availableStorage = rand.nextDouble()*this.sSDSize;
        //set the GPU string
        this.gPUString = "Nvidia GeForce " + (rand.nextInt(4) + 1) + "0" + (rand.nextInt(4) + 6)*10;
        //list of operating systems
        String[] operatingSystems = {"Windows 10", "Windows 8.1", "Windows 7", "Windows Vista", "Linux", "Unix", "Ubuntu", "Debian", "Chrome OS"};
        //pick a andom operating system from the list
        this.operatingSystem = operatingSystems[rand.nextInt(operatingSystems.length)];
    }

    //getters and setters
    public String getCPUString() {
        return cPUString;
    }

    public void setCPUString(String cPUString) {
        this.cPUString = cPUString;
    }

    public boolean isIntel() {
        return isIntel;
    }

    public void setIntel(boolean isIntel) {
        this.isIntel = isIntel;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public double getCoreClock() {
        return coreClock;
    }

    public void setCoreClock(double coreClock) {
        this.coreClock = coreClock;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRamSpeed() {
        return ramSpeed;
    }

    public void setRamSpeed(int ramSpeed) {
        this.ramSpeed = ramSpeed;
    }

    public boolean isHasSSD() {
        return hasSSD;
    }

    public void setHasSSD(boolean hasSSD) {
        this.hasSSD = hasSSD;
    }

    public int getSSDSize() {
        return sSDSize;
    }

    public void setSSDSize(int sSDSize) {
        this.sSDSize = sSDSize;
    }

    public double getAvailableStorage() {
        return availableStorage;
    }

    public void setAvailableStorage(double availableStorage) {
        this.availableStorage = availableStorage;
    }

    public String getGPUString() {
        return gPUString;
    }

    public void setGPUString(String gPUString) {
        this.gPUString = gPUString;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //toString
    @Override
    public String toString() {
        /*return "Computer [availableStorage=" + availableStorage + ", cPUString=" + cPUString + ", coreClock=" + coreClock
                + ", coreCount=" + coreCount + ", gPUString=" + gPUString + ", hasSSD=" + hasSSD + ", isIntel=" + isIntel
                + ", operatingSystem=" + operatingSystem + ", ram=" + ram + ", ramSpeed=" + ramSpeed + ", sSDSize="
                + sSDSize + "]";*/
        return "Computer Core Clock: " + String.format( "%.1f", this.coreClock) + " GHz";
    }


}
