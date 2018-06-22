package owl2inconsistencymeasures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.NoSuchElementException;

import org.semanticweb.owl.explanation.api.ExplanationException;
import org.semanticweb.owl.explanation.api.ExplanationGeneratorInterruptedException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.InconsistentOntologyException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.ReasonerInterruptedException;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.TimeOutException;

import uk.ac.manchester.cs.jfact.JFactFactory;

public class inconsistency_measure_jfact {

	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();

		try {
			File file = new File("output_jfact_knowledgebaseK1.txt");
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);

			HashSet<OWLAxiom> ontologyAxiomSet = new HashSet<OWLAxiom>(3000000, 1000000F);

			File inputOntologyFile = new File("examples/knowledgebaseK1.owl");

			OWLReasonerFactory rf = new JFactFactory(); // for jfact

			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

			OWLOntology ontology = manager.loadOntologyFromOntologyDocument(inputOntologyFile);

			OWLReasonerConfiguration configuration = new SimpleConfiguration(); // for
																				// JFact

			/*
			 * Configuration configuration = new Configuration(); //for hermit
			 * configuration.throwInconsistentOntologyException=false; //for hermit
			 */
			OWLReasoner reasoner = rf.createReasoner(ontology, configuration); // for
																				// hermit
																				// and
																				// JFact

			System.out.println(
					"Is ontology (file name: " + inputOntologyFile + ") consistent? " + reasoner.isConsistent());

			ManageOWL.owlsetmanager(ontology, ontologyAxiomSet);

			System.out.println("                                   ");
			System.out.println("===============================================================");
			System.out.println("==============INCONSISTENCY MEASURES FOR ONTOLOGY==============");
			System.out.println("===============================================================");

			if (reasoner.isConsistent()) {
				System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 0);
			} else {
				System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 1);
			}

			System.out.println("***************************************************************");

		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException: " + e.getMessage());
		} catch (InconsistentOntologyException f) {
			System.out.println("InconsistentOntologyException: " + f.getMessage());
		} catch (FileNotFoundException g) {
			System.out.println("FileNotFoundException: " + g.getMessage());
		} catch (OWLOntologyCreationException g) {
			System.out.println("InconsistentOntologyException: " + g.getMessage());
		} catch (ExplanationGeneratorInterruptedException h) {
			System.out.println("ExplanationGeneratorInterruptedException: " + h.getMessage());
		} catch (ReasonerInterruptedException i) {
			System.out.println("ReasonerInterruptedException: " + i.getMessage());
		} catch (ExplanationException k) {
			System.out.println("ExplanationException: " + k.getMessage());
		} catch (TimeOutException l) {
			System.out.println("TimeOutException: " + l.getMessage());
		} catch (OutOfMemoryError m) {
			System.out.println("OutOfMemoryError: " + m.getMessage());
		}

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("                                 ");
		System.out.println("Total time execution: " + totalTime + " milliseconds.");

	}

}
