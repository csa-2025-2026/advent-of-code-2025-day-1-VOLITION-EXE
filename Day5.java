import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day5 {

  static class Range {
    long min;
    long max;

    Range(long min, long max) {
      this.min = min;
      this.max = max;
    }
  }

  public static void main(String[] args) throws IOException {
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);

      ArrayList<Range> ranges = new ArrayList<>();
      int answer = 0;

        // Read ranges
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (line.isEmpty()) break;

        int dash = line.indexOf('-');
        long min = Long.parseLong(line.substring(0, dash));
        long max = Long.parseLong(line.substring(dash + 1));

        ranges.add(new Range(min, max));
      }

      // Count values that fall within any range
      while (sc.hasNextLine()) {
        long value = Long.parseLong(sc.nextLine());

        for (Range r : ranges) {
          if (value >= r.min && value <= r.max) {
            answer++;
            break;
          }
        }
      }

      sc.close();

      // Sort ranges by starting value
      Collections.sort(ranges, Comparator.comparingLong(r -> r.min));

      // Merge ranges and count coverage
      long coveredCount = 0;
      long currentMin = ranges.get(0).min;
      long currentMax = ranges.get(0).max;

      for (int i = 1; i < ranges.size(); i++) {
        Range r = ranges.get(i);

        if (r.min <= currentMax + 1) {
          // Overlapping or touching
          currentMax = Math.max(currentMax, r.max);
        } else {
          // Disjoint range
          coveredCount += (currentMax - currentMin + 1);
          currentMin = r.min;
          currentMax = r.max;
        }
      }

      // Add final range
      coveredCount += (currentMax - currentMin + 1);
      
      System.out.println(answer);
      System.out.println(coveredCount);
  }
}