/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 */
public class Point6
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;
  
  /**
   * Contains the current point in cartesian coordinates as type PointC
   */
  private PointC pointC;
  
  /**
   * Contains the current point in polar coordinates as type PointP
   */
  private PointP pointP;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public Point6(char type, double xOrRho, double yOrTheta)
  {
	  
	  if(type == 'C') {
		  this.pointC = new PointC(xOrRho,yOrTheta);
		  this.pointP = new PointP(this.pointC.getRho(), this.pointC.getTheta());
	  }
	  else if (type == 'P') {
		  this.pointP = new PointP(xOrRho,yOrTheta);
		  this.pointC = new PointC(this.pointP.getX(), this.pointP.getY());
	  }
	  else {
		  throw new IllegalArgumentException();
	  }
	  typeCoord = type;
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
	  return pointC.getX();
  }
  
  public double getY()
  {
	  return pointC.getY();
  }
  
  public double getRho()
  {
	  return pointP.getRho();
  }
  
  public double getTheta()
  {
	  return pointP.getTheta();
  }
  
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(Point6 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public Point6 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new Point6('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as " + (typeCoord == 'C' 
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}