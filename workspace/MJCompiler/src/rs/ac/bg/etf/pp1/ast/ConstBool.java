// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ConstBool extends ConstDecl {

    private String booleans;
    private String bool;

    public ConstBool (String booleans, String bool) {
        this.booleans=booleans;
        this.bool=bool;
    }

    public String getBooleans() {
        return booleans;
    }

    public void setBooleans(String booleans) {
        this.booleans=booleans;
    }

    public String getBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool=bool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstBool(\n");

        buffer.append(" "+tab+booleans);
        buffer.append("\n");

        buffer.append(" "+tab+bool);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBool]");
        return buffer.toString();
    }
}
