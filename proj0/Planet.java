public class Planet {
	public double xxPos;   //Its current x position
	public double yyPos;   //Its current y position
	public double xxVel;   //Its current velocity in the x direction
	public double yyVel;   //Its current velocity in the y direction
	public double mass;    //Its mass
	public String imgFileName;   //The name of an image in the images directory that depicts the planet
	private double g = 6.67*Math.pow(10,-11);

	/*
	 * first constructor
	 */
	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/*
	 * Second constructor to take in a Planet object and initialize
	 * an identical Planet object 
	 */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/*
	 * method calcDistance: calculates the distance between two Planets,
	 * This method will take in a single Planet and should return a double
	 * equal to the distance between the supplied planet and the planet that
	 * is doing the calculation.
	 */
	public double calcDistance(Planet p) {
		return Math.sqrt((p.xxPos - this.xxPos)*(p.xxPos - this.xxPos)
			+ (p.yyPos - this.yyPos)*(p.yyPos - this.yyPos));
	}

	/*
	 * method calcForceExertedBy: The calcForceExertedBy method takes in a planet, 
	 * and returns a double describing the force exerted on this 
	 * planet by the given planet. 
	 */
	public double calcForceExertedBy(Planet p) {
		return g*p.mass*this.mass/(this.calcDistance(p)*this.calcDistance(p));
	}

	/*
	 * calcForceExertedByX and calcForceExertedByY. Unlike the calcForceExertedBy method, 
	 * which returns the total force, these two methods describe the force 
	 * exerted in the X and Y directions, respectively.
	 */
	public double calcForceExertedByX(Planet p) {
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	/*
	 * methods calcNetForceExertedByX and calcNetForceExertedByY that each take in an 
	 * array of Planets and calculate the net X and net Y force exerted by all planets 
	 * in that array upon the current Planet.
	 */
	public double calcNetForceExertedByX(Planet p[]) {
		double netX = 0;
		for(Planet specPlanet : p) {
			if(!this.equals(specPlanet))
				netX += this.calcForceExertedByX(specPlanet);
		}
		return netX;
	}

	public double calcNetForceExertedByY(Planet p[]) {
		double netY = 0;
		for(int i = 0; i < p.length; i++) {
			if(!this.equals(p[i]))
				netY += this.calcForceExertedByY(p[i]);
		}
		return netY;
	}

	/*
	 * method update: determines how much the forces exerted on the planet will cause that 
	 * planet to accelerate, and the resulting change in the planet's velocity and position 
	 * in a small period of time dt.
	 */
	public void update(double dt, double fX, double fY) {
		double aX = fX/this.mass;
		double aY = fY/this.mass;

		this.xxVel = this.xxVel + dt*aX;
		this.yyVel = this.yyVel + dt*aY;

		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;
	}

	/*
	 * draw method: uses the StdDraw API mentioned above to draw the Planet's img at 
	 * the Planet's position.
	 */
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}