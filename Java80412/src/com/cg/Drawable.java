package com.cg;

public interface Drawable {
    public void draw();
    default
    public void offer() {
    	System.out.println("Discount of 100Rs");    	
    }
}
