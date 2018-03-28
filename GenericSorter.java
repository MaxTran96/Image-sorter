// Max Tran, CSE 373 HW#6, 3/9/17
package sorting;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort generic class of type <E>.
 * 
 * TODO: Implement mergeSort() and selectionSort().
 * 
 * insertionSort is implemented for you as an example.
 * 
 * @author pattersp
 *
 */

public class GenericSorter {
    /**
     * Sorts the given array of objects of generic class type <E> in ascending order according to the
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
     *            the objects of generic class type <E> to sort
     * @param comparator
     *            The comparator the will be used to compare the two objects of type <E>.
     */
	public static <E> void mergeSort(E[] array, Comparator<? super E> comparator) {
    	E[] temp = newArray(array);
        mergeSort(comparator, array, temp, 0, array.length - 1);
    }
	
	private static <E> E[] newArray(E[] array){
		Class<?> type = array.getClass().getComponentType();
		@SuppressWarnings("unchecked")
		E[] array2 = (E[]) Array.newInstance(type, array.length);
		return array2;
	}
     
    private static <E> void mergeSort(Comparator<? super E> comparator, E[] array, 
    		E[] temp, int leftInitial, int rightInitial){
    	if(leftInitial < rightInitial){
    		int mid = (leftInitial+rightInitial)/2;
            mergeSort(comparator,array,temp,leftInitial,mid);
            mergeSort(comparator,array,temp,mid+1,rightInitial);
            mergeHelper(comparator,array,temp,leftInitial,mid+1,rightInitial);
       }
    }
     
    private static <E> void mergeHelper(Comparator<? super E> comparator, E[] array, 
    		E[] temp, int leftInitial, int rightInitial, int rightFinal){
        int leftFinal = rightInitial - 1;
        int tempIndex = leftInitial;
        int k = rightFinal-leftInitial+1;
        while(leftInitial<=leftFinal && rightInitial<=rightFinal){
        	if(comparator.compare(array[leftInitial],array[rightInitial]) <= 0){
        		temp[tempIndex++]=array[leftInitial++];
            } else {
            	temp[tempIndex++]=array[rightInitial++];
            }
        }
        while(leftInitial <= leftFinal){
        	temp[tempIndex++] = array[leftInitial++];
        }
        while(rightInitial <= rightFinal){
        	temp[tempIndex++] = array[rightInitial++];
        }
        for(int i = 0; i < k; i++, rightFinal--){
            array[rightFinal] = temp[rightFinal];
        }
    }

    /**
     * Sort the array of objects of type <E> in ascending order according to the comparator
     * using selection sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of objects of type <E> that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two objects of type <E>.
     */
    public static <E> void selectionSort(E[] array,
            Comparator<? super E> comparator) {
    	for(int i = 0; i < array.length - 1; i++){
    		int minIndex = i;
    	    for(int j = i+1;j<array.length;j++){
    	    	if(comparator.compare(array[minIndex], array[j]) >0){
    	            minIndex = j;
    	        }
    	    }
    	    E temp = array[minIndex];
    	    array[minIndex] = array[i];
    	    array[i] = temp;
    	}
    }

    /**
     * Sort the array of objects of type <E> in ascending order according to the comparator
     * using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of objects of type <E> that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare the two objects of type <E>.
     */
    public static <E> void insertionSort(E[] array,
            Comparator<? super E> comparator) {
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            E currentE = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0
                    && comparator.compare(currentE, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentE;
        }
    }
}