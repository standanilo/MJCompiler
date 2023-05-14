// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class BracesPars extends ActParsListNB {

    private ActParsListN ActParsListN;

    public BracesPars (ActParsListN ActParsListN) {
        this.ActParsListN=ActParsListN;
        if(ActParsListN!=null) ActParsListN.setParent(this);
    }

    public ActParsListN getActParsListN() {
        return ActParsListN;
    }

    public void setActParsListN(ActParsListN ActParsListN) {
        this.ActParsListN=ActParsListN;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsListN!=null) ActParsListN.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsListN!=null) ActParsListN.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsListN!=null) ActParsListN.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BracesPars(\n");

        if(ActParsListN!=null)
            buffer.append(ActParsListN.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BracesPars]");
        return buffer.toString();
    }
}
