package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GraphCreator {
	
	GraphCreator(){
		//empty constructor
	}
	
	public static Canvas getGraph(double[] x, double[] y, String xLable, String yLabel, int sizeX, int sizeY){
		Canvas canvas = new Canvas(sizeX, sizeY);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//limits, represent how much offset the graph has 
		//(i.e. the graph starts at point (xLimit, 0) and ends at
		//(sizeX, yLimit)
		//basically every x value must have 20 added to it, and every y value cannot extend beyond sizeY - yLimit
		int xLimit = 80;
		int yLimit = 80;
		
		gc.strokeLine(xLimit, 0, xLimit, sizeY - yLimit);
		gc.strokeLine(xLimit, sizeY - yLimit, sizeX, sizeY - yLimit);
		
		return canvas;
	}
	
	
}
