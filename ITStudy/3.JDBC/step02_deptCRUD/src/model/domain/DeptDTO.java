/*deptno, dname, loc
 * dept�� row �ϳ��� 1:1 ���εǴ� Ŭ����
 * �ø��� getter setter, toString, constructors using field ��ȯ
 */

package model.domain;

public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
	public DeptDTO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override //toString �޴� �ȿ��� StringBuilder/Buffer üũ
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeptDETO [deptno=");
		builder.append(deptno);
		builder.append(", dname=");
		builder.append(dname);
		builder.append(", loc=");
		builder.append(loc);
		builder.append("]");
		return builder.toString();
	}

	
	
}
