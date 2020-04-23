// https://www.javatpoint.com/java-linkedhashset
public class Book {
	private int id;
	private String name, author, publisher;
	private int quantity;
	
	
	static public class Builder {
		private int id;
		private String name, author, publisher;
		private int quantity;
		
		public Builder(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}
		
		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}				
	}
	
	private Book(Builder b) {
		this.id = b.id;
		this.name = b.name;
		this.author = b.author;
		this.publisher = b.publisher;
		this.quantity = b.quantity;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
