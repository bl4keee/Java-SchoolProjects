public class Skladnik implements Comparable {
	private String nazwa;
	
	public Skladnik( String n) {
		nazwa = n;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	
	public String toString() {
		return getNazwa();
	}
	
	public int compareTo(Object o) {
		Skladnik p = (Skladnik) o;
		return this.getNazwa().compareTo(p.getNazwa());
	}
	
}