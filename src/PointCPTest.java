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
    double rotation = Math.random() * 360;
    
	PointCP pointCP_P = new PointCP('P',Math.random(), Math.random() * 360);
	PointCP pointCP_C = new PointCP('C',Math.random(), Math.random());
	PointCP2 pointCP2 = new PointCP2('P',Math.random(), Math.random() * 360);
	PointCP3 pointCP3 = new PointCP3('C',Math.random(), Math.random());
	PointCP6 pointCP6P = new PointP('P',Math.random(), Math.random() * 360);
	PointCP6 pointCP6C = new PointC('C',Math.random(), Math.random());
	
	PointCP pointCP_PB = new PointCP('P',Math.random(), Math.random() * 360);
	PointCP pointCP_CB = new PointCP('C',Math.random(), Math.random());
	PointCP2 pointCP2B = new PointCP2('P',Math.random(), Math.random() * 360);
	PointCP3 pointCP3B = new PointCP3('C',Math.random(), Math.random());
	PointCP6 pointCP6PB = new PointP('P',Math.random(), Math.random() * 360);
	PointCP6 pointCP6CB = new PointC('C',Math.random(), Math.random());
    
    System.out.println(String.format("Timings for %d runs (milliseconds)",N));
    System.out.println("\t\t\t\tPointCP (P)\tPointCP (C)\tPointCP2\t\tPointCP3\t\tPoint6 (PointP)\t\tPoint6 (PointC)");
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.getRho();  pointCP_P.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.print("getRho();getTheta();:\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.getRho();  pointCP_C.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.getRho();  pointCP2.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.getRho();  pointCP3.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.getRho();  pointCP6P.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.getRho();  pointCP6C.getTheta();};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.getX();  pointCP_P.getY();};
    endTime = System.currentTimeMillis();
    System.out.print("getX();getY();:\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.getX();  pointCP_C.getY();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.getX();  pointCP2.getY();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.getX();  pointCP3.getY();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.getX();  pointCP6P.getY();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.getX();  pointCP6C.getY();};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.print("convertStorageToPolar():\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.convertStorageToPolar();};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.print("convertStorageToCartesian():\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.convertStorageToCartesian();};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.print("rotatePoint(rotation):\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.rotatePoint(rotation);};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.getDistance(pointCP_PB);};
    endTime = System.currentTimeMillis();
    System.out.print("getDistance(pointB):\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.getDistance(pointCP_CB);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.getDistance(pointCP2B);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.getDistance(pointCP3B);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.getDistance(pointCP6PB);};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.getDistance(pointCP6CB);};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_P.toString();};
    endTime = System.currentTimeMillis();
    System.out.print("toString():\t\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP_C.toString();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP2.toString();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP3.toString();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6P.toString();};
    endTime = System.currentTimeMillis();
    System.out.print("\t\t" + (endTime - startTime));
    
    startTime = System.currentTimeMillis();
    for (int i=0; i<N; i++) { pointCP6C.toString();};
    endTime = System.currentTimeMillis();
    System.out.println("\t\t\t" + (endTime - startTime));
    
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