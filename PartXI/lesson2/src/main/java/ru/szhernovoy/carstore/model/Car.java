package ru.szhernovoy.carstore.model;


/**
 * Created by admin on 09.01.2017.
 */
public class Car {
    /**
     * Created by admin on 10.01.2017.
     */
    private Body body;
    /**
     * Created by admin on 10.01.2017.
     */
    private DriveType driveType;
    /**
     * Created by admin on 10.01.2017.
     */
    private Engine engine;
    /**
     * Created by admin on 10.01.2017.
     */
    private Model model;
    /**
     * Created by admin on 10.01.2017.
     */
    private Transmission transmission;
    /**
     * Created by admin on 10.01.2017.
     */
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
     * default contructor with parametres
     */
    public Car(String name, int model,int body,int drive,int transm, int engine){
        this.name = name;

        this.body = new Body();
        this.driveType = new DriveType();
        this.engine = new Engine();
        this.model = new Model();
        this.transmission = new Transmission();

        this.driveType.setId(drive);
        this.body.setId(body);
        this.model.setId(model);
        this.transmission.setId(transm);
        this.engine.setId(engine);

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
