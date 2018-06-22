package owl2inconsistencymeasures;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;

class ManageOWL {

	public static void owlsetmanager(OWLOntology ontology, HashSet<OWLAxiom> ontologyAxiomSet) {

		Set<OWLSubClassOfAxiom> OWLSubClassOfAxiomSet = ontology.getAxioms(AxiomType.SUBCLASS_OF);
		for (OWLSubClassOfAxiom OWLSubClassOf : OWLSubClassOfAxiomSet) {
			ontologyAxiomSet.add(OWLSubClassOf);
		}

		Set<OWLEquivalentClassesAxiom> OWLEquivalentClassesAxiomSet = ontology.getAxioms(AxiomType.EQUIVALENT_CLASSES);
		for (OWLEquivalentClassesAxiom OWLEquivalentClasses : OWLEquivalentClassesAxiomSet) {
			ontologyAxiomSet.add(OWLEquivalentClasses);
		}

		Set<OWLDisjointClassesAxiom> OWLDisjointClassesAxiomSet = ontology.getAxioms(AxiomType.DISJOINT_CLASSES);
		for (OWLDisjointClassesAxiom OWLDisjointClasses : OWLDisjointClassesAxiomSet) {
			ontologyAxiomSet.add(OWLDisjointClasses);
		}

		Set<OWLDisjointUnionAxiom> OWLDisjointUnionAxiomSet = ontology.getAxioms(AxiomType.DISJOINT_UNION);
		for (OWLDisjointUnionAxiom OWLDisjointUnion : OWLDisjointUnionAxiomSet) {
			ontologyAxiomSet.add(OWLDisjointUnion);
		}

		Set<OWLDifferentIndividualsAxiom> OWLDifferentIndividualsAxiomSet = ontology
				.getAxioms(AxiomType.DIFFERENT_INDIVIDUALS);
		for (OWLDifferentIndividualsAxiom OWLDifferentIndividuals : OWLDifferentIndividualsAxiomSet) {
			ontologyAxiomSet.add(OWLDifferentIndividuals);
		}

		Set<OWLSameIndividualAxiom> OWLSameIndividualAxiomSet = ontology.getAxioms(AxiomType.SAME_INDIVIDUAL);
		for (OWLSameIndividualAxiom OWLSameIndividual : OWLSameIndividualAxiomSet) {
			ontologyAxiomSet.add(OWLSameIndividual);
		}

		Set<OWLClassAssertionAxiom> OWLClassAssertionAxiomSet = ontology.getAxioms(AxiomType.CLASS_ASSERTION);
		for (OWLClassAssertionAxiom OWLClassAssertion : OWLClassAssertionAxiomSet) {
			ontologyAxiomSet.add(OWLClassAssertion);
		}

		Set<OWLObjectPropertyAssertionAxiom> OWLObjectPropertyAssertionAxiomSet = ontology
				.getAxioms(AxiomType.OBJECT_PROPERTY_ASSERTION);
		for (OWLObjectPropertyAssertionAxiom OWLObjectPropertyAssertion : OWLObjectPropertyAssertionAxiomSet) {
			ontologyAxiomSet.add(OWLObjectPropertyAssertion);
		}

		Set<OWLNegativeObjectPropertyAssertionAxiom> OWLNegativeObjectPropertyAssertionAxiomSet = ontology
				.getAxioms(AxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION);
		for (OWLNegativeObjectPropertyAssertionAxiom OWLNegativeObjectPropertyAssertion : OWLNegativeObjectPropertyAssertionAxiomSet) {
			ontologyAxiomSet.add(OWLNegativeObjectPropertyAssertion);
		}

		Set<OWLSubObjectPropertyOfAxiom> OWLSubObjectPropertyOfAxiomSet = ontology
				.getAxioms(AxiomType.SUB_OBJECT_PROPERTY);
		for (OWLSubObjectPropertyOfAxiom OWLSubObjectPropertyOf : OWLSubObjectPropertyOfAxiomSet) {
			ontologyAxiomSet.add(OWLSubObjectPropertyOf);
		}

		Set<OWLEquivalentObjectPropertiesAxiom> OWLEquivalentObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.EQUIVALENT_OBJECT_PROPERTIES);
		for (OWLEquivalentObjectPropertiesAxiom OWLEquivalentObjectProperty : OWLEquivalentObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLEquivalentObjectProperty);
		}

		Set<OWLDisjointObjectPropertiesAxiom> OWLDisjointObjectPropertiesSet = ontology
				.getAxioms(AxiomType.DISJOINT_OBJECT_PROPERTIES);
		for (OWLDisjointObjectPropertiesAxiom OWLDisjointObjectProperties : OWLDisjointObjectPropertiesSet) {
			ontologyAxiomSet.add(OWLDisjointObjectProperties);
		}

		Set<OWLInverseObjectPropertiesAxiom> OWLInverseObjectPropertiesAxiomSet = ontology
				.getAxioms(AxiomType.INVERSE_OBJECT_PROPERTIES);
		for (OWLInverseObjectPropertiesAxiom OWLInverseObjectProperties : OWLInverseObjectPropertiesAxiomSet) {
			ontologyAxiomSet.add(OWLInverseObjectProperties);
		}

		Set<OWLObjectPropertyDomainAxiom> OWLObjectPropertyDomainAxiomSet = ontology
				.getAxioms(AxiomType.OBJECT_PROPERTY_DOMAIN);
		for (OWLObjectPropertyDomainAxiom OWLObjectPropertyDomain : OWLObjectPropertyDomainAxiomSet) {
			ontologyAxiomSet.add(OWLObjectPropertyDomain);
		}

		Set<OWLObjectPropertyRangeAxiom> OWLObjectPropertyRangeAxiomSet = ontology
				.getAxioms(AxiomType.OBJECT_PROPERTY_RANGE);
		for (OWLObjectPropertyRangeAxiom OWLObjectPropertyRange : OWLObjectPropertyRangeAxiomSet) {
			ontologyAxiomSet.add(OWLObjectPropertyRange);
		}

		Set<OWLFunctionalObjectPropertyAxiom> OWLFunctionalObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.FUNCTIONAL_OBJECT_PROPERTY);
		for (OWLFunctionalObjectPropertyAxiom OWLFunctionalObjectProperty : OWLFunctionalObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLFunctionalObjectProperty);
		}

		Set<OWLInverseFunctionalObjectPropertyAxiom> OWLInverseFunctionalObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
		for (OWLInverseFunctionalObjectPropertyAxiom OWLInverseFunctionalObjectProperty : OWLInverseFunctionalObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLInverseFunctionalObjectProperty);
		}

		Set<OWLReflexiveObjectPropertyAxiom> OWLReflexiveObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.REFLEXIVE_OBJECT_PROPERTY);
		for (OWLReflexiveObjectPropertyAxiom OWLReflexiveObjectProperty : OWLReflexiveObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLReflexiveObjectProperty);
		}

		Set<OWLIrreflexiveObjectPropertyAxiom> OWLIrreflexiveObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
		for (OWLIrreflexiveObjectPropertyAxiom OWLIrreflexiveObjectProperty : OWLIrreflexiveObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLIrreflexiveObjectProperty);
		}

		Set<OWLSymmetricObjectPropertyAxiom> OWLSymmetricObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.SYMMETRIC_OBJECT_PROPERTY);
		for (OWLSymmetricObjectPropertyAxiom OWLSymmetricObjectProperty : OWLSymmetricObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLSymmetricObjectProperty);
		}

		Set<OWLAsymmetricObjectPropertyAxiom> OWLAsymmetricObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.ASYMMETRIC_OBJECT_PROPERTY);
		for (OWLAsymmetricObjectPropertyAxiom OWLAsymmetricObjectProperty : OWLAsymmetricObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLAsymmetricObjectProperty);
		}

		Set<OWLTransitiveObjectPropertyAxiom> OWLTransitiveObjectPropertyAxiomSet = ontology
				.getAxioms(AxiomType.TRANSITIVE_OBJECT_PROPERTY);
		for (OWLTransitiveObjectPropertyAxiom OWLTransitiveObjectProperty : OWLTransitiveObjectPropertyAxiomSet) {
			ontologyAxiomSet.add(OWLTransitiveObjectProperty);
		}

		Set<OWLAxiom> theSet = new HashSet<OWLAxiom>(3000000, 1000000F);
		theSet.addAll(ontologyAxiomSet);

		System.out.println("======================");

		int sizeOfK = ontologyAxiomSet.size();
		System.out.println("Size of K: " + sizeOfK);

	}

}
