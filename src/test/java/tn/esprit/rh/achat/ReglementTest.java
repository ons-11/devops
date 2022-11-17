package tn.esprit.rh.achat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class ReglementTest {
	
	@Autowired
	IReglementService ps;
	
	List<Reglement> reglist = new ArrayList<Reglement>() {

		{
			/*add(new Produit(1L, "123456789", "Biscuit", 5, null, null, null, null, null));
			add(new Produit(2L, "55522233", "Javel", 5, null, null, null, null, null));
			add(new Produit(3L, "456897321", "Tv", 5, null, null, null, null, null));*/
		}};
	
	@Test
	@Order(1)
	public void testRetrieveAllReglements() {
		List<Reglement> listReglements = ps.retrieveAllReglements();
		Assertions.assertEquals(0, listReglements.size());
		System.out.println("retrieveAllReglements test");
	}
	
}

