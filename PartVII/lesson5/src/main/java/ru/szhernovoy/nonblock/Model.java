package ru.szhernovoy.nonblock;

/**
 * Created by szhernovoy on 27.10.2016.
 */
public class Model {
    private  String name;
    private volatile int version = 0;
    private int id;

    public int getId() {
        return id;
    }



    public Model(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void increment(){
        this.version++;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        return name != null ? name.equals(model.name) : model.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
