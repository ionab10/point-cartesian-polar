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
public class PointP implements PointCP6
{
  //Instance variables ************************************************
  
  /**
   * Contains the current value of RHO
   */
  private double Rho;
  
  /**
   * Contains the current value of THETA
   */
  private double Theta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointP(char type, double xOrRho, double yOrTheta)
  {
	  if (type == 'C') {
		  this.Rho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
		  this.Theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	  }
	  else if (type == 'P') {
		  this.Rho = xOrRho;
		  this.Theta = yOrTheta;
	  }
	  else
		  throw new IllegalArgumentException();
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
    return (Math.cos(Math.toRadians(Theta)) * Rho);
  }
  
  public double getY()
  {
    return (Math.sin(Math.toRadians(Theta)) * Rho);
  }
  
  public double getRho()
  {
    return Rho;
  }
  
  public double getTheta()
  {
    return Theta;
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
        
    return new PointP('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  @Override
  public PointP convertStorageToPolar() {
  	return new PointP('P', getRho(), getTheta());
  	
  }


  @Override
  public PointC convertStorageToCartesian() {
	  return new PointC('P', getRho(), getTheta());
  	
  }
  
  
  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
	  return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
  }

}