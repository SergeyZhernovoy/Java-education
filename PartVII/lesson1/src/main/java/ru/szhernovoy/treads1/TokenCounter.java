package ru.szhernovoy.treads1;

import java.util.StringTokenizer;

/**
 * Created by admin on 08.10.2016.
 */
public class TokenCounter{

    /**define type reading StrongTokenizer with delimetr or not delimetr*/
    private final boolean typeToken;
    /**counter word or space */
    private int count = 0;
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

    public class TokenThread implements Runnable{

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
            StringTokenizer stringTokenizer ;
            if(typeToken){
                stringTokenizer = new StringTokenizer(in, DELIMETR, typeToken);
            }
            else{
                stringTokenizer = new StringTokenizer(in);
            }

            while (stringTokenizer.hasMoreTokens()) {
                if (typeToken && stringTokenizer.nextElement().equals(DELIMETR)) {
                    count++;
                    System.out.println(String.format("%s = %d", "Space", count ));

                } else {
                    if (!typeToken &&  stringTokenizer.nextElement() != null) {
                        count++;
                        System.out.println(String.format("%s = %d", "Word", count ));
                    }
                }
            }
        }
    }





}
