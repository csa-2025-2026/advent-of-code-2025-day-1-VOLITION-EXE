import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Day2
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    
    
    String line = sc.nextLine();
      
    System.out.println(line);
      
    
    
    sc.close();
  }
}
