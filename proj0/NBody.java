public class NBody {
	/*
	 * method readRadius: return a double corresponding to the radius of the universe in that file
	 */
	public static double readRadius(String filePath) {
		int line = 0;
		In in = new In("./data/planets.txt");
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
	public static Planet[] readPlanets(String filePath) {
		Planet[] planetsArray = new Planet[5];
		int line = 0;
		In in = new In("./data/planets.txt");
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
}