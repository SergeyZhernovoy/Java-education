package ru.szhernovoy.security.carstore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by admin on 05.01.2017.
 */
@Entity(name = "model")
public class Model {
    /**
     * Created by admin on 10.01.2017.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Created by admin on 10.01.2017.
     */
    private String name;

    /**
     * Created by admin on 10.01.2017.
     */
    public Model() {
    }

    /**
     * Created by admin on 10.01.2017.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id .
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
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
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
