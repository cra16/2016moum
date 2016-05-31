package oodp;
public abstract class Display{
	public abstract int getColumns();
	public abstract int getRows();
	public abstract String getRowText(int row);
	public final void show(){
		for(int i = 0; i < getRows(); i++){
			System.out.println(getRowText(i));
		}
	}
	public final StringBuffer show2(){
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		for(int i = 0; i < getRows(); i++){
			System.out.println(getRowText(i));
			sb.append(getRowText(i));
			sb.append("<br>");
		}
		sb.append("</html>");
		return sb;
	}

	
}



