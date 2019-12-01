package bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.lang.model.element.Element;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitBinarySearchTree {
	private BinarySearchTree bsc;

	@BeforeEach
	void setUp() throws Exception {
		bsc = new BinarySearchTree();
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bsc = new BinarySearchTree();
	}

	
	/* Testa metoderna height, add och size genom att använda JUnit. Glöm inte att testa att
	din add-metod fungerar om man försöker sätta in dubbletter och att add altid returnerar
	rätt resultat. Glöm inte heller att testa metoderna height och size i ett tomt träd. */
	@Test
	void testAdd() { //inorder
	
		assertTrue("First element added",bsc.add(3));
		assertFalse("A Binary tree cannot contain duplicates",bsc.add(3));
		assertTrue("Second element added,",bsc.add(6));
		assertTrue("Third element added",bsc.add(5));

	}
	@Test
	public final void testHeight() {
		assertEquals("Height",0,bsc.height());
		for(int i =0;i<10;i++) {
			bsc.add(i);
		}
		/* 0
		 *  \
		     1
		      \
		       2
		        \
		         3
		          \
		           4
		            \
		             5
		              \
		               6
		                \
		                 7
		                  \
		                   8
		                    \
		                     9 -> height = 10 */
		System.out.println(bsc.height());
		assertEquals("Height",10,bsc.height());
		
	}
	@Test
	public final void testSize() {
		for(int i =0;i<10;i++) {
			bsc.add(i);
		}
		assertEquals("size",10,bsc.size());
	}
	
	
	

}
