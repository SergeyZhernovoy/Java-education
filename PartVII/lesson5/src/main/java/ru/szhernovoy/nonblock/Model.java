package ru.szhernovoy.nonblock;

/**
 * Created by szhernovoy on 27.10.2016.
 */
public class Model {
    private volatile String name;
    private int version;

    public Model(String name) {
        this.name = name;
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

        return name != null ? name.equals(model.name) : model.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
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
