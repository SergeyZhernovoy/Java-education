package ru.szhernovoy.security.carstore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * type engine : privod ; backoff front full
 * Created by admin on 05.01.2017.
 */
@Entity(name = "drivetype")
public class DriveType {
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
    public DriveType() {
    }

    /**
     * Created by admin on 10.01.2017.
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

        DriveType driveType = (DriveType) o;

        if (id != driveType.id) return false;
        return name != null ? name.equals(driveType.name) : driveType.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
