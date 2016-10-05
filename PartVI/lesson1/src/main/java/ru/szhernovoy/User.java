package ru.szhernovoy;


/**
 * Created by szhernovoy on 03.10.2016.
 */
public class User {
   private String name;
   private Integer age;
    private int pol;


    public User(String name, int age, int pol) {
        this.name = name;
        this.age = age;
        this.pol = pol;
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("User %s is finalize",this));

    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age;
    }

    public static void info(){
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [MB] #####");
        System.out.println("Used memory: "+ (runtime.totalMemory() - runtime.freeMemory())/mb + "Mb");
        System.out.println("Free memory: "+ (runtime.freeMemory())/mb + "Mb");
        System.out.println("Total memory: "+ (runtime.totalMemory() )/mb + "Mb");
        System.out.println("Max memory: "+ (runtime.maxMemory() )/mb + "Mb");
    }

    public static void main(String[] args) {
        //for (int index = 0; index < 10000; index++){
           // System.out.println(new User(String.valueOf(index),index,index));
        //}
        new User("test",20,1);
        User.info();

    }

}
