// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ProgVarList extends ProgDecl {

    private GlobalVarDeclList GlobalVarDeclList;

    public ProgVarList (GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarDeclList=GlobalVarDeclList;
        if(GlobalVarDeclList!=null) GlobalVarDeclList.setParent(this);
    }

    public GlobalVarDeclList getGlobalVarDeclList() {
        return GlobalVarDeclList;
    }

    public void setGlobalVarDeclList(GlobalVarDeclList GlobalVarDeclList) {
        this.GlobalVarDeclList=GlobalVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarDeclList!=null) GlobalVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclList!=null) GlobalVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgVarList(\n");

        if(GlobalVarDeclList!=null)
            buffer.append(GlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgVarList]");
        return buffer.toString();
    }
}
