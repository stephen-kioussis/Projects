import java.util.*;
import java.io.*;


public class Histogram
{
  int[] incrementArray = new int[10];
  int max = incrementArray[0];
  final int FACTOR_OF_TEN = 10;

  public int[] readFile(String fileName) throws IOException
  {
    int iRightBound = 10;
    int iLeftBound = 1;
    int position = 0;
    int quantity = -1;


    while (iRightBound <= 100)
    {
      Scanner fileScan = new Scanner(new File(fileName));

      while (fileScan.hasNextInt())
      {
        quantity = fileScan.nextInt();


        if (quantity >= iLeftBound && quantity <= iRightBound)
        {
          incrementArray[position] = incrementArray[position] + 1;
        }
      }

      fileScan.close();
      position++;
      iLeftBound = iLeftBound + FACTOR_OF_TEN;
      iRightBound = iRightBound + FACTOR_OF_TEN;
    }
    return incrementArray;
  }

  public void maxFinder()
  {
    int position = 1;

    while (position < incrementArray.length)
    {
      if (incrementArray[position] > max)
      {
        max = incrementArray[position];
      }
      position++;
    }
  }

  public String dataChart()
  {
    int position = 0;
    final int FACTOR_OF_TEN = 10;
    final double MAX_LENGTH = 60;
    double dScale = max / MAX_LENGTH;
    double dFactor = 1;
    int iLeftBound = 1;
    int iRightBound = 10;
    String outPut = "one star is roughly equal to " + dScale + " values" + "\n"
                    + "\n" + "\n";

    while (position < incrementArray.length)
    {
      outPut += iLeftBound + " to " + iRightBound + " " + "\t";

      while ((dScale * dFactor) < incrementArray[position])
      {
        outPut += "*";
        dFactor++;
      }

      dFactor = 1;
      position++;
      iLeftBound = iLeftBound + FACTOR_OF_TEN;
      iRightBound = iRightBound + FACTOR_OF_TEN;
      outPut += "\n";
    }
    return outPut;
  }
}
