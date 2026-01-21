import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class Day3
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    long answer = 0;
    
    while (sc.hasNext())  // as long as the Scanner has more lines to read from the file...
    {
      String line = sc.nextLine();
      int lenghtPos = 0;
      String maxPower = "";
      for(int i = 11; i>=0; i--){
        int numStore = 0;
        for(int j = lenghtPos; j<line.length()-i; j++){
          if(numStore<Integer.parseInt(line.substring(j, j+1))){
            numStore = Integer.parseInt(line.substring(j, j+1));
            lenghtPos = j+1;
          }
        }
        maxPower += String.valueOf(numStore);
      }
      answer += Long.parseLong(maxPower);
    }
    System.out.println(answer);
    sc.close();
  }
}