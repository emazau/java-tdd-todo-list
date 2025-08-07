package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void addTasksTest() {
        TodoList todo = new TodoList();
        Task newtask = new Task();
        Assertions.assertEquals(true, todo.addtask(newtask));
        //Assertions.assertEquals(false, todo.addtask(newtask));

    }
    @Test
    public void showTasksTest() {
        TodoList todo = new TodoList();
        Task newtask = new Task();
        Task newtask2 = new Task();
        Assertions.assertEquals(false, todo.show());

        todo.addtask(newtask);
        Assertions.assertEquals(todo, todo.show());
        todo.addtask(newtask2);
        Assertions.assertEquals(todo, todo.show());

    }
    @Test
    public void ChangeStatusTest() {

        TodoList todo = new TodoList();
        Task newtask = new Task();
        todo.addtask(newtask);
        newtask.status  = false;

        Assertions.assertEquals("Task turned to completed", todo.changeStatus(newtask));
        Assertions.assertEquals("Task turned to not completed", todo.changeStatus(newtask));

        newtask = null;
        Assertions.assertEquals("task not found", todo.addtask(newtask));

    }
    @Test
    public void showCompletedTest() {
        TodoList todo = new TodoList();
        Task newtask = new Task();
        Task newtask2 = new Task();


        todo.addtask(newtask);

        todo.addtask(newtask2);
        newtask.status  = false;
        Assertions.assertEquals(false, todo.completed());

        newtask.status  = true;

        Assertions.assertEquals(new TodoList().addtask(newtask), todo.completed());




        newtask = null;
        Assertions.assertEquals(false, todo.completed());
    }

    @Test
    public void showNotCompletedTest() {
        TodoList todo = new TodoList();
        Assertions.assertEquals(false, todo.notCompleted());

        Task newtask = new Task();
        Task newtask2 = new Task();


        todo.addtask(newtask);
        newtask.status  = true;
        Assertions.assertEquals(false, todo.notCompleted());
        newtask.status  = false;
        Assertions.assertEquals(todo, todo.notCompleted());
        newtask.status  = true;

        todo.addtask(newtask2);
        newtask2.status  = false;

        Assertions.assertEquals(true, todo.notCompleted());
    }

    @Test
    public void searchTest() {
        TodoList todo = new TodoList();

        Task newtask = new Task();
        Task newtask2 = new Task();
        Assertions.assertEquals(false, todo.search("Buy Gifts"));


        todo.addtask(newtask);
        todo.addtask(newtask2);
        Assertions.assertEquals(false, todo.search("Buy Gifts"));
        Assertions.assertEquals(false, todo.search("D H"));
        Assertions.assertEquals(false, todo.search("Mak food"));
        Assertions.assertEquals(false, todo.search("Do Laundry"));
        Assertions.assertEquals(false, todo.search("Eat cakes"));
        Assertions.assertEquals(false, todo.search("Buy a kebab"));


        Assertions.assertEquals(newtask, todo.search("Do Homework"));
        Assertions.assertEquals(newtask2, todo.search("Make Food"));

    }

    @Test
    public void removeTest() {
        TodoList todo = new TodoList();

        Task newtask = new Task();
        Task newtask2 = new Task();
        Assertions.assertEquals(false, todo.remove("Buy Gifts"));


        todo.addtask(newtask);
        todo.addtask(newtask2);
        Assertions.assertEquals(false, todo.remove("Buy Gifts"));
        Assertions.assertEquals(false, todo.remove("D H"));
        Assertions.assertEquals(false, todo.remove("Mak food"));
        Assertions.assertEquals(false, todo.remove("Do Laundry"));
        Assertions.assertEquals(false, todo.remove("Eat cakes"));
        Assertions.assertEquals(false, todo.remove("Buy a kebab"));


        Assertions.assertEquals(newtask, todo.remove("Do Homework"));

        Assertions.assertEquals(false, todo.remove("Do Homework"));
        Assertions.assertEquals(newtask2, todo.remove("Make Food"));
        Assertions.assertEquals(false, todo.remove("Make Food"));
    }

    @Test
    public void ascendingTest() {

        TodoList todo = new TodoList();
        TodoList todo2 = new TodoList();
        Assertions.assertEquals(false, todo.notCompleted());

        Task newtask = new Task();
        Task newtask2 = new Task();
        Task newtask3 = new Task();
        Task newtask4 = new Task();
        newtask.title = "A";
        newtask2.title = "C";
        newtask4.title = "Z";
        newtask3.title = "B";
        Assertions.assertEquals(false, todo.ascending());




        todo.addtask(newtask2);
        todo.addtask(newtask3);
        todo.addtask(newtask4);
        todo.addtask(newtask);


        todo2.tasks.set(0, newtask);
        todo2.tasks.set(1, newtask3);
        todo2.tasks.set(2, newtask2);
        todo2.tasks.set(3, newtask4);

        //List<> ordered = todo.ascending();

        Assertions.assertEquals(todo2, todo.ascending());



    }
    @Test
    public void descendingTest() {

        TodoList todo = new TodoList();
        TodoList todo2 = new TodoList();
        Assertions.assertEquals(false, todo.notCompleted());

        Task newtask = new Task();
        Task newtask2 = new Task();
        Task newtask3 = new Task();
        Task newtask4 = new Task();
        newtask.title = "A";
        newtask2.title = "C";
        newtask4.title = "Z";
        newtask3.title = "B";
        Assertions.assertEquals(false, todo.ascending());




        todo.addtask(newtask2);
        todo.addtask(newtask3);
        todo.addtask(newtask4);
        todo.addtask(newtask);


        todo2.tasks.set(0, newtask4);
        todo2.tasks.set(1, newtask2);
        todo2.tasks.set(2, newtask3);
        todo2.tasks.set(3, newtask);
        Assertions.assertEquals(todo2, todo.descending());

    }

}
