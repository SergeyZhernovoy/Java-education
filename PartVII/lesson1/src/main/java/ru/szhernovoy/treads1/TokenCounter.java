package ru.szhernovoy.treads1;

import java.util.StringTokenizer;

/**
 * Created by admin on 08.10.2016.
 */
public class TokenCounter implements Runnable{

    /**define type reading StrongTokenizer with delimetr or not delimetr*/
    private final boolean typeToken;
    /**counter word or space */
    private int count =0;
    /**Enter string for parsing */
    private final String in;
    /**delimetr for parsing string */
    private final String DELIMETR = " ";

    /**
     * Getter count words / spaces
     * @return
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Constructor
     * @param typeToken
     * @param builder
     */
    public TokenCounter(final boolean typeToken, final String builder) {
        this.typeToken = typeToken;
        this.in = builder;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        StringTokenizer stringTokenizer = new StringTokenizer(in, this.DELIMETR, typeToken);
        while (stringTokenizer.hasMoreTokens()) {
            if (this.typeToken && stringTokenizer.nextElement().equals(this.DELIMETR)) {
                this.count++;
                System.out.println(String.format("%s = %d", "Space", this.count));
            } else {
                if (!this.typeToken && stringTokenizer.nextElement() != null) {
                    this.count++;
                    System.out.println(String.format("%s = %d", "Word", this.count));
                }
            }
        }
    }
}
