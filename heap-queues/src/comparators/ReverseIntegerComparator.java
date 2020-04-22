package comparators;

import java.util.Comparator;

public class ReverseIntegerComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer arg0, Integer arg1) {
    if (arg0.compareTo(arg1) > 0)
      return -1;
    if (arg0.compareTo(arg1) < 0)
      return 1;
    else
      return 0;
  }
}
