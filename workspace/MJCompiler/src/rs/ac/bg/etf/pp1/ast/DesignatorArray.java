// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArray extends DesignatorStatement {

    private LBracketD1 LBracketD1;
    private DesignatorList DesignatorList;
    private RBracketD1 RBracketD1;
    private DesignatorLS DesignatorLS;

    public DesignatorArray (LBracketD1 LBracketD1, DesignatorList DesignatorList, RBracketD1 RBracketD1, DesignatorLS DesignatorLS) {
        this.LBracketD1=LBracketD1;
        if(LBracketD1!=null) LBracketD1.setParent(this);
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.RBracketD1=RBracketD1;
        if(RBracketD1!=null) RBracketD1.setParent(this);
        this.DesignatorLS=DesignatorLS;
        if(DesignatorLS!=null) DesignatorLS.setParent(this);
    }

    public LBracketD1 getLBracketD1() {
        return LBracketD1;
    }

    public void setLBracketD1(LBracketD1 LBracketD1) {
        this.LBracketD1=LBracketD1;
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public RBracketD1 getRBracketD1() {
        return RBracketD1;
    }

    public void setRBracketD1(RBracketD1 RBracketD1) {
        this.RBracketD1=RBracketD1;
    }

    public DesignatorLS getDesignatorLS() {
        return DesignatorLS;
    }

    public void setDesignatorLS(DesignatorLS DesignatorLS) {
        this.DesignatorLS=DesignatorLS;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LBracketD1!=null) LBracketD1.accept(visitor);
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(RBracketD1!=null) RBracketD1.accept(visitor);
        if(DesignatorLS!=null) DesignatorLS.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracketD1!=null) LBracketD1.traverseTopDown(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(RBracketD1!=null) RBracketD1.traverseTopDown(visitor);
        if(DesignatorLS!=null) DesignatorLS.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracketD1!=null) LBracketD1.traverseBottomUp(visitor);
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(RBracketD1!=null) RBracketD1.traverseBottomUp(visitor);
        if(DesignatorLS!=null) DesignatorLS.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArray(\n");

        if(LBracketD1!=null)
            buffer.append(LBracketD1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RBracketD1!=null)
            buffer.append(RBracketD1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorLS!=null)
            buffer.append(DesignatorLS.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArray]");
        return buffer.toString();
    }
}
