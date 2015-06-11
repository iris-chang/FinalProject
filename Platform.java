/**
 * @Platform.java
 * 	- stores information on all types of platforms besides normal and water
 *
 * @Iris Chang 
 * @version 1.00 2015/5/05
 */
 
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Platform{
	private int x,y,ox,oy,dx,dy,width,height,dir,vel;
	private String [] data;
	private String type;
	private boolean falling=false;
	private boolean willFall=false;
	private int fallCount=0;
	private int countDown=0;
	public Platform(String line){
		data = line.split(",");
		x = Integer.parseInt(data[0]);
		y = Integer.parseInt(data[1]);
		ox = x;
		oy = y;
		width = Integer.parseInt(data[2]);
		height = Integer.parseInt(data[3]);
		dx = Integer.parseInt(data[4]);
		dy = Integer.parseInt(data[5]);
		dir = Integer.parseInt(data[6]);
		vel = Integer.parseInt(data[7]);
		type=data[8];
		//System.out.println(data[8]);
	}
	public int getX(){;return x;}
	public int getY(){return y;}
	public int getxVel(){
		if (dx!=0){
			return vel*dir;
		}
		else{
			return 0;
		}
	}
	public int getyVel(){
		if (dy!=0){
			return vel*dir;
		}
		else{
			return 0;
		}
		}
	public String getType(){
		//System.out.println(type);
		return type;
	}
	public void fallPrepare(){
		if (willFall==false){
			countDown=5;	
			willFall=true;
		}
		
	}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	
	public void move(){
		if (dx!=0){
			if ((x-ox)*dir<dx){
				x += vel*dir;
				String velo = vel+"";
				//System.out.println("VELOCITY: " + velo + "\nDIRECTION")
			}
			else{
				dir*=-1;
				x += vel*dir;
			}
		}
		else{
			if ((y-oy)*dir<dy){
				y += vel*dir;
				String velo = vel+"";
				//System.out.println("VELOCITY: " + velo + "\nDIRECTION")
			}
			else{
			//	System.out.println("BLLOP");
				dir*=-1;
				y += vel*dir;
			}
		}
		if (willFall==true){
			countDown-=1;
			if (countDown==0){
				falling=true;
				willFall=false;
				countDown=0;
			}
		}
		if (falling==true){
			y+=6;
			fallCount+=1;
			if (fallCount==100){
				falling=false;
				fallCount=0;
				y=oy;
			}
		}	
	}
	public String toString(){
		return "{"+data[0]+","+data[1]+"}";
	}
	
	
}