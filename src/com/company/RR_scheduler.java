package com.company;

import java.util.ArrayList;

public class RR_scheduler {

    ArrayList<Task> userTasks = new ArrayList<>();

    private int lastTask = 0;
    public int timeslot = 2;


    public Task nextRRTask(){

        Task returnTask =  userTasks.get(lastTask);

        returnTask.getCpuTime(1);

        timeslot--;

        return returnTask;
    }

    public boolean hasTask(){
        return !userTasks.isEmpty();
    }

    public void doneTasks(){
        int delet=-1;
        for (int i = 0; i < userTasks.size(); i++){
            if(userTasks.get(i).getRemainTime() == 0){
                delet = i;
            }
        }
        if(delet != -1) {
            userTasks.remove(delet);
//            Logger.log("Item fdeleted");
            timeslot = 0;
        }

        if(timeslot == 0) {
            timeslot = 2;
            lastTaskShift();
        }
    }

    public void lastTaskShift() {
        int count = userTasks.size();
//        Logger.log("lastTask:" + lastTask + " count:" + count + "----->");

        if (count > lastTask + 1) {
            lastTask++;
        } else {
            lastTask = 0;
        }
//        Logger.log("newLastTask:" + lastTask);
    }
}
