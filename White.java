/*
* Class: CS 1233
* Section: 001
* 
* Description: Program that reads list of x/y coordinates and outputs the map of the corresponding region.
* Name: White.java
*/

import java.util.Scanner;
import java.io.*;

public class White
{
	//Declare constant
	public static final String PATH_TO_FILE = "data/";
	public static final String FILE_EXTENSION = ".txt";

	public static void main(String[] args) throws FileNotFoundException {
		//Make sure we have at least one cmd arguments
		if (args.length < 1) {
			System.out.println("Usage: java White <region>");
			System.exit(-1);
		}

		//Reading the file
		Scanner sc = new Scanner(new File(PATH_TO_FILE + args[0] + FILE_EXTENSION));

		//Reading min x/y
		double minX = sc.nextDouble();
		double minY = sc.nextDouble();
		System.out.println(minX + " " + minY);

		//Reading max x/y
		double maxX = sc.nextDouble();
		double maxY = sc.nextDouble();
		System.out.println(maxX + " " + maxY);

		StdDraw.setCanvasSize(700, 512);

		//Scale the window
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);

		//Readng number of subregions
		int numSubRegions, numPoints;
		String subRegionName, regionName;

		numSubRegions = sc.nextInt();

		for (int i = 0; i < numSubRegions; i++) {
			String junk = sc.nextLine(); //consumes the extra new line
			junk = sc.nextLine();
			subRegionName = sc.nextLine();
			regionName = sc.nextLine();
			System.out.println(subRegionName + " " + regionName);

			//Reading number of points
			numPoints = sc.nextInt();
			double[] longs = new double[numPoints];
			double[] lats = new double[numPoints];
			for (int j = 0; j < numPoints; j++) {
				//read longitude
				longs[j] = sc.nextDouble();
				// read latitude
				lats[j] = sc.nextDouble();
				System.out.println(longs[j] + " " + lats[j]);
			}
			StdDraw.polygon(longs, lats);
			//fill polygon

		}



	}
}