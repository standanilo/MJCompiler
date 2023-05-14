// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Matched {

    private RExpr RExpr;

    public ReturnStatement (RExpr RExpr) {
        this.RExpr=RExpr;
        if(RExpr!=null) RExpr.setParent(this);
    }

    public RExpr getRExpr() {
        return RExpr;
    }

    public void setRExpr(RExpr RExpr) {
        this.RExpr=RExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RExpr!=null) RExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RExpr!=null) RExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RExpr!=null) RExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(RExpr!=null)
            buffer.append(RExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}
