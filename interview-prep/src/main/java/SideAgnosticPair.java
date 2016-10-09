public class SideAgnosticPair {

	public int n0;
	public int n1;

	public SideAgnosticPair(int n0, int n1) {
		this.n0 = n0;
		this.n1 = n1;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}
		SideAgnosticPair cObj = (SideAgnosticPair) obj;
		if (n0 == cObj.n0 && n1 == cObj.n1) {
			return true;
		} else if (n0 == cObj.n1 && n1 == cObj.n0) {
			return true;
		}

		return false;
	}

	public String toString() {
		return "(" + n0 + ", " + n1 + ")";
	}

	@Override
	public int hashCode() {
		return 31 * (n0 + n1);
	}

}