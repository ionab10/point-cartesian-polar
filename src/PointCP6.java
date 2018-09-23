
public interface PointCP6 {
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public PointP convertStorageToPolar();
	public PointC convertStorageToCartesian();
	
	/**
	 * Calculates the distance in between two points using the Pythagorean
	 * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */
	public default double getDistance(PointCP6 pointB) {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}
	
	public PointCP6 rotatePoint(double rotation);
	
	public String toString();
	
}
