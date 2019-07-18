
//********************************************************************
//File:         Histogram.java       
//Author:       Stephen Kioussis
//
//Program Description:
//	A program that creates a histogram that allows you to visually
//	inspect the frequency distribution of a set of values. The program
//	reads an arbitrary number of integers from a text input 
//	file that are in the range 1 to 100 inclusive; then produces a chart 
//	that indicates how many input values fell in the range 1 to 10,
//	11 to 20, and so on. It thenPrints one asterisk for each value entered.
//
//Inputs:   text file
//Outputs:  A histogram representation of the text file 
// 
//********************************************************************
import java.io.*;


public class Driver
{

  public static void main(String[] args) throws IOException
  {

    Histogram chart = new Histogram();
    String fileName = "realdata.txt";

    chart.readFile(fileName);
    chart.maxFinder();
    System.out.println(chart.dataChart());
  }

}
