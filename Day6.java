import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Day6
{
  public static void main(String[] args) throws IOException
  {

    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    //List<List<Integer>> listNL = new ArrayList<>();
    //List<Boolean> listMPL = new ArrayList<>();
    List<String> listSL = new ArrayList<>();
    long answer = 0;

    while (sc.hasNextLine()){
      listSL.add(sc.nextLine());
    }
    
    String mORpList = listSL.get(listSL.size()-1) + " X";
    long total = 0;
    boolean mORpCurrent = true;
    for(int i = 0 ; i<mORpList.length()-1; i++){
      if(mORpList.charAt(i)==' '&&mORpList.charAt(i+1)!=' '){
        answer += total;
        total = 0;
        i++;
        if(i==mORpList.length()-1) break;
      }
      if(mORpList.charAt(i)=='*'){
        total = 1;
        mORpCurrent=false;
      } else if(mORpList.charAt(i)=='+'){
        total = 0;
        mORpCurrent=true;
      }
      String num = "";
      for(int k = 0; k<listSL.size()-1; k++){
        char C = listSL.get(k).charAt(i);
        if(Character.isDigit(C))num += C;
      }

      if(mORpCurrent){
        total += Integer.parseInt(num);
      } else total *= Integer.parseInt(num);
    }
    System.out.println(answer);
    /*
    List<Integer> numList = new ArrayList<>();
    int back = 0;

    for(int i = 0; i<currentLine.size()()-1; i++){
      if(currentLine.charAt(i+1)!=' '&&currentLine.charAt(i)==' ')back = i+1;
      if(currentLine.charAt(i)!=' '&&currentLine.charAt(i+1)==' ')numList.add(Integer.parseInt(currentLine.substring(back, i+1)));
    }
    listNL.add(numList);

    for(int i = 0; i<currentLine.size()(); i++){
      if(currentLine.charAt(i)=='+'){
        listMPL.add(true);
      }else if(currentLine.charAt(i)=='*'){
        listMPL.add(false);
      }
    }
    
    
    for(int i = 0; i<listMPL.size(); i++){

      boolean state = listMPL.get(i);
      long total;
      if(state){
        total = 0;
      } else total = 1;
      for(int k = 0; k<listNL.size(); k++){
        if(state){
          total += listNL.get(k).get(i);
        } else {
          total *= listNL.get(k).get(i);
        }
      }
      System.out.println(total);
      answer += total;
    }
    System.out.println(answer);
    */
    
    
      
    sc.close();
  }
}
