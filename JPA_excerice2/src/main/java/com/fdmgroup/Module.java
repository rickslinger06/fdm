package com.fdmgroup;




import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Module {
	
	@SequenceGenerator(name= "seq_Module",sequenceName="Module_id_seq", initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_Module")
	@Id
	

	private int id;
	
	@Column(unique =true)
	private String name;
	
	
	@ManyToMany(mappedBy ="modules")
	private List<Stream> streams;
	
	
	public Module() {
		streams = new ArrayList<>();
	}

	public Module(String name) {
		this();
		this.name = name;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stream> getStreams() {
		return streams;
	}

	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
	
	
	
	

}
