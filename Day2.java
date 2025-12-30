import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Day2
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    
    String line = sc.nextLine()+",";
    long answer = 0;
    int backPos = 0;
    int frontPos = line.indexOf(",");
    
    while(frontPos!=-1){
      String cID = line.substring(backPos,frontPos);
      int dID = cID.indexOf("-");
      for(long i=Long.parseLong(cID.substring(0,dID));i<Long.parseLong(cID.substring(dID+1))+1;i++){
        String cV = String.valueOf(i);
        int cL = cV.length();
        for(int j = 1; j<=cL/2; j++){
          String cD = cV.substring(0,j);
          int counter = 0;
          while(cV.substring(counter, Math.min(counter+j,cL)).equals(cD)){
            counter+=j;
          }
          if(counter==cL){
            answer+=i;
            break;
          }
        }
      }
      backPos = frontPos+1;
      frontPos = line.indexOf(",",frontPos+1);
    }
    System.out.println(answer);
    sc.close();
    
  }
}
