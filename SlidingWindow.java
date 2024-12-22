public class SlidingWindow {
  public static void main(String[] args) {
      int windowSize = 4;
      int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      for (int i = 0; i < data.length - windowSize + 1; i++) {
          // Simulate sending a window of data
          System.out.print("Sending window: ");
          for (int j = i; j < i + windowSize; j++) {
              System.out.print(data[j] + " ");
          }
          System.out.println();
          // Simulate waiting for acknowledgment
          System.out.println("Waiting for acknowledgment...");
          // Simulate receiving acknowledgment
          System.out.println("Acknowledgment received.");
      }
  }
}
