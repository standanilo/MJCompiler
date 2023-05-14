// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class BracketsDesignators extends DesignatorLS {

    private LBracketD2 LBracketD2;
    private DesignatorLST DesignatorLST;
    private RBracketD2 RBracketD2;

    public BracketsDesignators (LBracketD2 LBracketD2, DesignatorLST DesignatorLST, RBracketD2 RBracketD2) {
        this.LBracketD2=LBracketD2;
        if(LBracketD2!=null) LBracketD2.setParent(this);
        this.DesignatorLST=DesignatorLST;
        if(DesignatorLST!=null) DesignatorLST.setParent(this);
        this.RBracketD2=RBracketD2;
        if(RBracketD2!=null) RBracketD2.setParent(this);
    }

    public LBracketD2 getLBracketD2() {
        return LBracketD2;
    }

    public void setLBracketD2(LBracketD2 LBracketD2) {
        this.LBracketD2=LBracketD2;
    }

    public DesignatorLST getDesignatorLST() {
        return DesignatorLST;
    }

    public void setDesignatorLST(DesignatorLST DesignatorLST) {
        this.DesignatorLST=DesignatorLST;
    }

    public RBracketD2 getRBracketD2() {
        return RBracketD2;
    }

    public void setRBracketD2(RBracketD2 RBracketD2) {
        this.RBracketD2=RBracketD2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LBracketD2!=null) LBracketD2.accept(visitor);
        if(DesignatorLST!=null) DesignatorLST.accept(visitor);
        if(RBracketD2!=null) RBracketD2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracketD2!=null) LBracketD2.traverseTopDown(visitor);
        if(DesignatorLST!=null) DesignatorLST.traverseTopDown(visitor);
        if(RBracketD2!=null) RBracketD2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracketD2!=null) LBracketD2.traverseBottomUp(visitor);
        if(DesignatorLST!=null) DesignatorLST.traverseBottomUp(visitor);
        if(RBracketD2!=null) RBracketD2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BracketsDesignators(\n");

        if(LBracketD2!=null)
            buffer.append(LBracketD2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorLST!=null)
            buffer.append(DesignatorLST.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RBracketD2!=null)
            buffer.append(RBracketD2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BracketsDesignators]");
        return buffer.toString();
    }
}
