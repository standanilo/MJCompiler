// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActPars extends Operation {

    private Designator Designator;
    private LBracket LBracket;
    private ActParsListN ActParsListN;
    private RBracket RBracket;

    public DesignatorActPars (Designator Designator, LBracket LBracket, ActParsListN ActParsListN, RBracket RBracket) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.LBracket=LBracket;
        if(LBracket!=null) LBracket.setParent(this);
        this.ActParsListN=ActParsListN;
        if(ActParsListN!=null) ActParsListN.setParent(this);
        this.RBracket=RBracket;
        if(RBracket!=null) RBracket.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public LBracket getLBracket() {
        return LBracket;
    }

    public void setLBracket(LBracket LBracket) {
        this.LBracket=LBracket;
    }

    public ActParsListN getActParsListN() {
        return ActParsListN;
    }

    public void setActParsListN(ActParsListN ActParsListN) {
        this.ActParsListN=ActParsListN;
    }

    public RBracket getRBracket() {
        return RBracket;
    }

    public void setRBracket(RBracket RBracket) {
        this.RBracket=RBracket;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(LBracket!=null) LBracket.accept(visitor);
        if(ActParsListN!=null) ActParsListN.accept(visitor);
        if(RBracket!=null) RBracket.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(LBracket!=null) LBracket.traverseTopDown(visitor);
        if(ActParsListN!=null) ActParsListN.traverseTopDown(visitor);
        if(RBracket!=null) RBracket.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(LBracket!=null) LBracket.traverseBottomUp(visitor);
        if(ActParsListN!=null) ActParsListN.traverseBottomUp(visitor);
        if(RBracket!=null) RBracket.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActPars(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LBracket!=null)
            buffer.append(LBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsListN!=null)
            buffer.append(ActParsListN.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RBracket!=null)
            buffer.append(RBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActPars]");
        return buffer.toString();
    }
}
