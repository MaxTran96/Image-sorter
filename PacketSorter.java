// Max Tran, CSE 373 HW#6, 3/9/17
package sorting;

import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort packets received from a
 * server containing image metadata.
 * 
 * TODO: Implement mergeSort() and selectionSort().
 * 
 * insertionSort is implemented for you as an example.
 * 
 * @author pattersp
 *
 */

public class PacketSorter {
    /**
     * Sorts the given array of packets in ascending order according to the
     * comparator using mergesort. You may create as many private helper
     * functions as you wish to implement this method.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the packets to sort
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void mergeSort(Packet[] array, Comparator<Packet> comparator) {
    	Packet[] temp = new Packet[array.length];
        mergeSort(comparator, array, temp, 0, array.length - 1);

    }
     
    private static void mergeSort(Comparator<Packet> comparator, Packet[] array, 
    		Packet[] temp, int leftInitial, int rightInitial){
    	if(leftInitial < rightInitial){
    		int mid = (leftInitial+rightInitial)/2;
            mergeSort(comparator,array,temp,leftInitial,mid);
            mergeSort(comparator,array,temp,mid+1,rightInitial);
            mergeHelper(comparator,array,temp,leftInitial,mid+1,rightInitial);
       }
    }
     
    private static void mergeHelper(Comparator<Packet> comparator, Packet[] array, 
    		Packet[] temp, int leftInitial, int rightInitial, int rightFinal){
        int leftFinal = rightInitial - 1;
        int tempIndex = leftInitial;
        int numElement = rightFinal-leftInitial+1;
        while(leftInitial<=leftFinal && rightInitial<=rightFinal){
        	if(comparator.compare(array[leftInitial],array[rightInitial]) <= 0){
        		temp[tempIndex]=array[leftInitial];
        		leftInitial++;
            } else {
            	temp[tempIndex]=array[rightInitial];
            	rightInitial++;
            }
            tempIndex++;
        }
        while(leftInitial <= leftFinal){
        	temp[tempIndex] = array[leftInitial];
            tempIndex++;
            leftInitial++;
        }
        while(rightInitial <= rightFinal){
        	temp[tempIndex] = array[rightInitial];
            tempIndex++;
            rightInitial++;
        }
        for(int i = 0; i < numElement; i++, rightFinal--){
            array[rightFinal] = temp[rightFinal];
        }
    }
    /**
     * Sort the array of packets in ascending order using selection sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void selectionSort(Packet[] array,
            Comparator<Packet> comparator) {
    	for(int i = 0; i < array.length - 1; i++){
    		int minIndex = i;
    	    for(int j = i+1;j<array.length;j++){
    	    	if(comparator.compare(array[minIndex], array[j]) >0){
    	            minIndex = j;
    	        }
    	    }
    	    Packet temp = array[minIndex];
    	    array[minIndex] = array[i];
    	    array[i] = temp;
    	}
    }

    /**
     * Sort the array of packets in ascending order using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void insertionSort(Packet[] array,
            Comparator<Packet> comparator) {
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            Packet currentPacket = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0
                    && comparator.compare(currentPacket, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentPacket;
        }
    }
}
