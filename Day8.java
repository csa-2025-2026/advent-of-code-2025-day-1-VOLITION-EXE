import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Day8
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    
    
    
    List<List<Integer>> listC = new ArrayList<>();
    List<int[]> listSC = new ArrayList<>();
    List<int[]> listJ = new ArrayList<>();
    
    while(sc.hasNextLine()){
      String cL = sc.nextLine();
      int[] jPos = {Integer.parseInt(cL.substring(0,cL.indexOf(","))),
      Integer.parseInt(cL.substring(cL.indexOf(",")+1, cL.lastIndexOf(","))),
      Integer.parseInt(cL.substring(cL.lastIndexOf(",")+1))};
      listJ.add(jPos);
    }

    double sD = 100000;
    int tPos = -1;
    for(int k = 0 ; k<listJ.size(); k++){
      int[] kJ = listJ.get(k);
      for(int [] iJ : listJ){
        if(i!=k){
          int t = (int)Math.sqrt(Math.pow(kJ[0] - iJ[0], 2) + Math.pow(kJ[1] - iJ[1], 2) + Math.pow(kJ[2] - iJ[2], 2));
          if(t<=sD){
            sD = t;
            tPos = i;
          }
        }
      }
      int[] SC = {k, sD, tPos};
      System.out.println();
      listSC.add(SC);

    }

    /*
    for(int k = 0 ; k<listJ.size()/2; k++){
      boolean ft = true;
      for(List<Integer> o : listC){
        if(o.contains(k)){
          ft = false;
        }
      } 
      if(ft){
        
        for(int i = 0 ; i<listJ.size(); i++){
          int[] iJ = listJ.get(i);
          
        }
        boolean tf = true; 
        for(int l = 0 ; l<listC.size(); l++){
          if(listC.get(l).contains(tPos)){
            listC.get(l).add(k);
            tf = false;
            break;
          }
        }
        if(tf){
          List<Integer> listNC = new ArrayList<>();
          listNC.add(k);
          listNC.add(tPos);
          listC.add(listNC);
        }
      
        
        sD = 100000;
        tPos = -1;
      }
    }
    int max = 0;
    int mid = 0;
    int min = 0;
    for(List<Integer> k : listC){
      if(k.size()>=max){
        min = mid;
        mid = max;
        max = k.size();
      }
      if(k.size()>=mid){
        min = mid;
        mid = k.size();
      }
      if(k.size()>=min){
        min = k.size();
      }
    }
    System.out.println(max * mid * min);
    
    sc.close();
  

  20 junctions = 10 connections
  find 10 shortest possible connections even if they're repeating
  merge the circuits, ignore the ones that repeat in the list of connections
  */
  }

}