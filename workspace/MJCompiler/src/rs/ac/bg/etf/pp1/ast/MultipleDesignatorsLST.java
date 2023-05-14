// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class MultipleDesignatorsLST extends DesignatorLST {

    private DesignatorNL DesignatorNL;
    private DesignatorLST DesignatorLST;

    public MultipleDesignatorsLST (DesignatorNL DesignatorNL, DesignatorLST DesignatorLST) {
        this.DesignatorNL=DesignatorNL;
        if(DesignatorNL!=null) DesignatorNL.setParent(this);
        this.DesignatorLST=DesignatorLST;
        if(DesignatorLST!=null) DesignatorLST.setParent(this);
    }

    public DesignatorNL getDesignatorNL() {
        return DesignatorNL;
    }

    public void setDesignatorNL(DesignatorNL DesignatorNL) {
        this.DesignatorNL=DesignatorNL;
    }

    public DesignatorLST getDesignatorLST() {
        return DesignatorLST;
    }

    public void setDesignatorLST(DesignatorLST DesignatorLST) {
        this.DesignatorLST=DesignatorLST;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorNL!=null) DesignatorNL.accept(visitor);
        if(DesignatorLST!=null) DesignatorLST.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorNL!=null) DesignatorNL.traverseTopDown(visitor);
        if(DesignatorLST!=null) DesignatorLST.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorNL!=null) DesignatorNL.traverseBottomUp(visitor);
        if(DesignatorLST!=null) DesignatorLST.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleDesignatorsLST(\n");

        if(DesignatorNL!=null)
            buffer.append(DesignatorNL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorLST!=null)
            buffer.append(DesignatorLST.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleDesignatorsLST]");
        return buffer.toString();
    }
}
