package edu.miu.cs.cs544.group1.service;

import edu.miu.cs.cs544.group1.domain.Block;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;

public interface BlockService {
	public Block addBlock(Block block);
	public Block getBlock(long blockId) throws NoSuchResouceException;
	public Block updateBlock(long blockID, Block address);
}
