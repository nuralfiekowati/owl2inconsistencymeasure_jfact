package owl2inconsistencymeasures;

import org.semanticweb.owlapi.reasoner.OWLReasoner;

class Drastic_jfact extends inconsistency_measure_jfact {

	public static String Drastic_measure(OWLReasoner reasoner) {
		
		if (reasoner.isConsistent()) {
			return "1. DRASTIC INCONSISTENCY MEASURE I_d: " + 0;
		} else {
			return "1. DRASTIC INCONSISTENCY MEASURE I_d: " + 1;
		}
		
	}
}