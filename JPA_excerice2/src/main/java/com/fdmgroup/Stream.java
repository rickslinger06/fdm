package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;


@Entity
@NamedQuery(name = "findByStream", query = "Select s From Stream s WHERE s.name = :streamName")
public class Stream {
	
	@SequenceGenerator(name= "seq_Stream",sequenceName="Stream_id_seq", initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_Stream")
	@Id
	private int id;
	
	
	@Column(unique=true)
	private String name;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Stream_Module", joinColumns = @JoinColumn(name= "fk_Stream_Id"), inverseJoinColumns = @JoinColumn (name = "fk_module_id"))
	private List<Module> modules;
	
	
	public Stream() {
		modules = new ArrayList<>();
	
	}
	
	public Stream(String name, List<Module> modules) {
		super();
		this.name = name;
		this.modules = modules;
	}

	
	public Stream(String name) {
		super();
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


	public List<Module> getModules() {
		
		return modules;
	}


	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Stream [id=" + id + ", name=" + name + ", modules=" + modules + "]";
	}


	

	
	
	
	
	

}

	
	
	


