public class NBody {

	public static String imageToDraw = "./images/starfield.jpg";
	/*
	 * main method: draw the universe in its starting position
	 */
	public static void main(String[] args) {

		StdAudio.play("./audio/2001.mid");

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		int numberOfStar = readNumbers(filename);
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename, numberOfStar);

		drawBackground(radius);
		drawAllofPlanets(planets);

		// Creating an Animation
		for(double t = 0.0; t <= T; t+=dt) {

			/*
			 * Create an xForces array and yForces array.
			 */
			Double[] xForces = new Double[numberOfStar];
			Double[] yForces = new Double[numberOfStar];

			/*
			 * Calculate the net x and y forces for each planet, storing
			 * these in the xForces and yForces arrays respectively.
			 */
			for(int i = 0; i < numberOfStar; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			/*
			 * Call update on each of the planets. This will update each 
			 * planet's position, velocity, and acceleration.
			 */
			for (int i = 0; i < numberOfStar; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			/*
			 * Draw the background image and Draw all of the planets.
			 */
			drawBackground(radius);
			drawAllofPlanets(planets);

			/* Shows the drawing to the screen, and waits 10 milliseconds. */	
			StdDraw.show(10);
		}

		StdAudio.close();
		System.exit(0);
	}

	/*
	 * method readNumbers: return a int corresponding to the number of the star in that file
	 */
	public static int readNumbers(String filePath) {
		int line = 0;
		In in = new In(filePath);
		int number = 0;

		while(!in.isEmpty()) {
			line++;
			if (line == 1) {
				number = in.readInt();
				break;
			}
		}

		return number+1;
	}

	/*
	 * method readRadius: return a double corresponding to the radius of the universe in that file
	 */
	public static double readRadius(String filePath) {
		int line = 0;
		In in = new In(filePath);
		double radius = 0;
		int number = 0;

		while(!in.isEmpty()) {
			line++;
			
			//read the first line
			if (line == 1) {
				number = in.readInt();
			}

			//read the second line
			if(line == 2) {
				radius = in.readDouble();
				break;
			}
		}
		return radius;
	}

	/*
	 * method readPlanets: Given a file name, it should return an array of Planets corresponding 
	 * to the planets in the file
	 */
	public static Planet[] readPlanets(String filePath, int num) {
		int line = 0;
		Planet[] planetsArray = new Planet[num];
		In in = new In(filePath);
		double radius = 0;
		int number = 0;

		while(!in.isEmpty()) {
			line++;
			
			//read the first line
			if (line == 1) {
				number = in.readInt()+1;
			}

			//read the second line
			if(line == 2) {
				radius = in.readDouble();
			}

			//read the planets
			if(line >= 3) {
				planetsArray[line-3] = new Planet(in.readDouble(), in.readDouble(),in.readDouble(),
					in.readDouble(), in.readDouble(), in.readString());
			}

			//braek when the read all planets
			if(line == number+2)
				break;
		}
		return planetsArray;
	}

	/*
	 * method drawBackground: draw the background of the universe
	 */
	public static void drawBackground(double radius) {
		/** Sets up the universe so it goes from 
		  * -radius, -radius up to radius, radius */
		StdDraw.setScale(-radius,radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of starfield.jpg in the center. */
		StdDraw.picture(0, 0, imageToDraw);
	}

	/*
	 * method drawAllofPlanets: draw each one of the planets in the planets array.
	 */
	public static void drawAllofPlanets(Planet[] planets) {
		for(Planet p : planets)
			p.draw();
	}
}