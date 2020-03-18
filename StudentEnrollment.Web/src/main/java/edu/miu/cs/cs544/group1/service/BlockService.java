package edu.miu.cs.cs544.group1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.miu.cs.cs544.group1.domain.Block;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface BlockService {
	public Block addBlock(Block block);
	public Block getBlock(long blockId) throws NoSuchResouceException;
	public List<Block> getBlocks();

	public Block updateBlock(long blockID, Block address);
	public ResponseEntity<Void> deleteBlock(long blockId) throws NoSuchResouceException;

}
