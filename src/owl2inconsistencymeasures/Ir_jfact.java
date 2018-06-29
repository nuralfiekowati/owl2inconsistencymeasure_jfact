package owl2inconsistencymeasures;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.explanation.api.Explanation;
import org.semanticweb.owlapi.model.OWLAxiom;

class Ir_jfact {

	public static void Iir_measure(Set<Explanation<OWLAxiom>> explanations, HashSet<OWLAxiom> ontologyAxiomSet) {

		int Ksize = SizeOfK.sizeK(ontologyAxiomSet);
		float sizeOfMI = explanations.size();

		float I_ir = sizeOfMI / Ksize;
		System.out.println("Size of MI(K): " + sizeOfMI);
		System.out.println("Size of K: " + Ksize);
		if ((sizeOfMI == 0) && (Ksize == 0)) {
			System.out.println("6. INCOMPATIBILITY RATIO INCONSISTENCY MEASURE I_ir: 0");
		} else {
			System.out.println("6. INCOMPATIBILITY RATIO INCONSISTENCY MEASURE I_ir: " + I_ir);
		}
		System.out.println("-----------------------------------------------------------------------------");

	}

}
