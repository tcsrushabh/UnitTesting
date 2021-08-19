package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService businessservice;
	
	@Mock
	private ItemRepository repository;
	

	@Test
	void testRetreiveHardcodedItem() {	
		ItemBusinessService businessservice = new ItemBusinessService();
		Item item = businessservice.retreiveHardcodedItem();
		assertNotNull(item);
		//assertEquals(new Item(1, "Ball", 10, 100),item);
	}
	
	@Test 
	void testSaveItem() {
		Item item = new Item(4,"item2",20,20);
		when(repository.save(item)).thenReturn(item);
		Item saved = businessservice.saveItem(item);
		assertEquals("item2",saved.getName());
		assertNotNull(saved.getId());
	}
	
    
	@Test
	void testRetrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2 , "item2" , 20 ,  20),(new Item(3, "item3" ,30 ,30))));
		businessservice.retrieveAllItems();
 		
	}

}
