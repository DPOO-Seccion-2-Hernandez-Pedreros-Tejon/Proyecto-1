package Controller;

import java.util.ArrayList;
import java.lang.System;

public final class Cronometro
{
    private long begin, end;
    public ArrayList<Long> tiempos;
    
    
    public Cronometro(long begin, long end) {
    	this.begin = begin;
    	this.end = end;
    	this.tiempos = new ArrayList<Long>();
	}

	public void start(){
        begin = System.currentTimeMillis();
        //System.out.println(getTime());
    }
 
    public void stop(){
        end = System.currentTimeMillis();
        getTime();
    }
 
    public void getTime() 
    {
    	tiempos.add(end-begin);
        
    }
    public long getTotal()
    {
    	
    	int suma = 0;

    	for (long number : tiempos){
    	    suma += number;
    	}
    	return suma/1000;
    }
}