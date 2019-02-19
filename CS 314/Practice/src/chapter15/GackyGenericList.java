package chapter15;

public class GackyGenericList {

	private Object[] con;
	private int size;

	/*
	 * Question:
	 * Complete a method to remove redundant Objects in the GackyGenericList.
	 */

	/*
	 * pre: None
	 * post: Remove all redundant values within this list
	 */
	public void removeRedundants() {
		int uniques = 0; // the number of unique values in the list
		for(int index = 0; index < size; index++) {
			/* search if this value is redundant by iterating backwards, so the first unique
				element is not redundant but any elements afterwards is considered redundant */
			boolean isRedundant = false;
			int searchIndex = uniques - 1; // start iterating within the uniques section of the list
			while(!isRedundant && searchIndex >= 0) {
				if(con[index].equals(con[searchIndex])) {
					// found the same value, so it's redundant
					isRedundant = true;
				}
				searchIndex--;
			}
			if(!isRedundant) {
				// shift the unique value to the left
				con[uniques] = con[index];
				uniques++;
			}
		}
		// nullify all the non-unique elements for the garbage collector
		for(int nonUnique = uniques + 1; nonUnique < size; nonUnique++) {
			con[nonUnique] = null;
		}
		// update size to equal uniques since we only want the unique values
		size = uniques;
	}
}
