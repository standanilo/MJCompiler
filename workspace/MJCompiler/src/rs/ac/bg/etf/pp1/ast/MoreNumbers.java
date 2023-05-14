// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class MoreNumbers extends Numbers {

    private Numbers Numbers;
    private Integer n;

    public MoreNumbers (Numbers Numbers, Integer n) {
        this.Numbers=Numbers;
        if(Numbers!=null) Numbers.setParent(this);
        this.n=n;
    }

    public Numbers getNumbers() {
        return Numbers;
    }

    public void setNumbers(Numbers Numbers) {
        this.Numbers=Numbers;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n=n;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Numbers!=null) Numbers.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Numbers!=null) Numbers.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Numbers!=null) Numbers.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreNumbers(\n");

        if(Numbers!=null)
            buffer.append(Numbers.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+n);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreNumbers]");
        return buffer.toString();
    }
}
