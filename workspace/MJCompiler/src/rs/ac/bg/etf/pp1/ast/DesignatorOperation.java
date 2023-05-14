// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class DesignatorOperation extends DesignatorStatement {

    private Operation Operation;

    public DesignatorOperation (Operation Operation) {
        this.Operation=Operation;
        if(Operation!=null) Operation.setParent(this);
    }

    public Operation getOperation() {
        return Operation;
    }

    public void setOperation(Operation Operation) {
        this.Operation=Operation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Operation!=null) Operation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Operation!=null) Operation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Operation!=null) Operation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorOperation(\n");

        if(Operation!=null)
            buffer.append(Operation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorOperation]");
        return buffer.toString();
    }
}
