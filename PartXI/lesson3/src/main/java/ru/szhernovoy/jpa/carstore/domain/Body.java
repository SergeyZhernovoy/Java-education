package ru.szhernovoy.jpa.carstore.domain;


import javax.persistence.*;

/**
 * Created by admin on 05.01.2017.
 */
@Entity
@Table(name = "body")
public class Body {

    /**
     * Created by admin on 10.01.2017.
     */
    private String name;
    /**
     * Created by admin on 10.01.2017.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Created by admin on 10.01.2017.
     */
    public Body() {
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

    /**
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param id .
     */
    public void setId(int id) {
        this.id = id;
    }
}
