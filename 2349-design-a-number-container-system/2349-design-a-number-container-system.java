
import java.util.*;

class NumberContainers {

    HashMap<Integer, Integer> indexToNumber;
    HashMap<Integer, TreeSet<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {

        // Remove the index from its previous number
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            numberToIndices.get(oldNumber).remove(index);
        }

        // Update the index with the new number
        indexToNumber.put(index, number);

        // Create a sorted set if this number is new
        numberToIndices.putIfAbsent(number, new TreeSet<>());

        // Add the index to the new number's set
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {

        if (!numberToIndices.containsKey(number) ||
            numberToIndices.get(number).isEmpty()) {
            return -1;
        }

        return numberToIndices.get(number).first();
    }
}
