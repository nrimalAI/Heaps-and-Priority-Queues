package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

  protected StudentArrayHeap(Comparator<P> comparator) {
    super(comparator);
  }

  @Override
  protected int getLeftChildOf(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();
    else
      return 2 * index + 1;
  }

  @Override
  protected int getRightChildOf(int index) {
    if (index < 0)
      throw new IndexOutOfBoundsException();
    else
      return 2 * index + 2;
  }

  @Override
  protected int getParentOf(int index) {
    if (index < 1)
      throw new IndexOutOfBoundsException();
    else {
      return (index - 1) / 2;
    }
  }

  @Override
  protected void bubbleUp(int index) {
    int parent = (index - 1) / 2;
    Entry<P, V> elem = heap.get(index);
    while ((index > 0) && comparator.compare(heap.get(index).getPriority(), heap.get(parent).getPriority()) > 0) {
      this.swap(index, parent);
      index = parent;
      parent = (parent - 1) / 2;
    }
    heap.set(index, elem);
  }

  @Override
  protected void bubbleDown(int index) {
    int child = 0;
    Entry<P, V> elem = heap.get(index);
    while (index < heap.size() / 2) {
      int leftChild = index * 2 + 1;
      int rightChild = index * 2 + 2;
      if (rightChild < heap.size()
          && comparator.compare(heap.get(leftChild).getPriority(), heap.get(rightChild).getPriority()) < 0)
        child = rightChild;
      else
        child = leftChild;
      if (comparator.compare(heap.get(index).getPriority(), heap.get(child).getPriority()) >= 0)
        break;
      this.swap(index, child);
      index = child;
      leftChild = (index * 2) + 1;
      rightChild = (index * 2) + 2;
    }
  }
}
