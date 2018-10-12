package owl2inconsistencymeasures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.semanticweb.owlapi.reasoner.OWLReasoner;

class Drastic_jfact {

	public static void Drastic_measure(OWLReasoner reasoner) throws FileNotFoundException {

		long startTime = System.currentTimeMillis();

		File file = new File("outputs/output_jfact_drastic_K1.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);

		if (reasoner.isConsistent()) {
			System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 0);
			System.out.println("-----------------------------------------------------------------------------");
		} else {
			System.out.println("1. DRASTIC INCONSISTENCY MEASURE I_d: " + 1);
			System.out.println("-----------------------------------------------------------------------------");
		}

		TotalTimeExecution.totalTime(startTime);

	}
}