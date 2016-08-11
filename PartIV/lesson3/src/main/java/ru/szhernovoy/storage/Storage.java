package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 *
 * Created by admin on 08.08.2016.
 */
public abstract class Storage {

    /**value save name storage */
    protected String name;
    /**value is array food in storage */
    protected Food[] food;
    /**currant position in array food */
    protected int position =0;

    protected GregorianCalendar today;

    /**
     * Constructor.
     * @param name
     * @param size
     */
    public Storage(String name, int size,GregorianCalendar today) {
        this.name = name;
        this.food = new Food[size];
        this.today = today;
    }

    /**
     * Add food in storage
     * @param food
     * @throws ArrayIndexOutOfBoundsException
     */
    public void addFood(Food food) {
        this.food[position++] = food;
    }

    /**
     * Abstract method identify check range
     * @param food
     * @return
     */
    public abstract boolean matchRange(Food food);

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
        return info.toString();
    }

    public boolean checkFullingStorage(){
        boolean result = false;
        if(this.position >= this.food.length){
            result = true;
        }
        return result;
    }

}
