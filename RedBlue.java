import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class RedBlue {
	public static final String PATH_TO_FILE = "data/";
	public static final String FILE_EXTENSION = ".txt";

	public static void main(String[] args) throws FileNotFoundException {
		//Make sure we have at least one cmd arguments
		if (args.length < 2) {
			System.out.println("Usage: java RedBlue <region> <year>");
			System.exit(-1);
		}

		Scanner sc = new Scanner(new File(PATH_TO_FILE + args[0] + FILE_EXTENSION));


		double minX = sc.nextDouble();
		double minY = sc.nextDouble();
		//System.out.println(minX + " " + minY);

		//Reading max x/y
		double maxX = sc.nextDouble();
		double maxY = sc.nextDouble();
		//System.out.println(maxX + " " + maxY);

		StdDraw.setCanvasSize(700, 512);

		//Scale the window
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);

		//Readng number of subregions
		int numSubRegions, numPoints;
		String subRegionName, regionName;

		numSubRegions = sc.nextInt();



		Color red = new Color(255, 0, 0);
		Color blue = new Color(0, 0, 255);
		Color black = new Color(255, 255, 255);
		Color green = new Color(0, 255, 0);

		for (int i = 0; i < numSubRegions; i++) {
			String junk = sc.nextLine(); //consumes the extra new line
			junk = sc.nextLine();
			subRegionName = sc.nextLine();
			regionName = sc.nextLine();
			//System.out.println(subRegionName + " " + regionName);

			Scanner sca = new Scanner(new File(PATH_TO_FILE + regionName +  args[1] + FILE_EXTENSION));
			sca.nextLine();
			int rep = 0;
			int dem = 0;
			int ind = 0;
			while (sca.hasNextLine()) {
				String line = sca.nextLine();
				String[] array = line.split(",");
				array[0] = array[0].toLowerCase();
				subRegionName = subRegionName.toLowerCase();
				if (subRegionName.indexOf(array[0])!= -1) {
					rep = Integer.parseInt(array[1]);
					dem = Integer.parseInt(array[2]);
					ind = Integer.parseInt(array[3]);
					break;
				}
			}
			//Reading number of points
			numPoints = sc.nextInt();
			double[] longs = new double[numPoints];
			double[] lats = new double[numPoints];
			for (int j = 0; j < numPoints; j++) {
				//read longitude
				longs[j] = sc.nextDouble();
				// read latitude
				lats[j] = sc.nextDouble();
				//System.out.println(longs[j] + " " + lats[j]);
			}
			StdDraw.setPenColor(black);
			StdDraw.polygon(longs, lats);
			//fill polygon

			if (rep > dem) {
				StdDraw.setPenColor(red);
			}
			else if (dem > rep) {
				StdDraw.setPenColor(blue);
			}
			else {
				StdDraw.setPenColor(green);
			}
			StdDraw.filledPolygon(longs, lats);
		}
	}
}