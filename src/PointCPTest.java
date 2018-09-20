// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
     
	long startTime;
	long endTime;
    long N = 1000000000;

    System.out.println("Calculating coordinates and creating a new point");
    System.out.println(String.format("Timings for %d runs (milliseconds)",N));
    System.out.println("\t\t\t(PointCP -> PointCP)\t(Point2 -> Point2)\t(Point3 -> Point3)");
    
    startTime = System.currentTimeMillis();
    Polar2PolarCP(N);
    endTime = System.currentTimeMillis();
    System.out.print("Polar to Polar:\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar2Polar2(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar2Polar3(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar2CartesCP(N);
    endTime = System.currentTimeMillis();
    System.out.print("Polar to Cartesian:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar2Cartes2(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar2Cartes3(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2PolarCP(N);
    endTime = System.currentTimeMillis();
    System.out.print("Cartesian to Polar:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2Polar2(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2Polar3(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2CartesCP(N);
    endTime = System.currentTimeMillis();
    System.out.print("Cartesian to Cartesian:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2Cartes2(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes2Cartes3(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    System.out.println("\n\nCalculating coordinates");
    System.out.println(String.format("Timings for %d runs (milliseconds)",N));
    System.out.println("\t\t\t(PointCP -> (d,d))\t(Point2 -> (d,d))\t\t(Point3 -> (d,d))");
    
    startTime = System.currentTimeMillis();
    PolarCP2PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("Polar to Polar:\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    PolarP2PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar52PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    PolarCP2CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("Polar to Cartesian:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    PolarP2CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Polar52CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    CartesCP2PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("Cartesian to Polar:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    CartesC2PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes52PolarDD(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    CartesCP2CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("Cartesian to Cartesian:\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    CartesC2CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.print("\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    Cartes52CartesDD(N);
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t\t" + (endTime - startTime));
    
    System.out.println("\n");
    //convertACoordinate(args);

  }
  
  /**

   */
  private static void Polar2PolarCP(long n)
  {
	  PointCP pointCP = new PointCP('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  pointCP = new PointCP('P',pointCP.getRho(), pointCP.getTheta());
	  }
	  
  }
  
  /**

   */
  private static void Polar2CartesCP(long n)
  {
	  PointCP pointCP = new PointCP('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  pointCP = new PointCP('C',pointCP.getX(), pointCP.getY());
	  }
	  
  }
  
  /**

   */
  private static void Cartes2CartesCP(long n)
  {
	  PointCP pointCP = new PointCP('C', Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  pointCP = new PointCP('C',pointCP.getX(), pointCP.getY());
	  }
	  
  }
  
  /**

   */
  private static void Cartes2PolarCP(long n)
  {
	  PointCP pointCP = new PointCP('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  pointCP = new PointCP('P',pointCP.getRho(), pointCP.getTheta());
	  }
	  
  }
  
  /**

   */
  private static void Polar2PolarP(long n)
  {
	  PointP pointP = new PointP(Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  pointP = new PointP(pointP.getRho(), pointP.getTheta());
	  }
	  
  }
  
  /**

   */
  private static void Polar2CartesP(long n)
  {
	  PointP pointP = new PointP(Math.random(), Math.random() * 360);
	  PointC pointC;
	  
	  for (int i=0; i<n; i++) {
		  pointC = new PointC(pointP.getX(), pointP.getY());
	  }
	  
  }
  
  
  /**

   */
  private static void Cartes2CartesC(long n)
  {
	  PointC pointC = new PointC(Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  pointC = new PointC(pointC.getX(), pointC.getY());
	  }
	  
  }
  
  /**

   */
  private static void Cartes2PolarC(long n)
  {
	  PointP pointP;
	  PointC pointC = new PointC(Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  pointP = new PointP(pointC.getRho(), pointC.getTheta());
	  }
	  
  }
  
  /**

   */
  private static void Polar2Polar5(long n)
  {
	  Point5 point5 = new Point5('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  point5 = new Point5('P',point5.getRho(), point5.getTheta());
	  }
  }
  
  /**

   */
  private static void Polar2Cartes5(long n)
  {
	  Point5 point5 = new Point5('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  point5 = new Point5('C',point5.getX(), point5.getY());
	  }
	  
  }
  
  
  /**

   */
  private static void Cartes2Cartes5(long n)
  {
	  Point5 point5 = new Point5('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  point5 = new Point5('C',point5.getX(), point5.getY());
	  }
	  
  }
  
  /**

   */
  private static void Cartes2Polar5(long n)
  {
	  Point5 point5 = new Point5('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  point5 = new Point5('P',point5.getRho(), point5.getTheta());
	  }
	  
  }
 
  /**

   */
  private static void PolarCP2PolarDD(long n)
  {
	  PointCP pointCP = new PointCP('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointCP.getRho(), pointCP.getTheta()};
	  }
	  
  }
  
  /**

   */
  private static void PolarCP2CartesDD(long n)
  {
	  PointCP pointCP = new PointCP('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointCP.getX(), pointCP.getY()};
	  }
	  
  }
  
  /**

   */
  private static void CartesCP2CartesDD(long n)
  {
	  PointCP pointCP = new PointCP('C', Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointCP.getX(), pointCP.getY()};
	  }
	  
  }
  
  /**

   */
  private static void CartesCP2PolarDD(long n)
  {
	  PointCP pointCP = new PointCP('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointCP.getRho(), pointCP.getTheta()};
	  }
	  
  }
  
  /**

   */
  private static void PolarP2PolarDD(long n)
  {
	  PointP pointP = new PointP(Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointP.getRho(), pointP.getTheta()};
	  }
	  
  }
  
  /**

   */
  private static void PolarP2CartesDD(long n)
  {
	  PointP pointP = new PointP(Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointP.getX(), pointP.getY()};
	  }
	  
  }
  
  
  /**

   */
  private static void CartesC2CartesDD(long n)
  {
	  PointC pointC = new PointC(Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointC.getX(), pointC.getY()};
	  }
	  
  }
  
  /**

   */
  private static void CartesC2PolarDD(long n)
  {
	  PointC pointC = new PointC(Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {pointC.getRho(), pointC.getTheta()};
	  }
	  
  }
  
  /**

   */
  private static void Polar52PolarDD(long n)
  {
	  Point5 point5 = new Point5('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {point5.getRho(), point5.getTheta()};
	  }
  }
  
  /**

   */
  private static void Polar52CartesDD(long n)
  {
	  Point5 point5 = new Point5('P',Math.random(), Math.random() * 360);
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {point5.getX(), point5.getY()};
	  }
	  
  }
  
  
  /**

   */
  private static void Cartes52CartesDD(long n)
  {
	  Point5 point5 = new Point5('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {point5.getX(), point5.getY()};
	  }
	  
  }
  
  /**

   */
  private static void Cartes52PolarDD(long n)
  {
	  Point5 point5 = new Point5('C',Math.random(), Math.random());
	  
	  for (int i=0; i<n; i++) {
		  double[] dd = {point5.getRho(), point5.getTheta()};
	  }
	  
  }
  
  /**

   */
  private static void convertACoordinate(String[] args)
  {
	    PointCP point;
	    
	    System.out.println("Cartesian-Polar Coordinates Conversion Program");

	    // Check if the user input coordinates from the command line
	    // If he did, create the PointCP object from these arguments.
	    // If he did not, prompt the user for them.
	    try
	    {
	      point = new PointCP(args[0].toUpperCase().charAt(0), 
	        Double.valueOf(args[1]).doubleValue(), 
	        Double.valueOf(args[2]).doubleValue());
	    }
	    catch(Exception e)
	    {
	      // If we arrive here, it is because either there were no
	      // command line arguments, or they were invalid
	      if(args.length != 0)
	        System.out.println("Invalid arguments on command line");

	      try
	      {
	        point = getInput();
	      }
	      catch(IOException ex)
	      {
	        System.out.println("Error getting input. Ending program.");
	        return;
	      }
	    }
	    System.out.println("\nYou entered:\n" + point);
	    point.convertStorageToCartesian();
	    System.out.println("\nAfter asking to store as Cartesian:\n" + point);
	    point.convertStorageToPolar();
	    System.out.println("\nAfter asking to store as Polar:\n" + point);
	    
  } 
  
  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP(coordType, a, b));
  }
  
}