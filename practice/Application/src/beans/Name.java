package beans;

import javax.jdo.annotations.*;

@PersistenceCapable

public class Name {
	
	@Persistent
    private String title;
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String first;
    @Persistent
    private String last;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	@Override
	public String toString() {
		return "Name [title=" + title + ", first=" + first + ", last=" + last + "]";
	}

	public void setLast(String last) {
		this.last = last;
	}
    
}