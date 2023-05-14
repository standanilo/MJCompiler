// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class SingleDesignatorsLST extends DesignatorLST {

    private DesignatorNL DesignatorNL;

    public SingleDesignatorsLST (DesignatorNL DesignatorNL) {
        this.DesignatorNL=DesignatorNL;
        if(DesignatorNL!=null) DesignatorNL.setParent(this);
    }

    public DesignatorNL getDesignatorNL() {
        return DesignatorNL;
    }

    public void setDesignatorNL(DesignatorNL DesignatorNL) {
        this.DesignatorNL=DesignatorNL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorNL!=null) DesignatorNL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorNL!=null) DesignatorNL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorNL!=null) DesignatorNL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleDesignatorsLST(\n");

        if(DesignatorNL!=null)
            buffer.append(DesignatorNL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleDesignatorsLST]");
        return buffer.toString();
    }
}
