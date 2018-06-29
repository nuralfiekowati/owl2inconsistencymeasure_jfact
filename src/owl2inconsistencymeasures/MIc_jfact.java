package owl2inconsistencymeasures;

import java.util.ArrayList;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAxiom;

class MIc_jfact {

	static float onePerSizeOfM;
	static float sumOfSize = 0;
	static float sizeOfM;
	static ArrayList<Integer> explanationSizeList = new ArrayList<>();

	public static void MIc_measure(Set<OWLAxiom> arrayOfExplanation) {

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("--------------------------Computation for I_mic------------------------------");
		System.out.println("M in MI(K): " + arrayOfExplanation);
		sizeOfM = arrayOfExplanation.size();
		System.out.println("M size: " + sizeOfM);
		explanationSizeList.add((int) sizeOfM);
		onePerSizeOfM = (float) 1 / sizeOfM;
		System.out.println("One per M size: " + onePerSizeOfM);
		sumOfSize = sumOfSize + onePerSizeOfM;

		System.out.println("Sum of one per M size: " + sumOfSize);
		System.out.println("3. MI^C-INCONSISTENCY MEASURE I_mic: " + sumOfSize);
		System.out.println("-----------------------------------------------------------------------------");

	}
}
