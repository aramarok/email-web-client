package net.emailwebclient.model;

public final class User {

	private long userId;
	private String userName;
	private String password;

	private String lastName;
	private String firstName;
	private String city;
	private Integer age;
	private Integer sex;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/*
	 * private List<File> files;
	 * 
	 * private long fileSizes = 0;
	 * 
	 * public String getFileSizesInMb(){ DecimalFormat format = new
	 * DecimalFormat("0.00"); return
	 * format.format(fileSizes*9.53674316*Math.pow(10, -7)); }
	 * 
	 * public void addFile(FileInfo f){ fileSizes += f.getSize(); if
	 * (files==null){ files = new ArrayList<File>(); } File ff = new File();
	 * ff.setFileName(f.getFileName()); ff.setFileSize(f.getSize());
	 * files.add(ff); }
	 * 
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getNume() { return nume; }
	 * 
	 * public void setNume(String nume) { this.nume = nume; }
	 * 
	 * public String getPrenume() { return prenume; }
	 * 
	 * public void setPrenume(String prenume) { this.prenume = prenume; }
	 * 
	 * public String getLocalitate() { return localitate; }
	 * 
	 * public void setLocalitate(String localitate) { this.localitate =
	 * localitate; }
	 * 
	 * public int getVarsta() { return varsta; }
	 * 
	 * public void setVarsta(int varsta) { this.varsta = varsta; }
	 * 
	 * public String getSex() { return sex; }
	 * 
	 * public void setSex(String sex) { this.sex = sex; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public long getFileSizes() { return fileSizes; }
	 * 
	 * public void setFileSizes(long fileSizes) { this.fileSizes = fileSizes; }
	 * 
	 * public List<File> getFiles() { return files; }
	 * 
	 * public void setFiles(List<File> files) { this.files = files; }
	 */

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}