import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Day1
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    int currentDial = 50;

    int answer = 0;
    while (sc.hasNext())  // as long as the Scanner has more lines to read from the file...
    {
      //System.out.println(currentDial);
      String line = sc.nextLine();
      
      int value = Integer.parseInt(line.substring(1));
      answer += value/100;
      value = value%100;
      if(line.substring(0,1).equals("R")){
        currentDial += value;
      } else {
        currentDial -= value;
      }

      if(currentDial < 0){
        if(currentDial+value!=0&&currentDial+100!=0)answer++;
        currentDial = 100+currentDial;
      }else if(currentDial > 99){
        if(currentDial+value!=0&&currentDial-100!=0)answer++;
        currentDial = currentDial - 100;
      }
      if(currentDial==0)answer++;
      
    }
    //System.out.println(currentDial);
    System.out.println("The password is " + answer);
    sc.close();
  }
}
