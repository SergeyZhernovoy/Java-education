package ru.szhernovoy.extended;

import ru.szhernovoy.storage.Storage;

import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Created by admin on 10.08.2016.
 */
public abstract class StorageExtended extends Storage {

    /**array reproduct food */
    protected FoodReproduct[] foodReproducts;
    /**value save temperature */
    protected int temperature = 0;
    /**currant position in arrray reproduct */
    protected int positionReproduct =0;
    /**value for test */
    protected  GregorianCalendar calendar;

     /**
     * Constructor.
     *
     * @param name
     * @param size
     */
    public StorageExtended(String name, int size, int temperature, GregorianCalendar today) {
        super(name, size, today);
        this.foodReproducts = new FoodReproduct[size];
        this.temperature = temperature;
        this.calendar = today;
    }


    /**
     * Add reproduct food in storage.
     * @param foodReproduct
     */
    public void addFood(FoodReproduct foodReproduct){
        this.foodReproducts[positionReproduct++] = foodReproduct;
    }

    /**
     * Abstract method identify check range
     * @param food
     * @return
     */
    public abstract boolean matchRange(FoodReproduct food);

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("In %s \'%s\' have next products:\n",this.getClass().getCanonicalName(),this.name));
        for (int index = 0 ; index < food.length; index++){
            if(food[index]!=null){
                info.append(String.format("\n -- %s - %s",food[index].getClass(),food[index].getName()));
            }
        }

        for (int index = 0 ; index < foodReproducts.length; index++){
            if(foodReproducts[index]!=null){
                info.append(String.format("\n -- %s - %s",foodReproducts[index].getClass(),foodReproducts[index].getName()));
            }
        }

        return info.toString();
    }
}
