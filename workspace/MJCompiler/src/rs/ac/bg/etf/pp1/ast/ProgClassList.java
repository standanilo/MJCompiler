// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class ProgClassList extends ProgDecl {

    private ClassDeclList ClassDeclList;

    public ProgClassList (ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
        if(ClassDeclList!=null) ClassDeclList.setParent(this);
    }

    public ClassDeclList getClassDeclList() {
        return ClassDeclList;
    }

    public void setClassDeclList(ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclList!=null) ClassDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclList!=null) ClassDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgClassList(\n");

        if(ClassDeclList!=null)
            buffer.append(ClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgClassList]");
        return buffer.toString();
    }
}
