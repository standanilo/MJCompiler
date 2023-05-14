// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private ActParsListNB ActParsListNB;

    public FactorDesignator (Designator Designator, ActParsListNB ActParsListNB) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsListNB=ActParsListNB;
        if(ActParsListNB!=null) ActParsListNB.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsListNB getActParsListNB() {
        return ActParsListNB;
    }

    public void setActParsListNB(ActParsListNB ActParsListNB) {
        this.ActParsListNB=ActParsListNB;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsListNB!=null) ActParsListNB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsListNB!=null) ActParsListNB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsListNB!=null) ActParsListNB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsListNB!=null)
            buffer.append(ActParsListNB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
