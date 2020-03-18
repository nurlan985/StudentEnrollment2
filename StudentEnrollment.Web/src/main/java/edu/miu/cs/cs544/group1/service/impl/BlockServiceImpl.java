package edu.miu.cs.cs544.group1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.group1.domain.Block;
import edu.miu.cs.cs544.group1.exceptions.NoSuchResouceException;
import edu.miu.cs.cs544.group1.repository.BlockRepository;
import edu.miu.cs.cs544.group1.service.BlockService;

@Service
@Transactional
public class BlockServiceImpl implements BlockService{

	@Autowired
	BlockRepository blockRepository;
	@Override
	public Block addBlock(Block block) {
		return blockRepository.save(block);
	}

	@Override
	public Block getBlock(long blockId) throws NoSuchResouceException {
				Block block = blockRepository.findById(blockId).orElseThrow(() -> 
				new NoSuchResouceException("No Block found  with" , blockId));
				
		return block;
	}

	@Override
	public Block updateBlock(long blockID, Block update_block) {

		Block block = blockRepository.findById(blockID).orElseThrow(() -> 
		new  NoSuchResouceException("No Block found  with" , blockID));
		
		block.setCode(update_block.getCode());
		block.setName(update_block.getName());
		block.setSemester(update_block.getSemester());
		block.setBlockSequencyNo(update_block.getBlockSequencyNo());
		block.setStartDate(update_block.getStartDate());
		block.setEndDate(update_block.getEndDate());
		
		return blockRepository.save(block);
		
	}

}
