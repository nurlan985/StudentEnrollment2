package edu.miu.cs.cs544.group1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.group1.domain.Block;
import edu.miu.cs.cs544.group1.domain.Offering;
import edu.miu.cs.cs544.group1.domain.Section;
import edu.miu.cs.cs544.group1.service.BlockService;
import edu.miu.cs.cs544.group1.service.OfferingService;
import edu.miu.cs.cs544.group1.service.SectionService;

@RestController
@RequestMapping("/block")
public class BlockController {
	@Autowired
	BlockService blockService;
	

	@Autowired
	SectionService sectionService;
	
	@Autowired
	OfferingService offeringService;
	
	@PostMapping(value = "/")
	public ResponseEntity<Block> addBlock(@RequestBody Block block) {

		HttpHeaders headers = new HttpHeaders();

		if (block == null) {
			return new ResponseEntity<Block>(HttpStatus.BAD_REQUEST);
		}
		blockService.addBlock(block);

		headers.add("Block added :", block.getCode());

		return new ResponseEntity<Block>(block, headers, HttpStatus.CREATED);

	}
	@GetMapping(value = "/")
	public ResponseEntity<List<Block>> getBlocks() {

		HttpHeaders headers = new HttpHeaders();

		List<Block> blocks = blockService.getBlocks();

		if (blocks == null) {
			return new ResponseEntity<List<Block>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number of Blocks returned", String.valueOf(blocks.size()));

		return new ResponseEntity<List<Block>>(blocks, headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{blockId}")
	public ResponseEntity<Block> getBlock(@PathVariable long blockId) {

		Block block = blockService.getBlock(blockId);

		if (block == null) {

			return new ResponseEntity<Block>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Block>(block, HttpStatus.OK);
	}
	
	@PutMapping(value="/{blockId}")
	public ResponseEntity<Block> updateBlock(@PathVariable long blockId,@RequestBody Block block){
		
		HttpHeaders headers = new HttpHeaders();
		Block block_toUpdate = blockService.getBlock(blockId);
		
		if(block_toUpdate == null) {
			
			return new ResponseEntity<Block>(HttpStatus.NOT_FOUND);
		}
		
		blockService.updateBlock(blockId, block);
		
		headers.add("Updated Block : ",String.valueOf(blockId));
		
		return new ResponseEntity<Block>(block,headers, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{blockId}")
	public ResponseEntity<Void> deleteBlock(@PathVariable long blockId){

		blockService.deleteBlock(blockId);
		
		return  ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/sections/{blockId}")
	public List<Section> getSections(@PathVariable long blockId) {
		return sectionService.getSectionsByBlockId(blockId);
	}
	
	@GetMapping(value = "/offerings/{blockId}")
	public List<Offering> getOfferings(@PathVariable long blockId) {
		return offeringService.getOfferingsByBlockId(blockId);
	}
}
