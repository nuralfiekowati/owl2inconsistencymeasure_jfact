package owl2inconsistencymeasures;

import org.semanticweb.owlapi.reasoner.OWLReasoner;

class Drastic_jfact {

	public static void Drastic_measure(OWLReasoner reasoner) {

		if (reasoner.isConsistent()) {
			System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 0);
		} else {
			System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 1);
		}

	}
}