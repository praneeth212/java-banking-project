package com.example.test;
 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.BranController;
import com.example.entities.Branch;
import com.example.entities.Branches;
import com.example.repo.BranRepository;
import com.example.service.BranService;
import com.fasterxml.jackson.databind.ObjectMapper;
// 
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(BranController.class)
//public class BranchServiceTest {
//	@Autowired
//	private MockMvc mockMvc;
//	@MockBean
//	private BranRepository branRepository;
//	@MockBean
//	private BranService branService;
//	@InjectMocks
//	private BranController branController;
//	private Branch branch1;
//	private Branch branch2;
//	@BeforeEach
//	void setUp() {
//		branch1 = new Branch();
//		branch1.setBranch_id(1);
//		branch1.setBranch_location("ABC Street");
//		branch1.setBranch_name("ABC Bank");
//		branch1.setBranch_contact(123456789);
//		
//		branch2 = new Branch();
//		branch2.setBranch_id(2);
//		branch2.setBranch_location("DEF Street");
//		branch2.setBranch_name("DEF Bank");
//		branch2.setBranch_contact(282828282);
//	}
//	@Test
//	void testRead() throws Exception{
//		Branches brans =new Branches(Arrays.asList(branch1,branch2));
//		when(branService.getAll()).thenReturn(brans);
//		mockMvc.perform(get("/branchservice/Bgetall"))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.branchList[0].branch_name").value("ABC Bank"))
//			.andExpect(jsonPath("$.branchList[1].branch_name").value("DEF Bank"));
//	}
//	@Test
//	void testAdd() throws Exception{
//		ObjectMapper objectMapper = new ObjectMapper();
//		String teamJson = objectMapper.writeValueAsString(branch1);
//		mockMvc.perform(post("/branchservice/Badd")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(teamJson))
//			.andExpect(status().isOk());
//    		verify(branService).Badd(branch1);
//	}
//	@Test
//	void testReadOne() throws Exception{
////		Customers customers = new Customers(Arrays.asList(customer1));
//		when(branService.Bgetone(1)).thenReturn(branch1);
//		mockMvc.perform(get("/branchservice/Bgetone/1"))
//			   .andExpect(status().isOk())
//			   .andExpect(jsonPath("$.branch_location").value("ABC Street"));
//	}
//	@Test
//	void testUpdate() throws Exception{
//		ObjectMapper objectMapper = new ObjectMapper();
//		String branchJson = objectMapper.writeValueAsString(branch1);
//		mockMvc.perform(put("/branchservice/Bupdate/1")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(branchJson))
//			.andExpect(status().isOk());
//		verify(branService).Bupdate(1,branch1);
//	}
//	@Test
//	void testDelete() throws Exception{
//		mockMvc.perform(delete("/branchservice/Bdelete/1"))
//			.andExpect(status().isOk());
//		verify(branService).Bdelete(1);
//	}
//}


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entities.Branch;
import com.example.entities.Branches;
import com.example.repo.BranRepository;

@ExtendWith(MockitoExtension.class)
public class BranchServiceTest {

    @Mock
    private BranRepository branRepository;

    @InjectMocks
    private BranService branService;

    private Branch branch;
    private Branch updatedBranch;

    @BeforeEach
    void setUp() {
        branch = new Branch();
        branch.setBranch_id(0);
        branch.setBranch_name("Branch1");
        branch.setBranch_location("Location1");
        branch.setBranch_contact(12345678);

        updatedBranch = new Branch();
        updatedBranch.setBranch_name("UpdatedBranch");
        updatedBranch.setBranch_location("UpdatedLocation");
        updatedBranch.setBranch_contact(89745621);
    }

    @Test
    void testGetAll() {
        when(branRepository.findAll()).thenReturn(Arrays.asList(branch));

        Branches branches = branService.getAll();

        assertNotNull(branches);
        assertEquals(1, branches.getBranchList().size());
        verify(branRepository, times(1)).findAll();
    }

    @Test
    void testBgetone() {
        when(branRepository.findById(1)).thenReturn(Optional.of(branch));

        Branch result = branService.Bgetone(1);

        assertNotNull(result);
        assertEquals("Branch1", result.getBranch_name());
        verify(branRepository, times(1)).findById(1);
    }

    @Test
    void testBadd() {
        branService.Badd(branch);

        verify(branRepository, times(1)).save(branch);
    }

    @Test
    void testBupdate() {
        when(branRepository.findById(1)).thenReturn(Optional.of(branch));

        Branch result = branService.Bupdate(1, updatedBranch);

        assertNotNull(result);
        assertEquals("UpdatedBranch", result.getBranch_name());
        assertEquals("UpdatedLocation", result.getBranch_location());
        assertEquals(89745621, result.getBranch_contact());
        verify(branRepository, times(1)).findById(1);
        verify(branRepository, times(1)).save(branch);
    }

    @Test
    void testBdelete() {
        branService.Bdelete(1);

        verify(branRepository, times(1)).deleteById(1);
    }
}
