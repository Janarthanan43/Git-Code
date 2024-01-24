package com.example.ThreadUT;

public class Logger {
    private static Logger instance;
    private static final Object single=new Object(); // A single object for synchronization

    // Private constructor to prevent external instantiation
    private Logger(){

    }

    // Method will double check the locking
    public static Logger getInstance(){
        if(instance==null){
            synchronized(single){
                if(instance==null)
                {
                    instance=new Logger();
                }
            }
        }
        return instance;
    }

    // Prints the message
    public void log(String message){
        System.out.println("Log:"+message);
    }

}
