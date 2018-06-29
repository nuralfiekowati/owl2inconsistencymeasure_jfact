package owl2inconsistencymeasures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.explanation.api.Explanation;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyRenameException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.ReasonerInterruptedException;
import org.semanticweb.owlapi.reasoner.TimeOutException;

import uk.ac.manchester.cs.jfact.JFactFactory;

class Mc_jfact {

	static Set<OWLAxiom> ontologyAxiomsCausingUnsatisfiable = new HashSet<OWLAxiom>();
	static HashSet<Set<OWLAxiom>> inconsistentSubset = new HashSet<Set<OWLAxiom>>();
	static HashSet<Set<OWLAxiom>> consistentSubset = new HashSet<Set<OWLAxiom>>();
	static ArrayList<Set<OWLAxiom>> MCKcandidate = new ArrayList<Set<OWLAxiom>>();

	public static void Imc_measure(Set<Explanation<OWLAxiom>> explanations, HashSet<OWLAxiom> ontologyAxiomSet) {

		if (explanations.size() > 0) {

			for (Set<OWLAxiom> inconsistent : inconsistentSubset) {
				for (Set<OWLAxiom> consistent : consistentSubset) {
					if ((inconsistent.containsAll(consistent) == true) && (inconsistent.equals(consistent) == false)) {
						// if (inconsistent.size() != consistent.size() &&
						// consistent.isEmpty() == false) {
						MCKcandidate.add(consistent);
						// }
					}
				}
			}

		} else {
			MCKcandidate.add(ontologyAxiomSet);
		}

		for (Set<OWLAxiom> mck : NotMCK.eliminate_notMCK(MCKcandidate)) {
			System.out.println("MCK: " + mck);
		}

		int MCsize = NotMCK.eliminate_notMCK(MCKcandidate).size();

		// To compute SC(K) in MC Inconsistency Measure
		try {
			OWLReasonerFactory rf8 = new JFactFactory(); // for jfact
			OWLOntologyManager manager8 = OWLManager.createOWLOntologyManager();
			OWLOntology AxiomOntology8 = manager8.createOntology();
			Set<OWLAxiom> axiomsToRemove8;
			AddAxiom addAxiom8;

			for (OWLAxiom theAxiom : ontologyAxiomSet) {

				manager8 = OWLManager.createOWLOntologyManager();
				AxiomOntology8 = manager8.createOntology();

				axiomsToRemove8 = AxiomOntology8.getAxioms();

				if (axiomsToRemove8 != null) {
					manager8.removeAxioms(AxiomOntology8, axiomsToRemove8);
				}

				addAxiom8 = new AddAxiom(AxiomOntology8, theAxiom);
				manager8.applyChange(addAxiom8);

				OWLReasoner reasoner8 = rf8.createReasoner(AxiomOntology8); // for
																			// hermit
																			// and
																			// JFact

				System.out.println("The axiom: " + theAxiom);
				System.out
						.println("Is the axiom (" + theAxiom + ") consistent/satisfiable? " + reasoner8.isConsistent());

				if (reasoner8.isConsistent() == false) {
					ontologyAxiomsCausingUnsatisfiable.add(theAxiom);
				}

			}
		} catch (OWLOntologyRenameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeOutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReasonerInterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		float SCsize = ontologyAxiomsCausingUnsatisfiable.size();
		System.out.println("MCsize: " + MCsize);
		System.out.println("SCsize: " + SCsize);
		float imc = (float) MCsize + SCsize - 1;

		System.out.println("7. MC INCONSISTENCY MEASURE I_mc: " + imc);

	}
}
