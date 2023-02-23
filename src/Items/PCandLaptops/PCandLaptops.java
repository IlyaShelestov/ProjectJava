package Items.PCandLaptops;


import Items.Device;

public abstract class PCandLaptops extends Device {
    private int RAM;
    private int memory;
    private String CPU;
    private String GPU;

    public PCandLaptops(String model, double price, String brand) {
        super(model, price, brand);
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
}





