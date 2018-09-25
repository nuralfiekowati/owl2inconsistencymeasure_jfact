package owl2inconsistencymeasures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.semanticweb.owlapi.model.OWLAxiom;

class Nc_jfact {
	
	static int sizeOfK, maxOfSizeK;

	public static void Inc_measure(ArrayList<Integer> consistentSubsetSize, HashSet<OWLAxiom> ontologyAxiomSet) {
		
		System.out.println("Size of consistent subset size: " + consistentSubsetSize.size());

		if (consistentSubsetSize.size() != 0) {
			int maxOfSizeK = Collections.max(consistentSubsetSize);
			System.out.println("Size of K: " + SizeOfK.sizeK(ontologyAxiomSet));
			System.out.println("Max of size K: " + maxOfSizeK);
			float inc = (float) sizeOfK - (float) maxOfSizeK;
			System.out.println("8. NC INCONSISTENCY MEASURE I_nc: " + inc);
			System.out.println("-----------------------------------------------------------------------------");
		} else {
			System.out.println("Size of K: " + sizeOfK);
			float inc = (float) sizeOfK;
			System.out.println("8. NC INCONSISTENCY MEASURE I_nc: " + inc);
			System.out.println("-----------------------------------------------------------------------------");
		}
		
	}
	
}
