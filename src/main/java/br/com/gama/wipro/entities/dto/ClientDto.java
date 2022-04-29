package br.com.gama.wipro.entities.dto;

public class ClientDto {
	private Integer id;
	
	private String name;
	
	private CurrentDto currentAccount;
	
	private SpecialDto specialAccount;
	
	private Boolean active;
	
	public ClientDto() {
	}
	
	public ClientDto(String name) {
		this.name = name;
		this.active = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getActive () {
		return this.active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
