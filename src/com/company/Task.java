package com.company;

public class Task implements Comparable<Task> {
    public int priority;
    public int startTime;
    private int CPUTime;
    public String name;

    private int remainTime;
    public int waitTime = 0;


    public Task(String name, int priority, int startTime, int cpuTime) {
        this.priority = priority;
        this.startTime = startTime;
        this.CPUTime = cpuTime;
        this.name = name;
        this.remainTime = cpuTime;
    }

    public void getCpuTime(int time){
        remainTime -= time;
    }

    public void waitCpuTime(int time){
        waitTime += time;
    }

    public int getRemainTime(){
        return this.remainTime;
    }

    @Override
    public int compareTo(Task task) {
        return this.remainTime - task.remainTime;
    }
}
