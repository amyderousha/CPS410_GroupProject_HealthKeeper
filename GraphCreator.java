import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 *
 * @author Tyler Beachnau
 * @since 3/28/2017
 * @version 1.0
 *
 * The GraphCreator class has a single static method which creates a graph.
 * It will create a graph given an array of x and y values, and an x and y label.
 *
 * The graph will be a simple line graph, with proper increments given a constant tick size (default set at 20).
 * The GraphCreator returns a javafx.scene.canvas.Canvas object, which can be displayed on a javafx stage/application.
 *
 * USE: TO USE THE CLASS: Simply call via:
 *
 * Canvas canvasName = GraphCreator.getGraph(x, y, xLabel, yLabel, sizeX, sizeY), ensure you have imported the package containing the GraphCreator class.
 * where x and y are an array of doubles (double[] x, double[] y)
 * xLabel and yLabel are strings representing labels for the respective axes
 * sizeX and sizeY are the desired width and height of the canvas object!
 *
 * This will return a canvas with the graph on it, you can then add this to a javafx stage.
 */
public class GraphCreator {
 
 private static final double DOT_SIZE = 5;
 private static final int TICK_COUNT = 20;
 
 GraphCreator(){
  //empty constructor
 }
 
 public static Canvas getGraph(double[] x, double[] y, String xLabel, String yLabel, int sizeX, int sizeY){
  
  
  
  Canvas canvas = new Canvas(sizeX + 10, sizeY);
  GraphicsContext gc = canvas.getGraphicsContext2D();
  
  //find x and y max values (for conversion)
  double xMaxValue = x[0];
  double yMaxValue = y[0];
  for(int i = 1; i < x.length; i++){
   if(x[i] > xMaxValue)
    xMaxValue = x[i];
   if(y[i] > yMaxValue)
    yMaxValue = y[i];
  }
  
  int xLimit = 80;
  int yLimit = 80;
  
  int graphSizeX = sizeX - xLimit;
  int graphSizeY = sizeY - yLimit;
  
  double xConversion = graphSizeX / xMaxValue;
  double yConversion = graphSizeY / yMaxValue;
  
  //TO-DO
  //Implement method to label ticks on the axes!!! (just draw small diagonal/horizontal/vertical lines, and place text near the bottom/left of those lines)
  //implement better tick method (maybe require user to specify interval??? Or devise better algorithm to detect nice integer intervals.
  
  int xInc = graphSizeX / TICK_COUNT;
  int yInc = graphSizeY / TICK_COUNT;
  
  System.out.println("x size is: "+ graphSizeX + " tick count size: " + xInc);
  
  gc.strokeLine(xLimit, 0, xLimit, sizeY - yLimit);
  gc.strokeLine(xLimit, sizeY - yLimit, sizeX, sizeY - yLimit);
  
  gc.fillText(yLabel, 10, sizeY/2, xLimit);
  gc.fillText(xLabel, sizeX/2, sizeY - yLimit / 2);
  
  for(int i = 0; i < x.length - 1; i++){
   //lines and points/dots
   gc.strokeLine(x[i] * xConversion + xLimit, graphSizeY - (y[i] * yConversion) ,x[i+1] * xConversion + xLimit, graphSizeY - (y[i+1] * yConversion));
   gc.fillOval(x[i] * xConversion - DOT_SIZE / 2 + xLimit, graphSizeY - (y[i] * yConversion) - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
  }
  
  //each tick represents a value of max / tick count
  for(int i = 0; i <= TICK_COUNT; i++){
   //tick marks, uses i
   gc.strokeLine(xLimit + i*xInc, graphSizeY, xLimit + i*xInc, graphSizeY + 15);
   gc.fillText(String.format("%.2f", xMaxValue / TICK_COUNT * i), xLimit + i*xInc - 10, graphSizeY + 25);
  }
  
  gc.fillOval(x[x.length-1] * xConversion - DOT_SIZE / 2 + xLimit, graphSizeY - (y[y.length-1] * yConversion) - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
  
  return canvas;
 } 
}
