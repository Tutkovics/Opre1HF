package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {

    public static void main(String[] args) {
            ArrayList<Task> commigTasks = new ArrayList<>();
            ArrayList<Task> withWaitTime = new ArrayList<>();
            String lastTask = "";

            // read the tasks

            Scanner sc = new Scanner(System.in).useDelimiter("[,\\s]");
            while (sc.hasNext()) {
                commigTasks.add(new Task(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }

            sc.close();

            SRTF_scheduler SRTF = new SRTF_scheduler();
            RR_scheduler RR = new RR_scheduler();

            int period = 0;
            while (true) {
//                Logger.log(""+ period);
                RR.doneTasks();
                SRTF.doneTasks();
                //add the arrived tasks to the array
                for (Task examineTask : commigTasks) {
                    if (examineTask.startTime == period) {
                        if (examineTask.priority == 0) {
                            SRTF.kernerTasks.add(examineTask);
                            withWaitTime.add(examineTask);
                        } else {
                            RR.userTasks.add(examineTask);
                            withWaitTime.add(examineTask);
                        }
                    }
                }

                // code
                Task runed;
                if (SRTF.hasTask()) {
                    runed = SRTF.nextSRTFTask();
                    if (RR.timeslot == 1) {
                        RR.lastTaskShift();
                    }
                    RR.timeslot = 2;
                } else if (RR.hasTask()) {
                    runed = RR.nextRRTask();
                } else {
                    break;
                }





                if (lastTask.equals(runed.name)) {
                    lastTask = runed.name;
                } else {
                    lastTask = runed.name;
                    System.out.print(runed.name);
                }

                for (Task task : RR.userTasks
                        ) {
                    if (task != runed) {
                        task.waitCpuTime(1);
                    }
                }
                for (Task task : SRTF.kernerTasks
                        ) {
                    if (task != runed) {
                        task.waitCpuTime(1);
                    }
                }



                period++;
            }


            // final sum
            System.out.print("\n");

            for (int i = 0; i < withWaitTime.size(); i++) {
                System.out.print(withWaitTime.get(i).name + ":" + withWaitTime.get(i).waitTime);
                if (i < withWaitTime.size() - 1) {
                    System.out.print(",");
                }
            }
    }
}


