package com.niit.exercise.dayone;

public class Methodoverloading {
	
	public static void main(String [] args)
	{
		TDgeometry td=new TDgeometry();
		
		System.out.println("Area Of Squera::"+td.calculateArea(2));
		System.out.println("Area Of Rectangle::"+td.calculateArea(4, 6));
		
		ThreeDGeometry tg=new ThreeDGeometry();
		
		System.out.println("Volume Of Cube::"+tg.cubeArea(3));
		System.out.println("Volume Of cuboid::"+tg.cubeArea(2, 3, 4));
		
	}

}
