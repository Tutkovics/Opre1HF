package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class SRTF_scheduler{

    ArrayList<Task> kernerTasks = new ArrayList<>();

    public Task nextSRTFTask(){
        Collections.sort(kernerTasks);

        Task t = kernerTasks.get(0);
        t.getCpuTime(1);

        return t;
    }

    public boolean hasTask(){
        return !kernerTasks.isEmpty();
    }

    public void doneTasks(){
        for (int i = 0; i < kernerTasks.size(); i++){
            if(kernerTasks.get(i).getRemainTime() == 0){
                kernerTasks.remove(i);
            }
        }
    }

}
