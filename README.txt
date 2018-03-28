// Max Tran, CSE 373 HW#6, 3/9/17 (Read from notepad so the table doesn't get messed up)

1) I'll use the median pivot rule (pick the median of: data[lo], data[hi - 1], and data[(hi + lo) / 2])
This gives 3 at index which is smaller than 5 and bigger than 2. Here's how i do the swapping
[5, 7, 9, 1, 3, 4, 6, 8, 2] swap pivot
[3, 7, 9, 1, 5, 4, 6, 8, 2] i=1  j = 8
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 8
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 7
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 6
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 5
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 4
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=1  j = 3
[3, 2, 9, 1, 5, 4, 6, 8, 7] i=2  j = 3
[3, 2, 1, 9, 5, 4, 6, 8, 7] i=2  j = 3
[1, 2, 3, 9, 5, 4, 6, 8, 7] i=2  j = 3 swap pivot
Thus, this gives 2 partitions
[1, 2], pivot 3, and [9, 5, 4, 6, 8, 7]
Using the cutoffs, [1, 2] is automatically [1, 2] after selection sort
[9, 5, 4, 6, 8, 7], pick 7 as a pivot from the median pivot rule
this will then becomes
[7, 5, 4, 6, 8, 9] i = 1 j = 5
[7, 5, 4, 6, 8, 9] i = 1 j = 4
[7, 5, 4, 6, 8, 9] i = 1 j = 3
[7, 5, 4, 6, 8, 9] i = 2 j = 3
[7, 5, 4, 6, 8, 9] i = 3 j = 3
[6, 5, 4, 7, 8, 9] i = 3 j = 3 swap pivot
This gives 2 partitions
[6, 5, 4], pivot 7, and [8, 9]
Using the cutoffs rule with selection sorts
we get [4, 5, 6], 7, and [8, 9]
Thus it becomes [1, 2, 3, 4, 5, 6, 7, 8, 9]
The process can be summarized as 
                               [5, 7, 9, 1, 3, 4, 6, 8, 2]
                                            ||
                               [1, 2, 3, 9, 5, 4, 6, 8, 7]          
			      /             |             \
		           [1, 2]           3              [9, 5, 4, 6, 8, 7]
		             ||             |                      ||
		           [1, 2]           |              [6, 5, 4, 7, 8, 9]
		             |              |             /        |         \
		             |              |       [4, 5, 6]      7          [8, 9]
		             |              |          ||          |           ||
		             |              |       [4, 5, 6]      7          [8, 9]
		             |              |          |	   |           |
		           [1, 2]           |	    [4, 5, 6]      7          [8, 9]
		                 \_         |          |         _/          /
		                   \        |          |       _/           /
		                    [1, 2, 3, 4, 5, 6, 7, 8, 9]____________/
		                   
              
		                  
2) We gonna look at the data as followed

a b c _ _
d a _ _ _
f f f f _
d e f c d
a b e b d
c a _ _ _
b _ _ _ _
f e f _ _
d f e _ _
where _ is the padding and we going to read from right to left
Using the table,
The first column from the right
***********************************************************************
*    _    *    a    *    b    *    c    *    d    *    e    *    f    * 
*         *	    *	      *		*	  *         *         *
***********************************************************************
* abc     *         *	      *	        * defcd   *         *         * 
* da      *	    *	      *	        * abebd   *         *         *
* ffff    *         *	      *		*	  *         *         *
* ca      *	    *	      *		*	  *         *         *  
* b       *	    *	      *		*	  *         *         *  
* fef     *         *         *		*	  *         *         *  
* dfe     *	    *	      *		*	  *         *         *  
***********************************************************************
Second column from the right
***********************************************************************
*    _    *    a    *    b    *    c    *    d    *    e    *    f    * 
*         *	    *	      *		*         *         *         *
***********************************************************************
* abc     *         * abebd   *	defcd   * 	  *         * ffff    *
* da      *         *	      *         *	  *         *         *
* ca      *	    *	      *		*	  *         *         *
* b       *	    *	      *		*	  *         *         *
* fef     *	    *	      *		*	  *         *         *  
* dfe     *	    *	      *		*	  *         *         *
***********************************************************************
Third column from the right
***********************************************************************
*    _    *    a    *    b    *    c    *    d    *    e    *    f    *
*         *	    *	      *		*	  *         *         *
***********************************************************************
* da      *	    *         * abc     *         * dfe     * fef     *
* ca      *	    *	      *	        *         * abebd   * defcd   *
* b       *	    *	      *		*	  *         * ffff    *
*         *	    *	      *		*	  *         *         *  
***********************************************************************
Fourth column from the right
***********************************************************************
*    _    *    a    *    b    *    c    *    d    *    e    *    f    *
*         *	    *	      *		*	  *         *         *
***********************************************************************
* b       * da	    * abc     *         *         * fef     * dfe     *
*         * ca      * abebd   *	        *         * defcd   * ffff    *
*         *	    *	      *		*	  *         *         *
*         *	    *	      *		*	  *         *         *  
***********************************************************************
Final column from the right
***********************************************************************
*    _    *    a    *    b    *    c    *    d    *    e    *    f    *
*         *	    *	      *		*	  *         *         *
***********************************************************************
*         * abc	    * b       * ca      * da      *         * fef     *
*         * abebd   *	      *	        * defcd   *         * ffff    *
*         *	    *	      *		* dfe	  *         *         *
*         *	    *	      *		*	  *         *         *  
***********************************************************************
So the output is [abc, abebd, b, ca, da, defcd, dfe, fef, ffff]
3) Yes I implement the GenericSorter class in order to be able to do sorting algorithm on an array 
of objects of any type as long as it has a compare methods. 

