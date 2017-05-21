public class Planet {
	public double xxPos;   //Its current x position
	public double yyPos;   //Its current y position
	public double xxVel;   //Its current velocity in the x direction
	public double yyVel;   //Its current velocity in the y direction
	public double mass;    //Its mass
	public String imgFileName;   //The name of an image in the images directory that depicts the planet

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
}