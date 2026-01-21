import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Day7
{
  public static void main(String[] args) throws IOException
  {
    File file = new File("input.txt");  // this is your problem input as a File object
    Scanner sc = new Scanner(file);   // the Scanner object is now reading from the file object
    long answer = 0;
    String sP= sc.nextLine();
    long[] listNL = new long[sP.length()];
    listNL[sP.length()/2] = 1;
    sc.nextLine();
    while(sc.hasNextLine()){
      String i = sc.nextLine();
      for(int j = i.indexOf("^"); j!=-1; j = i.indexOf("^",j+1)){
        if(listNL[j]!=0){
          listNL[j-1] += listNL[j];
          listNL[j+1] += listNL[j];
          listNL[j]=0;
        }
      }
      
      sc.nextLine();
    }
    for(long k : listNL)answer+=k;
    System.out.println(answer);
    /*
    for(int l = 1; l<listSL.size(); l++){
      String i = listSL.get(l);
      for(int k = 1; k<i.length()-1; k++){
        if((i.charAt(k-1)=='^'||i.charAt(k+1)=='^')&&!listNL.contains(k)){
          listNL.add(k);
        }
      }
      for(int j = i.indexOf('^'); j!=-1; j=i.indexOf('^', j+1)){
        if(listNL.contains(j)){
          listNL.remove((Integer) j);
        }
      }
      listSL.set(l,i);
    }



    
    listSL.set(0,listSL.get(0).replaceAll("\\.", "^"));
    listNL.clear();
    List<Integer> listTP = new ArrayList<>();
    String sP = listSL.get(listSL.size()-1);
    for(int i = 0; i<1; i++){
      if(sP.charAt(i)=='.'){
        listNL.add(i);
        for(int l = listSL.size()-1; l>-1; l--){
          String k = listSL.get(l);
          for(int o = 0; o<listNL.size(); o++){
            int j = listNL.get(o);
            if(k.charAt(j)=='^'){
              listNL.remove((Integer) j);
            } else if(sP.charAt(j)!='S'){
              if(j!=0&&k.charAt(j-1)=='^'){
                listNL.add(j-1);
                o++;
              }
              if(j!=k.length()-1&&k.charAt(j+1)=='^'){
                listNL.add(j+1);
                o++;
              }
            }
            System.out.println(listNL);
          }
          if(listSL.isEmpty()) break;
        }
        answer += listNL.size();
        
        
      }
    }
    */
    

    sc.close();
  }
}
