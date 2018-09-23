// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointC implements PointCP6
{
  //Instance variables ************************************************
  
  /**
   * Contains the current value of X
   */
  private double X;
  
  /**
   * Contains the current value of Y
   */
  private double Y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointC(char type, double xOrRho, double yOrTheta)
  {
	  if (type == 'C') {
		  this.X = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
		  this.Y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
	  }
	  else if (type == 'P') {
		  this.X = xOrRho;
		  this.Y = yOrTheta;
	  }
	  else
		  throw new IllegalArgumentException();
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
    return X;
  }
  
  public double getY()
  {
    return Y;
  }
  
  public double getRho()
  {
    return (Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)));
  }
  
  public double getTheta()
  {
    return Math.toDegrees(Math.atan2(Y, X));
  }
  

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP6 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointC('C',
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
	  return "Stored as Caresian [" + getX() + "," + getY() + "]\n";
  }


@Override
public PointP convertStorageToPolar() {
	return new PointP('C', getX(), getY());
	
}


@Override
public PointC convertStorageToCartesian() {
	return new PointC('C', getX(), getY());
	
}


}