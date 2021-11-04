package pl.mzelechowski;

import java.util.StringJoiner;

public class Computer {
    private String mainBoard;
    private String cpu;
    private String gpu;
    private String hardDisk;
    private String cost;

    public Computer() {

    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Computer(String mainBoard, String cpu, String gpu, String hardDisk, String cost) {
        this.mainBoard = mainBoard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.hardDisk = hardDisk;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add("mainBoard: " + mainBoard)
                .add("cpu: " + cpu)
                .add("gpu: " + gpu)
                .add("hardDisk: " + hardDisk)
                .add("cost: " + cost)
                .toString();
    }
}
