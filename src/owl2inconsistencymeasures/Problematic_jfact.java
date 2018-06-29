package owl2inconsistencymeasures;

import java.util.HashSet;

import org.semanticweb.owlapi.model.OWLAxiom;

class Problematic_jfact {

	public static void Ip_measure(HashSet<OWLAxiom> MIKAxiomSet) {

		for (OWLAxiom MIKAxiom : MIKAxiomSet) {
			System.out.println("Axiom of M in MI(K) : " + MIKAxiom);
		}

		float cardOfAxiomMIUnion = MIKAxiomSet.size();

		System.out.println("5. PROBLEMATIC INCONSISTENCY MEASURE I_p: " + cardOfAxiomMIUnion);
		System.out.println("-----------------------------------------------------------------------------");

	}

}
