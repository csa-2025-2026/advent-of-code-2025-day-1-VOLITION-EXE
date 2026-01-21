import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Day4
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    String[] L = new String[2];
    int answer = 0;
    int pastAnswer = -1; 
    for(int i = 0;sc.hasNext(); i++)  // as long as the Scanner has more lines to read from the file...
    {
      L = Arrays.copyOf(L, i+1);
      L[i] = sc.nextLine(); 
    }
    sc.close();
    while(answer!=pastAnswer){
      pastAnswer=answer;
      for(int k=0; k<L.length; k++){
        for(int i=L[k].indexOf("@"); i!=-1; i=L[k].indexOf("@",i+1)){
          int adjacentCount = 0;
          for(int j = Math.max(0,i-1); j<=Math.min(L[k].length()-1,i+1); j++){
            String top = L[Math.max(0,k-1)].substring(j, j+1);
            String middle = L[k].substring(j, j+1);
            String bottom = L[Math.min(k+1, L.length-1)].substring(j, j+1);
            if(k-1!=-1&&top.equals("@")||top.equals("X"))adjacentCount++;
            if(j!=i&&middle.equals("@")||middle.equals("X"))adjacentCount++;
            if(k+1!=L.length&&bottom.equals("@")||bottom.equals("X"))adjacentCount++;
          }
          if(adjacentCount<4){
            L[k] = L[k].substring(0,i) + "X" + L[k].substring(i+1);
            answer++;
          }
        }
      }
      for(int k=0; k<L.length; k++){
        for(int i=L[k].indexOf("X"); i!=-1; i=L[k].indexOf("X",i+1)){
          L[k] = L[k].substring(0,i) + "." + L[k].substring(i+1);
        }
      }
      
    }
    System.out.println("Answer:" + answer);
  }
}