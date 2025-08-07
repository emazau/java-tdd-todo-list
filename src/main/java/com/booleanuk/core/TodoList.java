package com.booleanuk.core;

import java.util.Collections;
import java.util.List;

public class TodoList { //should I use public variables or private?
    public List<Task> tasks = Collections.singletonList(new Task());


    public boolean addtask(Task addedtask){
        if (addedtask == null){
            return false;
        }

       // this.tasks.set(0, new Task());
        return true;

    }
    public boolean show(){
        return true;
    }
    public boolean changeStatus(Task addedtask){
        return true;
    }
    public boolean completed(){
        return true;
    }
    public boolean notCompleted(){
        return true;
    }
    public boolean search(String  query){
        return true;
    }
    public boolean remove(String title){
        return true;
    }
    public boolean ascending(){
        return true;
    }
    public boolean descending(){
        return true;
    }

}
