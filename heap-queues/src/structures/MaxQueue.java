package structures;

import comparators.IntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {
  IntegerComparator newComp = new IntegerComparator();
  StudentArrayHeap<Integer, V> heap = new StudentArrayHeap<Integer, V>(newComp);

  @Override
  public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
    if (priority == null || value == null)
      throw new NullPointerException();
    else
      heap.add(priority, value);
    return this;
  }

  @Override
  public V dequeue() {
    if (heap.isEmpty())
      throw new NullPointerException();
    else
      return heap.remove();
  }

  @Override
  public V peek() {
    if (heap.isEmpty())
      throw new NullPointerException();
    else
      return heap.peek();
  }

  @Override
  public Iterator<Entry<Integer, V>> iterator() {
    return heap.asList().iterator();
  }

  @Override
  public Comparator<Integer> getComparator() {
    return heap.getComparator();
  }

  @Override
  public int size() {
    return heap.size();
  }

  @Override
  public boolean isEmpty() {
    return heap.isEmpty();
  }
}
