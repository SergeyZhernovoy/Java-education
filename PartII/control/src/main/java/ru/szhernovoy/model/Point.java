package ru.szhernovoy.model;

public class Point{
	
	private int positionX;
	private int positionY;
	
	public Point(int x, int y){
		this.positionX = x;
		this.positionY = y;
	}
	
	public void setX(int x){
		this.positionX = x;
	}
	
	public void setY(int y){
		this.positionY = y;
	}
	
	public int getX(){
		return this.positionX;
	}
	
	public int getY(){
		return this.positionY;
	}
	
}