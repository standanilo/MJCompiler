// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class SingleDesignatorN extends DesignatorList {

    private DesignatorN DesignatorN;

    public SingleDesignatorN (DesignatorN DesignatorN) {
        this.DesignatorN=DesignatorN;
        if(DesignatorN!=null) DesignatorN.setParent(this);
    }

    public DesignatorN getDesignatorN() {
        return DesignatorN;
    }

    public void setDesignatorN(DesignatorN DesignatorN) {
        this.DesignatorN=DesignatorN;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorN!=null) DesignatorN.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorN!=null) DesignatorN.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorN!=null) DesignatorN.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleDesignatorN(\n");

        if(DesignatorN!=null)
            buffer.append(DesignatorN.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleDesignatorN]");
        return buffer.toString();
    }
}
