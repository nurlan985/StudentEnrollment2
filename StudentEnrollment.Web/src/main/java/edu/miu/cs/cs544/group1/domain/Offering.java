package edu.miu.cs.cs544.group1.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Section.findAllByCourseId", query = "select o FROM Offering o  WHERE o.course.id = ?1")
@NamedQuery(name = "Section.findAllByBlockId", query = "select o FROM Offering o  WHERE o.block.id = ?1")
public class Offering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blockId", nullable = false)
	private Block block;
	
	
	
	
	public Offering() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offering(Course course, Block block) {
		super();
		this.course = course;
		this.block = block;
	}

	public String getCode() {
		if(course!=null && block!=null) {
			return course.getCode() + "-" + block.getCode();
		}
		return id + "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}
