package ru.szhernovoy.jpa.carstore.domain;


import javax.persistence.*;

/**
 * Created by admin on 09.01.2017.
 */
@Entity
@Table(name = "car")
public class Car {
    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_body")
    private Body body;
    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_drivetype")
    private DriveType driveType;
    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_engine")
    private Engine engine;
    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_model")
    private Model model;
    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_transmission")
    private Transmission transmission;
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
    public Car() {
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

    /**
     * Created by admin on 10.01.2017.
     * @return Body
     */
    public Body getBody() {
        return body;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param body .
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return DriveType
     */
    public DriveType getDriveType() {
        return driveType;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param driveType .
     */
    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return Engine.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param engine .
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return Model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param model .
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return Transmission .
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param transmission .
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }



}
